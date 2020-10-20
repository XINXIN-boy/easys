package com.itqf.demo01.service.impl;

import com.itqf.demo01.dao.UserDao;
import com.itqf.demo01.entity.User;
import com.itqf.demo01.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * projectName:easys
 *
 * @author: 三毛
 * time:2020/9/2514:57
 * description: 用户的业务实现
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao ;

    @Override
    public User findUser(String no, String pass) {

         User user = userDao.findUser(no);

         if (user != null ){

             if (pass.equals(user.getPassword())){
                 return user ;
             }else {
              throw new RuntimeException("密码错误") ;
             }
         }else {
             throw  new RuntimeException("账号不存在") ;
         }
    }

    @Override
    public void updateUserPassword(User user, String password) {

        user.setPassword(password);

       int rows =  userDao.updatePassword( user) ;

        if (rows>0) {
            //success
        }else {
            throw new RuntimeException("密码修改失败") ;
        }

    }
}
