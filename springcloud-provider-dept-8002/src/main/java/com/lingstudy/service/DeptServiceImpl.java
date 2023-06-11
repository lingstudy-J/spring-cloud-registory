package com.lingstudy.service;

import com.lingstudy.mapper.DeptMapper;
import com.lingstudy.springcloud.pojo.Dept;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author SirLi
 */
@Service
public class DeptServiceImpl implements DeptService {

    /**
     * 部门mapper
     */
    private final DeptMapper deptMapper;

    public DeptServiceImpl(DeptMapper deptMapper) {
        this.deptMapper = deptMapper;
    }

    @Override
    public void addDept(Dept dept) {
        deptMapper.addDept(dept);
    }

    @Override
    public void updateDept(Dept dept) {
        deptMapper.updateDept(dept);
    }

    @Override
    public Dept queryOfDeptNo(String deptNo) {
        return deptMapper.queryOfDeptNo(deptNo);
    }

    @Override
    public void deleteDeptByDeptNo(String deptNo) {
        deptMapper.deleteDeptByDeptNo(deptNo);
    }

    @Override
    public List<Dept> queryAll() {
        return deptMapper.queryAll();
    }
}
