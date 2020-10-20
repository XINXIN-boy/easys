package com.itqf.demo01.controller;

import com.itqf.demo01.entity.Course;
import com.itqf.demo01.service.CourseService;
import com.itqf.demo01.utils.JsonMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * projectName:easys
 *
 * @author: 三毛
 * time:2020/10/1320:28
 * description:
 */
@Controller
@ResponseBody
@RequestMapping("/course")
public class CourseController {


    @Autowired
    private CourseService courseService ;

    @RequestMapping("/addCourse.do")
    public JsonMessage addCourse(Course course){
        JsonMessage jsonMessage = new JsonMessage();
        try {
            courseService.insertCourse(course);
            jsonMessage.setCode(0);
            jsonMessage.setMsg("添加成功");
        } catch (RuntimeException e) {
            jsonMessage.setCode(1);
            jsonMessage.setMsg(e.getMessage());
        }
        return jsonMessage ;
    }

    @RequestMapping("/deleteCourse.do")
    public JsonMessage deleteCourse(int id){
        JsonMessage jsonMessage = new JsonMessage();
        try {
            courseService.deleteCourse(id);
            jsonMessage.setCode(0);
            jsonMessage.setMsg("删除成功");
        } catch (RuntimeException e) {
            jsonMessage.setCode(1);
            jsonMessage.setMsg(e.getMessage());
        }
        return jsonMessage ;
    }
    @RequestMapping("/updateCourse.do")
    public JsonMessage updateCourse(Course course){
        JsonMessage jsonMessage = new JsonMessage();
        try {
            courseService.updateCourse(course);
            jsonMessage.setCode(0);
            jsonMessage.setMsg("更新成功！");
        } catch (RuntimeException e) {
            jsonMessage.setCode(1);
            jsonMessage.setMsg(e.getMessage());
        }
        return jsonMessage ;
    }
    @RequestMapping("/findCourseByName.do")
    public JsonMessage findCourseByName(String name){
        JsonMessage jsonMessage = new JsonMessage();
        try {
            Course course = courseService.findCourseByName(name);
            jsonMessage.setCode(0);
            jsonMessage.setMsg("查询成功！");
            jsonMessage.setData(course);
        } catch (RuntimeException e) {
            jsonMessage.setCode(1);
            jsonMessage.setMsg(e.getMessage());
        }
        return jsonMessage ;
    }
    @RequestMapping("/findAll.do")
    public JsonMessage findAll(int page , int limit){
        JsonMessage jsonMessage = courseService.findAll(page,limit);
        return jsonMessage ;
    }

}
