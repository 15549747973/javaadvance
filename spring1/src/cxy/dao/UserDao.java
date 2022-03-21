package cxy.dao;

import cxy.pojo.User;

import java.util.List;

/**
 * @author 蔡心勇
 * @create 2022/3/4 - 15:39
 */
public interface UserDao {
    int add(User user);

    int delete(String id);

    int queryCount();

    User query(String id);

    List<User> queryList();

    int[] batchUpdate(List<Object[]> batchArgs);
}
