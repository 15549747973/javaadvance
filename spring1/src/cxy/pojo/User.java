package cxy.pojo;

/**
 * @author 蔡心勇
 * @create 2022/3/4 - 16:08
 */
public class User {
    private String user;
    private String password;
    private int balance;


    public User() {
    }

    public User(String user, String password, int balance) {
        this.user = user;
        this.password = password;
        this.balance = balance;
    }

    /**
     * 获取
     * @return user
     */
    public String getUser() {
        return user;
    }

    /**
     * 设置
     * @param user
     */
    public void setUser(String user) {
        this.user = user;
    }

    /**
     * 获取
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 获取
     * @return balance
     */
    public int getBalance() {
        return balance;
    }

    /**
     * 设置
     * @param balance
     */
    public void setBalance(int balance) {
        this.balance = balance;
    }

    public String toString() {
        return "User{user = " + user + ", password = " + password + ", balance = " + balance + "}";
    }
}
