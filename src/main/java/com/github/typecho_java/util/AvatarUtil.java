package com.github.typecho_java.util;

import org.apache.commons.lang3.StringUtils;

/**
 * @author zhaojiejun
 * @date 2020/11/8 6:09 下午
 **/
public class AvatarUtil {
    private static final String QQ_SUFFIX = "@qq.com";

    /**
     * 根据邮箱获取用户头像图片地址
     *
     * @param mail 邮箱地址
     * @return 头像地址
     */
    public static String getAvatarUrl(String mail) {
        if (StringUtils.isNotBlank(mail)) {
            if (mail.contains(QQ_SUFFIX)) {
                //调用qq头像API
                String s = StringUtils.substringBeforeLast(mail, QQ_SUFFIX);
                return String.format("http://q1.qlogo.cn/g?b=qq&nk=%s&s=640", s);
            }
        }
        return null;
    }
}