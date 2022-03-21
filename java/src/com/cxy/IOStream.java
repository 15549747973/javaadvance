import org.junit.Test;

import java.io.*;

/**
 * @author 蔡心勇
 * @create 2022/3/17 - 14:42
 */
public class IOStream {
    @Test
    public void test1() throws Exception {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("D:/t.txt"));
        bufferedWriter.write("我爱我的祖国");
        bufferedWriter.close();

        BufferedReader bufferedReader = new BufferedReader(new FileReader("D:/t.txt"));
        String s;
        while ((s = bufferedReader.readLine()) != null) {
            System.out.println(s);
        }
    }

    @Test
    public void test2() throws Exception {
        FileInputStream fileInputStream = new FileInputStream("D:/t.txt");
        InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, "UTF-16");
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        String s;
        while ((s = bufferedReader.readLine()) != null) {
            System.out.println(s);
        }
    }

    @Test
    public void test3() throws Exception {
        FileOutputStream fileOutputStream = new FileOutputStream("D:/t.txt", true);
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream, "UTF-16LE");
        BufferedWriter bufferedWriter=new BufferedWriter(outputStreamWriter);

        bufferedWriter.write("我和我的家乡");
        bufferedWriter.close();
    }
}
