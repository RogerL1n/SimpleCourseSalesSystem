package com.test.k12.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.test.k12.dao.TeacherDAO;
import com.test.k12.pojo.Teacher;
import com.test.k12.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lry
 */
@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private TeacherDAO teacherDAO;

    @Override
    public void addTeacher(Teacher teacher) {
        teacherDAO.addTeacher(teacher);
    }

    @Override
    public void updateTeacher(Teacher teacher) {
        teacherDAO.updateTeacher(teacher);
    }

    @Override
    public PageInfo<Teacher> getTeacherList(Integer pageNum, Integer limit) {
        PageHelper.startPage(pageNum, limit);
        return new PageInfo<>(teacherDAO.getTeacherList());
    }

    @Override
    public Teacher getTeacherById(Integer id) {
        return teacherDAO.getTeacherById(id);
    }

    @Override
    public List<Teacher> getTeacherList() {
        return teacherDAO.getTeacherList();
    }
}
