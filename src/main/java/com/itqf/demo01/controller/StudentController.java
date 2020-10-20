package com.itqf.demo01.controller;

import com.itqf.demo01.entity.Grade;
import com.itqf.demo01.entity.Student;
import com.itqf.demo01.service.GradeService;
import com.itqf.demo01.service.StudentService;
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
 * time:2020/9/2520:46
 * description:学生的控制层
 */
@Controller
@ResponseBody
@RequestMapping("/student")
public class StudentController  {

    @Autowired
    private StudentService studentService ;

    @RequestMapping("/addStudent.do")
    public JsonMessage addStudent(Student student){
        JsonMessage jsonMessage = new JsonMessage();

        try {
            studentService.addStudent(student);
            jsonMessage.setCode(0);
            jsonMessage.setMsg("添加成功！");
        } catch (RuntimeException e) {
            jsonMessage.setCode(1);
            jsonMessage.setMsg(e.getMessage());
        }
        return jsonMessage ;
    }

    @RequestMapping("/deleteStudent.do")
    public JsonMessage deleteStudent(int id){
        JsonMessage jsonMessage = new JsonMessage();

        try {
            studentService.deleteStudent(id);
            jsonMessage.setCode(0);
            jsonMessage.setMsg("删除成功！");
        } catch (RuntimeException e) {
            jsonMessage.setCode(1);
            jsonMessage.setMsg(e.getMessage());
        }
        return jsonMessage ;
    }
    @RequestMapping("/updateStudent.do")
    public JsonMessage updateStudent(Student student){
        JsonMessage jsonMessage = new JsonMessage();

        try {
            studentService.updateStudent(student);
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
        JsonMessage jsonMessage = studentService.findAll(page,limit);
        return jsonMessage ;
    }


}
