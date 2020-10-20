package com.itqf.demo01.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.itqf.demo01.dao.ResourcesDao;
import com.itqf.demo01.entity.Question;
import com.itqf.demo01.entity.User;
import com.itqf.demo01.service.ResourcesService;
import com.itqf.demo01.utils.Constant;
import com.itqf.demo01.utils.JsonMessage;
import com.itqf.demo01.vo.VoVip;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * projectName:easys
 *
 * @author: 三毛
 * time:2020/10/1616:47
 * description:
 */
@Service
public class ResourcesServiceImpl implements ResourcesService {

    @Autowired
    private ResourcesDao resourcesDao ;

    @Override
    public void insertResources(Question question, HttpSession session) {
        User user = (User) session.getAttribute(Constant.LOGIN_USER);
        question.setUNo(user.getNo());

        if (!"资源".equals(question.getFlag())){
            question.setQtype(question.getFlag());
        }

       int rows =  resourcesDao.insertResources(question) ;
        if (rows == 0){
            throw new RuntimeException("添加失败！");
        }

    }

    @Override
    public void updateResources(Question question) {
        int rows =  resourcesDao.updateResources(question) ;
        if (rows == 0){
            throw new RuntimeException("修改失败！");
        }
    }

    @Override
    public void deleteResources(int id) {
        int rows =  resourcesDao.deleteResources(id) ;
        if (rows == 0){
            throw new RuntimeException("删除失败！");
        }
    }

    @Override
    public JsonMessage findAll(int page, int limit) {
        JsonMessage jsonMessage = new JsonMessage();
        PageHelper.offsetPage(page , limit) ;
        List<Question> list =  resourcesDao.findAll() ;
        if ( list != null && list.size()>0){
            jsonMessage.setMsg("查询成功");
            jsonMessage.setCode(0);
            jsonMessage.setCount(((Page)list).getTotal());
            jsonMessage.setData(list);
        }else {
            jsonMessage.setMsg("未查询到数据");
            jsonMessage.setCode(1);
        }
        return jsonMessage;
    }
}
