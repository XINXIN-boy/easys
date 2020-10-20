package com.itqf.demo01.controller;

import com.itqf.demo01.entity.User;
import com.itqf.demo01.service.VipService;
import com.itqf.demo01.utils.Constant;
import com.itqf.demo01.utils.JsonMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * projectName:easys
 *
 * @author: 三毛
 * time:2020/9/299:24
 * description:  会员的控制层
 */
@Controller
@RequestMapping("/vip")
@ResponseBody
public class VipController {

    @Autowired
    private VipService vipService ;

    /**
     * 查询所有的会员申请
     * @return
     */
    @RequestMapping("/findAll.do")
    public JsonMessage findAll(Integer status,int page ,int limit ){

        JsonMessage jsonMessage = vipService.findAll(status , page , limit);

        return jsonMessage ;
    }

    /**
     * 修改会员的状态
     * @param vid
     * @return
     */
    @RequestMapping("/updateVipStatus.do")
    public JsonMessage updateVipStatus(Integer vid , Integer status){
        JsonMessage jsonMessage = new JsonMessage();

        try {
            vipService.updateVipStatus(vid , status);
            jsonMessage.setCode(0);
            jsonMessage.setMsg("修改成功");
            return  jsonMessage ;
        } catch (RuntimeException e) {
            jsonMessage.setCode(1);
            jsonMessage.setMsg(e.getMessage());
            return  jsonMessage ;

        }
    }

    /**
     * 删除申请
     * @param vid
     * @return
     */
    @RequestMapping("/deleteVipApply.do")
    public JsonMessage deleteVipApply(Integer vid){
        JsonMessage jsonMessage = new JsonMessage();

        try {
            vipService.deleteVipApply(vid);
            jsonMessage.setCode(0);
            jsonMessage.setMsg("拒绝成功");
            return  jsonMessage ;
        } catch (RuntimeException e) {
            jsonMessage.setCode(1);
            jsonMessage.setMsg(e.getMessage());
            return  jsonMessage ;

        }
    }

    /**
     * 申请会员
     * @return
     */
    @RequestMapping("/insertVipApply.do")
    public JsonMessage insertVipApply(HttpSession session , String content){
        User user = (User) session.getAttribute(Constant.LOGIN_USER);
        JsonMessage jsonMessage = new JsonMessage();
        try {
            vipService.insertVipApply(user,content);
            jsonMessage.setCode(0);
            jsonMessage.setMsg("申请成功，静候佳音！");
            return  jsonMessage ;
        } catch (RuntimeException e) {
            jsonMessage.setCode(1);
            jsonMessage.setMsg(e.getMessage());
            return  jsonMessage ;

        }

    }

}
