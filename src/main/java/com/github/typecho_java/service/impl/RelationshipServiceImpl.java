package com.github.typecho_java.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.typecho_java.constant.dbConstant.RelationShipConstant;
import com.github.typecho_java.dao.Relationship;
import com.github.typecho_java.mapper.RelationshipMapper;
import com.github.typecho_java.service.RelationshipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zhaojiejun
 * @date 2020/11/8 6:37 下午
 **/
@Service
public class RelationshipServiceImpl implements RelationshipService {
    @Autowired
    private RelationshipMapper relationshipMapper;
    /**
     * 根据分类Id查找当前分类下所有文章ID
     * @param mid 分类ID
     * @return 当前分类下所有文章Id
     */
    @Override
    public List<Relationship> selectListByMid(Integer mid) {
        return relationshipMapper.selectList(new QueryWrapper<Relationship>()
                .eq(RelationShipConstant.MID_FIELD, mid));
    }
}
