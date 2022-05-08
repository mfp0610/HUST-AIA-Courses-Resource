import java.sql.*;
     
public class TransactionTest {

	public static void main(String args[]) {
		  
		String url = "jdbc:mysql://localhost/test";
		Connection con = null;
		Statement stmt;
		PreparedStatement updateSales;
		PreparedStatement updateTotal;
		
		String updateString = "update COFFEES " +
						"set SALES = ? where COF_NAME = ?";
	
		String updateStatement = "update COFFEES " +
				"set TOTAL = TOTAL + ? where COF_NAME = ?";
		String query = "select COF_NAME, SALES, TOTAL from COFFEES";
	
		try {
			Class.forName("com.mysql.jdbc.Driver");

		} catch(java.lang.ClassNotFoundException e) {
			System.err.print("ClassNotFoundException: "); 
			System.err.println(e.getMessage());
		}

		try {
	
			con = DriverManager.getConnection(url, "root", "java");
			
			//创建两个预编译语句。
			updateSales = con.prepareStatement(updateString);
			updateTotal = con.prepareStatement(updateStatement);
			int [] salesForWeek = {175, 150, 60, 155, 90};
			String [] coffees = {"Colombian", "French_Roast", 
								"Espresso", "Colombian_Decaf",
								"French_Roast_Decaf"};
			int len = coffees.length;
			
			//关闭事务自动更新模式。
			con.setAutoCommit(false);
			
			
			 //循环的每次执行都作为一个单独的事务。 
			for (int i = 0; i < len; i++) {
				updateSales.setInt(1, salesForWeek[i]);
				updateSales.setString(2, coffees[i]);
				updateSales.executeUpdate();
	
				updateTotal.setInt(1, salesForWeek[i]);
				updateTotal.setString(2, coffees[i]);
				updateTotal.executeUpdate();
				con.commit(); 
			}
	
			//恢复事务自动更新模式。
			con.setAutoCommit(true);
	
			updateSales.close();
			updateTotal.close();
	
			stmt = con.createStatement();							
			ResultSet rs = stmt.executeQuery(query);
				
			while (rs.next()) {
				String c = rs.getString("COF_NAME");
				int s = rs.getInt("SALES");
				int t = rs.getInt("TOTAL");
				System.out.println(c + "     " +  s + "    " + t);
			}
	
			stmt.close();
			con.close();
	
		} catch(SQLException ex) {
			System.err.println("SQLException: " + ex.getMessage());
			if (con != null) {
				try {
					System.err.println("Transaction is being rolled back");
					con.rollback();   //如果事务执行中有异常抛出，则撤消事务。
				} catch(SQLException excep) {
					System.err.println("SQLException: "+excep.getMessage());
				}
			}
		}	
	}
}