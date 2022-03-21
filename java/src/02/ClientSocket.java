import javax.jnlp.FileContents;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Scanner;

/**
 * @author 蔡心勇
 * @create 2022/3/20 - 13:59
 */
public class ClientSocket {
    public static void main(String[] args)throws Exception {

        FileContents socket = null;
        OutputStream outputStream=null;
        PrintStream printStream=new PrintStream(outputStream);

        while (true){
            Scanner scanner=new Scanner(System.in);
            System.out.println("请输入");
            printStream.println(scanner.nextLine());
            printStream.flush();
        }
    }
}
