package com.itqf.demo01.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.itqf.demo01.dao.VipDao;
import com.itqf.demo01.entity.User;
import com.itqf.demo01.service.VipService;
import com.itqf.demo01.utils.JsonMessage;
import com.itqf.demo01.vo.VoVip;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * projectName:easys
 *
 * @author: 三毛
 * time:2020/9/299:42
 * description:会员的业务实现
 */
@Service
public class VipServiceImpl implements VipService {

    @Autowired
    private VipDao vipDao ;

    @Override
    public void updateVipStatus(Integer vid, Integer status) {
       int rows =  vipDao.updateStatus(vid , status);

       if (rows > 0){
           //success
       }else {
           throw  new RuntimeException("修改失败，稍后再试") ;
       }
    }

    @Override
    public void deleteVipApply(Integer vid) {

    }

    @Override
    public void insertVipApply(User user, String content) {

    }

    @Override
    public JsonMessage findAll(Integer status,int page ,int limit) {
        JsonMessage jsonMessage = new JsonMessage();

        PageHelper.offsetPage(page , limit) ;
       List<VoVip> list =  vipDao.findAll(status) ;
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
