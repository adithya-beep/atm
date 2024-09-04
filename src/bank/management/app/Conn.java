//sql connection
package bank.management.app;
import java.sql.*;
 public class Conn {
    //register driver
    //create connection
    //create statement
    //execute query
    // close connection
    //msql external entity )runtime error so try catch
    Connection c;
    Statement s;
     public Conn()
     {
         try{
             
             c=DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem","root","icecreams"); 
             s=c.createStatement();
         }catch(Exception e)
         {
             System.out.println(e);
         }
     }

   
}
