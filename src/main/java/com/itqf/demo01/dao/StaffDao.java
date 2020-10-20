package com.itqf.demo01.dao;

import com.itqf.demo01.entity.Staff;

import java.util.List;

/**
 * projectName:easys
 *
 * @author: 三毛
 * time:2020/9/2516:55
 * description:职员的数据控制
 */
public interface StaffDao {


    void insertStaff(Staff staff);

    int deleteStaff(int id);
    /**
     * 修改个人资料
     * @param newStaff
     * @return
     */
    int updateInfo(Staff newStaff);

    /**
     * 查找职员
     * @param no 账号
     * @return
     */
    Staff findStaff(String no);

    /**
     * 查询所有的员工
     * @return
     */
    List<Staff> findAll();

    Staff findStaffById(int id);
}
