package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;



public class Withdrawl extends JFrame implements ActionListener{
    JButton withdraw,back;
    String pin;
    JTextField t1;
      Withdrawl(String pin)
     {
this.pin=pin;
             ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(800,800,   Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l1 = new JLabel(i3);
        l1.setBounds(0,0,800,800);
        add(l1);
        
        JLabel details = new JLabel("Enter the amount to be withdrawn");
        details.setFont(new Font("Raleway",Font.BOLD,16));
        details.setForeground(Color.WHITE);
        details.setBounds(160,270,400,30);
       l1.add(details);
        t1 = new JTextField();
      t1.setBounds(160,300,270,30);
      l1.add(t1);
       
       
        withdraw = new JButton("Withdraw");
       
       withdraw.setBounds(330,400,100,30);
       withdraw.addActionListener(this);
       l1.add( withdraw);
       
       back = new JButton("Back");
       
       back.setBounds(330,450,100,30);
       
       
       back.addActionListener(this);
       l1.add(back);
        
       
       setLocation(300,0);
      setUndecorated(true);
        setVisible(true);
        setSize(800,800);
        getContentPane().setBackground(Color.white);
        
     }
     public void actionPerformed(ActionEvent ae)
     {
         if(ae.getSource()==back)
         {
             setVisible(false);
             new Transaction(pin).setVisible(true);
         }
         if(ae.getSource()==withdraw)
         {
             String details = t1.getText();
             Date date = new Date();
             
            
             
                  if(details.equals(""))
                 {
                     JOptionPane.showMessageDialog(null,"Please enter the amount");
                 }
                  else
                  {
                    
                  
                 try{
                   Cos c = new Cos();
               String query1 = "select * from bank where pinnumber = '"+pin+"'";
           int balance=0;
           
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
               if(balance<Integer.parseInt(details))
               {
                   JOptionPane.showMessageDialog(null,"Insufficient balance");
                   setVisible(false);
                   new Transaction (pin).setVisible(true);
                   return;
               }
           
           
                     
                 
                 String query = "insert into bank values('"+pin+"','withdraw','"+date+"','"+details+"')";
                 c.s.executeUpdate(query);
                 setVisible(false);
                 JOptionPane.showMessageDialog(null,"amount withdrawn");
                  
             new Transaction(pin).setVisible(true);
             }
                 }
             
             catch(Exception e)
                     {
                         System.out.println(e);
                     }
            
         }
         
         }
     }

    public static void main(String args[]) {
       new Withdrawl("");
    }
}
