package com.test.k12.dao;


import com.test.k12.pojo.Course;

import java.util.List;

public interface CourseDAO {
    void addCourse(Course course);

    void updateCourse(Course course);

    List<Course> getCourseList(Course course);

    Course getCourseById(Integer id);
}
