package com.itqf.demo01.utils;

import java.util.Random;

/**
 * projectName:easys
 *
 * @author: 三毛
 * time:2020/10/169:31
 * description:
 */
public class RandomCode {
    private RandomCode(){}
    public static String getCode(){
        StringBuilder stringBuilder = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 4; i++) {
            stringBuilder.append(random.nextInt(10));
        }
        return stringBuilder.toString();
    }

}
