package com.github.typecho_java.service;

import com.github.typecho_java.dao.Metas;

import java.util.List;

/**
 * @author zhaojiejun
 */
public interface MetaService {
    /**
     * 查找所有的项目
     * @param type category:类目 tag:标签
     * @return @return 成功：返回类目List 失败：空集合
     */
    List<Metas> queryMetasByType(String type);
}
