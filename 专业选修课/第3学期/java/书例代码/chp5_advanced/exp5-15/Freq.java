import java.util.*;

public class Freq {
 
     public static void main(String args[]) {
        String[] words={"if","it","is", "to", "be", "it", "is", "up", 
        					"to", "me", "to", "delegate"};
        Integer freq ;
        Map<String, Integer> m = new TreeMap<String, Integer>();

        // 构造字符串数组words的单词频率表.以单词为key,以词频为value。
        for (String a : words) {
        	freq = m.get(a); //获取指定单词的词频。
        	
 			//词频递增
            if (freq==null){
            	freq = new Integer(1);
            }else{
            	freq = new Integer(freq.intValue() + 1);
            }
            m.put(a, freq); //在Map中更改词频。
        }

        System.out.println(m.size() + " distinct words detected:");
        System.out.println(m);
    }
}
