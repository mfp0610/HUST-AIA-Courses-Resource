import java.io.*;
import java.net.*;

public class MyUdpClient {
    public static void main(String[] args) throws IOException {

        //创建数据报Socket。
        DatagramSocket socket = new DatagramSocket();

        // 构造请求数据报并发送。
        byte[] buf = new byte[256];
        InetAddress address = InetAddress.getByName("localhost");
        DatagramPacket packet = new DatagramPacket(
        							buf, buf.length, address, 4445);
        socket.send(packet);
    
        // 构造接收数据报并启动接收。
        packet = new DatagramPacket(buf, buf.length);
        socket.receive(packet);

	    // 收到Server端响应数据报，获取数据并显示。
        String received = new String(packet.getData());
        System.out.println("The sentence send by the server: \n    " 
        								+ received);
    
        socket.close(); //关闭Socket。
    }
}
