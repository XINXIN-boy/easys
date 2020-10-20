package com.itqf.demo01.service;

import com.itqf.demo01.entity.Grade;
import com.itqf.demo01.utils.JsonMessage;

/**
 * projectName:easys
 *
 * @author: 三毛
 * time:2020/10/1611:16
 * description:
 */
public interface GradeService {
    void insertGrade(Grade grade);

    void deleteGrade(int id);

    void updateGrade(Grade grade);

    JsonMessage findAll(int page, int limit);

}
