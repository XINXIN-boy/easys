package com.itqf.demo01.dao;

import com.itqf.demo01.entity.Course;
import com.itqf.demo01.vo.VoCourse;

import java.util.List;

/**
 * projectName:easys
 *
 * @author: 三毛
 * time:2020/10/1320:55
 * description:
 */
public interface CourseDao {
    int insertCourse(Course course);

    int deleteCourse(int id);

    int updateCourse(Course course);

    Course findCourseByName(String name);

    List<VoCourse> findAll();
}
