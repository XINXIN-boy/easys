package com.itqf.demo01.dao;

import com.itqf.demo01.entity.Grade;
import com.itqf.demo01.vo.VoDepart;

import java.util.List;

/**
 * projectName:easys
 *
 * @author: 三毛
 * time:2020/10/1611:21
 * description:
 */
public interface GradeDao {
    int insertGrade(Grade grade);

    int deleteGrade(int id);

    int updateGrade(Grade grade);

    List<Grade> findAll();

    Grade findGradById(String id);

}
