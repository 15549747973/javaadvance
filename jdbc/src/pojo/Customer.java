import java.sql.Date;

public class Customer {
    private Integer id;
    private String name;
    private String email;
    private Date birth;


    public Customer() {
    }

    public Customer(Integer id, String name, String email, Date birth) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.birth = birth;
    }

    /**
     * 获取
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * 设置
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取
     * @return email
     */
    public String getEmail() {
        return email;
    }

    /**
     * 设置
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * 获取
     * @return birth
     */
    public Date getBirth() {
        return birth;
    }

    /**
     * 设置
     * @param birth
     */
    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public String toString() {
        return "Customer{id = " + id + ", name = " + name + ", email = " + email + ", birth = " + birth + "}";
    }
}
