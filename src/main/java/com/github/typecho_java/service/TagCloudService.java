package com.github.typecho_java.service;

import com.github.typecho_java.dto.TagDTO;

import java.util.List;

/**
 * 标签云接口
 * @author zhaojiejun
 */
public interface TagCloudService {
    /**
     * 查找所有的标签List
     * @return 成功：返回标签List 失败：空集合
     */
    List<TagDTO> findAllTag();
}
