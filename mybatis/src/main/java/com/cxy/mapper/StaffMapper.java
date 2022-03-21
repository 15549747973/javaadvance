package com.cxy.mapper;

import com.cxy.pojo.Staff;
import com.cxy.pojo.StaffTemp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 蔡心勇
 * @create 2022/3/10 - 17:34
 */
public interface StaffMapper {

    int addStaff(Staff staff);

    Staff queryStaffById(@Param("id") Integer id);

    StaffTemp queryStaffAndDept(@Param("id") Integer id);

    StaffTemp queryStaffTwo(@Param("id") Integer id);

    List<Staff> queryStaffByDeptId(@Param("id") Integer id);
}
