import java.io.*;

public class Copy {
    public static void main(String[] args) throws IOException {

        //创建文件字符输入/输出流。
        FileReader in = new FileReader("farrago.txt");
        FileWriter out = new FileWriter("outagainc.txt");
        
        int c;

		//读、写数据。
        while ((c = in.read()) != -1)
           out.write(c);

        //关闭流。
        in.close();
        out.close();
    }
}
