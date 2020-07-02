package com.aihwaong.minicm.convert;

import com.alibaba.druid.util.StringUtils;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * +-------------------------------------------------------
 * |
 * +-------------------------------------------------------
 * | @package:       com.aihwaong.minicm.convert
 * +-------------------------------------------------------
 * | @Title:         日期转换器
 * +-------------------------------------------------------
 * | @ProjectName:   minicm
 * +-------------------------------------------------------
 * | @Description:   功能描述
 * +-------------------------------------------------------
 * | @author:        王富琳
 * +-------------------------------------------------------
 * | @email:         < 894633456@qq.com >
 * +-------------------------------------------------------
 * | @date:          2020/7/1 16:32
 * +-------------------------------------------------------
 * | @updateUser:    修改人
 * +-------------------------------------------------------
 * | @updateTime:    修改时间
 * +-------------------------------------------------------
 */
@Configuration
public class StringToDateConverter implements Converter<String, Date> {
    private static final String shortDateFormat = "yyyy-MM-dd";

    @Override
    public Date convert(String source) {
        if (StringUtils.isEmpty(source)) {
            return null;
        }
        source = source.trim();
        try {
            SimpleDateFormat formatter = new SimpleDateFormat(shortDateFormat);
            Date converterDate = formatter.parse(source);
            return converterDate;
        }
        catch (ParseException exception) {
            exception.printStackTrace();
        }
        return null;
    }

}
