package com.test.k12.dao;


import com.test.k12.pojo.Subject;

import java.util.List;

public interface SubjectDAO {
    void addSubject(Subject subject);

    void updateSubject(Subject subject);

    void deleteSubject(Integer id);

    List<Subject> getSubjectList();

    Subject getSubjectById(Integer id);
}
