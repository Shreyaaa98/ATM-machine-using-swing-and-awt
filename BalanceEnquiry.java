package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;



public class BalanceEnquiry extends JFrame implements ActionListener{
    String pin;
    JButton back;
     BalanceEnquiry(String pin)
     {
this.pin=pin;
             ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(800,800,   Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l1 = new JLabel(i3);
        l1.setBounds(0,0,800,800);
        add(l1);
        
        
      
              back = new JButton ("Back");
      back.setBounds(350,460,100,20);
      back.addActionListener(this);
      
              l1.add(back);
               Cos c = new Cos();
               int balance = 0;
         try
         {
           
           String query1 = "select * from bank where pinnumber = '"+pin+"'";
           
           ResultSet rs = c.s.executeQuery(query1);
           
           while(rs.next())
           {
               if(rs.getString("type").equals("deposit"))
               {
                   balance +=  Integer.parseInt(rs.getString("amount"));
           }
               else
               {
                   balance -=  Integer.parseInt(rs.getString("amount"));
               }
           
           }
         }
         catch(Exception e)
         {
             System.out.println(e);
         }
         JLabel details = new JLabel("Your current account balance is:  "+balance);
         details.setBounds(160,250,300,30);
         details.setFont(new Font("System",Font.BOLD,15));
         details.setForeground(Color.WHITE);
         l1.add(details);
              
              
       setLocation(300,0);
      setUndecorated(true);
        setVisible(true);
        setSize(800,800);
        getContentPane().setBackground(Color.white);
        
     }
     public void actionPerformed(ActionEvent ae)
     
     {
         
        
             setVisible(false);
             new Transaction(pin).setVisible(true);
         
     }
    public static void main(String args[]) {
       new BalanceEnquiry("");
    }
}
