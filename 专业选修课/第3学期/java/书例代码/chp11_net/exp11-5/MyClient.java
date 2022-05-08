import java.io.*;
import java.net.*;

public class MyClient{
	public static void main (String args[]){
		try{
			Socket socket = new Socket("127.0.0.1",1680);  //发出连接请求。
			
			//连接建立，通过Socket获取连接上的输入/输出流。
			PrintWriter out = new PrintWriter(socket.getOutputStream());
			BufferedReader in = new BufferedReader(
									new InputStreamReader (socket.getInputStream()));
			
			//创建标准输入流，从键盘接收数据。
			BufferedReader sin = new BufferedReader(
									new InputStreamReader (System.in));
			
			//从标准输入中读取一行，发送Server端，当用户输入bye时结束连接。
			String s;
			do{
				s=sin.readLine();
				out.println(s);
				out.flush();
				if (!s.equals("bye")){
					System.out.println("@ Server response:  "+in.readLine());
				}
				else{
					System.out.println("The connection is closing... ... "); 
				}
				
			}while(!s.equals("bye"));

			//关闭连接。
			out.close();
			in.close();
			socket.close();

		}catch (Exception e) {
			System.out.println("Error"+e);
		}	
	}
}

