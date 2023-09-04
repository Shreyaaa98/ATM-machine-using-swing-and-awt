
package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;



public class FastCash extends JFrame implements ActionListener{
    JButton exit,deposit,withdraw,pinchange,balance,fast,mini;
    String pin;
     FastCash(String pin)
     {
this.pin=pin;
             ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(800,800,   Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l1 = new JLabel(i3);
        l1.setBounds(0,0,800,800);
        add(l1);
        
        JLabel details = new JLabel("Select Withdrawl amount");
        details.setFont(new Font("Raleway",Font.BOLD,16));
        details.setForeground(Color.WHITE);
        details.setBounds(180,250,400,30);
       l1.add(details);
       
       
       deposit = new JButton("Rs 100");
       
       deposit.setBounds(150,300,120,30);
       l1.add(deposit);
       deposit.addActionListener(this);
       
       withdraw = new JButton("Rs 500");
       
       withdraw.setBounds(280,300,150,30);
       withdraw.addActionListener(this);
       l1.add(withdraw);
       
     fast = new JButton("Rs 1000");
       
       fast.setBounds(150,340,120,30);
       fast.addActionListener(this);
       l1.add(fast);
       
        mini = new JButton("Rs 2000");
       
       mini.setBounds(280,340,150,30);
       mini.addActionListener(this);
       l1.add(mini);
        pinchange = new JButton("Rs 5000");
       
       pinchange.setBounds(150,380,120,30);
       pinchange.addActionListener(this);
       
       l1.add(pinchange);
       
       balance= new JButton("Rs 10000");
       
      balance.setBounds(280,380,150,30);
      balance.addActionListener(this);
       l1.add(balance);
        
       
        exit= new JButton("Exit");
       
      exit.setBounds(280,420,150,30);
      exit.addActionListener(this);
       l1.add(exit);
        
      setLocation(300,0);
      setUndecorated(true);
        setVisible(true);
        setSize(800,800);
        getContentPane().setBackground(Color.white);
        
        
    }
     public void actionPerformed(ActionEvent ae)
     {
         if(ae.getSource()==exit)
         {
            System.exit(0);
         }
        
             
       
         String amount = ((JButton)ae.getSource()).getText().substring(3);
      
         Cos c = new Cos();
         try
         {
           
           String query1 = "select * from bank where pinnumber = '"+pin+"'";
           int balance=0;
           Date date = new Date();
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
         
           if(ae.getSource() != exit && balance<Integer.parseInt(amount))
           {
               JOptionPane.showMessageDialog(null,"Insufficient balance");
               return;
           }
           String query2 = "insert into bank values('"+pin+"','withdraw','"+date+"','"+amount+"')";
           c.s.executeUpdate(query2);
           JOptionPane.showMessageDialog(null,"Rs"+amount+"Debited successfully");
           
           setVisible(false);
           new Transaction(pin).setVisible(true);
         }
         catch(Exception e)
         {
             System.out.println(e);
         }
         
     }



    
    public static void main(String args[]) {
        new FastCash("");
    }
}
