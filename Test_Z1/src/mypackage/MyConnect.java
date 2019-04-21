package mypackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyConnect {
	
	private String servername;
	private String port;
	private String db_user;
	private String db_pass;
	private String db_name;
	
	public MyConnect() {
		this.servername = "127.0.0.1";
		this.port = "1433";
		this.db_user = "sa";
		this.db_pass = "123456";
		this.db_name = "Z1_TEST";
	}

	public MyConnect(String servername, String port, String db_user, String db_pass, String db_name) {
		super();
		this.servername = servername;
		this.port = port;
		this.db_user = db_user;
		this.db_pass = db_pass;
		this.db_name = db_name;
	}
	
	
	public Connection getConnect() {
		Connection con = null;
		try {
			String db_url = "jdbc:sqlserver://" + servername + ":" + port + "; databasename = " + db_name;
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			con = DriverManager.getConnection(db_url,db_user,db_pass);
		}catch(ClassNotFoundException | SQLException ex ) {
			System.out.println(ex.getMessage());
		}
		return con;
	}
	
	

}
