package com.test.k12.dao;


import com.test.k12.pojo.Grade;

import java.util.List;

public interface GradeDAO {
    void addGrade(Grade grade);

    void updateGrade(Grade grade);

    void deleteGrade(Integer id);

    List<Grade> getGradeList();

    Grade getGradeById(Integer id);
}
