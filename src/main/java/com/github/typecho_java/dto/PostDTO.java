package com.github.typecho_java.dto;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

/**
 * 文章列表类型DTO
 * @author zhaojiejun
 * @date 2020/11/8 2:54 下午
 **/
@Data
@Builder
public class PostDTO {
    /**
     * 文章ID
     */
    private Integer id;
    /**
     * 作者
     */
    private String author;
    /**
     * 标题
     */
    private String title;
    /**
     * 小结
     */
    private String summary;
    /**
     * 观看次数
     */
    private Integer views;
    /**
     * 更新时间
     */
    private String updateTimeStr;
    /**
     * 封面
     */
    private String cover;
    /**
     * 头像
     */
    private String avatar;
}
