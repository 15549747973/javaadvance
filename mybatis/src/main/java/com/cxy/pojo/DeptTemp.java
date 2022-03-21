package com.cxy.pojo;

import java.util.List;

/**
 * @author 蔡心勇
 * @create 2022/3/11 - 10:12
 */
public class DeptTemp {
    private Integer deptId;
    private String deptName;
    private List<Staff> staffList;


    public DeptTemp() {
    }

    public DeptTemp(Integer deptId, String deptName, List<Staff> staffList) {
        this.deptId = deptId;
        this.deptName = deptName;
        this.staffList = staffList;
    }

    /**
     * 获取
     * @return deptId
     */
    public Integer getDeptId() {
        return deptId;
    }

    /**
     * 设置
     * @param deptId
     */
    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    /**
     * 获取
     * @return deptName
     */
    public String getDeptName() {
        return deptName;
    }

    /**
     * 设置
     * @param deptName
     */
    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    /**
     * 获取
     * @return staffList
     */
    public List<Staff> getStaffList() {
        return staffList;
    }

    /**
     * 设置
     * @param staffList
     */
    public void setStaffList(List<Staff> staffList) {
        this.staffList = staffList;
    }

    public String toString() {
        return "DeptTemp{deptId = " + deptId + ", deptName = " + deptName + ", staffList = " + staffList + "}";
    }
}
