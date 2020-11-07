package com.github.typecho_java.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.typecho_java.constant.CommonConstant;
import com.github.typecho_java.constant.dbConstant.MetasConstant;
import com.github.typecho_java.dao.Metas;
import com.github.typecho_java.mapper.MetasMapper;
import com.github.typecho_java.service.MetaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zhaojiejun
 * @date 2020/11/7 11:35 下午
 **/
@Service
public class MetaServiceImpl implements MetaService {
    @Autowired
    private MetasMapper metasMapper;

    /**
     * 查找所有的项目
     * @return 成功：返回类目List 失败：空集合
     */
    @Override
    public List<Metas> findAllCategory() {
        return metasMapper.selectList(new QueryWrapper<Metas>().eq(MetasConstant.TYPE_FIELD
                , CommonConstant.DB_CATEGORY_VALUE).orderByAsc(MetasConstant.ORDER_FIELD));
    }
}
