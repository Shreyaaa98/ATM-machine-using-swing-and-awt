package bank.management.system;
import java.sql.*;
public class Cos {

   
    Connection c;
    Statement s;
    public Cos()
    {
        try{
        c = DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem","root","system");
        s = c.createStatement();
    }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
}
