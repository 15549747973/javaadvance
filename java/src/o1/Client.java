import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * @author 蔡心勇
 * @create 2022/3/20 - 13:30
 */
public class Client {
    public static void main(String[] args) throws Exception{
        System.out.println("===========客户端开启===========");

        byte[] bytes="我来了，干饭吧".getBytes();
        DatagramPacket datagramPacket = new DatagramPacket(bytes, bytes.length, InetAddress.getLocalHost(), 9898);

        DatagramSocket datagramSocket=new DatagramSocket();
        datagramSocket.send(datagramPacket);

        datagramSocket.close();
    }
}
