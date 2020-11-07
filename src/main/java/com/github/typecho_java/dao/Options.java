package com.github.typecho_java.dao;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 *配置表
 * @author zhaojiejun
 * @date 2020/11/7 10:52 下午
 **/
@Data
@TableName("typecho_options")
public class Options {
    /**
     *	配置名称
     */
    private String name;
    /**
     *配置所属用户,默认为0(全局配置)
     */
    private Integer user;
    /**
     *配置值
     */
    private String value;
}
