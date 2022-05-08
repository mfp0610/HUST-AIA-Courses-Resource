public class ThreadTerminate {
    public static void main(String args[ ]) throws Exception{
	
		int i=0;
		Hello h = new Hello();
	
		Thread t = new Thread( h);
		t.setPriority(Thread.MAX_PRIORITY);
		t.start( );
	
		System.out.println("Please stop saying Hello and say good morning!");
		h.stopRunning();
		
		while( i<5){
		    
		   	System.out.println("Good Morning"+i++);
		   	
		}
	
  	}
}


class Hello implements Runnable{
   
    int i = 0;
    private boolean  timeToQuit = false;
    
    public void run( ){
		while(!timeToQuit){  
	 	
			System.out.println(" Hello"+i++);
			try{
			   if (i%2 == 0 )
			       Thread.sleep(10);

			 } catch(Exception e){ }
		
		}
    }
    
    public void stopRunning( ){
		timeToQuit = true ;
    }
}

