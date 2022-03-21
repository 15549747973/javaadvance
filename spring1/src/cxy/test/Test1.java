package cxy.test;

import cxy.pojo.User;
import cxy.service.UserService;
import cxy.service.UserTest;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author 蔡心勇
 * @create 2022/3/4 - 15:26
 */
public class Test1 {
    @Test
    public void testAdd() {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("bean1.xml");
        UserService userService = context.getBean("userService", UserService.class);
        int addUser = userService.addUser(new User("1231", "1231", 1231));
        System.out.println(addUser);
    }

    @Test
    public void testDelete() {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("bean1.xml");
        UserService userService = context.getBean("userService", UserService.class);
        int deleteUserById = userService.deleteUserById("cxy");
        System.out.println(deleteUserById);
    }

    @Test
    public void testQueryCount() {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("bean1.xml");
        UserService userService = context.getBean("userService", UserService.class);
        int count = userService.queryCount();
        System.out.println(count);
    }

    @Test
    public void testQueryUser() {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("bean1.xml");
        UserService userService = context.getBean("userService", UserService.class);
        User user = userService.queryUserById("123");
        System.out.println(user);
    }

    @Test
    public void testQueryUserList() {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("bean1.xml");
        UserService userService = context.getBean("userService", UserService.class);
        List<User> list = userService.queryUserList();
        for (User user : list) {
            System.out.println(user);
        }
    }

    @Test
    public void testBatchAdd() {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("bean1.xml");
        UserService userService = context.getBean("userService", UserService.class);
        List<Object[]> batchArgs=new ArrayList<>();
        Object[] o1={"qqq","qqq",111};
        Object[] o2={"aaa","aaa",222};
        Object[] o3={"zzz","zzz",333};
        batchArgs.add(o1);
        batchArgs.add(o2);
        batchArgs.add(o3);
        int[] ints = userService.batchAdd(batchArgs);
        System.out.println(Arrays.toString(ints));
    }

    @Test
    public void testt() {
        ApplicationContext context=
                new ClassPathXmlApplicationContext("bean1.xml");
        UserTest userTest = context.getBean("userTest", UserTest.class);
        userTest.test1();
    }

    @Test
    public void test1() {
        ApplicationContext context=
                new ClassPathXmlApplicationContext("bean2.xml");
        UserTest userTest = context.getBean("userTest", UserTest.class);
        userTest.test1();
    }
}
