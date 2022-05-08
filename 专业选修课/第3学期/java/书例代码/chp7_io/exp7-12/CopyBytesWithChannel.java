import java.io.*;
import java.nio.*;
import java.nio.channels.*;

public class CopyBytesWithChannel {
	private static final int BSIZE = 1024;  //定义缓冲区大小
    public static void main(String[] args) throws IOException {   	
         
        FileInputStream inStream = new FileInputStream("farrago.txt");
        FileOutputStream outStream = new FileOutputStream("outagain.txt");
        
        FileChannel inChannel = inStream.getChannel(); //获取该文件输入流的通道
        FileChannel outChannel = outStream.getChannel(); //获取该文件输出流的通道
        
        ByteBuffer buffer = ByteBuffer.allocate(BSIZE);  //创建缓冲区   
        
        while ((inChannel.read(buffer))!= -1){
           buffer.flip();               // 使缓冲区准备好写操作         
           outChannel.write(buffer);
           buffer.clear();  // 使缓冲区准备好读操作
        }
  
        inStream.close();
        outStream.close();
    }
}
