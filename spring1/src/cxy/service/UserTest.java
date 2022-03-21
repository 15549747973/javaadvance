package cxy.service;

import cxy.dao.UserDao;
import cxy.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author 蔡心勇
 * @create 2022/3/4 - 20:12
 */
@Component
@Transactional
public class UserTest {
    @Autowired
    private UserDao userDao;

    public void test1(){
        userDao.add(new User("pp","pp",0));

//        int i = 1 / 0;
        userDao.add(new User("bb","bb",1));
    }
}
