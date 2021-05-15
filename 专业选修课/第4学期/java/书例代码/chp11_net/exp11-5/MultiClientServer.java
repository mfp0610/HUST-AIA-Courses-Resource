import java.io.*;
import java.net.*;

public class MultiClientServer implements Runnable{
	
	static int SerialNum = 0; //每个Client的序列号。
	Socket socket;
	
	public MultiClientServer(Socket ss){
		socket = ss;
	}
	
	public static void main (String args[]){
		
		int MaxClientNum = 5;  
		try{
			//建立Server Socket。
			ServerSocket server = new ServerSocket(1680);
			
			for( int i = 0; i<MaxClientNum;i++){
				Socket socket=server.accept();

			//连接建立,创建一个Server端线程与Client端通信。
				Thread t = new Thread(new MultiClientServer(socket));
				t.start();
			}
		server.close();  //关闭Server Socket。
		
		}catch(Exception e){
			System.out.println("Error:"+e);
		}
	    	    
	}
	
  //Server端通信线程的线程体。	
  public void run(){
  	    int myNum = ++SerialNum;

  		try{
  			//通过Socket获取连接上的输入/输出流。
  			BufferedReader in = new BufferedReader(
									new InputStreamReader(socket.getInputStream()));
			PrintWriter out = new PrintWriter(socket.getOutputStream());
			
			//创建标准输入流，从键盘接收数据。
			BufferedReader sin=new BufferedReader(
									new  InputStreamReader(System.in));

			/* 先读取Client发送的数据，然后从标准输入读取数据发送给Client。
			当接收到bye时关闭连接。*/
			String s;
			while(!(s=in.readLine()).equals("bye")){
				System.out.println("# Received from Client No."+myNum+": "+s);
				out.println(sin.readLine());
				out.flush();
			}
		    System.out.println("The connection to Client No."+
		    						myNum+" is closing... ... ");
		    
		    //关闭连接。
			in.close();
			out.close();
			socket.close();
			
		}catch(Exception e){
			System.out.println("Error:"+e);
		}	
	
}
}
