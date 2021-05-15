public class ThreadTest2 {
    public static void main(String args[ ]){
	
	Hello t1 = new Hello( );
	Hello t2 = new Hello( );
	
	t1.start( );
	t2.start( );
	}
}

class Hello extends Thread{
    int i ;
    public void run( ){
	while( true){
		System.out.println("Hello"+i++);
		if (i==5)  break ;
		}
    	}
  }
