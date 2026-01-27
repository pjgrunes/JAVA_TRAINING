package M5.act.db.act3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class App 
{
	private static final String URL = "jdbc:postgresql://localhost:5432/training_db";
    private static final String USER = "pjgrunes";
    private static final String PASSWORD = "postgres";
   
    


    public static Connection get() throws Exception {
    	
    	Connection connection = null;
    

        try {
        	//connection
        connection=DriverManager.getConnection(URL,USER,PASSWORD);
        System.out.print("Connected to Postgre...");
        return connection;
        	
  
        }catch(SQLException e) {
        	e.printStackTrace();
        }catch(Exception e) {
        	e.printStackTrace();
        }
        
		return connection;
		
    }
}
    

 
