import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author 蔡心勇
 * @create 2022/3/20 - 13:59
 */
public class ClientSocket {
    public static void main(String[] args)throws Exception {
        System.out.println("=========客户端启动============");
        Socket socket=new Socket("127.0.0.1",9898);

        OutputStream outputStream=socket.getOutputStream();
        PrintStream printStream=new PrintStream(outputStream);

        while (true){
            Scanner scanner=new Scanner(System.in);
            System.out.println("请输入");
            printStream.println(scanner.nextLine());
            printStream.flush();
        }
    }
}
