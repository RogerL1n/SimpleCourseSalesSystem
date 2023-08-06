package com.test.k12.dao;


import com.test.k12.pojo.Teacher;

import java.util.List;

public interface TeacherDAO {
    void addTeacher(Teacher teacher);

    void updateTeacher(Teacher teacher);

    List<Teacher> getTeacherList();

    Teacher getTeacherById(Integer id);
}
