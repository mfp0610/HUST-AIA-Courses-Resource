package employee;

import java.io.*;
import java.util.*;

class Employee implements Serializable
{
  int id;
  String name;
  int age;
  int salary;
  String hireDay;
  String department;
  
  public Employee(){}
  
  public Employee(int id, String name, int age, int salary, 
  					String hireDay, String department) {
    this.id = id;
    this.name = name;
    this.age = age;
    this.salary = salary;
    this.hireDay = hireDay;
    this.department = department;
  }

   private void writeObject(ObjectOutputStream out) throws IOException {
   	Date savedDate = new Date();
   	
    out.writeInt(id);
    out.writeInt(age);
    out.writeUTF(name);
    out.writeInt(salary);
    out.writeUTF(hireDay);
    out.writeUTF(department);
  
    out.writeInt(savedDate.getYear());
  }

  private void readObject(ObjectInputStream in) throws IOException {
    Date readDate= new Date();
    int savedYear;
    
    id = in.readInt();
    age = in.readInt();
    name = in.readUTF();
    salary = in.readInt();
    hireDay = in.readUTF();
    department = in.readUTF();
 
    savedYear = in.readInt();
    age = age + (readDate.getYear()-savedYear);
  }
   
    
   public String toString(){
     	return "id: " +id +"\n name:  " + name + " \n age: " 
      				+age + "\n salary:  " + salary + "\n hireDay: " 
      				+ hireDay + "\n department: " + department ;
   }   
  
}



public class ObjectSerial {
    public static void main(String args[]) throws IOException,
        ClassNotFoundException {

      Employee employ = new Employee(123456, "Tom", 23, 6000, "03/10/10", "intel");
 
      ObjectOutputStream fout1 = new ObjectOutputStream( 
      								new FileOutputStream("data1.ser"));
      fout1.writeObject(employ) ; //使用Employee定制的writeObject方法
      fout1.close() ;

      employ = null;
  

      ObjectInputStream fin1 =new ObjectInputStream( 
           							new FileInputStream("data1.ser"));
      employ = (Employee) fin1.readObject() ;//使用Employee定制的readObject方法
      fin1.close();
        
      System.out.println(employ.toString());
    }

  }
