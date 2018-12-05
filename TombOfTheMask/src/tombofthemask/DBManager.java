package tombofthemask;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DBManager {
    
    public static Connection getConnection() throws Exception
    {
        try
        {
            String driver = "com.mysql.jdbc.Driver";
            String url = "jdbc:mysql://localhost:3306/results?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegyDatetimeCode=false&serverTimezone=CET";
            String username = "root";
            String password = "";
            
            Class.forName(driver);
            
            Connection con = DriverManager.getConnection(url, username, password);
            
            return con;
        }
        catch (Exception e)
        {System.out.print(e);}
        
        
        return null;
        
    }
    
    public static void insert(String map, String score, String death, String date) throws Exception
    {        
        try
        {
            Connection con = getConnection();
            
            PreparedStatement inserted = con.prepareStatement("insert into results (name,score,death,date) VALUES('" + map + "','" + score + "','" + death + "','" + date +"')");
            inserted.executeUpdate();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        finally 
        {
            System.out.println("Inserted!");
        }
        
    }
}
