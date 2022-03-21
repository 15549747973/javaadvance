package com.cxy.pojo;

/**
 * @author 蔡心勇
 * @create 2022/3/11 - 8:29
 */
public class StaffTemp {
    private Integer staffId;
    private String staffName;
    private String StaffEmail;
    private Dept dept;


    public StaffTemp() {
    }

    public StaffTemp(Integer staffId, String staffName, String StaffEmail, Dept dept) {
        this.staffId = staffId;
        this.staffName = staffName;
        this.StaffEmail = StaffEmail;
        this.dept = dept;
    }

    /**
     * 获取
     * @return staffId
     */
    public Integer getStaffId() {
        return staffId;
    }

    /**
     * 设置
     * @param staffId
     */
    public void setStaffId(Integer staffId) {
        this.staffId = staffId;
    }

    /**
     * 获取
     * @return staffName
     */
    public String getStaffName() {
        return staffName;
    }

    /**
     * 设置
     * @param staffName
     */
    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    /**
     * 获取
     * @return StaffEmail
     */
    public String getStaffEmail() {
        return StaffEmail;
    }

    /**
     * 设置
     * @param StaffEmail
     */
    public void setStaffEmail(String StaffEmail) {
        this.StaffEmail = StaffEmail;
    }

    /**
     * 获取
     * @return dept
     */
    public Dept getDept() {
        return dept;
    }

    /**
     * 设置
     * @param dept
     */
    public void setDept(Dept dept) {
        this.dept = dept;
    }

    public String toString() {
        return "StaffTemp{staffId = " + staffId + ", staffName = " + staffName + ", StaffEmail = " + StaffEmail + ", dept = " + dept + "}";
    }
}
