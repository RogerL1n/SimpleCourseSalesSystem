package com.test.k12.customer.controller;

import com.test.k12.pojo.Course;
import com.test.k12.service.CourseService;
import com.test.k12.service.GradeService;
import com.test.k12.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author lry
 */
@Controller
public class IndexController {
    @Autowired
    private CourseService courseService;

    @Autowired
    private GradeService gradeService;
    @Autowired
    private SubjectService subjectService;

    @RequestMapping("index.html")
    public String index(Model model) {
        model.addAttribute("courseList", courseService.getCourseList(null, 1, 6).getList());
        model.addAttribute("gradeList", gradeService.getGradeList());
        return "index";
    }

    @RequestMapping("course.html")
    public String course(Model model, Integer pageNum, Course course) {
        if (pageNum == null) {
            pageNum = 1;
        }
        model.addAttribute("subjectList", subjectService.getSubjectList());
        model.addAttribute("gradeList", gradeService.getGradeList());
        model.addAttribute("pageInfo", courseService.getCourseList(course, pageNum, 12));
        return "courses";
    }

    @RequestMapping("detail.html")
    public String detail(Model model, Integer id) {
        Course course = courseService.getCourseById(id);
        model.addAttribute("course", course);
        return "detail";
    }
}
