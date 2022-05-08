public class Consumer extends Thread {
  	private SyncStack theStack;
	private int num;
	private static int counter = 1;
	
	
	public Consumer(SyncStack s){
		theStack = s ;
		num = counter++ ;
		}


public void run( ){
    char c ;
    for(int i=0; i<200; i++){
		c = theStack.pop( );
		System.out.println("Consumer"+num+":"+c);

		try{
	    	Thread.sleep(300) ;
			}catch(InterruptedException e){ }
		}
	}
}
