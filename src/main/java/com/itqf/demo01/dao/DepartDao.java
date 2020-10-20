package com.itqf.demo01.dao;

import com.itqf.demo01.entity.Depart;
import com.itqf.demo01.vo.VoDepart;

import java.util.List;

/**
 * projectName:easys
 *
 * @author: 三毛
 * time:2020/9/2519:09
 * description:部门的数据层
 */
public interface DepartDao {
    int insertDepart(Depart depart);

    int deleteDepart(int id);

    int updateDepart(Depart depart);
    /**
     * 查询所有的部门
     * @return
     */
    List<VoDepart> findAll();

    Depart findDepartByName(String name);

    Depart findDepartByID(int id);

}
