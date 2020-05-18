package com.xyh.producer.service;

import com.xyh.producer.pojo.Dept;

import java.util.List;

public interface DeptService {
    List<Dept> queryAll() throws Exception;

    void addDept(Dept dept) throws Exception;
}
