package com.github.typecho_java.dao;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author zhaojiejun
 * @date 2020/11/7 10:56 下午
 **/
@Data
@TableName("typecho_users")
public class User {
    /**
     * user表主键
     */
    @TableId("uid")
    private Integer uid;
    /**
     * 用户名称
     */
    private String name;
    /**
     * 用户密码
     */
    private String password;
    /**
     * 用户的邮箱
     */
    private String mail;
    /**
     * 用户的主页
     */
    private String url;
    /**
     * 用户显示的名称
     */
    @TableField("screenName")
    private String screenName;
    /**
     * 用户注册时的GMT unix时间戳
     */
    private Integer created;
    /**
     * 最后活动时间
     */
    private Integer activated;
    /**
     * 	上次登录最后活跃时间
     */
    private Integer logged;
    /**
     *用户组
     */
    @TableField("'group'")
    private String group;
    /**
     * 用户登录验证码
     */
    @TableField("authCode")
    private String authCode;
}
