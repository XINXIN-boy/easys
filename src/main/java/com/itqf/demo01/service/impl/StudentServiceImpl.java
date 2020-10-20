package com.itqf.demo01.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.itqf.demo01.dao.GradeDao;
import com.itqf.demo01.dao.StudentDao;
import com.itqf.demo01.dao.UserDao;
import com.itqf.demo01.entity.Grade;
import com.itqf.demo01.entity.Student;
import com.itqf.demo01.entity.User;
import com.itqf.demo01.service.StudentService;
import com.itqf.demo01.utils.JsonMessage;
import com.itqf.demo01.utils.RandomCode;
import com.itqf.demo01.vo.VoDepart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * projectName:easys
 *
 * @author: 三毛
 * time:2020/10/1611:38
 * description:
 */
@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentDao studentDao ;

    @Autowired
    private UserDao userDao ;

    @Autowired
    private GradeDao gradeDao ;

    @Override
    public void addStudent(Student student) {
        String uNo = "ST" ;
        while (true){
            uNo += RandomCode.getCode();
            Student judgeStudent = studentDao.findStudentByUNo(uNo);
            if (judgeStudent == null){
                break;
            }
        }
        student.setUNo(uNo);
        student.setFlag(1);

       Grade grade =  gradeDao.findGradById(student.getCno());
        student.setgName(grade.getName());

        int rows =  studentDao.insertStudent(student);
        if (rows == 0){
            throw new RuntimeException("添加失败！") ;
        }

        User user = new User();
        user.setPassword("000000");
        user.setNo(uNo);
        user.setStatus("0");
        user.setFlag(1);
        user.setRole(1);
        user.setIdentity(1);
        userDao.insertUser(user);


    }

    @Override
    public void deleteStudent(int id) {
        int rows =  studentDao.deleteStudent(id);
        if (rows == 0){
            throw new RuntimeException("删除失败！") ;
        }
    }

    @Override
    public void updateStudent(Student student) {
        int rows =  studentDao.updateStudent(student);
        if (rows == 0){
            throw new RuntimeException("更新失败！") ;
        }
    }

    @Override
    public JsonMessage findAll(int page, int limit) {
        PageHelper.startPage(page,limit ) ;
        List<Student> list = studentDao.findAll();
        JsonMessage jsonMessage = new JsonMessage();
        if (list != null && list.size()>0) {
            jsonMessage.setCode(0);
            jsonMessage.setMsg("查询成功");
            jsonMessage.setCount(((Page)list).getTotal());
            jsonMessage.setData(list);
        }else {
            jsonMessage.setCode(1);
            jsonMessage.setMsg("未查询到数据");
        }
        return jsonMessage ;
    }
}
