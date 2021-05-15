import java.sql.*;

public class JdbcTest {
    public static void main(String args[]) {

        String url= "jdbc:mysql://localhost/test";
        Connection con;
        String sql;
        Statement stmt;
		String num,name,sex;
		int age,math,eng,spec;
		
        try {
   
   			Class.forName("com.mysql.jdbc.Driver");
        } catch(java.lang.ClassNotFoundException e) {
            System.err.print("ClassNotFoundException: ");
            System.err.println(e.getMessage());
        }

        try {	      
            con = DriverManager.getConnection(url, "root", "java");  //
            stmt = con.createStatement();
            
            //向student表中插入一行记录。
        	sql = "INSERT INTO STUDENT " +
                            "VALUES('200108','赵小龙','男',20,71,62,76)";
        	stmt.executeUpdate(sql);
            
        	//检索student表中的所有记录并获取数据输出。
        	sql = " SELECT * FROM STUDENT";
        	ResultSet rs = stmt.executeQuery(sql);
        	System.out.println("学号        姓名        性别   年龄"+	
        								"   高等数学  英语  专业课");
        	while(rs.next()){
        		num = rs.getString(1);
        		name = rs.getString(2);
        		sex = rs.getString(3);
        		age = rs.getInt(4);
        		math = rs.getInt(5);
        		eng = rs.getInt("英语");
        		spec = rs.getInt("专业课");
        		System.out.println(num+"    "+name+"	"+sex+"	"+age+"	"+math
        								+"	"+eng+"	"+spec);
        	}	
        
         	//检索高等数学成绩80分以上的学生信息。
         	rs = stmt.executeQuery("SELECT 学号,姓名,高等数学,英语,专业课 "+
        							"FROM STUDENT  "+
        							"WHERE 高等数学>=80" );
			System.out.println();			
        	System.out.println("The students whose math mark is beyond 80 are:");
        	while(rs.next()){
        		num = rs.getString(1);
        		name = rs.getString(2);
        		math = rs.getInt(3);
        		eng = rs.getInt("英语");
        		spec = rs.getInt("专业课");
        		System.out.println("学号="+num+"	"+"姓名="+name+"	"+"高等数学="+
        							math+"    "+"英语="+eng+"	"+"专业课="+spec);
        	}
        
        	//关闭连接。
        	stmt.close();
        	con.close();
     	} catch(SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
        }          
    }
}
