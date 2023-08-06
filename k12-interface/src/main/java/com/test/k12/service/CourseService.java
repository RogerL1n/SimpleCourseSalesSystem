package com.test.k12.service;

import com.github.pagehelper.PageInfo;
import com.test.k12.pojo.Course;

public interface CourseService {
    void addCourse(Course course);

    void updateCourse(Course course);

    PageInfo<Course> getCourseList(Course course, Integer pageNum, Integer limit);

    Course getCourseById(Integer id);
}
