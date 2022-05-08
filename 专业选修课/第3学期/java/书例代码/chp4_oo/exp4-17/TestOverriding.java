class Employee {
	String name ;
	int salary;
	
	public Employee(String name,int salary){
		this.name = name;
		this.salary = salary;
	}
	
	public String getDetails( ){
		return "Name: "+name+"\nSalary: "+salary;
		}
	}


class Manager extends Employee {
	private String department ;
	
	public Manager(String name,int salary,String department){
		super(name,salary);
		this.department = department;
	}
	public String getDetails( ){
		return "Name: "+name+"\nSalary: "+salary+"\nDepartment: "+ department;
		}
	}
	
class Secretary extends Employee{
	
	public Secretary(String name,int salary){
		super(name,salary);
	}
}



public class TestOverriding{
	public static void main(String[] srgs){
		Manager m = new Manager("Tom",2000,"Finance");
		Secretary s = new Secretary("Mary",1500);
		System.out.println(m.getDetails());
		System.out.println(s.getDetails());
	}
}