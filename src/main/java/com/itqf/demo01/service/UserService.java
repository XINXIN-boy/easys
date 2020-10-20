package com.itqf.demo01.service;

import com.itqf.demo01.entity.User;

/**
 * projectName:easys
 *
 * @author: 三毛
 * time:2020/9/2514:56
 * description:用户的业务
 */
public interface UserService  {

    /**
     * 登录
     * @param no
     * @param pass
     * @return
     */
    User findUser(String no, String pass);

    /**
     * 修改密码
     * @param user
     * @param password
     */
    void updateUserPassword(User user, String password);
}
