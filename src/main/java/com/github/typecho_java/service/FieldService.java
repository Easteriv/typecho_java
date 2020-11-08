package com.github.typecho_java.service;

import com.github.typecho_java.dao.Fields;

import java.util.List;
import java.util.Map;

/**
 * 自定义字段service层
 * @author zhaojiejun
 */
public interface FieldService {

    /**
     * 根据文章id查找文章配置参数信息
     * @param cid 文章主键ID
     * @return 文章配置参数
     */
    Map<String,String> selectMap(Integer cid);
}
