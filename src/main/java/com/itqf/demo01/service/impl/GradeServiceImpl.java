package com.itqf.demo01.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.itqf.demo01.dao.GradeDao;
import com.itqf.demo01.entity.Grade;
import com.itqf.demo01.service.GradeService;
import com.itqf.demo01.utils.JsonMessage;
import com.itqf.demo01.vo.VoDepart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * projectName:easys
 *
 * @author: 三毛
 * time:2020/10/1611:18
 * description:
 */
@Service
public class GradeServiceImpl implements GradeService {

    @Autowired
    private GradeDao gradeDao ;

    @Override
    public void insertGrade(Grade grade) {

        int rows =  gradeDao.insertGrade(grade);
        if (rows == 0){
            throw new RuntimeException("添加失败！") ;
        }
    }

    @Override
    public void deleteGrade(int id) {
        int rows =  gradeDao.deleteGrade(id);
        if (rows == 0){
            throw new RuntimeException("删除失败！") ;
        }
    }

    @Override
    public void updateGrade(Grade grade) {
        int rows =  gradeDao.updateGrade(grade);
        if (rows == 0){
            throw new RuntimeException("更新失败！") ;
        }
    }

    @Override
    public JsonMessage findAll(int page, int limit) {
        PageHelper.startPage(page,limit ) ;
        List<Grade> list = gradeDao.findAll();
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
