package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyConnect {
	
	private String servername = "127.0.0.1";
	private String port = "1433";
	private String db_user = "sa";
	private String db_pass = "123456";
	private String db_name = "Z4_TEST";
	
	public MyConnect() {
		
	}
	
	
	public Connection getConnect() {
		Connection con = null;
		try {
			String db_url = "jdbc:sqlserver://"+this.servername+":"+this.port+";databasename="+this.db_name;
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			con = DriverManager.getConnection(db_url, db_user, db_pass);
		} catch(SQLException | ClassNotFoundException ex) {
			System.out.println(ex.toString());
		}
		return con;
	}
	
	
//	public static void main(String[] args) {
//		if(new MyConnect().getConnect() != null) {
//			System.out.println("Success");
//		} else {
//			System.out.println("fail");
//		}
//	}

}
