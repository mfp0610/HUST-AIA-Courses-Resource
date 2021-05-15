import java.util.*;

public class ListIteratorDemo {
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		
		//向list中添加元素。
		for(int i=1; i<5; i++){
			list.add(new Integer(i));
		}
		System.out.println("The original list : "+list);
		
		ListIterator<Integer> listIter = list.listIterator(); //创建list的iterator。
		listIter.add(new Integer(0));  //在序号为0的元素前添加一个元素。
		System.out.println("After add at beginning:"+list);

		if ( listIter.hasNext() ) {
			int i = listIter.nextIndex();  //i的值将为1。
			listIter.next();  //返回序号为1的元素。
			listIter.set(new Integer(9));  //修改list中的序号为1的元素。
			System.out.println("After set at "+i+":"+list);
		}
	
		if ( listIter.hasNext() ) {
			int i = listIter.nextIndex();  // i的值将为2。
			listIter.next();
			listIter.remove();  //删除序号为2的元素。
			System.out.println("After remove at "+i+" : "+list);	
		}		
	}
}
