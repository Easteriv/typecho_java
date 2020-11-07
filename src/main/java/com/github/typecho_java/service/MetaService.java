package com.github.typecho_java.service;

import com.github.typecho_java.dao.Metas;

import java.util.List;

/**
 * @author zhaojiejun
 */
public interface MetaService {
    /**
     * 查找所有的项目
     * @return 成功：返回类目List 失败：空集合
     */
    List<Metas> findAllCategory();
}
