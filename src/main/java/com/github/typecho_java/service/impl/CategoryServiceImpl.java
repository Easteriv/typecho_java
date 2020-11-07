package com.github.typecho_java.service.impl;

import com.github.typecho_java.dao.Metas;
import com.github.typecho_java.dto.CategoryDTO;
import com.github.typecho_java.service.CategoryService;
import com.github.typecho_java.service.MetaService;
import com.github.typecho_java.util.CategoryTreeUtil;
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
     * 查找所有的项目
     *
     * @return 成功：返回类目List 失败：空集合
     */
    @Override
    public List<CategoryDTO> findAllCategory() {
        List<Metas> metas = metaService.findAllCategory();
        if (CollectionUtils.isNotEmpty(metas)) {
            List<CategoryDTO> list = convert2Category(metas);
            return CategoryTreeUtil.formattedTree(list);
        }
        return Collections.emptyList();
    }

    /**
     * metas转换为category集合
     * @param metas 元数据
     * @return 类目集合
     */
    private List<CategoryDTO> convert2Category(List<Metas> metas) {
        List<CategoryDTO> list = new ArrayList<>();
        for (Metas meta : metas) {
            CategoryDTO categoryDTO = CategoryDTO.builder().cid(meta.getMid()).name(meta.getName()).parentId(meta.getParent())
                    .slug(meta.getSlug()).order(meta.getOrder()).build();
            list.add(categoryDTO);
        }
        return list;
    }
}
