import java.sql.*;

public class PreparedTest {
	
    public static void main(String args[]) {
        String url = "jdbc:mysql://localhost/test";
        Connection con;
        Statement stmt;
		String name;
		int sale;
		
      try {
           Class.forName("com.mysql.jdbc.Driver");
        } catch(java.lang.ClassNotFoundException e) {
            System.err.print("ClassNotFoundException: ");
            System.err.println(e.getMessage());
        }

        try {	      
            con = DriverManager.getConnection(url, "root", "java");
			stmt = con.createStatement();
			showValues(stmt,"The original values:");
			
			PreparedStatement updateSales;
			String updateString = "update COFFEES " +
		     			 "set SALES = ? where COF_NAME= ? ";
			updateSales = con.prepareStatement(updateString);
			int [] salesForWeek = {150, 140, 50, 145, 85};
			String [] coffees = {"Colombian", "French_Roast", "Espresso",
		     						"Colombian_Decaf", "French_Roast_Decaf"};
			int len = coffees.length;
			for(int i = 0; i < len; i++) {
				updateSales.setInt(1, salesForWeek[i]);
				updateSales.setString(2, coffees[i]);
				updateSales.executeUpdate();

			}
			
			System.out.println();
			showValues(stmt,"The new values :");
		} catch(SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
        } 
	}
			
	public static void showValues(Statement stmt,String s) throws SQLException{

		String name;
		int sale;		
		ResultSet rs = stmt.executeQuery("SELECT COF_NAME,SALES "+
											"FROM COFFEES ");
        System.out.println(s);
        while(rs.next()){
        	name = rs.getString(1);
        	sale = rs.getInt(2);
        	System.out.println( "COFF_NAME = "+name+" ; 	"+ "SALE = "+sale);
        }	
    }
}