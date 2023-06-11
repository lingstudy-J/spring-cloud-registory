package com.lingstudy.controller;

import com.lingstudy.springcloud.pojo.Dept;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

/**
 * @author SirLi
 */
@RestController
public class DeptConsumerController {

    private final RestTemplate restTemplate;

    //Ribbon  这里的地址应该是一个变量，通过服务名称访问
//    private static final String REST_URL_PREFIX = "http://localhost:8001";
    private static final String REST_URL_PREFIX = "http://SPRINGCLOUD-PROVIDER-DEPT";


    public DeptConsumerController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/consumer/dept/get/{deptNo}")
    public Map get(@PathVariable String deptNo){

      return   restTemplate.getForObject(REST_URL_PREFIX + "/deptApi/queryDept/" + deptNo, Map.class);

    }

    @PostMapping("/add")
    public Map add(Dept dept){
        return restTemplate.postForObject(REST_URL_PREFIX+"/deptApi/addDept",dept, Map.class);
    }

    @DeleteMapping("/delete/{deptNo}")
    public Map delete(@PathVariable String deptNo){
        return restTemplate.getForObject(REST_URL_PREFIX+"/deptApi/deleteDept"+deptNo,Map.class);
    }

    @GetMapping("/getAll")
    public Map getAll(){
        return restTemplate.getForObject(REST_URL_PREFIX+"/deptApi/queryAll", Map.class);
    }
}

