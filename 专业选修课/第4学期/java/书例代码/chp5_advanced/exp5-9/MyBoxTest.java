class MyBox<T> {
    private T t;          
    public void add(T t) {
        this.t = t;
    }
    public T get() {
        return t;
    }
}

public class MyBoxTest{
	public static void main(String args[]){
		MyBox<Integer> aBox;
		aBox = new MyBox<Integer>(); 
		aBox.add(new Integer(1000));
		Integer i = aBox.get(); 
		System.out.println("The Integer is : "+i);
	}
	
}
