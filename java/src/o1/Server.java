import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * @author 蔡心勇
 * @create 2022/3/20 - 13:30
 */
public class Server {
    public static void main(String[] args)throws Exception {
        System.out.println("=========服务器启动===========");

        byte[] bytes = new byte[1024*64];
        DatagramPacket datagramPacket = new DatagramPacket(bytes, bytes.length);

        DatagramSocket datagramSocket=new DatagramSocket(9898);
        datagramSocket.receive(datagramPacket);

        System.out.println(new String(bytes,0,datagramPacket.getLength()));
        System.out.println(datagramPacket.getAddress().getHostAddress());
        System.out.println(datagramPacket.getPort());

        datagramSocket.close();
    }
}
