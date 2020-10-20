package com.itqf.demo01.controller;

import com.itqf.demo01.entity.Depart;
import com.itqf.demo01.service.DepartService;
import com.itqf.demo01.utils.JsonMessage;
import com.itqf.demo01.vo.VoDepart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * projectName:easys
 *
 * @author: 三毛
 * time:2020/9/2519:09
 * description: 部门的控制层
 */
@Controller
@RequestMapping("/depart")
public class DepartController {

    @Autowired
    private DepartService departService ;

    @ResponseBody
    @RequestMapping("/addDepart.do")
    public JsonMessage addDepart (Depart depart){
        JsonMessage jsonMessage = new JsonMessage() ;
        try {
            departService.insertDepart(depart);
            jsonMessage.setCode(0);
            jsonMessage.setMsg("添加成功！");
        } catch (RuntimeException e) {
            jsonMessage.setCode(1);
            jsonMessage.setMsg(e.getMessage());
        }
        return  jsonMessage ;
    }

    @ResponseBody
    @RequestMapping("/deleteDepart.do")
    public JsonMessage deleteDepart (int id){
        JsonMessage jsonMessage = new JsonMessage() ;
        try {
            departService.deleteDepart(id);
            jsonMessage.setCode(0);
            jsonMessage.setMsg("删除成功！");
        } catch (RuntimeException e) {
            jsonMessage.setCode(1);
            jsonMessage.setMsg(e.getMessage());
        }
        return  jsonMessage ;
    }

    @ResponseBody
    @RequestMapping("/updateDepart.do")
    public JsonMessage updateDepart (Depart depart){
        JsonMessage jsonMessage = new JsonMessage() ;
        try {
            departService.updateDepart(depart);
            jsonMessage.setCode(0);
            jsonMessage.setMsg("更新成功！");
        } catch (RuntimeException e) {
            jsonMessage.setCode(1);
            jsonMessage.setMsg(e.getMessage());
        }
        return  jsonMessage ;
    }



    @RequestMapping("/findDepartByName.do")
    @ResponseBody
    public JsonMessage findDepartByName (String  name){
        JsonMessage jsonMessage = new JsonMessage() ;
        try {
           Depart depart =  departService.findDepartByName(name);
            jsonMessage.setCode(0);
            jsonMessage.setData(depart);
        } catch (RuntimeException e) {
            jsonMessage.setCode(1);
            jsonMessage.setMsg(e.getMessage());
        }
        return  jsonMessage ;
    }


    @ResponseBody
    @RequestMapping("/findAll.do")
    public JsonMessage findAll (@RequestParam(defaultValue = "1") int page , @RequestParam(defaultValue = "10") int limit){

        JsonMessage jsonMessage = departService.findAll(page,limit);

        return  jsonMessage ;
    }



}
