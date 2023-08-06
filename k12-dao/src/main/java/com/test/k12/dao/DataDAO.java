package com.test.k12.dao;

import com.test.k12.pojo.SubjectSaleCount;

import java.util.List;

public interface DataDAO {
    List<SubjectSaleCount> getSubjectSaleCount();

    List<SubjectSaleCount> getSubjectSaleMonthCount();
}
