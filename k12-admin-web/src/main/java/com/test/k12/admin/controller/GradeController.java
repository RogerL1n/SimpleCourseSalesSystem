package com.test.k12.admin.controller;

import com.github.pagehelper.PageInfo;
import com.test.k12.admin.util.AjaxMessage;
import com.test.k12.admin.util.TableData;
import com.test.k12.pojo.Grade;
import com.test.k12.service.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/auth/grade.html")
public class GradeController {
    @Autowired
    private GradeService gradeService;


    @RequestMapping
    public String page() {
        return "grade";
    }

    @RequestMapping(params = "act=table")
    @ResponseBody
    public TableData table(Integer page, Integer limit) {
        PageInfo<Grade> pageInfo = gradeService.getGradeList(page, limit);
        return new TableData(pageInfo.getTotal(), pageInfo.getList());
    }

    @RequestMapping(params = "act=edit")
    @ResponseBody
    public AjaxMessage edit(Grade grade) {
        try {
            if (grade.getId() == null) {
                gradeService.addGrade(grade);
            } else {
                gradeService.updateGrade(grade);
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
            gradeService.deleteGrade(id);
            return new AjaxMessage(true);
        } catch (Exception e) {
            e.printStackTrace();
            return new AjaxMessage(true, "删除失败");
        }
    }
}
