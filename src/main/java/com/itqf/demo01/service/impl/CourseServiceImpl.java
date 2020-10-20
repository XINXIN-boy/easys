package com.itqf.demo01.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.itqf.demo01.dao.CourseDao;
import com.itqf.demo01.entity.Course;
import com.itqf.demo01.service.CourseService;
import com.itqf.demo01.utils.JsonMessage;
import com.itqf.demo01.vo.VoCourse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * projectName:easys
 *
 * @author: 三毛
 * time:2020/10/1320:43
 * description:
 */
@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseDao courseDao ;

    @Override
    public void insertCourse(Course course) {
        int rows =  courseDao.insertCourse(course);
        if (rows == 0){
            throw new RuntimeException("添加失败！") ;
        }
    }

    @Override
    public void deleteCourse(int id) {
        int rows =  courseDao.deleteCourse(id);
        if (rows == 0){
            throw new RuntimeException("删除失败！") ;
        }
    }

    @Override
    public void updateCourse(Course course) {
        int rows =  courseDao.updateCourse(course);
        if (rows == 0){
            throw new RuntimeException("更新失败！") ;
        }
    }

    @Override
    public Course findCourseByName(String name) {
        Course course =  courseDao.findCourseByName(name) ;
        if (course != null){
            return course ;
        }else {
            throw new RuntimeException("未查到数据！") ;
        }
    }

    @Override
    public JsonMessage findAll(int page, int limit) {
        JsonMessage jsonMessage = new JsonMessage();
        PageHelper.startPage(page,limit);
        List<VoCourse> list = courseDao.findAll();
        if (list != null && list.size()>0) {
            jsonMessage.setCode(0);
            jsonMessage.setMsg("查询成功！");
            jsonMessage.setCount(((Page)list).getTotal());
            jsonMessage.setData(list);
        }else {
            jsonMessage.setCode(1);
            jsonMessage.setMsg("未查询到数据！");
        }
        return jsonMessage;
    }
}
