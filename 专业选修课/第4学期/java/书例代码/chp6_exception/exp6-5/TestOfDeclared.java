import java.io.*;
import java.util.Vector;
class ListOfNumbersDeclared {
    private Vector<Integer> victor;
    private static final int size = 10;

    public ListOfNumbersDeclared () {
        victor = new Vector<Integer>(size);
        for (int i = 0; i < size; i++)
            victor.addElement(new Integer(i));
    }
    
    //ÉùÃ÷Å×³öÒì³£
    public void writeList() throws IOException, ArrayIndexOutOfBoundsException {
        PrintWriter out = new PrintWriter(new FileWriter("OutFile.txt"));
        
        for (int i = 0; i < size; i++)
            out.println("Value at: " + i + " = " + victor.elementAt(i));

        out.close();
    }
}

public class TestOfDeclared {
    public static void main(String[] args) {
	 try{
		ListOfNumbersDeclared list = new ListOfNumbersDeclared();
		list.writeList();
		}catch(Exception e){};
	System.out.println("A list of numbers is created and stored in OutFile.txt");
    }
}