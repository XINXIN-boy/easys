package com.itqf.demo01.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.itqf.demo01.dao.AnonymityDao;
import com.itqf.demo01.service.AnonymityService;
import com.itqf.demo01.utils.JsonMessage;
import com.itqf.demo01.vo.VoAnonymity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * projectName:easys
 *
 * @author: 三毛
 * time:2020/9/2911:01
 * description:匿名投诉的业务实现
 */
@Service
public class AnonymityServiceImpl implements AnonymityService {

    @Autowired
    private AnonymityDao anonymityDao ;

    /**
     * 查询所有
     * @param page
     * @param limit
     * @return
     */
    @Override
    public JsonMessage findAll(int page, int limit) {
        JsonMessage jsonMessage = new JsonMessage();

        PageHelper.offsetPage(page , limit) ;
        List<VoAnonymity> list = anonymityDao.findAll();

        if (list.size() > 0 && list != null){
            //success
            jsonMessage.setCode(0);
            jsonMessage.setMsg("查询成功");
            jsonMessage.setCount(((Page)list).getTotal());
            jsonMessage.setData(list);
            return jsonMessage ;

        }else {
            jsonMessage.setCode(1);
            jsonMessage.setMsg("未查询到数据");
            return jsonMessage ;
        }
    }


    @Override
    public void deleteAnonymity(int id) {
        int rows = anonymityDao.deleteAnonymity(id) ;

        if (rows > 0){
            //success
        }else {
         throw new RuntimeException("删除失败！")   ;
        }
    }

    @Override
    public void updateAnonymityStatus(int id, int status) {
        int rows = anonymityDao.updateAnonymityStatus(id , status) ;

        if (rows > 0){
            //success
        }else {
            throw new RuntimeException("修改失败！")   ;
        }
    }
}
