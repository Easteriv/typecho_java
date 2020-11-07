package com.github.typecho_java.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.github.typecho_java.dao.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author zhaojiejun
 * @date 2020/11/7 11:02 下午
 **/
@Mapper
public interface UserMapper extends BaseMapper<User> {
}
