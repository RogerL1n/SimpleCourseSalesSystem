package com.test.k12.admin.controller;

import com.github.pagehelper.PageInfo;
import com.test.k12.admin.util.AjaxMessage;
import com.test.k12.admin.util.TableData;
import com.test.k12.pojo.Subject;
import com.test.k12.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/auth/subject.html")
public class SubjectController {
    @Autowired
    private SubjectService subjectService;


    @RequestMapping
    public String page() {
        return "subject";
    }

    @RequestMapping(params = "act=table")
    @ResponseBody
    public TableData table(Integer page, Integer limit) {
        PageInfo<Subject> pageInfo = subjectService.getSubjectList(page, limit);
        return new TableData(pageInfo.getTotal(), pageInfo.getList());
    }

    @RequestMapping(params = "act=edit")
    @ResponseBody
    public AjaxMessage edit(Subject subject) {
        try {
            if (subject.getId() == null) {
                subjectService.addSubject(subject);
            } else {
                subjectService.updateSubject(subject);
            }
            return new AjaxMessage(true, "编辑成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new AjaxMessage(false, "编辑失败");
        }
    }

    @RequestMapping(params = "act=delete")
    @ResponseBody
    public AjaxMessage delete(Integer id) {
        try {
            subjectService.deleteSubject(id);
            return new AjaxMessage(true);
        } catch (Exception e) {
            e.printStackTrace();
            return new AjaxMessage(true, "删除失败");
        }
    }
}
