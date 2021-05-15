class Empolyee {
	private String name ;
	private int salary;
	
	public Empolyee(String name,int salary){
		this.name = name;
		this.salary = salary;
	}
	
	public String getDetails( ){
		return "Name: "+name+"\nSalary: "+salary;
		}
	}


class Manager extends Empolyee {
	private String department ;
	
	public Manager(String name,int salary,String department){
		super(name,salary);
		this.department = department;
	}
	public String getDetails( ){
		return super.getDetails( )+"\nDepartment: "+ department;
		}
	}

public class TestSuper{
	public static void main(String[] srgs){
		Manager m = new Manager("TOM",2000,"Finance");
		System.out.println(m.getDetails());
	}
}