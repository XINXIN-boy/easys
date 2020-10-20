package com.itqf.demo01.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.itqf.demo01.dao.ExerciesDao;
import com.itqf.demo01.echarts.ExercisesEcharts;
import com.itqf.demo01.entity.Type;
import com.itqf.demo01.service.ExerciesService;
import com.itqf.demo01.utils.JsonMessage;
import com.itqf.demo01.vo.VoExercises;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * projectName:easys
 *
 * @author: 三毛
 * time:2020/9/2917:35
 * description:
 */
@Service
public class ExerciesServiceImpl implements ExerciesService {

    @Autowired
    private ExerciesDao exerciesDao ;

    @Override
    public JsonMessage findType() {

        List<Type> list = exerciesDao.findType();
        JsonMessage jsonMessage = new JsonMessage();
        if (list != null && list.size()>0) {
            jsonMessage.setCode(0);
            jsonMessage.setMsg("查询成功");
            jsonMessage.setData(list);
            return jsonMessage ;
        }else{
            throw  new RuntimeException("未查询到数据") ;
        }
    }

    @Override
    public void addExercises(int tid, String equestion, String eanswer) {
       int rows =  exerciesDao.insertExercises(tid , equestion ,eanswer);

       if (rows > 0){

       }else {
           throw new RuntimeException("添加失败") ;
       }

    }

    @Override
    public void updateExercises(VoExercises voExercises) {
        int rows =  exerciesDao.updateExercises(voExercises);

        if (rows > 0){

        }else {
            throw new RuntimeException("添加失败") ;
        }
    }

    @Override
    public void deleteExercises(int id) {
        int rows =  exerciesDao.deleteExercises(id);

        if (rows > 0){

        }else {
            throw new RuntimeException("添加失败") ;
        }
    }

    @Override
    public JsonMessage findAll(int page , int limit) {
      PageHelper.offsetPage(page, limit);
        List<VoExercises> list = exerciesDao.findAll();
        JsonMessage jsonMessage = new JsonMessage();
        if (list != null && list.size()>0) {
            jsonMessage.setCode(0);
            jsonMessage.setMsg("查询成功");
            jsonMessage.setCount(((Page)list).getTotal());
            jsonMessage.setData(list);
            return jsonMessage ;
        }else{
            throw  new RuntimeException("未查询到数据") ;
        }
    }

    @Override
    public JsonMessage findEchartsEx() {
        List<ExercisesEcharts> list = exerciesDao.findEchartsEx();
        JsonMessage jsonMessage = new JsonMessage();
        if (list != null && list.size()>0) {
            jsonMessage.setCode(0);
            jsonMessage.setMsg("查询成功");
            jsonMessage.setData(list);
            return jsonMessage ;
        }else{
            throw  new RuntimeException("未查询到数据") ;
        }
    }
}
