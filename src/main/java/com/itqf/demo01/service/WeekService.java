package com.itqf.demo01.service;

import com.itqf.demo01.entity.User;
import com.itqf.demo01.utils.JsonMessage;
import com.itqf.demo01.vo.VoWeek;

/**
 * projectName:easys
 *
 * @author: 三毛
 * time:2020/9/271:25
 * description:周报业务
 */
public interface WeekService {

    /**
     * 添加周报
     * @param user
     * @param weekMessage
     * @param title
     */
    void insertWeek(User user, String weekMessage, String title);
    /**
     * 查询所有周报
     * @return
     */
    JsonMessage findAll(User user,String page ,String limit);

    /**
     * 删除周报
     * @param wid
     */
    void deleteWeek(String wid);

    /**
     * 修改周报
     * @param voWeek
     */
    void updateWeek(VoWeek voWeek);
}
