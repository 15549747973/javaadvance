package cxy.dao;

import cxy.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author 蔡心勇
 * @create 2022/3/4 - 15:40
 */
@Component
public class UserDaoImpl implements UserDao{
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int add(User user) {
        String sql="insert into user_table values(?,?,?)";
        Object[] args={user.getUser(),user.getPassword(),user.getBalance()};
        return jdbcTemplate.update(sql,args);
    }

    @Override
    public int delete(String id) {
        String sql="delete from user_table where user=?";
        Object[] args={id};
        return jdbcTemplate.update(sql,args);
    }

    @Override
    public int queryCount() {
        String sql="select count(*) from user_table";
        Integer count = jdbcTemplate.queryForObject(sql, Integer.class);
        return count;
    }

    @Override
    public User query(String id) {
        String sql="select * from user_table where user=?";
        Object[] args={id};
        return jdbcTemplate.queryForObject(sql,new BeanPropertyRowMapper<User>(User.class),args);
    }

    @Override
    public List<User> queryList() {
        String sql="select * from user_table";
        List<User> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<User>(User.class));
        return list;
    }

    @Override
    public int[] batchUpdate(List<Object[]> batchArgs) {
        String sql="insert into user_table values(?,?,?)";
        return jdbcTemplate.batchUpdate(sql, batchArgs);
    }
}
