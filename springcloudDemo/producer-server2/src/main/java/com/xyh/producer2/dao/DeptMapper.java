package com.xyh.producer2.dao;

import com.xyh.producer2.pojo.Dept;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DeptMapper {
    List<Dept> queryAll() throws Exception;
}
