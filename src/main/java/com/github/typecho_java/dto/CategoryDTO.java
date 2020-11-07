package com.github.typecho_java.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

/**
 * 分类模型
 * @author zhaojiejun
 * @date 2020/11/7 11:24 下午
 **/
@Data
@Builder
public class CategoryDTO {
    /**
     * 类目Id
     */
    private Integer cid;
    /**
     * 排行顺序
     */
    private Integer order;
    /**
     * 缩略名
     */
    private String slug;
    /**
     * 类目名称
     */
    private String name;
    /**
     * 父Id
     */
    private Integer parentId;
    /**
     * 所有子节点类目
     */
    private List<CategoryDTO> childes;
}
