class MyException extends Exception {
	
	MyException( ) {}
	
    MyException(String msg){
    	super(msg); 
	}
}

class UsingMyException {
	void f() throws MyException {
		System.out.println("Throws MyException from f()");
		throw new MyException();
	}
	void g() throws MyException {
		System.out.println("Throws MyException from g()");
		throw new MyException("Originated in g()");
	}
}

public class TestMyException{
	public static void main ( String args[] ) {
	    UsingMyException m = new  UsingMyException();
	    	
		try {
			m.f();
		} catch ( MyException e ) {
            e.printStackTrace();
        }
        
        try {
			m.g();
		} catch ( MyException e ) {
            e.printStackTrace();
        }
        
		}
	}

