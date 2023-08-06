package com.test.k12.admin.controller;

import com.test.k12.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * @author  lry
 */
@Controller
@RequestMapping("/auth/data.html")
public class DataController {
    @Autowired
    private DataService dataService;

    @RequestMapping
    public String page() {
        return "month_sale";
    }

    @RequestMapping(params = "act=month")
    @ResponseBody
    public Map<String, int[]> month() {
        return dataService.getSubjectSaleMonthCount();
    }
}
