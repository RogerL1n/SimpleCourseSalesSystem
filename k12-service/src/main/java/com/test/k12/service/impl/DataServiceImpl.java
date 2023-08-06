package com.test.k12.service.impl;

import com.test.k12.dao.DataDAO;
import com.test.k12.pojo.SubjectSaleCount;
import com.test.k12.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author lry
 */
@Service
public class DataServiceImpl implements DataService {
    @Autowired
    private DataDAO dataDAO;

    @Override
    public Map<String, List> getSubjectSaleCount() {
        List<SubjectSaleCount> list = dataDAO.getSubjectSaleCount();
        List<Integer> count = new ArrayList<>();
        List<String> subject = new ArrayList<>();
        for (SubjectSaleCount subjectSaleCount : list) {
            count.add(subjectSaleCount.getCount());
            subject.add(subjectSaleCount.getName());
        }
        Map<String, List> result = new HashMap<>();
        result.put("count", count);
        result.put("subject", subject);
        return result;
    }

    @Override
    public Map<String, int[]> getSubjectSaleMonthCount() {
        List<SubjectSaleCount> list = dataDAO.getSubjectSaleMonthCount();
        Map<String, int[]> result = new HashMap<>();
        for (SubjectSaleCount sale : list) {
            int[] array = result.get(sale.getName());
            if (array == null) {
                array = new int[12];
                result.put(sale.getName(), array);
            }
            array[sale.getMonth() - 1] = sale.getCount();
        }
        return result;
    }
}
