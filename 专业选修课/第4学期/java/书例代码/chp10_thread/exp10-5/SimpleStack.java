public class SimpleStack{
	
	public static void main(String args[]){ 
	
		MyStack s = new MyStack();
		A a = new A(s);
		B b = new B(s);
		a.start();
		b.start();
	}

} 	




class MyStack{
     private int idx = 0 ;
     private char[ ] data = new char[6] ;

    public void push( char c ){
  		data[idx] = c ;
		idx ++ ;
	}

    public char pop( ){
		idx-- ;
 		return data[idx] ;
	}
	
	public int getIdx(){
		return idx;
	}
	
}

class A extends Thread{
	MyStack s;
	char c;
	
	public A(MyStack s){
		this.s=s;
    }
    
	public void run(){
		for (int i=0; i<100; i++){
			if (s.getIdx() < 5){
		   		c=(char)(Math.random()*26+'A');
		   		s.push(c);
		   		System.out.println("A:push "+c);
	    		} 
	     }
 	}
 	
}

class B extends Thread{
	MyStack s;
	char c;
	
	public B(MyStack s){
		this.s=s;
    }
    
	public void run(){
		
		for (int i=0; i<100; i++){
			if (s.getIdx() > 0){
				c=s.pop();
				System.out.println("B:pop "+c);
		    } 
	     }
     }
     
}
	