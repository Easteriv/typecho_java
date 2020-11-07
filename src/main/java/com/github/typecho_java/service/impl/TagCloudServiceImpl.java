package com.github.typecho_java.service.impl;

import com.github.typecho_java.constant.CommonConstant;
import com.github.typecho_java.dao.Metas;
import com.github.typecho_java.dto.TagDTO;
import com.github.typecho_java.service.MetaService;
import com.github.typecho_java.service.TagCloudService;
import com.github.typecho_java.util.ConvertUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zhaojiejun
 * @date 2020/11/8 1:10 上午
 **/
@Service
public class TagCloudServiceImpl implements TagCloudService {
    @Autowired
    private MetaService metaService;

    /**
     * 查找所有的标签List
     *
     * @return 成功：返回标签List 失败：空集合
     */
    @Override
    public List<TagDTO> findAllTag() {
        List<Metas> metas = metaService.queryMetasByType(CommonConstant.DB_TAG_VALUE);
        return ConvertUtil.meta2Tag(metas);
    }
}
