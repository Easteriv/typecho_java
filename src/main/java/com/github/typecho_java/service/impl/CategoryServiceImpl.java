package com.github.typecho_java.service.impl;

import com.github.typecho_java.constant.CommonConstant;
import com.github.typecho_java.constant.dbConstant.MetasConstant;
import com.github.typecho_java.dao.Metas;
import com.github.typecho_java.dto.CategoryDTO;
import com.github.typecho_java.service.CategoryService;
import com.github.typecho_java.service.MetaService;
import com.github.typecho_java.util.CategoryTreeUtil;
import com.github.typecho_java.util.ConvertUtil;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author zhaojiejun
 * @date 2020/11/7 11:51 下午
 **/
@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private MetaService metaService;

    /**
     * 查找所有的类目List
     *
     * @return 成功：返回类目List 失败：空集合
     */
    @Override
    public List<CategoryDTO> findAllCategory() {
        List<Metas> metas = metaService.queryMetasByType(CommonConstant.DB_CATEGORY_VALUE);
        if (CollectionUtils.isNotEmpty(metas)) {
           return ConvertUtil.meta2Category(metas);
        }
        return Collections.emptyList();
    }


    /**
     * 查找所有的类目树
     * @return 成功：返回类目List 失败：空集合
     */
    @Override
    public List<CategoryDTO> findCategoryTreeList() {
        List<CategoryDTO> list = findAllCategory();
        return CategoryTreeUtil.formattedTree(list);
    }
}
