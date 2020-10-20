package com.itqf.demo01.controller;

import com.itqf.demo01.service.AnonymityService;
import com.itqf.demo01.utils.JsonMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * projectName:easys
 *
 * @author: 三毛
 * time:2020/9/2910:46
 * description: 匿名投诉的控制层
 */
@ResponseBody
@RequestMapping("/anonymity")
@Controller
public class AnonymityController {
    @Autowired
    private AnonymityService anonymityService ;

    /**
     * 查询所有的匿名投诉
     * @param page
     * @param limit
     * @return
     */
    @RequestMapping("/findAll.do")
    public JsonMessage findaAll(int page , int limit){

        JsonMessage jsonMessage =  anonymityService.findAll(page , limit) ;

        return jsonMessage ;
    }

    @RequestMapping("/deleteAnonymity.do")
    public JsonMessage deleteAnonymity(int id){
        JsonMessage jsonMessage  = new JsonMessage() ;

        try {
            anonymityService.deleteAnonymity(id) ;
            jsonMessage.setCode(0);
            jsonMessage.setMsg("修改成功！");
            return jsonMessage ;
        } catch (RuntimeException e) {
            jsonMessage.setCode(1);
            jsonMessage.setMsg(e.getMessage());
            return jsonMessage ;
        }
    }

    @RequestMapping("/updateAnonymityStatus.do")
    public JsonMessage updateAnonymityStatus(int id , int status){
        JsonMessage jsonMessage  = new JsonMessage() ;

        try {
            anonymityService.updateAnonymityStatus(id , status) ;
            jsonMessage.setCode(0);
            jsonMessage.setMsg("删除成功！");
            return jsonMessage ;
        } catch (RuntimeException e) {
            jsonMessage.setCode(1);
            jsonMessage.setMsg(e.getMessage());
            return jsonMessage ;
        }
    }



}
