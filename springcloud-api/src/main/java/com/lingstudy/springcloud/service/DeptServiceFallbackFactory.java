package com.lingstudy.springcloud.service;

import com.lingstudy.springcloud.pojo.Dept;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author SirLi
 */
@Component
public class DeptServiceFallbackFactory implements FallbackFactory<DeptService> {
    @Override
    public DeptService create(Throwable throwable) {
        return new DeptService() {
            @Override
            public Map<String, List<Dept>> getAll() {
                return null;
            }

            @Override
            public Map<String, Object> get(String deptNo) {
                HashMap<String, Object> restMap = new HashMap<>(4);
                restMap.put("code",200);
                restMap.put("data",deptNo+"不存在，该服务被关闭！");
                return restMap;
            }

            @Override
            public Map<String, Object> add(Dept dept) {
                return null;
            }

            @Override
            public Map<String, Object> delete(String deptNo) {
                return null;
            }
        };
    }
}
