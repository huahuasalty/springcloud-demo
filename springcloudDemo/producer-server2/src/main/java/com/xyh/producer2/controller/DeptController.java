package com.xyh.producer2.controller;

import com.xyh.producer2.pojo.Dept;
import com.xyh.producer2.pojo.OutData;
import com.xyh.producer2.service.DeptService;
import io.swagger.annotations.Api;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/dept")
@Api(value = "部门")
public class DeptController {

    private Logger log =Logger.getLogger(this.getClass());
    @Autowired
    private DeptService deptService;

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
            log.error(e.getMessage(),e);
        }
        return out;
    }
}
