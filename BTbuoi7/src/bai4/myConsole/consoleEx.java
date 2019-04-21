package bai4.myConsole;

import java.io.Console;

public class consoleEx {

	   public static void main(String[] args) {
	        
	        //Obtaining a reference to the console. 
	        Console con = System.console(); 
	        // Checking If there is no console available, then exit. 
	        if(con == null)  
	        {
	            System.out.print("No console available"); 
	            return; 
	        } 
	         String myuser = "duykhanh";
	         String mypassword = "121212";
	         String user;
	         char[] password;
	         String temppass;
	         do {
	 	        // Read a user and then display it.
	   	        user = con.readLine("Enter User: ");
	   	        //to read password and then display it
	   	        password =con.readPassword("Enter Password: ");
	   	        //converting char array into string
	   	        temppass = String.valueOf(password);
	   	        if(user.equals(myuser) && temppass.equals(mypassword)) {
	   	        	System.out.println("Connect successful");
	   	        	System.out.println("this is your password: "+ temppass);
	   	        	
	   	        	password =con.readPassword("Enter new Password: ");
	   	        	String constain1 = String.valueOf(password);
	   	        	password =con.readPassword("Comfirm new Password: ");
	   	        	String constain2 = String.valueOf(password);
		   	        
		   	        if(constain1.equals(constain2)) {
		   	        	mypassword = constain1;
		   	        }
		   	        
	   	        } else {
	   	        	System.out.println("Connect be error");
	   	        }
	         }while(!user.equals(myuser) || !temppass.equals(mypassword));

	}
}

