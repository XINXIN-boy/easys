package com.itqf.demo01.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.itqf.demo01.entity.Staff;
import com.itqf.demo01.entity.User;
import com.itqf.demo01.service.StaffService;
import com.itqf.demo01.service.UserService;
import com.itqf.demo01.utils.Constant;
import com.itqf.demo01.utils.JsonMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * projectName:easys
 *
 * @author: 三毛
 * time:2020/9/2516:53
 * description: 员工控制类
 */
@Controller
@ResponseBody
@RequestMapping("/staff")
public class StaffController {

    @Autowired
    private StaffService staffService ;

    @Autowired
    private UserService userService ;


    @RequestMapping("addStaff.do")
    public JsonMessage addStaff(Staff staff){
        JsonMessage jsonMessage = new JsonMessage();
        System.out.println("jsonMessage = " + staff);
        try {
            staffService.insertStaff(staff);
            jsonMessage.setCode(0);
            jsonMessage.setMsg("添加信息成功!");
        } catch (RuntimeException e) {
            jsonMessage.setCode(1);
            jsonMessage.setMsg(e.getMessage());
        }
        return jsonMessage ;
    }

    @RequestMapping("deleteStaff.do")
    public JsonMessage deleteStaff(int id){
        JsonMessage jsonMessage = new JsonMessage();
            try {
                staffService.deleteStaff(id);
                jsonMessage.setCode(0);
                jsonMessage.setMsg("删除成功!");
            } catch (RuntimeException e) {
                jsonMessage.setCode(1);
                jsonMessage.setMsg(e.getMessage());
            }
        return jsonMessage ;
    }

    @RequestMapping("updateStaff.do")
    public JsonMessage updateStaff(Staff staff){
        JsonMessage jsonMessage = new JsonMessage();
        try {
            staffService.updateStaff(staff);
            jsonMessage.setCode(0);
            jsonMessage.setMsg("更新成功!");
        } catch (RuntimeException e) {
            jsonMessage.setCode(1);
            jsonMessage.setMsg(e.getMessage());
        }
        return jsonMessage ;
    }



    /**
     * 修改个人资料
     * @param session
     * @param newStaff
     * @return
     */
    @RequestMapping("/updateInfo.do")
    @ResponseBody
    public JsonMessage updateStaffInfo(HttpSession session ,Staff newStaff, String password){
        JsonMessage jsonMessage = new JsonMessage();
        User user = (User) session.getAttribute(Constant.LOGIN_USER);

        if (newStaff.getName() != null || newStaff.getPhone() != null) {
            //anme sex
            System.out.println("newStaff.getName() = " + newStaff.getName());

            try {
                staffService.updateStaffInfo(user,newStaff);
                jsonMessage.setCode(0);
                jsonMessage.setMsg("信息修改成功!");

                return jsonMessage ;
            } catch (RuntimeException e) {
                jsonMessage.setCode(1);
                jsonMessage.setMsg(e.getMessage());

                return jsonMessage ;
            }
        }

        if (password != null) {
            try {
                userService.updateUserPassword(user,password);
                jsonMessage.setCode(2);
                jsonMessage.setMsg("密码修改成功!");

                return jsonMessage ;
            } catch (RuntimeException e) {
                jsonMessage.setCode(1);
                jsonMessage.setMsg(e.getMessage());

                return jsonMessage ;
            }
        }

        return  jsonMessage ;
    }


    @RequestMapping("/findAll.do")
    @ResponseBody
    public JsonMessage findAll(@RequestParam(defaultValue = "1")int page , @RequestParam(defaultValue = "10") int limit ){
        JsonMessage jsonMessage = staffService.findAll(page, limit);

        return jsonMessage  ;
    }


    /**
     * 查找职员 根据 uno
     * @param session
     * @return
     */
    @RequestMapping("/findStaffByNo.do")
    @ResponseBody
    public JsonMessage findStaffByNo(HttpSession session){
        JsonMessage jsonMessage = new JsonMessage();
        User user = (User) session.getAttribute(Constant.LOGIN_USER);

        try {
            Staff staff =  staffService.findStaffByNo(user.getNo());
            jsonMessage.setData(0);
            jsonMessage.setMsg("查询成功");
            jsonMessage.setData(staff);
        } catch (RuntimeException e) {
            jsonMessage.setData(1);
            jsonMessage.setMsg(e.getMessage());
        }

        return jsonMessage ;
    }

//    {"name":"","qq":"","phone":"14525256363","email":"4564556@qq.com","sex":"男","password":"123456789"}


}
