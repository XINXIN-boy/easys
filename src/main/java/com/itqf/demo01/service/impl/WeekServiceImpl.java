package com.itqf.demo01.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.itqf.demo01.dao.WeekDao;
import com.itqf.demo01.entity.User;
import com.itqf.demo01.entity.Week;
import com.itqf.demo01.service.WeekService;
import com.itqf.demo01.utils.Constant;
import com.itqf.demo01.utils.JsonMessage;
import com.itqf.demo01.vo.VoWeek;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * projectName:easys
 *
 * @author: 三毛
 * time:2020/9/271:26
 * description:周报的业务实现
 */
@Service
public class WeekServiceImpl implements WeekService {

    @Autowired
    private WeekDao weekDao ;


    @Override
    public void insertWeek(User user, String weekMessage, String title) {
        Week week = new Week();
        //完善数据  tital  content status  uno
        week.setContent(weekMessage);
        week.setTitle(title);
        week.setUno(user.getNo());
        week.setStatus(Constant.WEEK_DEFAULT_STATUS);

        int rows = weekDao.insertWeek(week) ;
        if (rows>0) {
            //添加ok
        }else {
            throw new RuntimeException("添加失败！");
        }

    }

    @Override
    public JsonMessage findAll(User user,String page ,String limit) {
        //处理参数
        int pageNum = Integer.parseInt(page);
        int pageCount = Integer.parseInt(limit);

        JsonMessage jsonMessage = new JsonMessage();
        PageHelper.startPage(pageNum,pageCount);
        List<VoWeek> list =  weekDao.findAll(user) ;

        if (list != null && list.size()>0) {
            jsonMessage.setCode(0);
            jsonMessage.setMsg("查询成功！");
            jsonMessage.setData(list);
            jsonMessage.setCount(((Page)list).getTotal());
            return jsonMessage ;
        }else {
            jsonMessage.setCode(1);
            jsonMessage.setMsg("未查询到数据！");
            return jsonMessage ;
        }
    }

    @Override
    public void deleteWeek(String wid) {
        //参数处理
        int id = Integer.parseInt(wid);
       int rows  =  weekDao.deleteWeek(id);
        if (rows > 0){
            //success
        }else {
            throw new RuntimeException("删除异常，稍后再试！") ;
        }

    }

    @Override
    public void updateWeek(VoWeek voWeek) {
        int rows = weekDao.updateWeek(voWeek) ;
        if (rows > 0){
            //success
        }else {
            throw new RuntimeException("修改失败，稍后再试") ;
        }

    }
}
