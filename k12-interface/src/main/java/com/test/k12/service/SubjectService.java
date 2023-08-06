package com.test.k12.service;

import com.github.pagehelper.PageInfo;
import com.test.k12.pojo.Subject;

import java.util.List;

public interface SubjectService {
    void addSubject(Subject subject);

    void updateSubject(Subject subject);

    void deleteSubject(Integer id);

    PageInfo<Subject> getSubjectList(Integer pageNum, Integer limit);

    List<Subject> getSubjectList();

    Subject getSubjectById(Integer id);
}
