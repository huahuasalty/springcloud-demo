package com.xyh.producer.dao;

import com.xyh.producer.pojo.Dept;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DeptMapper {
    List<Dept> queryAll() throws Exception;

    void addDept(Dept dept) throws Exception;
}
