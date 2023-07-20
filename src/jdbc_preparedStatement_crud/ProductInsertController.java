package jdbc_preparedStatement_crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ProductInsertController {

	public static void main(String[] args) {
		Connection connection=null;
		
		
		try {
			// step1 load/register driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			 // step2 create connection
			String url = "jdbc:mysql://localhost:3306/jdbc_preparedstatement";
			String user = "root";
			String pass = "root";
			
			connection = DriverManager.getConnection(url,user,pass);
			String insertQuery = "insert into product values(?,?,?,?)";
			
			// step3 create statement
			PreparedStatement preparedStatement=connection.prepareStatement(insertQuery);
			
			preparedStatement.setInt(1, 100);
			preparedStatement.setString(2, "pen");
			preparedStatement.setDouble(3, 45);
			preparedStatement.setString(4, "black");
			
			preparedStatement.setInt(1, 200);
			preparedStatement.setString(2, "pencil");
			preparedStatement.setDouble(3, 35);
			preparedStatement.setString(4, "grey");
			
			
			//execute query
			preparedStatement.execute();
			System.out.println("data has inserted successfully");
				
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
