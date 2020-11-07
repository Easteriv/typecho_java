package com.github.typecho_java.dto;

import lombok.Builder;
import lombok.Data;

/**
 * 标签DTO
 * @author zhaojiejun
 * @date 2020/11/7 11:27 下午
 **/
@Data
@Builder
public class TagDTO {
    /**
     * 标签ID
     */
    private Integer tid;
    /**
     * 标签名称
     */
    private String name;
    /**
     * 标签缩略名
     */
    private String slug;
}
