package com.xyh.producer.controller;

import com.xyh.producer.pojo.Dept;
import com.xyh.producer.pojo.OutData;
import com.xyh.producer.service.DeptService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(tags = "部门操作方法")
@RestController
@RequestMapping("/dept")
public class DeptController {
    @Autowired
    private DeptService deptService;

    @ApiOperation(value = "部门查询方法",notes = "")
    @RequestMapping("/queryAll")
    public OutData queryAll(){
        OutData out=new OutData();
        try {
            List<Dept> list=deptService.queryAll();
            out.setCode(1);
            out.setMsg("操作成功");
            out.setList(list);
        } catch (Exception e) {
            out.setMsg("操作失败！");
            out.setCode(-1);
            e.printStackTrace();
        }
        return out;
    }

    @ApiOperation(value = "添加部门方法",notes = "")
    @RequestMapping("addDept")
    public OutData addDept(Dept dept){
        OutData out=new OutData();
        try {
            deptService.addDept(dept);
            out.setCode(1);
            out.setMsg("操作成功");
        } catch (Exception e) {
            out.setMsg("操作失败！");
            out.setCode(-1);
            e.printStackTrace();
        }
        return out;
    }
}
