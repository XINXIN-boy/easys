package com.itqf.demo01.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.itqf.demo01.dao.DepartDao;
import com.itqf.demo01.entity.Depart;
import com.itqf.demo01.service.DepartService;
import com.itqf.demo01.utils.JsonMessage;
import com.itqf.demo01.vo.VoDepart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * projectName:easys
 *
 * @author: 三毛
 * time:2020/9/2519:11
 * description:部门的业务实现
 */
@Service
public class DepartServiceImpl implements DepartService {

    @Autowired
    private DepartDao departDao ;


    @Override
    public void insertDepart(Depart depart) {



       int rows =  departDao.insertDepart(depart);
       if (rows == 0){
           throw new RuntimeException("添加失败！") ;
       }
    }

    @Override
    public void deleteDepart(int id) {
        int rows =  departDao.deleteDepart(id);
        if (rows == 0){
            throw new RuntimeException("删除失败！") ;
        }
    }

    @Override
    public void updateDepart(Depart depart) {
        int rows =  departDao.updateDepart(depart);
        if (rows == 0){
            throw new RuntimeException("更新失败！") ;
        }
    }

    @Override
    public Depart findDepartByName(String name) {
        Depart depart =  departDao.findDepartByName(name);
        if (depart == null ){
            throw new RuntimeException("为查找到数据！") ;
        }else {
            return depart ;
        }
    }

    @Override
    public JsonMessage findAll(int page , int limit) {
        PageHelper.startPage(page,limit ) ;
        List<VoDepart> list = departDao.findAll();
        JsonMessage jsonMessage = new JsonMessage();
        if (list != null && list.size()>0) {
            jsonMessage.setCode(0);
            jsonMessage.setMsg("查询成功");
            jsonMessage.setCount(((Page)list).getTotal());
            jsonMessage.setData(list);
        }else {
            jsonMessage.setCode(1);
            jsonMessage.setMsg("未查询到部门");
        }
        return jsonMessage ;
    }
}
