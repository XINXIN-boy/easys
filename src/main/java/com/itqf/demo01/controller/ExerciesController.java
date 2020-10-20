package com.itqf.demo01.controller;

import com.itqf.demo01.service.ExerciesService;
import com.itqf.demo01.utils.JsonMessage;
import com.itqf.demo01.vo.VoExercises;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * projectName:easys
 *
 * @author: 三毛
 * time:2020/9/2917:31
 * description:
 */
@Controller
@RequestMapping("/exercises")
@ResponseBody
public class ExerciesController {

    @Autowired
    private ExerciesService exerciesService ;

    /**
     * 查找类型
     * @return
     */
    @RequestMapping("/findType.do")
    public JsonMessage findType(){
        JsonMessage jsonMessage = exerciesService.findType();
        return jsonMessage ;
    }

    /**
     * 添加练习题
     * @param tid
     * @param equestion
     * @param eanswer
     * @return
     */
    @RequestMapping("/addExercises.do")
    public JsonMessage addExercises(int tid , String equestion,String eanswer){
        JsonMessage jsonMessage = new JsonMessage();
        try {
            exerciesService.addExercises(tid , equestion , eanswer);
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
     * @param voExercises
     * @return
     */
    @RequestMapping("/updateExercises.do")
    public JsonMessage updateExercises(VoExercises voExercises){
        JsonMessage jsonMessage = new JsonMessage();
        try {
            exerciesService.updateExercises(voExercises);
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
    @RequestMapping("/deleteExercises.do")
    public JsonMessage deleteExercises(int id){
        JsonMessage jsonMessage = new JsonMessage();
        try {
            exerciesService.deleteExercises(id);
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
        JsonMessage jsonMessage = exerciesService.findAll(page , limit);
        return jsonMessage ;
    }

    /**
     * 查
     * @return
     */
    @RequestMapping("/findEchartsEx.do")
    public JsonMessage findEchartsEx(){
        JsonMessage jsonMessage = exerciesService.findEchartsEx();
        return jsonMessage ;
    }
}
