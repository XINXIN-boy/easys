package com.itqf.demo01.controller;

import com.itqf.demo01.entity.User;
import com.itqf.demo01.service.UserService;
import com.itqf.demo01.utils.Constant;
import com.itqf.demo01.utils.JsonMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * projectName:easys
 *
 * @author: 三毛
 * time:2020/9/2514:30
 * description: 用户的控制层
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService ;

    /**
     * 登录
     * @param session
     * @param no
     * @param pass
     * @return
     */
    @RequestMapping("/login.do")
    @ResponseBody
    public JsonMessage login(HttpSession session , String no , String pass){
        JsonMessage jsonMessage = new JsonMessage();


        try {
            User user  = userService.findUser(no , pass);

            jsonMessage.setCode(0);
            jsonMessage.setData(user);
            jsonMessage.setMsg("登录成功");

            session.setAttribute(Constant.LOGIN_USER, user);
            return jsonMessage ;
        } catch (RuntimeException e) {

            jsonMessage.setCode(1);
            jsonMessage.setMsg(e.getMessage());

            return jsonMessage ;
        }

    }

    /**
     * 注销
     * @param session
     * @return
     */
    @RequestMapping("/logout.do")
    @ResponseBody
    public JsonMessage login(HttpSession session , HttpServletRequest request){
        JsonMessage jsonMessage = new JsonMessage();

        session.removeAttribute(Constant.LOGIN_USER);
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            if (Constant.JSESSIONID.equals(cookie.getName())) {
                cookie.setValue(null);
            }
        }
        jsonMessage.setCode(0);
        jsonMessage.setMsg("登出成功");
        return jsonMessage ;
    }

    /**
     * 登录状态的验证
     * @param session
     * @return
     */
    @RequestMapping("/loginToJudge.do")
    @ResponseBody
    public JsonMessage loginToJudge(HttpSession session){
        JsonMessage jsonMessage = new JsonMessage();
        User user  = (User) session.getAttribute(Constant.LOGIN_USER);

        if (user!= null){
            jsonMessage.setCode(0);
            jsonMessage.setMsg("已登录");
            jsonMessage.setData(user);
        }else{
            jsonMessage.setCode(1);
            jsonMessage.setMsg("未登录");
        }
        return jsonMessage ;
    }


}
