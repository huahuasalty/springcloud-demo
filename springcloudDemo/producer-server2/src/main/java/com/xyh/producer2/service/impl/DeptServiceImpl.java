package com.xyh.producer2.service.impl;

import com.xyh.producer2.dao.DeptMapper;
import com.xyh.producer2.pojo.Dept;
import com.xyh.producer2.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptMapper deptMapper;

    @Override
    public List<Dept> queryAll() throws Exception {
        return deptMapper.queryAll();
    }
}
