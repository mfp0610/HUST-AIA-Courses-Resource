import java.io.*;
import java.net.*;

public class MultiUdpServer{

    DatagramSocket socket = null;
    BufferedReader in = null;
    boolean moreQuotes = true;
   
    public void serverWork() throws IOException{    
     
       	socket = new DatagramSocket(4445);  //创建数据报Socket。
        in = new BufferedReader(new FileReader("sentences.txt")); 
  
        while (moreQuotes) {
            byte[] buf = new byte[256];  
 			DatagramPacket packet ;
   
            /* 从sentences.txt中读取一行，作为数据报中的数据。*/
            String dString = null;                        
            if ((dString = in.readLine()) == null) {
                in.close();
				moreQuotes = false;
                dString = "No more sentences. Bye.";
            }                  
            buf = dString.getBytes();

		    /* 构造发往多播组的数据报并发送*/
		    InetAddress group = InetAddress.getByName("228.5.6.7");
            packet = new DatagramPacket(buf, buf.length, group, 4446);
            socket.send(packet);
                        
            try{
			    Thread.sleep(5000);    //间隔5秒钟。
            }catch(InterruptedException e){}
            
         }
        socket.close(); //所有句子发送完毕，关闭Socket。
    }

   public static void main(String[] args){
   		MultiUdpServer server = new MultiUdpServer();
   		try{
   	   		server.serverWork();
    	}catch(IOException e){}
   }
}