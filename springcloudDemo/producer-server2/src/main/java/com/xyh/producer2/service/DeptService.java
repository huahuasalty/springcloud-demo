package com.xyh.producer2.service;

import com.xyh.producer2.pojo.Dept;

import java.util.List;

public interface DeptService {
    List<Dept> queryAll() throws Exception;
}
