import java.io.*;
import java.util.*;

class ListOfNumbers {
    private ArrayList<Integer> list;
    private static final int size = 10;

    public ListOfNumbers () {
        list = new ArrayList<Integer>(size);
        for (int i = 0; i < size; i++)
            list.add(new Integer(i));
    }  
    //将list保存到OutFile.txt文件中。
    public void writeList() {
        PrintWriter out = new PrintWriter(new FileWriter("OutFile.txt"));
        
        for (int i = 0; i < size; i++)
            out.println("Value at: " + i + " = " + list.get(i));

        out.close();
    }
}

public class TestListOfNumbers1 {
    public static void main(String[] args) {
		ListOfNumbers list = new ListOfNumbers();
		list.writeList();
    }
}
