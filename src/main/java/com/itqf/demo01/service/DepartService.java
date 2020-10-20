package com.itqf.demo01.service;

import com.itqf.demo01.entity.Depart;
import com.itqf.demo01.utils.JsonMessage;

/**
 * projectName:easys
 *
 * @author: 三毛
 * time:2020/9/2519:10
 * description:部门的业务
 */
public interface DepartService {
    /**
     * 查询所有的部门
     * @return
     */
    void insertDepart(Depart depart);

    void deleteDepart(int id);

    void updateDepart(Depart depart);

    Depart findDepartByName(String name);

    JsonMessage findAll(int page , int limit);


}
