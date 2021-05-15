import java.util.*;

public class Counter {
    public static void main(String[] args){
        int time = 5;
        Queue<Integer> queue = new LinkedList<Integer>();
        for (int i = time; i >= 0; i--)
            queue.add(i);
        while (!queue.isEmpty()) {
            System.out.println("    "+queue.remove());
            try{
            	Thread.sleep(1000);
            }catch(InterruptedException e){ }
        }
    }
}

