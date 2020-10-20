package com.itqf.demo01.dao;

import com.itqf.demo01.entity.User;

/**
 * projectName:easys
 *
 * @author: 三毛
 * time:2020/9/2515:01
 * description: 用户的数据操作
 */
public interface UserDao {

    /**
     * 根据账号查找用户
     * @param no
     * @return
     */
     User findUser(String no) ;

    /**
     * 修改密码
     * @param user
     * @return
     */
    int updatePassword(User user);

    void insertUser(User user);
}
