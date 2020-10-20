package com.itqf.demo01.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.itqf.demo01.dao.DepartDao;
import com.itqf.demo01.dao.StaffDao;
import com.itqf.demo01.dao.UserDao;
import com.itqf.demo01.entity.Depart;
import com.itqf.demo01.entity.Staff;
import com.itqf.demo01.entity.User;
import com.itqf.demo01.service.StaffService;
import com.itqf.demo01.utils.JsonMessage;
import com.itqf.demo01.utils.RandomCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

/**
 * projectName:easys
 *
 * @author: 三毛
 * time:2020/9/2516:56
 * description:职员的业务实现
 */
@Service
public class StaffServiceimpl implements StaffService {

    @Autowired
    private StaffDao staffDao ;

    @Autowired
    private DepartDao departDao ;

    @Autowired
    private UserDao userDao ;
    @Override
    public void insertStaff(Staff staff) {
        String uno = "ZZ" ;
        while(true) {
            uno += RandomCode.getCode();
            Staff judgeStaff = staffDao.findStaff(uno);
            if (judgeStaff==null){
                break;
            }
        }
        staff.setUno(uno);
        Depart depart =  departDao.findDepartByID(staff.getDid());
        staff.setDname(depart.getName());
        staff.setHeading("media/images/qf.jpg");
        staff.setFlag(1);
        staffDao.insertStaff(staff);

        User user = new User();
        user.setPassword("000000");
        user.setNo(uno);
        user.setStatus("0");
        user.setFlag(1);
        user.setRole(1);
        user.setIdentity(1);
        userDao.insertUser(user);

    }

    @Override
    public void deleteStaff(int id) {
        int rows =  staffDao.deleteStaff(id);
        if (rows==0){
            throw new RuntimeException("删除失败");
        }
    }

    @Override
    public void updateStaff(Staff staff) {
        Staff staff1 =  staffDao.findStaffById(staff.getId());
        staff.setUno(staff1.getUno());
        int rows  =   staffDao.updateInfo(staff);
        if (rows > 0){
            //success
        }else {
            throw  new RuntimeException("系统异常，稍后再试") ;
        }

    }


    @Override
    public void updateStaffInfo(User user, Staff newStaff) {
        String uno = user.getNo() ;
        newStaff.setUno(uno);
        //调用dao
        int rows  =   staffDao.updateInfo(newStaff);
        if (rows > 0){
            //success
        }else {
            throw  new RuntimeException("系统异常，稍后再试") ;
        }
    }

    @Override
    public Staff findStaffByNo(String no) {
        Staff staff =   staffDao.findStaff(no);
        if (staff == null){
            throw  new RuntimeException("系统异常，稍后再试") ;
        }else {
            return staff ;
        }
    }


    @Override
    public JsonMessage findAll(int page , int limit) {
        JsonMessage jsonMessage = new JsonMessage();
        PageHelper.startPage(page, limit);
        List<Staff> list =  staffDao.findAll();

        if (list!= null && list.size()>0){
            jsonMessage.setCode(0);
            jsonMessage.setMsg("查询成功");
            jsonMessage.setData(list);
            jsonMessage.setCount(((Page)list).getTotal());
        }else {
            jsonMessage.setCode(1);
            jsonMessage.setMsg("未查到数据");
            jsonMessage.setData(list);
        }
        return jsonMessage ;
    }


}
