package com.itqf.demo01.service;

import com.itqf.demo01.entity.User;
import com.itqf.demo01.utils.JsonMessage;

/**
 * projectName:easys
 *
 * @author: 三毛
 * time:2020/9/299:42
 * description:会员的业务
 */
public interface VipService {

    /**
     * 修改状态
     * @param vid
     * @param status
     */
    void updateVipStatus(Integer vid, Integer status);

    /**
     * 删除申请
     * @param vid
     */
    void deleteVipApply(Integer vid);

    /**
     * 添加申请
     * @param user
     * @param content
     */
    void insertVipApply(User user, String content);
    /**
     * 查询所有
     * @return
     */
    JsonMessage findAll(Integer status ,int page ,int limit);
}
