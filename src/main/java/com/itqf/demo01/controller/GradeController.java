package com.itqf.demo01.controller;

import com.itqf.demo01.entity.Grade;
import com.itqf.demo01.service.GradeService;
import com.itqf.demo01.utils.JsonMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * projectName:easys
 *
 * @author: 三毛
 * time:2020/10/1611:10
 * description:
 */
@Controller
@ResponseBody
@RequestMapping("/grade")
public class GradeController {

    @Autowired
    private GradeService gradeService ;

    @RequestMapping("/addGrade.do")
    public JsonMessage addGrade(Grade grade){
        JsonMessage jsonMessage = new JsonMessage();

        try {
            gradeService.insertGrade(grade);
            jsonMessage.setCode(0);
            jsonMessage.setMsg("添加成功！");
        } catch (RuntimeException e) {
            jsonMessage.setCode(1);
            jsonMessage.setMsg(e.getMessage());
        }
        return jsonMessage ;
    }

    @RequestMapping("/deleteGrade.do")
    public JsonMessage deleteGrade(int id){
        JsonMessage jsonMessage = new JsonMessage();

        try {
            gradeService.deleteGrade(id);
            jsonMessage.setCode(0);
            jsonMessage.setMsg("删除成功！");
        } catch (RuntimeException e) {
            jsonMessage.setCode(1);
            jsonMessage.setMsg(e.getMessage());
        }
        return jsonMessage ;
    }
    @RequestMapping("/updateGrade.do")
    public JsonMessage updateGrade(Grade grade){
        JsonMessage jsonMessage = new JsonMessage();

        try {
            gradeService.updateGrade(grade);
            jsonMessage.setCode(0);
            jsonMessage.setMsg("修改成功！");
        } catch (RuntimeException e) {
            jsonMessage.setCode(1);
            jsonMessage.setMsg(e.getMessage());
        }
        return jsonMessage ;
    }


    @RequestMapping("/findAll.do")
    public JsonMessage findAll(@RequestParam(defaultValue = "1") int page , @RequestParam(defaultValue = "10")int limit){
        JsonMessage jsonMessage = gradeService.findAll(page,limit);
        return jsonMessage ;
    }
    @RequestMapping("/findGradeById.do")
    public JsonMessage findGradeById(Grade grade){
        JsonMessage jsonMessage = new JsonMessage();


        return jsonMessage ;
    }



}
