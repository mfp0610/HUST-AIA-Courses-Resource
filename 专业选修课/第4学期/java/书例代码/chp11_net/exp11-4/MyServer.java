import java.io.*;
import java.net.*;

public class MyServer{
	public static void main (String args[]){
		try{
			//建立Server Socket并等待连接请求。
			ServerSocket server = new ServerSocket(1680);
			Socket socket=server.accept();

			//连接建立，通过Socket获取连接上的输入/输出流。
			BufferedReader in = new BufferedReader(
									new InputStreamReader(socket.getInputStream()));
			PrintWriter out = new PrintWriter(socket.getOutputStream());
			
			//创建标准输入流，从键盘接收数据。
			BufferedReader sin=new BufferedReader(
									new  InputStreamReader(System.in));

			//先读取Client发送的数据，然后从标准输入读取数据发送给Client。当接收到bye时关闭连接。
			String s;
			while(!(s=in.readLine()).equals("bye")){
				System.out.println("# Received from Client:  "+s);
				out.println(sin.readLine());
				out.flush();
			}
		    System.out.println("The connection is closing... ... ");
		    
		    //关闭连接。
			in.close();
			out.close();
			socket.close();
			server.close();

		}catch(Exception e){
			System.out.println("Error:"+e);
		}
	}
}
