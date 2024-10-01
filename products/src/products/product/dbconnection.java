package products;
import java.util.*;
import java.sql.Connection;
import java.sql.DriverManager;

public class dbconnection {

	public Connection dbconnection() {
		Connection con=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/coffee","subi","");
		}catch(Exception ex)
		{
			System.out.println(ex);
		}
		return con;
	}

}
