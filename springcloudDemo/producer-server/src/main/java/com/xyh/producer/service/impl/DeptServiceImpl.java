package com.xyh.producer.service.impl;

import com.xyh.producer.dao.DeptMapper;
import com.xyh.producer.pojo.Dept;
import com.xyh.producer.service.DeptService;
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

    @Override
    public void addDept(Dept dept) throws Exception {
        deptMapper.addDept(dept);
    }
}
