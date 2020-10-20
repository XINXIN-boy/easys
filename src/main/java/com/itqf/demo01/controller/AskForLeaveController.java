package com.itqf.demo01.controller;

import com.itqf.demo01.entity.Askforleave;
import com.itqf.demo01.service.AskService;
import com.itqf.demo01.utils.JsonMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.xml.bind.util.JAXBSource;
import java.util.List;

/**
 * projectName:easys
 *
 * @author: 三毛
 * time:2020/10/1316:12
 * description: 请假条
 */
@Controller
@ResponseBody
@RequestMapping("/ask")
public class AskForLeaveController {

    @Autowired
    private AskService askService ;

    @RequestMapping("/addAsk.do")
    public JsonMessage addAsk(Askforleave askforleave){
        JsonMessage jsonMessage = new JsonMessage();
        try {
            askService.insertAsk(askforleave);
            jsonMessage.setCode(0);
            jsonMessage.setMsg("添加成功");
        } catch (RuntimeException e) {
            jsonMessage.setCode(1);
            jsonMessage.setMsg(e.getMessage());
        }
        return jsonMessage ;
    }


    @RequestMapping("/deleteAsk.do")
    public JsonMessage deleteAsk(int id){
        JsonMessage jsonMessage = new JsonMessage();
        try {
            askService.deleteAsk(id);
            jsonMessage.setCode(0);
            jsonMessage.setMsg("删除成功");
        } catch (RuntimeException e) {
            jsonMessage.setCode(1);
            jsonMessage.setMsg(e.getMessage());
        }
        return jsonMessage ;
    }

    @RequestMapping("/updateAsk.do")
    public JsonMessage updateAsk(Askforleave askforleave){
        JsonMessage jsonMessage = new JsonMessage();
        try {
            askService.updateAsk(askforleave);
            jsonMessage.setCode(0);
            jsonMessage.setMsg("更新成功！");
        } catch (RuntimeException e) {
            jsonMessage.setCode(1);
            jsonMessage.setMsg(e.getMessage());
        }
        return jsonMessage ;
    }

    @RequestMapping("/findAskByStatus.do")
    public JsonMessage findAskByStatus(String status , int page , int limit){
        JsonMessage jsonMessage =  askService.findAskByStatus(status ,page , limit);
        return jsonMessage ;
    }
    @RequestMapping("/findAll.do")
    public JsonMessage findAll(int page , int limit){
        JsonMessage jsonMessage =  askService.findAll(page , limit);
        return jsonMessage ;
    }

}
