package com.itqf.demo01.controller;

import com.itqf.demo01.entity.User;
import com.itqf.demo01.service.WeekService;
import com.itqf.demo01.utils.Constant;
import com.itqf.demo01.utils.JsonMessage;
import com.itqf.demo01.vo.VoWeek;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * projectName:easys
 *
 * @author: 三毛
 * time:2020/9/271:07
 * description: 周报的控制层
 */
@Controller
@RequestMapping("/week")
public class WeekController {

    @Autowired
    private WeekService weekService ;

    /**
     * 添加一个周报
     * @param session
     * @param weekMessage
     * @param title
     * @return
     */
    @RequestMapping("/addWeek.do")
    @ResponseBody
    public JsonMessage addWeek(HttpSession session, String weekMessage , String title){
        JsonMessage jsonMessage = new JsonMessage();

        User  user = (User) session.getAttribute(Constant.LOGIN_USER);

        try {
            weekService.insertWeek(user , weekMessage , title);
            jsonMessage.setCode(0);
            jsonMessage.setMsg("添加成功");
            return jsonMessage ;
        } catch (RuntimeException e) {
            jsonMessage.setCode(1);
            jsonMessage.setMsg(e.getMessage());
            return jsonMessage ;
        }
    }

    /**
     * 查询所有的周报
     * @param session
     * @param page
     * @param limit
     * @return
     */
    @RequestMapping("/findAll.do")
    @ResponseBody
    public JsonMessage findAll(HttpSession session ,String page,String limit){
        JsonMessage jsonMessage = new JsonMessage();
        User  user = (User) session.getAttribute(Constant.LOGIN_USER);
        try {
            jsonMessage = weekService.findAll(user,page,limit);
            return jsonMessage ;
        } catch (RuntimeException e) {
            jsonMessage.setCode(1);
            jsonMessage.setMsg(e.getMessage());
            return jsonMessage ;
        }
    }

    /**
     * 删除周报
     * @param wid 周报的id
     * @return
     */
    @RequestMapping("/deleteWeek.do")
    @ResponseBody
    public JsonMessage deleteWeek(String wid){
        JsonMessage jsonMessage = new JsonMessage();

        try {
            weekService.deleteWeek(wid);
            jsonMessage.setCode(0);
            jsonMessage.setMsg("删除成功！");
            return jsonMessage ;
        } catch (RuntimeException e) {
            jsonMessage.setCode(1);
            jsonMessage.setMsg(e.getMessage());
            return jsonMessage ;
        }
    }

    /**
     * 修改周报
     * @param voWeek
     * @return
     */
    @RequestMapping("/updateWeek.do")
    @ResponseBody
    public JsonMessage updateWeek(VoWeek voWeek){
        JsonMessage jsonMessage = new JsonMessage();

        try {
            weekService.updateWeek(voWeek);
            jsonMessage.setCode(0);
            jsonMessage.setMsg("修改成功！");
            return jsonMessage ;
        } catch (RuntimeException e) {
            jsonMessage.setCode(1);
            jsonMessage.setMsg(e.getMessage());
            return jsonMessage ;
        }
    }
}
