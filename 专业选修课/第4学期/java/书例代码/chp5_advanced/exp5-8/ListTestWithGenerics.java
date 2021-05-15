import java.util.*; 

public class ListTestWithGenerics {

    public static void main(String[] args) {

        List<Integer> listofInteger = new LinkedList<Integer>();
        listofInteger.add(new Integer(2000));
//        listofInteger.add("8");   // Illegal.
		listofInteger.add(new Integer(8));            
//      listofInteger.add(8);
        
        Integer x = listofInteger.get(0);   
        System.out.println(x);
        x = listofInteger.get(1);  
      System.out.println(x);
    }
}
