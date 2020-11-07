package com.github.typecho_java.dao;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 文章评论表
 * @author zhaojiejun
 * @date 2020/11/7 10:40 下午
 **/
@Data
@TableName("typecho_comments")
public class PostComment {
    /**
     * comment表主键
     */
    @TableId("coid")
    private Integer coid;
    /**
     * post表主键,关联字段
     */
    private Integer cid;
    /**
     * 评论生成时的GMT unix时间戳
     */
    private Integer created;
    /**
     * 评论作者
     */
    private String author;
    /**
     * 评论所属用户id
     */
    @TableField(value = "authorId")
    private Integer authorId;
    /**
     * 评论所属内容作者id
     */
    @TableField(value = "ownerId")
    private Integer ownerId;
    /**
     * 评论者邮件
     */
    private String mail;
    /**
     * 评论者网址
     */
    private String url;
    /**
     * 评论者ip地址
     */
    private String ip;
    /**
     * 评论者客户端
     */
    private String agent;
    /**
     * 	评论文字
     */
    private String text;
    /**
     * 	评论类型
     */
    private String type;
    /**
     * 评论状态
     */
    private String status;
    /**
     * 父级评论
     */
    private Integer parent;
}
