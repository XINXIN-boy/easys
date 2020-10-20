package com.itqf.demo01.service;

import com.itqf.demo01.entity.Student;
import com.itqf.demo01.utils.JsonMessage;

/**
 * projectName:easys
 *
 * @author: 三毛
 * time:2020/10/1611:38
 * description:
 */
public interface StudentService {
    void addStudent(Student student);

    void deleteStudent(int id);

    void updateStudent(Student student);

    JsonMessage findAll(int page, int limit);

}
