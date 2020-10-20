package com.itqf.demo01.service;

import com.itqf.demo01.entity.Staff;
import com.itqf.demo01.entity.User;
import com.itqf.demo01.utils.JsonMessage;

import java.util.List;

/**
 * projectName:easys
 *
 * @author: 三毛
 * time:2020/9/2516:54
 * description: 职员的业务层
 */
public interface StaffService {
    /**
     * 根据账号查找职员
     * @param no
     * @return
     */
    Staff findStaffByNo(String no);

    /**
     * 修改个人资料
     * @param user
     * @param newStaff
     */
    void updateStaffInfo(User user, Staff newStaff);

    /**
     * 查询所有的员工
     * @return
     */
    JsonMessage findAll(int page , int limit);

    void insertStaff(Staff staff);

    void deleteStaff(int id);

    void updateStaff(Staff staff);

}
