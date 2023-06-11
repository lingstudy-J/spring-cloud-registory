package com.lingstudy.controller;

import com.lingstudy.service.DeptServiceImpl;
import com.lingstudy.springcloud.pojo.Dept;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author SirLi
 */

@RestController
@RequestMapping("/deptApi")
public class DeptController {

    private final DeptServiceImpl deptService;

    private final DiscoveryClient client;

    public DeptController(DeptServiceImpl deptService, DiscoveryClient client) {
        this.deptService = deptService;
        this.client = client;
    }

    @GetMapping("/queryDept/{deptNo}")
    public Map<String, Dept> queryDept(@PathVariable("deptNo") String deptNo) {
        Map<String, Dept> deptHashMap = new HashMap<>();
        deptHashMap.put("data", deptService.queryOfDeptNo(deptNo));
        return deptHashMap;
    }

    @GetMapping("/queryAll")
    public Map<String, List<Dept>> queryAll() {
        Map<String, List<Dept>> deptHashMap = new HashMap<>();
        deptHashMap.put("data", deptService.queryAll());
        return deptHashMap;
    }

    @PostMapping("/addDept")
    public Map<String, Object> addDept(@RequestBody Dept deptNo) {
        deptService.addDept(deptNo);
        Map<String, Object> deptHashMap = new HashMap<>();
        deptHashMap.put("Code", "200");
        deptHashMap.put("message", "添加成功");
        return deptHashMap;
    }

    @GetMapping("/deleteDept/{deptNo}")
    public Map<String, Object> deleteDept(@PathVariable String deptNo) {
        deptService.deleteDeptByDeptNo(deptNo);
        Map<String, Object> deptHashMap = new HashMap<>();
        deptHashMap.put("Code", "200");
        deptHashMap.put("message", "添加成功");

        return deptHashMap;
    }

    // 注册进来的微服务，我们可以获取一些消息~

    @GetMapping("/getDiscovery")
    public Object discovery() {
        //获取微服务清单
        List<String> services = client.getServices();
        services.forEach(System.out::println);

        //得到一个具体的微服务信息，通过serviceId获取,一般就是application.name中名字
        List<ServiceInstance> instances = client.getInstances("SPRINGCLOUD-PROVIDER-DEPT");

        instances.forEach(in -> {
            System.out.println(
                    in.getHost() + "\t" +
                            in.getPort() + "\t" +
                            in.getUri() + "\t" +
                            in.getServiceId()
            );
        });

        return services;
    }

}
