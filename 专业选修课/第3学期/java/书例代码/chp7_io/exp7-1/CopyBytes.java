import java.io.*;

public class CopyBytes {
    public static void main(String[] args) throws IOException {
 
        //创建两个File类对象。
        File inputFile = new File("farrago.txt");
        File outputFile = new File("outagainb.txt");

        //创建文件输入/输出字节流。
        FileInputStream in = new FileInputStream(inputFile);
        FileOutputStream out = new FileOutputStream(outputFile);
        
        int c;
        //读写文件流中的数据。
        while ((c = in.read()) != -1)
           out.write(c);

        //关闭流。
        in.close();
        out.close();
    }
}
