package com.cxy.pojo;

/**
 * @author 蔡心勇
 * @create 2022/3/10 - 17:33
 */
public class Dept {
    private Integer deptId;
    private String deptName;


    public Dept() {
    }

    public Dept(Integer deptId, String deptName) {
        this.deptId = deptId;
        this.deptName = deptName;
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

    public String toString() {
        return "Dept{deptId = " + deptId + ", deptName = " + deptName + "}";
    }
}
