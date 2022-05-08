import java.util.*;
import java.io.*;

public class UnSerializeDate{
	
	Date d = null ;
	
    UnSerializeDate(){

		try {
	  		FileInputStream f = new FileInputStream("date.ser");
	  		ObjectInputStream s = new ObjectInputStream(f);
	  		d = (Date) s.readObject();
	  		f.close();
			}catch(Exception e){
				e.printStackTrace() ;
			}
	}
	
public  static void main(String args[]){
	UnSerializeDate a =new UnSerializeDate();
	System.out.println("The date read is :"+a.d.toString());
	}
}
