package com.itqf.demo01.controller;

import com.alibaba.druid.support.http.ResourceServlet;
import com.itqf.demo01.entity.Question;
import com.itqf.demo01.service.ResourcesService;
import com.itqf.demo01.utils.JsonMessage;
import com.itqf.demo01.vo.VoExercises;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * projectName:easys
 *
 * @author: 三毛
 * time:2020/10/1615:31
 * description: 资源管理
 */
@Controller
@ResponseBody
@RequestMapping("resources")
public class ResourcesController {
    @Autowired
    private ResourcesService resourcesService ;



    /**
     * 添加练习题
     * @return
     */
    @RequestMapping("/addResources.do")
    public JsonMessage addResources(Question question , HttpSession session){
        JsonMessage jsonMessage = new JsonMessage();
        try {
            resourcesService.insertResources(question ,session);
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
     * 修改练习题
     * @return
     */
    @RequestMapping("/updateResources.do")
    public JsonMessage updateResources(Question question){
        JsonMessage jsonMessage = new JsonMessage();
        try {
            resourcesService.updateResources(question);
            jsonMessage.setCode(0);
            jsonMessage.setMsg("修改成功");
            return jsonMessage ;
        } catch (RuntimeException e) {
            jsonMessage.setCode(1);
            jsonMessage.setMsg(e.getMessage());
            return jsonMessage ;
        }
    }


    /**
     * 删除练习题
     * @param id
     * @return
     */
    @RequestMapping("/deleteResources.do")
    public JsonMessage deleteResources(int id){
        JsonMessage jsonMessage = new JsonMessage();
        try {
            resourcesService.deleteResources(id);
            jsonMessage.setCode(0);
            jsonMessage.setMsg("删除成功");
            return jsonMessage ;
        } catch (RuntimeException e) {
            jsonMessage.setCode(1);
            jsonMessage.setMsg(e.getMessage());
            return jsonMessage ;
        }
    }

    /**
     * 查所有
     * @param page
     * @param limit
     * @return
     */
    @RequestMapping("/findAll.do")
    public JsonMessage findAll(int page , int limit){
        JsonMessage jsonMessage = resourcesService.findAll(page , limit);
        return jsonMessage ;
    }

}
