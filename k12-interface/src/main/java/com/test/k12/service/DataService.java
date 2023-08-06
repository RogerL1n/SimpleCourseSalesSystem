package com.test.k12.service;

import java.util.List;
import java.util.Map;

public interface DataService {
    Map<String, List> getSubjectSaleCount();

    Map<String, int[]> getSubjectSaleMonthCount();
}
