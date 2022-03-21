import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author 蔡心勇
 * @create 2022/3/20 - 14:01
 */
public class ServerSocketTest {
    public static void main(String[] args)throws Exception {
        System.out.println("================服务端启动===========");
        ServerSocket serverSocket=new ServerSocket(9898);
        Socket socket = serverSocket.accept();

        InputStream inputStream = socket.getInputStream();
        InputStreamReader inputStreamReader=new InputStreamReader(inputStream);
        BufferedReader bufferedReader=new BufferedReader(inputStreamReader);

        String s;
        while((s=bufferedReader.readLine())!=null){
            System.out.println(s);
        }
    }
}
