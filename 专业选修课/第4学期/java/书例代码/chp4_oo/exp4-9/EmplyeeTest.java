class Employee{
	private String name;
	private int salary;
	public Employee(String n, int s){
		name = n ;
		salary = s;
	}
	public Employee( String n){ 
		this(n,0); 
	}
	public Employee( ){ 
		this("Unknown"); 
	}
	public String getName(){
		return name;
	}
	public int getSalary(){
		return salary;
	} 
 }

public class EmplyeeTest{
	
	public static void main(String [] args){
		Employee e = new Employee();
		System.out.println("Name: "+e.getName()+"   Salary: "+e.getSalary());
	}
}
		