package com.lingstudy.mapper;

import com.lingstudy.springcloud.pojo.Dept;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author SirLi
 */
@Mapper
@Repository
public interface DeptMapper {

    /**
     * 新增部门
     * @param dept 部门实体类
     */
    void addDept(Dept dept);

    /**
     * 根据ID修改部门信息
     * @param dept 部门数据
     */
    void updateDept(Dept dept);

    /**
     * 根据部门id查询部门信息
     * @return 返回该id部门信息
     */
    Dept queryOfDeptNo(@Param("deptNo") String deptNo);

    /**
     * 根据指定id删除部门数据
     * @param deptNo 部门id
     */
    void deleteDeptByDeptNo(@Param("deptNo") String deptNo);

    /**
     * 查询所有部门信息
     * @return 所有部门数据
     */
    List<Dept> queryAll();

}
