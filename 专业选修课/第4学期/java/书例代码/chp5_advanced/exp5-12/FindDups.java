import java.util.*;

public class FindDups {
    public static void main(String args[]) {
        Set<String> s = new HashSet<String>();//创建一个HashSet对象，缺省的初始容量是16。
        
        for (int i=0; i<args.length; i++){
        	//将命令行中的每个字符串加入到集合s中，其中重复的字符串将不能加入，并被打印输出。
            if (!s.add(args[i]))
                System.out.println("Duplicate detected: "+args[i]); 
        }

        System.out.println(s.size()+" distinct words detected: "+s);//输出集合s的元素个数以及集合中的所有元素。
    }
}
