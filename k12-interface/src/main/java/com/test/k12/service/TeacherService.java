package com.test.k12.service;

import com.github.pagehelper.PageInfo;
import com.test.k12.pojo.Teacher;

import java.util.List;

public interface TeacherService {
    void addTeacher(Teacher teacher);

    void updateTeacher(Teacher teacher);

    PageInfo<Teacher> getTeacherList(Integer pageNum, Integer limit);

    List<Teacher> getTeacherList();

    Teacher getTeacherById(Integer id);
}
