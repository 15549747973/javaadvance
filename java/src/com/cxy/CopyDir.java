import org.junit.Before;
import org.junit.Test;

import java.io.File;

/**
 * @author 蔡心勇
 * @create 2022/3/20 - 9:08
 */
public class CopyDir {
    @Before
    public void before(){
        System.out.println("this is before");
    }

    @Test
    public void test1(){
        File file=new File("D:\\ja-netfilter");
        work(file);
    }

    private void work(File file){
        //判断存在且是文件夹
        if((!file.exists())||(!file.isDirectory()))return;
        File[] files = file.listFiles();

        //一级文件可操作且有文件
        if(files==null||files.length<=0)return;
        for (File file1 : files) {
            if(file1.isDirectory()){
                System.out.println(file1.getName());
                work(file1);
            }
            else System.out.println(file1.getAbsolutePath());
        }
    }
}
