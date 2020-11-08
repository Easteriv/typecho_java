package com.github.typecho_java.service;

import com.github.typecho_java.dto.PageDTO;
import com.github.typecho_java.dto.PostDTO;

/**
 * @author zhaojiejun
 */
public interface PostService {
    /**
     * 根据类目分页查询文章列表
     * @param categoryId 类目ID
     * @param pageNo 当前页
     * @param pageSize 每页条数
     * @return 分页数据
     */
    PageDTO<PostDTO> queryPageByCid(Integer categoryId, Integer pageNo, Integer pageSize);
}
