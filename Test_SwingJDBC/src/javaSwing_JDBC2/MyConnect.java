package javaSwing_JDBC2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyConnect
{
	String servername;//ten server cua SQL da cai dat
	String port;
	String db_user;
	String db_pass;
	String db_name;
	
	
	public MyConnect()
	{
		servername="127.0.0.1";//cong ket noi voi SQL server
		port="1433";
		db_user="sa";//user connect vao SQL
		db_pass="123456";//pass connect vao SQL
		db_name="SwingJDBC(2)_BT2";//ten database trong SQL server
	}
	
	
	public MyConnect(String servername,String port,String db_name,String db_user,String db_pass)
	{
		this.servername = servername;
		this.port = port;
		this.db_user = db_user;
		this.db_pass = db_pass;
		this.db_name = db_name;
	}
	
	
	
	public Connection getcn()//day la ham thuc hien viec ket noi JDBC (Java-SQL Server) va tra ve 1 gia tri null hay != null
	{
		Connection cn=null;//Doi tuong connection bieu dien ngu canh giao tiep voi database
		try {
			
			//Database url
			String db_url="jdbc:sqlserver://"+servername+":"+port+"; databasename = " + db_name;
			//<=> "jdbc:sqlserver://127.0.0.1:1433;databasename = School;
			
			//Load JDBC
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			
			//Ket noi voi SQL
			cn = DriverManager.getConnection(db_url,db_user,db_pass);
			//cn tra ve true or false: true tuc la ket noi thanh cong va nguoc lai
		}
		catch (ClassNotFoundException | SQLException ex)
		{
			System.out.println(ex.getMessage());
		}
		return cn;
	}
}
