package com.wust.mybatis.mapper;

import com.wust.mybatis.pojo.Emp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmpMapper {

    /**
     * 查询所有员工信息
     */
    List<Emp> getAllEmp();

    /**
     * 查询员工以及员工所对应的部门信息
     * 处理一对多映射关系:
         * a>级联属性赋值
         * b>通过association
         * c>分步查询 ： 好处：延迟加载
     */
    Emp getEmpAndDept(@Param("eid")Integer eid);

    /**
     * 通过分步查询员工以及员工所对应的部门信息
     * 分步查询第一步：查询员工信息
     */
    Emp getEmpAndDeptByStepOne(@Param("eid") Integer eid);

    /**
     * 通过分步查询查询部门以及部门中所有的员工信息
     * 分布查询第二步：根据did查询员工信息
     */
    List<Emp> getDeptAndEmpByStepTwo(@Param("did") Integer did);
}
