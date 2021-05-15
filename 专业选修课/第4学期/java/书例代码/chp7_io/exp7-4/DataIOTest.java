import java.io.*;

public class DataIOTest {
    public static void main(String[] args) throws IOException {

        // 创建数据输出流，前端套接文件流并以invoice1.txt为输出目的地。
        DataOutputStream out = new DataOutputStream(new
				   FileOutputStream("invoice1.txt"));

        //定义要保存的数据数组。
        double[] prices = { 19.99, 9.99, 15.99, 3.99, 4.99 };
        int[] units = { 12, 8, 13, 29, 50 };
        String[] descs = { "Java T-shirt", "Java Mug", 
        					"Duke Juggling Dolls",
			                  "Java Pin", "Java Key Chain" };
	
	    //将prices,unites以及descs中的数据以Tab键为分割符保存在文件中。
		for (int i = 0; i < prices.length; i ++) {
            out.writeDouble(prices[i]);
            out.writeChar('\t');
            out.writeInt(units[i]);
            out.writeChar('\t');
            out.writeUTF(descs[i]);
            out.writeChar('\t');
        }
        out.close();

        // 创建数据输入流，将上面保存的文件再次打开并读取。
        DataInputStream in = new DataInputStream(new
				 FileInputStream("invoice1.txt"));

        double price;
        int unit;
        String desc;
        double total = 0.0;

        for (int i = 0; i < prices.length; i ++) {
                price = in.readDouble();
                in.readChar();       // 扔掉tab键
                unit = in.readInt();
                in.readChar();       // 扔掉tab键
                desc = in.readUTF();
                in.readChar();   // 扔掉tab键
                
                System.out.println("You've ordered " +
				    unit + " units of " +
				    desc + " at $" + price);
                total = total + unit * price;
        }
        
        System.out.println("For a TOTAL of: $" + total);
        in.close();
    }
}

