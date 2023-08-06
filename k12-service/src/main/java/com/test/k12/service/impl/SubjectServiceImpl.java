package com.test.k12.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.test.k12.dao.SubjectDAO;
import com.test.k12.pojo.Subject;
import com.test.k12.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lry
 */
@Service
public class SubjectServiceImpl implements SubjectService {

    @Autowired
    private SubjectDAO subjectDAO;

    @Override
    public void addSubject(Subject subject) {
        subjectDAO.addSubject(subject);
    }

    @Override
    public void updateSubject(Subject subject) {
        subjectDAO.updateSubject(subject);
    }

    @Override
    public void deleteSubject(Integer id) {
        subjectDAO.deleteSubject(id);
    }

    @Override
    public PageInfo<Subject> getSubjectList(Integer pageNum, Integer limit) {
        PageHelper.startPage(pageNum, limit);
        return new PageInfo<>(subjectDAO.getSubjectList());
    }

    @Override
    public Subject getSubjectById(Integer id) {
        return subjectDAO.getSubjectById(id);
    }

    @Override
    public List<Subject> getSubjectList() {
        return subjectDAO.getSubjectList();
    }
}
