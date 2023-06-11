package com.lingstudy.springcloud.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author SirLi
 */
@Data
@NoArgsConstructor
@Accessors(chain = true)
public class Dept implements Serializable {

    /**
     * 序号id
     */
    private int deptNo;

    /**
     * 部门名称
     */
    private String dName;

    /**
     * 数据来源库
     */
    private String dbSource;

    public Dept(String dName) {
        this.dName = dName;
    }
}
