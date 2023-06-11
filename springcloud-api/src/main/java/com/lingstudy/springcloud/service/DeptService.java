package com.lingstudy.springcloud.service;

import com.lingstudy.springcloud.pojo.Dept;
import feign.hystrix.FallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Map;

/**
 * @author SirLi
 */
@Component
@FeignClient(name = "SPRINGCLOUD-PROVIDER-DEPT",fallbackFactory = DeptServiceFallbackFactory.class) //value的值是在eureka注册springCloud名称
public interface DeptService {

    @GetMapping("/deptApi/queryAll")
    Map<String, List<Dept>> getAll();

    @GetMapping("/deptApi/queryDept/{deptNo}")
    Map<String, Object> get(@PathVariable(value = "deptNo") String deptNo);

    @PostMapping("/deptApi/addDept")
    Map<String, Object> add(Dept dept);

    @DeleteMapping("/deptApi/deleteDept/{deptNo}")
    Map<String, Object> delete(@PathVariable(value = "deptNo") String deptNo);

}
