import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 蔡心勇
 * @create 2022/3/20 - 15:54
 */
public class Test1 {
    @Test
    public void test1()throws  Exception{
        Class studentClass = Student.class;
        System.out.println(studentClass.getSimpleName());

        Constructor constructor = studentClass.getDeclaredConstructor();
        constructor.setAccessible(true);
        Student student= (Student) constructor.newInstance();
        System.out.println(student);
    }

    @Test
    public void test2()throws  Exception{
        Class<Student> studentClass = Student.class;
        Field[] declaredFields = studentClass.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            System.out.println(declaredField.getName()+"---->"+declaredField.getType());
        }
    }

    @Test
    public void test3()throws  Exception{
        Class<Student> studentClass = Student.class;
        Method[] declaredMethods = studentClass.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            System.out.println(declaredMethod);
        }
    }

    @Test
    public void test4()throws  Exception{
        List<Integer> list=new ArrayList<>();
        list.add(1);
        list.add(2);

        Class<? extends List> aClass = list.getClass();
        Method add = aClass.getMethod("add", Object.class);
        add.invoke(list,"wo");

        System.out.println(list);
    }

    @Test
    public void test5()throws  Exception{
        System.out.println(new int[]{1, 2, 3});
    }

    @work
    private void test6(){

    }
}

@interface work{

}
