package com.github.typecho_java.util;

import com.github.typecho_java.dao.Metas;
import com.github.typecho_java.dto.CategoryDTO;
import com.github.typecho_java.dto.TagDTO;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhaojiejun
 * @date 2020/11/8 1:08 上午
 **/
public class ConvertUtil {
    private ConvertUtil(){};

    /**
     * 将数据源集合按需转换成类目集合
     * @param metas metas数据源
     * @return CategoryDTO类目集合
     */
    public static List<CategoryDTO> meta2Category(List<Metas> metas) {
        List<CategoryDTO> list = new ArrayList<>();
        for (Metas meta : metas) {
            CategoryDTO categoryDTO = CategoryDTO.builder().cid(meta.getMid()).name(meta.getName())
                    .parentId(meta.getParent())
                    .slug(meta.getSlug()).order(meta.getOrder()).build();
            list.add(categoryDTO);
        }
        return list;
    }

    /**
     * 将数据源集合按需转换成标签集合
     * @param metas metas数据源
     * @return TagDTO
     */
    public static List<TagDTO> meta2Tag(List<Metas> metas) {
        List<TagDTO> list = new ArrayList<>();
        for (Metas meta : metas) {
            TagDTO tagDTO = TagDTO.builder().tid(meta.getMid()).name(meta.getName()).slug(meta.getSlug())
                    .build();
            list.add(tagDTO);
        }
        return list;
    }
}
