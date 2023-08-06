package com.test.k12.admin.controller;

import com.github.pagehelper.PageInfo;
import com.test.k12.admin.util.AjaxMessage;
import com.test.k12.admin.util.TableData;
import com.test.k12.pojo.Teacher;
import com.test.k12.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/auth/teacher.html")
public class TeacherController {
    @Autowired
    private TeacherService teacherService;


    @RequestMapping
    public String page() {
        return "teacher";
    }

    @RequestMapping(params = "act=table")
    @ResponseBody
    public TableData table(Integer page, Integer limit) {
        PageInfo<Teacher> pageInfo = teacherService.getTeacherList(page, limit);
        return new TableData(pageInfo.getTotal(), pageInfo.getList());
    }

    @RequestMapping(params = "act=edit")
    @ResponseBody
    public AjaxMessage edit(Teacher teacher) {
        try {
            if (teacher.getId() == null) {
                teacherService.addTeacher(teacher);
            } else {
                teacherService.updateTeacher(teacher);
            }
            return new AjaxMessage(true, "编辑成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new AjaxMessage(false, "编辑失败");
        }
    }
}
