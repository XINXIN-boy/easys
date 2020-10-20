package com.itqf.demo01.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.itqf.demo01.dao.AskDao;
import com.itqf.demo01.entity.Askforleave;
import com.itqf.demo01.service.AskService;
import com.itqf.demo01.utils.JsonMessage;
import com.itqf.demo01.vo.VoAsk;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * projectName:easys
 *
 * @author: 三毛
 * time:2020/10/1316:24
 * description:
 */
@Service
public class AskServiceImpl implements AskService {

    @Autowired
    private AskDao askDao ;

    @Override
    public void insertAsk(Askforleave askforleave) {
       int rows =  askDao.insertAsk(askforleave);
       if (rows == 0){
           throw new RuntimeException("添加失败！");
       }
    }

    @Override
    public void deleteAsk(int id) {
        int rows =  askDao.deleteAsk(id);
        if (rows == 0){
            throw new RuntimeException("删除失败！");
        }
    }

    @Override
    public void updateAsk(Askforleave askforleave) {
        int rows =  askDao.updateAsk(askforleave);
        if (rows == 0){
            throw new RuntimeException("更新失败！");
        }
    }

    @Override
    public JsonMessage findAskByStatus(String status, int page, int limit) {
        JsonMessage jsonMessage = new JsonMessage();
        PageHelper.startPage(page , limit) ;

        List<VoAsk> list =  askDao.findAskByStatus(status);
        if (list != null ){
            jsonMessage.setCode(0);
            jsonMessage.setMsg("查询成功！");
            jsonMessage.setData(list);
            jsonMessage.setCount(((Page)list).getTotal());
        }else {
            jsonMessage.setCode(1);
            jsonMessage.setMsg("未查询到数据！");
        }
        return jsonMessage;
    }

    @Override
    public JsonMessage findAll(int page, int limit) {
        JsonMessage jsonMessage = new JsonMessage();
        PageHelper.startPage(page , limit) ;
        List<VoAsk> list =  askDao.findAll();
        if (list != null ){
            jsonMessage.setCode(0);
            jsonMessage.setMsg("查询成功！");
            jsonMessage.setData(list);
            jsonMessage.setCount(((Page)list).getTotal());
        }else {
            jsonMessage.setCode(1);
            jsonMessage.setMsg("未查询到数据！");
        }
        return jsonMessage;
    }
}
