
package bank.management.system;
import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.util.Date;
import java.awt.event.*;

public class MiniStatement extends JFrame implements ActionListener{
    String pin;
    MiniStatement(String pin)
    {
      setLayout(null);
      JLabel bank = new JLabel("Indian Bank");
      bank.setBounds(150,70,200,30);
      bank.setFont(new Font("System",Font.BOLD,20));
      add(bank);
      JLabel mini = new JLabel();
      mini.setBounds(30,300,200,200);
      add(mini);
      JLabel card = new JLabel();
      card.setFont(new Font("System",Font.BOLD,20));
      card.setBounds(30,150,400,30);
      add(card);
      
      try{
        Cos c =new Cos();
        String query1 = "select * from login where pinnumber ='"+pin+"'";
        ResultSet rs = c.s.executeQuery(query1);
        while(rs.next())
        {
            card.setText("Card number:  "+rs.getString("cardnumber").substring(0,4)+"xxxxxxxx"+rs.getString("cardnumber").substring(12));
        }        
      }
      catch(Exception e)
      {
          System.out.println(e);
      }
      try{
          Cos c =new Cos();
           String query2 = "select * from bank where pinnumber ='"+pin+"'";
        ResultSet rs = c.s.executeQuery(query2);
        while(rs.next())
        {
            mini.setText(mini.getText()+"<html>"+rs.getString("date")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+rs.getString("type")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+rs.getString("amount")+"<br><br>"+"<html>");
        }
          
      }
      catch(Exception e)
      {
          System.out.println(e);
      }
      
      
      
      setVisible(true);
      getContentPane().setBackground(Color.WHITE);
      setSize(600,800);
      setLocation(60,30);
     
      
    }
    public void actionPerformed(ActionEvent ae)
    {
        
    }

    
    public static void main(String args[]) {
        new MiniStatement("");
    }
}
