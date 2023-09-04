package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;



public class PinChange extends JFrame implements ActionListener{
    JButton deposit,back;
    JLabel npin,repin;
    String pin;
    JTextField t1,t2;
    JButton change,back1;
     PinChange(String pin)
     {
this.pin=pin;
             ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(800,800,   Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l1 = new JLabel(i3);
        l1.setBounds(0,0,800,800);
        add(l1);
        
        JLabel details = new JLabel("Change Your Pin");
        details.setFont(new Font("Raleway",Font.BOLD,16));
        details.setForeground(Color.WHITE);
        details.setBounds(220,270,400,30);
       l1.add(details);
        
      npin = new JLabel("Enter New Pin");
       npin.setFont(new Font("Raleway",Font.BOLD,16));
        npin.setForeground(Color.WHITE);
        npin.setBounds(150,310,400,25);
       l1.add(npin);
       
       t1 = new JTextField();
      t1.setBounds(150,340,230,20);
      l1.add(t1);
      
       repin= new JLabel("Retype New Pin");
        repin.setFont(new Font("Raleway",Font.BOLD,16));
        repin.setForeground(Color.WHITE);
        repin.setBounds(150,370,400,25);
       l1.add(repin);
       
       t2 = new JTextField();
      t2.setBounds(150,400,230,20);
      l1.add(t2);
       
       
       
      change = new JButton ("Change");
      change.setBounds(350,430,100,20);
      change.addActionListener(this);
              l1.add(change);
              
              back1 = new JButton ("Back");
      back1.setBounds(350,460,100,20);
      back1.addActionListener(this);
      
              l1.add(back1);
              
              
       setLocation(300,0);
      setUndecorated(true);
        setVisible(true);
        setSize(800,800);
        getContentPane().setBackground(Color.white);
        
     }
     public void actionPerformed(ActionEvent ae)
     
     {
         
         if(ae.getSource()==change)
         { String npin = t1.getText();
             
         String repin = t2.getText();
             try
             {
                
         if(!npin.equals(repin))
         {
             JOptionPane.showMessageDialog(null,"Entered pin does not match");
         return;
         }
         if(npin.equals(""))
         {
            JOptionPane.showMessageDialog(null,"Please enter new pin");
         return; 
         }
          if(repin.equals(""))
         {
            JOptionPane.showMessageDialog(null,"Please re-enter new pin");
         return; 
         }
         Cos c = new Cos();
         String query1 = "Update login set pinnumber = '"+repin+"' where pinnumber='"+pin+"'";
                String query2 = "Update bank set pinnumber = '"+repin+"' where pinnumber='"+pin+"'";
                       String query3= "Update signup6 set pin = '"+repin+"' where pin='"+pin+"'";
                       c.s.executeUpdate(query1);
                       c.s.executeUpdate(query2);
                       c.s.executeUpdate(query3);
                       JOptionPane.showMessageDialog(null,"Pin Changed Successfully");
                       setVisible(false);
                       new Transaction(repin).setVisible(true);
         
         }
         
         catch(Exception e)
                 {
                 System.out.println(e);
                 }
         }
         if(ae.getSource() == back1)
         {
             setVisible(false);
             new Transaction(pin).setVisible(true);
         }
     }
    public static void main(String args[]) {
       new PinChange("");
    }
}
