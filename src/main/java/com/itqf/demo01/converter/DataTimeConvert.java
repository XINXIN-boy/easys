package com.itqf.demo01.converter;

import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * projectName:easys
 *
 * @author: 三毛
 * time:2020/9/2514:41
 * description:
 */
public class DataTimeConvert implements Converter<String , Date> {
    SimpleDateFormat[] simpleDateFormats = new SimpleDateFormat[]{
            new SimpleDateFormat("yyyy-MM-dd"),
            new SimpleDateFormat("yyyyMMdd"),
            new SimpleDateFormat("yyyy年MM月dd日"),
    } ;
    @Override
    public Date convert(String s) {

        if (s == null) {
            return null ;
        }
        for (SimpleDateFormat simpleDateFormat : simpleDateFormats) {
            try {
                Date date  = simpleDateFormat.parse(s);
                return date ;
            } catch (ParseException e) {
                e.printStackTrace();
                continue;
            }
        }
        return null ;
    }
}
