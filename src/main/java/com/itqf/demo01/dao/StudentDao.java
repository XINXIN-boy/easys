package com.itqf.demo01.dao;

import com.itqf.demo01.entity.Student;

import java.util.List;

/**
 * projectName:easys
 *
 * @author: 三毛
 * time:2020/10/1611:42
 * description:
 */
public interface StudentDao {
    int insertStudent(Student student);

    int deleteStudent(int id);

    int updateStudent(Student student);

    List<Student> findAll();

    Student findStudentByUNo(String uNo);
}
