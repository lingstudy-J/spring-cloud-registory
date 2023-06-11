package com.lingstudy.controller;

import com.lingstudy.springcloud.pojo.Dept;
import com.lingstudy.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

/**
 * @author SirLi
 */
@RestController
public class DeptConsumerController {


    private final DeptService deptService;

    public DeptConsumerController(DeptService deptService) {
        this.deptService = deptService;
    }


    @GetMapping("/consumer/dept/get/{deptNo}")
    public Map<String,Object> get(@PathVariable String deptNo){
      return  this.deptService.get(deptNo);

    }

    @PostMapping("/add")
    public Map add(Dept dept){
        return this.deptService.add(dept);
    }

    @DeleteMapping("/delete/{deptNo}")
    public Map<String,Object> delete(@PathVariable String deptNo){
        return this.deptService.delete(deptNo);
    }

    @GetMapping("/getAll")
    public Map<String, List<Dept>> getAll(){
        return this.deptService.getAll();
    }
}

