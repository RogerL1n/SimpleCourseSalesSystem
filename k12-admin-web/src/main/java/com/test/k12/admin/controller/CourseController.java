package com.test.k12.admin.controller;

import com.github.pagehelper.PageInfo;
import com.test.k12.admin.util.AjaxMessage;
import com.test.k12.admin.util.TableData;
import com.test.k12.pojo.Course;
import com.test.k12.service.CourseService;
import com.test.k12.service.GradeService;
import com.test.k12.service.SubjectService;
import com.test.k12.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author lry
 */
@Controller
@RequestMapping("/auth/course.html")
public class CourseController {

    @Autowired
    private CourseService courseService;
    @Autowired
    private SubjectService subjectService;
    @Autowired
    private GradeService gradeService;
    @Autowired
    private TeacherService teacherService;

    @RequestMapping
    public String page(Model model) {
        model.addAttribute("gradeList", gradeService.getGradeList());
        model.addAttribute("subjectList", subjectService.getSubjectList());
        model.addAttribute("teacherList", teacherService.getTeacherList());
        return "course";
    }

    @RequestMapping(params = "act=table")
    @ResponseBody
    public TableData table(Course course, Integer page, Integer limit) {
        PageInfo<Course> pageInfo = courseService.getCourseList(course, page, limit);
        return new TableData(pageInfo.getTotal(), pageInfo.getList());
    }

    @RequestMapping(params = "act=edit")
    @ResponseBody
    public AjaxMessage edit(Course course) {
        try {
            if (course.getId() == null) {
                courseService.addCourse(course);
            } else {
                courseService.updateCourse(course);
            }
            return new AjaxMessage(true, "编辑成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new AjaxMessage(false, "编辑失败");
        }
    }
}
