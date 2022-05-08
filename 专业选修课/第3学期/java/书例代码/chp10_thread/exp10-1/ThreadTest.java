public class ThreadTest{
    public static void main(String args[ ]){
	
	Thread t1 = new Thread( new Hello( ) );
	Thread t2 = new Thread( new Hello( ) );
	
	t1.start( );
	t2.start( );
	}
}

class Hello implements Runnable{
    int i ;
    public void run( ){
	while( true){
		System.out.println("Hello"+i++);
		if (i==5)  break ;
		}
    	}
  }
