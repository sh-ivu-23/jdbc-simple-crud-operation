package jdbc_preparedStatement_crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ProductUpdateController {
	
	public static void main(String[] args) {
		Connection connection=null;
		try {
		// step1 load
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		// step2 create connection
		String url = "jdbc:mysql://localhost:3306/jdbc_preparedstatement";
		String user = "root";
		String pass = "root";
		
		connection=DriverManager.getConnection(url,user,pass);
		
		//step3 create statement
		String updateColorQuery="update product set productcolor=? where productid=?";
		
		PreparedStatement preparedStatement=connection.prepareStatement(updateColorQuery);
		preparedStatement.setString(1, "white");
		preparedStatement.setInt(2, 100);
		
		// step 4 execute query
		int a=preparedStatement.executeUpdate();
		if(a==1) {
			System.out.println("date is updated sucessfully");
		}
		else {
			System.out.println("given data is not present");
		}
		
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				connection.close();
			}catch(SQLException e){
				//TODO auto-generated catch block
				e.printStackTrace();
				
			}
		}
	}

}
