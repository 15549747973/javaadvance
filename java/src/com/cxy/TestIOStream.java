import org.junit.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * @author 蔡心勇
 * @create 2022/3/20 - 7:42
 */
public class TestIOStream {
    @Test
    public void test1()throws Exception{
        BufferedWriter bufferedWriter=new BufferedWriter(new FileWriter("D:/t.txt"));
        List<String> list=new ArrayList<>();
        list.add("0悯农\r\n");
        list.add("1锄禾日当午\r\n");
        list.add("2汗滴禾下土\r\n");
        list.add("3谁知盘中餐\r\n");
        list.add("4粒粒皆辛苦\r\n");
        for (String s : list) {
            bufferedWriter.write(s);
        }
        bufferedWriter.close();
    }

    @Test
    public void test2()throws Exception{
        BufferedReader bufferedReader=new BufferedReader(new FileReader("D:/t.txt"));
        List<String> list=new ArrayList<>();
        String s;
        while((s=bufferedReader.readLine())!=null){
            list.add(s);
        }
        for (String s1 : list) {
            System.out.println(s1);
        }
        bufferedReader.close();
    }

    @Test
    public void test3()throws Exception{
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("D:/t.dat"));
        objectOutputStream.writeObject(new Student("1904240708","12345","cai",21));
        objectOutputStream.close();
    }

    @Test
    public void test4()throws Exception{
        ObjectInputStream objectInputStream=new ObjectInputStream(new FileInputStream("D:/t.dat"));
        Student student= (Student) objectInputStream.readObject();
        System.out.println(student);

    }

    @Test
    public void test5()throws Exception{
        PrintStream printStream=new PrintStream(new FileOutputStream("D:/t.txt",true));
        System.setOut(printStream);
        System.out.println("this is system.setOut");
    }

    @Test
    public void test6()throws Exception{
        PrintWriter printWriter=new PrintWriter(new FileWriter("D:/t.txt",true));
        printWriter.println("123asd");
        printWriter.write("waqsedzx");
        printWriter.close();
    }
    @Test
    public void test7()throws Exception{
        Properties properties=new Properties();
        properties.setProperty("username","root");
        properties.setProperty("password","123456");
        
        properties.store(new PrintWriter("jdbc.properties")," i had finised");
    }
}
