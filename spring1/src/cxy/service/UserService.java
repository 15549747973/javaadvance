package cxy.service;

import cxy.dao.UserDao;
import cxy.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author 蔡心勇
 * @create 2022/3/4 - 15:39
 */
@Component
public class UserService {
    @Autowired
    private UserDao userDao;

    /**
     * 添加一名用户信息
     *
     * @param user
     * @return
     */
    public int addUser(User user) {
        return userDao.add(user);
    }

    public int deleteUserById(String id) {
        return userDao.delete(id);
    }

    public int queryCount() {
        return userDao.queryCount();
    }

    public User queryUserById(String id) {
        return userDao.query(id);
    }

    public List<User> queryUserList() {
        return userDao.queryList();
    }

    public int[] batchAdd(List<Object[]> batchArgs) {
        return userDao.batchUpdate(batchArgs);
    }
}
