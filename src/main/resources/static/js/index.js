var vue = new Vue({
    el: "#app",
    data: {
        blogCategories: [],
        cid:0,
        cindex:-1,
        blogList:[],
        pageNo:1,
        total:0,
        pages:0,
        pageSize:4
    },
    created: function () {
        this.cid = document.getElementById("cid").value;
        // 页面执行加载异步事件方法
        this.loadCategory();
        this.loadBlogContent();
    },
    methods: {
        // 分类查询
        loadCategory: function () {
            var that = this;
            axios.get("/api/blogcategory/load").then(function (res) {
                that.blogCategories = res.data;

                var zindex = -1;
                for(var i=0;i<that.blogCategories.length;i++){
                    if(that.blogCategories[i].id == that.cid){
                        zindex = i;
                        break;
                    }
                }
                that.cindex = zindex;

            });
        },
        //click方式，注意修改分类id
        searchByCid: function (cid,index){
            this.cid = cid;
            this.cindex = index;
            // 为什么要清空呢？因为每次点击是一次全新的搜索，必须先清空，把分页置到第一页即可
            //比如说我已经到了第4页了，我去点击了分类id，那么是从第4页开始
            this.blogList = [];//覆盖式不需要清空了
            this.pageNo = 1;
            this.loadBlogContent();
        },
        //vue的active增设，注意修改分类id
        /* searchByCid: function (index){
             this.cid = this.blogCategories[index].id;
             this.cindex = index;
             // 为什么要清空呢？因为每次点击是一次全新的搜索，必须先清空，把分页置到第一页即可
             //比如说我已经到了第4页了，我去点击了分类id，那么是从第4页开始
             this.blogList = [];//覆盖式不需要清空了
             this.pageNo = 1;
             this.loadBlogContent();
         },*/
        nextPage: function (){
            if(this.pageNo == this.pages){
                alert("没有更多了...")
                return;
            }
            this.pageNo++;
            this.loadBlogContent();
        },
        /*loadBlogContent:function (){
            var that = this;
            axios.get("/api/blog/load").then(function (res) {
                that.blogList = res.data;
            });
        }*/
        loadBlogContent: function (){
            var that = this;
            var pageNo = that.pageNo;//1
            var pageSize = this.pageSize;//2
            var cid = that.cid;
            axios.get("/api/blog/load?pageNo="+pageNo+"&pageSize="+pageSize+"&cid="+cid).then(function (res) {
                var blogPage = res.data;
                //that.blogList = blogPage.records;//覆盖式
                that.blogList = that.blogList.concat(blogPage.records);//累加式
                that.total = blogPage.total;
                that.pages = blogPage.pages;
            });
        }
    }
})