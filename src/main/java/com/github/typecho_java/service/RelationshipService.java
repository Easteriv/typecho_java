package com.github.typecho_java.service;

import com.github.typecho_java.dao.Relationship;

import java.util.List;

/**
 * @author zhaojiejun
 */
public interface RelationshipService {
    /**
     * 根据分类Id查找当前分类下所有文章ID
     * @param mid 分类ID
     * @return 当前分类下所有文章Id
     */
    List<Relationship>selectListByMid(Integer mid);
}
