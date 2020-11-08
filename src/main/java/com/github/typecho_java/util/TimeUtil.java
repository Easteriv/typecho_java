package com.github.typecho_java.util;

import com.github.typecho_java.constant.ErrorCodeEnum;
import com.github.typecho_java.exception.BizException;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

/**
 * @author zhaojiejun
 * @date 2020/11/8 5:50 下午
 **/
public class TimeUtil {
    /**
     * 将10位时间戳按照时间格式转为时间字符串
     * @param time 10位数字时间戳
     * @param pattern 时间格式
     * @return 返回时间字符串
     */
    public static String getTimeStr(Long time,String pattern) {
        if (time == null || time <= 0) {
            throw new BizException(ErrorCodeEnum.PARAM_NULL);
        }
        LocalDateTime dateTimeOfTimestamp = getDateTimeOfTimestamp(time * 1000);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        return dateTimeOfTimestamp.format(formatter);
    }

    private static LocalDateTime getDateTimeOfTimestamp(long timestamp) {
        Instant instant = Instant.ofEpochMilli(timestamp);
        ZoneId zone = ZoneId.systemDefault();
        return LocalDateTime.ofInstant(instant, zone);
    }
}
