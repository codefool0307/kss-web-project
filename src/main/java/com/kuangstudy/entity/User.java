package com.kuangstudy.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author 飞哥
 * @Title: 学相伴出品
 * @Description: 飞哥B站地址：https://space.bilibili.com/490711252
 * 记得关注和三连哦！
 * @Description: 我们有一个学习网站：https://www.kuangstudy.com
 * @date 2021/11/10 21:03
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@TableName("kss_user") // 指定实体和数据库表kss-user做映射
public class User implements java.io.Serializable {
    // 用户id
    @TableId(type = IdType.AUTO)
    private Integer id;
    // 用户昵称
    @TableField("nickname")//一旦数据库字段与这个字段名称不一致
    private String nickname;
    // 用户密码
    private String password;
    // 用户收集
    private String telephone;
    // 用户的邮箱
    private String email;
    // 用户的头像
    private String avatar;
    // 用户的签名
    private String sign;
    // 用户的注册时间
    @TableField("create_time")//遵循驼峰命名法则就不需要了一定写这个注解
    private Date createTime;
    // 用户的更新时间
    private Date updateTime;
    // 用户的激活状态 1激活 0 未激活
    private Integer active;
    // 角色 admin 管理员 normal正常用户
    private String role;
}
