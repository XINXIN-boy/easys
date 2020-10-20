package com.itqf.demo01.service;

import com.itqf.demo01.entity.Course;
import com.itqf.demo01.utils.JsonMessage;

/**
 * projectName:easys
 *
 * @author: 三毛
 * time:2020/10/1320:42
 * description:
 */
public interface CourseService {

    void insertCourse(Course course);

    void deleteCourse(int id);

    void updateCourse(Course course);

    Course findCourseByName(String name);

    JsonMessage findAll(int page, int limit);

}
