package com.github.typecho_java.util;

import com.github.typecho_java.constant.ErrorCodeEnum;
import com.github.typecho_java.dao.Metas;
import com.github.typecho_java.dto.CategoryDTO;
import com.github.typecho_java.exception.BizException;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author zhaojiejun
 * @date 2020/11/7 11:59 下午
 **/
@Slf4j
public class CategoryTreeUtil {
    /**
     * 格式化类目树
     *
     * @param categoryDTOList 数据源
     * @return List<CategoryDTO>
     */
    public static List<CategoryDTO> formattedTree(List<CategoryDTO> categoryDTOList) {
        if (categoryDTOList == null) {
            return Collections.emptyList();
        } else {
            return getChildManyGroup(categoryDTOList, 0);
        }
    }

    /**
     * 按照pid 格式化子节点
     *
     * @param categoryDTOList 数据源
     * @param pid             父节点ID
     * @return List<CategoryDTO>
     */
    private static List<CategoryDTO> getChildManyGroup(List<CategoryDTO> categoryDTOList, Integer pid) {
        List<CategoryDTO> arr = new ArrayList<>();
        categoryDTOList.forEach(categoryDTO -> {
            if (pid.equals(categoryDTO.getParentId())) {
                categoryDTO.setChildes(getChildManyGroup(categoryDTOList, categoryDTO.getCid()));
                arr.add(categoryDTO);
            }
        });
        return arr;
    }
}
