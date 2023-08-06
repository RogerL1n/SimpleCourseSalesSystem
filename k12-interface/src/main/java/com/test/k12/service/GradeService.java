package com.test.k12.service;

import com.github.pagehelper.PageInfo;
import com.test.k12.pojo.Grade;

import java.util.List;

public interface GradeService {
    void addGrade(Grade grade);

    void updateGrade(Grade grade);

    void deleteGrade(Integer id);

    PageInfo<Grade> getGradeList(Integer pageNum, Integer limit);

    List<Grade> getGradeList();

    Grade getGradeById(Integer id);
}
