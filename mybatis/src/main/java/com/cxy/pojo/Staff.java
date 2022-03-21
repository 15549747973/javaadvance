package com.cxy.pojo;

/**
 * @author 蔡心勇
 * @create 2022/3/10 - 17:31
 */
public class Staff {
    private Integer staffId;
    private String staffName;
    private String StaffEmail;
    private Integer deptId;


    public Staff() {
    }

    public Staff(Integer staffId, String staffName, String StaffEmail, Integer deptId) {
        this.staffId = staffId;
        this.staffName = staffName;
        this.StaffEmail = StaffEmail;
        this.deptId = deptId;
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

    public String toString() {
        return "Staff{staffId = " + staffId + ", staffName = " + staffName + ", StaffEmail = " + StaffEmail + ", deptId = " + deptId + "}";
    }
}
