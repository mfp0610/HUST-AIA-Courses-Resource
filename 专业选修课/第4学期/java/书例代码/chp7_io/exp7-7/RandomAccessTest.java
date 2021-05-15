import java.io.*;

public class RandomAccessTest{

    public static void main(String args[]) throws Exception{
	    long filePoint = 0 ;
	    String s;

        RandomAccessFile file = new RandomAccessFile("RandomAccessTest.java","r");
        long fileLength = file.length();

	    while (filePoint<fileLength){
		    s = file.readLine();
		    System.out.println(s);
		    filePoint = file.getFilePointer();
	    }
	    file.close();
    }
}