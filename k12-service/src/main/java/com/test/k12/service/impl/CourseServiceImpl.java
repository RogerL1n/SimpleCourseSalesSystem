package com.test.k12.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.test.k12.dao.CourseDAO;
import com.test.k12.pojo.Course;
import com.test.k12.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author lry
 */
@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseDAO courseDAO;

    @Override
    public void addCourse(Course course) {
        courseDAO.addCourse(course);
    }

    @Override
    public void updateCourse(Course course) {
        courseDAO.updateCourse(course);
    }

    @Override
    public PageInfo<Course> getCourseList(Course course, Integer pageNum, Integer limit) {
        PageHelper.startPage(pageNum, limit);
        return new PageInfo<>(courseDAO.getCourseList(course));
    }

    @Override
    public Course getCourseById(Integer id) {
        return courseDAO.getCourseById(id);
    }
}
