import java.util.*; 

public class ListTest {

    public static void main(String[] args) {

        // 注意：列表中只存放Integer 类型的对象！
        List listofInteger = new LinkedList();
        listofInteger.add(new Integer(2000));
        listofInteger.add("8");             
        
        Integer x = (Integer) listofInteger.get(0);   
        System.out.println(x);
        x = (Integer) listofInteger.get(1);   
        System.out.println(x);
    }
}
