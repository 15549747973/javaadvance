package com.cxy.mapper;

import com.cxy.pojo.Dept;
import com.cxy.pojo.DeptTemp;
import org.apache.ibatis.annotations.Param;

/**
 * @author 蔡心勇
 * @create 2022/3/10 - 17:35
 */
public interface DeptMapper {

    Dept queryDeptById(@Param("id") Integer id);

    DeptTemp queryDeptAndStaff(@Param("id") Integer id);

    DeptTemp queryDeptAndStaffTwo(@Param("id") Integer id);
}
