package cxy.test;

import cxy.service.UserTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author 蔡心勇
 * @create 2022/3/5 - 9:14
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:bean2.xml")
public class TestJunit4 {
    @Autowired
    private UserTest userTest=new UserTest();

    @Test
    public void test1(){
        userTest.test1();
    }
}
