import java.io.*;
import java.net.*;

public class MultiUdpClient {
    public static void main(String[] args) throws IOException {

        //创建多播数据报Socket，并加入到一个多播组。       
        MulticastSocket socket = new MulticastSocket(4446);
		InetAddress group = InetAddress.getByName("228.5.6.7");
 		socket.joinGroup(group);

		//从Server端接收5个数据报，并显示数据报中的数据。
		DatagramPacket packet;
		for (int i = 0; i < 5; i++) {
    		byte[] buf = new byte[256];
    		packet = new DatagramPacket(buf, buf.length);
    		socket.receive(packet);

         	String received = new String(packet.getData());
        	System.out.println("The sentence send by the server: \n    " 
        								+ received);
		}
		
		socket.leaveGroup(group);  //离开多播组。
		socket.close();     	   //关闭Socket。	
     }
}
