package com.itqf.demo01.service;

import com.itqf.demo01.utils.JsonMessage;

/**
 * projectName:easys
 *
 * @author: 三毛
 * time:2020/9/2911:01
 * description:匿名投诉的业务
 */
public interface AnonymityService  {
    /**
     * 查询所有
     * @param page
     * @param limit
     * @return
     */
    JsonMessage findAll(int page, int limit);

    /**
     * 删除
     * @param id
     */
    void deleteAnonymity(int id);

    /**
     * 修改状态
     * @param id
     * @param status
     */
    void updateAnonymityStatus(int id, int status);
}
