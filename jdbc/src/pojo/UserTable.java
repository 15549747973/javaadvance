public class UserTable {
    private String user;
    private String password;
    private Integer balance;

    public UserTable() {
    }

    public UserTable(String user, String password, Integer balance) {
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
    public Integer getBalance() {
        return balance;
    }

    /**
     * 设置
     * @param balance
     */
    public void setBalance(Integer balance) {
        this.balance = balance;
    }

    public String toString() {
        return "UserTable{user = " + user + ", password = " + password + ", balance = " + balance + "}";
    }
}
