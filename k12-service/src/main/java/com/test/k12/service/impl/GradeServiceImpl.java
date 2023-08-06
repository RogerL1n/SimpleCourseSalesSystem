package com.test.k12.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.test.k12.dao.GradeDAO;
import com.test.k12.pojo.Grade;
import com.test.k12.service.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lry
 */
@Service
public class GradeServiceImpl implements GradeService {

    @Autowired
    private GradeDAO gradeDAO;

    @Override
    public void addGrade(Grade grade) {
        gradeDAO.addGrade(grade);
    }

    @Override
    public void updateGrade(Grade grade) {
        gradeDAO.updateGrade(grade);
    }

    @Override
    public void deleteGrade(Integer id) {
        gradeDAO.deleteGrade(id);
    }

    @Override
    public PageInfo<Grade> getGradeList(Integer pageNum, Integer limit) {
        PageHelper.startPage(pageNum, limit);
        return new PageInfo<>(gradeDAO.getGradeList());
    }

    @Override
    public Grade getGradeById(Integer id) {
        return gradeDAO.getGradeById(id);
    }

    @Override
    public List<Grade> getGradeList() {
        return gradeDAO.getGradeList();
    }
}
