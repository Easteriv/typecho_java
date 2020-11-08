package com.github.typecho_java.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.typecho_java.constant.CommonConstant;
import com.github.typecho_java.constant.dbConstant.FieldsConstant;
import com.github.typecho_java.constant.dbConstant.PostContentConstant;
import com.github.typecho_java.dao.PostContent;
import com.github.typecho_java.dao.Relationship;
import com.github.typecho_java.dao.User;
import com.github.typecho_java.dto.PageDTO;
import com.github.typecho_java.dto.PostDTO;
import com.github.typecho_java.mapper.PostContentMapper;
import com.github.typecho_java.service.FieldService;
import com.github.typecho_java.service.PostService;
import com.github.typecho_java.service.RelationshipService;
import com.github.typecho_java.service.UserService;
import com.github.typecho_java.util.AvatarUtil;
import com.github.typecho_java.util.TimeUtil;
import com.github.typecho_java.wrapper.PageWrapper;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author zhaojiejun
 * @date 2020/11/8 3:02 下午
 **/
@Service
public class PostServiceImpl implements PostService {

    private static final String DEFAULT_SUMMARY = "这是一段默认简介";
    private static final String DEFAULT_COVER_URL = "https://cdn.suscrb.com/uPic/001050387147.jpg";
    @Autowired
    private RelationshipService relationshipService;
    @Autowired
    private UserService userService;
    @Autowired
    private FieldService fieldService;
    @Autowired
    private PostContentMapper postContentMapper;

    /**
     * 根据类目分页查询文章列表
     *
     * @param categoryId 类目ID
     * @param pageNo     当前页
     * @param pageSize   每页条数
     * @return 分页数据
     */
    @Override
    public PageDTO<PostDTO> queryPageByCid(Integer categoryId, Integer pageNo, Integer pageSize) {
        List<Relationship> relationships = relationshipService.selectListByMid(categoryId);
        List<Integer> cidList = relationships.stream().map(Relationship::getCid).collect(Collectors.toList());
        Page<PostContent> page = new Page<>(pageNo, pageSize);
        Page<PostContent> postContentPage;
        if (CollectionUtils.isNotEmpty(cidList)) {
            postContentPage = postContentMapper.selectPage(page, new QueryWrapper<PostContent>()
                    .eq(PostContentConstant.TYPE_FIELD, CommonConstant.DB_POST_TYPE_VALUE)
                    .eq(PostContentConstant.STATUS_FIELD, CommonConstant.DB_PUBLISH_VALUE)
                    .orderByDesc(PostContentConstant.CREATED_FIELD));
        } else {
            postContentPage = page.setRecords(new ArrayList<>()).setTotal(NumberUtils.LONG_ZERO);
        }
        return convert(postContentPage);
    }

    /**
     * 分页文章数据源转为自定义分页文章实体类
     *
     * @param postContentPage 分页数据源
     * @return 自定义分页文章实体类
     */
    private PageDTO<PostDTO> convert(Page<PostContent> postContentPage) {
        PageWrapper<PostContent> pageWrapper = new PageWrapper<>(postContentPage);
        return pageWrapper.convertPage(this::content2post);
    }

    /**
     * 文章数据源转为自定义文章实体类
     *
     * @param postContent 文章数据源转
     * @return 自定义文章实体类
     */
    private PostDTO content2post(PostContent postContent) {
        Integer cid = postContent.getCid();
        Integer authorId = postContent.getAuthorId();
        //标题
        String title = postContent.getTitle();
        //阅读次数
        Integer views = postContent.getViews();
        User user = userService.getUser(authorId);
        //作者昵称
        String nickName = user.getScreenName();
        //作者头像
        String avatar = AvatarUtil.getAvatarUrl(user.getMail());
        //最后修改日期
        long created = postContent.getCreated();
        String updateTimeStr = TimeUtil.getTimeStr(created, CommonConstant.PATTERN_ALL);
        //封面
        Map<String, String> selectMap = fieldService.selectMap(cid);
        String coverUrl = selectMap.getOrDefault(FieldsConstant.DB_BIG_IMG, DEFAULT_COVER_URL);
        //简介
        String summary = selectMap.getOrDefault(FieldsConstant.DB_DESC, DEFAULT_SUMMARY);
        return PostDTO.builder().id(cid).author(nickName).views(views).updateTimeStr(updateTimeStr)
                .title(title).cover(coverUrl).avatar(avatar).summary(summary).build();
    }
}
