package com.itqf.demo01.dao;

import com.itqf.demo01.entity.Question;

import java.util.List;

/**
 * projectName:easys
 *
 * @author: 三毛
 * time:2020/10/1616:57
 * description:
 */
public interface ResourcesDao {

    int insertResources(Question question);

    int updateResources(Question question);

    int deleteResources(int id);


    List<Question> findAll();

}
