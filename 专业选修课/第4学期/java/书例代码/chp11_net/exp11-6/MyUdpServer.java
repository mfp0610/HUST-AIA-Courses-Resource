import java.io.*;
import java.net.*;

public class MyUdpServer{

    DatagramSocket socket = null;
    BufferedReader in = null;
    boolean moreQuotes = true;

    public void serverWork() throws IOException{    
     
       	socket = new DatagramSocket(4445);  //创建数据报Socket。
        in = new BufferedReader(new FileReader("sentences.txt")); 
  
        while (moreQuotes) {
 
            // 构造接收数据报并启动接收。
            byte[] buf = new byte[256];  
            DatagramPacket packet = new DatagramPacket(buf, buf.length);
            socket.receive(packet);

            /* 接收到Client端的数据报。从sentences.txt中读取一行，
               作为响应数据报中的数据。*/
            String dString = null;                        
            if ((dString = in.readLine()) == null) {
                in.close();
				moreQuotes = false;
                dString = "No more sentences. Bye.";
            }                  
            buf = dString.getBytes();

		    /* 从接收到的数据报中获取Client端的地址和端口，
		      构造响应数据报并发送。*/
		    InetAddress address = packet.getAddress();
            int port = packet.getPort();
            packet = new DatagramPacket(buf, buf.length, address, port);
            socket.send(packet);
         }
        socket.close(); //所有句子发送完毕，关闭Socket。
    }

   public static void main(String[] args){
   		MyUdpServer server = new MyUdpServer();
   		try{
   	   		server.serverWork();
    	}catch(IOException e){}
   }
}