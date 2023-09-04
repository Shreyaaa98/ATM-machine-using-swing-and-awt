
package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.sql.*;

public class Signup3 extends JFrame implements ActionListener{
    JButton submit,cancel;
    JLabel account,card,pin,services,cardno,pinno,details;
    JRadioButton savings,current,fixed,recurring;
    JCheckBox internet,mobile,atm,cheque,statement,debit,details1;
    String formno;
     public Signup3(String formno)
     {
         this.formno=formno;
         setLayout(null);
         getContentPane().setBackground(Color.WHITE);
         
        JLabel label = new JLabel("Page 3: Account Details");
      label.setBounds(200,15,400,50);
      label.setFont(new Font("Raleway",Font.BOLD,26));
      add(label);
      
       account = new JLabel("Account Type");
      account.setBounds(50,80,200,30);
      account.setFont(new Font("Raleway",Font.BOLD,24));
      add(account);
      
       savings = new JRadioButton("Saving account");
      savings.setBounds(50,120,200,30);
      savings.setBackground(Color.WHITE);
      add(savings);
      
       fixed = new JRadioButton("Fixed deposit account");
      fixed.setBounds(300,120,150,30);
      fixed.setBackground(Color.WHITE);
      add(fixed);
      
       current = new JRadioButton("Current account");
      current.setBounds(50,170,150,30);
      current.setBackground(Color.WHITE);
      add(current);
      
       recurring = new JRadioButton("Recurring deposit account");
      recurring.setBounds(300,170,180,30);
      recurring.setBackground(Color.WHITE);
      add(recurring);
      
      ButtonGroup accountgroup = new ButtonGroup();
      accountgroup.add(savings);
      accountgroup.add(fixed);
      accountgroup.add(current);
      accountgroup.add(recurring);
      
      card = new JLabel("Card Number");
      card.setFont(new Font("Raleway",Font.BOLD,24));
      card.setBounds(50,250,200,30);
      add(card);
      
      cardno = new JLabel("XXXX-XXXX-XXXX-4184");
      cardno.setFont(new Font("Raleway",Font.BOLD,24));
      cardno.setBounds(300,250,300,30);
      add(cardno);
      
      JLabel carddetails = new JLabel("(Your 14 digit Card number)");
      
      carddetails.setBounds(50,280,250,30);
      add(carddetails);
     
      
      pin = new JLabel("Pin Number");
      pin.setFont(new Font("Raleway",Font.BOLD,24));
      pin.setBounds(50,330,200,30);
      add(pin);
      
      pinno = new JLabel("XXXX");
      pinno.setFont(new Font("Raleway",Font.BOLD,24));
      pinno.setBounds(300,330,300,30);
      add(pinno);
      
      JLabel pindetails = new JLabel("(Your 4 digit pin number)");
      
      pindetails.setBounds(50,360,250,30);
      add(pindetails);
      
      
      services = new JLabel("Services Required:");
      services.setFont(new Font("Raleway",Font.BOLD,24));
      services.setBounds(50,430,300,30);
      add(services);
      
       internet = new JCheckBox("Internet Banking");
      internet.setBounds(50,470,200,30);
      internet.setBackground(Color.WHITE);
      add(internet);
      
      mobile = new JCheckBox("Mobile Banking");
      mobile.setBounds(300,470,200,30);
      mobile.setBackground(Color.WHITE);
      add(mobile);
      
      atm = new JCheckBox("ATM card");
     atm.setBounds(50,520,200,30);
      atm.setBackground(Color.WHITE);
      add(atm);
      
       debit = new JCheckBox("Debit Card");
      debit.setBounds(300,520,200,30);
      debit.setBackground(Color.WHITE);
      add(debit);
      
       cheque = new JCheckBox("Cheque book");
     cheque.setBounds(50,570,200,30);
      cheque.setBackground(Color.WHITE);
      add(cheque);
      
      
      statement = new JCheckBox("E-Statement");
      statement.setBounds(300,570,200,30);
      statement.setBackground(Color.WHITE);
      add(statement);
      
       details = new JLabel("I hereby declare that above enetered details are correct. ");
      details.setBounds(130,650,600,30);
      details.setBackground(Color.WHITE);
      add(details);
       details1 = new JCheckBox();
      details1.setBounds(100,650,20,30);
      details1.setBackground(Color.WHITE);
      add(details1);
      
       submit = new JButton("Submit");
      submit.setBounds(200,690,150,50);
      submit.setFont(new Font("Raleway",Font.BOLD,26));
      submit.setBackground(Color.BLACK);
      submit.setForeground(Color.WHITE);
      submit.addActionListener(this);
      add(submit);
      
        cancel = new JButton("Cancel");
      cancel.setBounds(400,690,150,50);
      cancel.setFont(new Font("Raleway",Font.BOLD,26));
     cancel.setBackground(Color.BLACK);
      cancel.setForeground(Color.WHITE);
      cancel.addActionListener(this);
      add(cancel);
      
      
     
      
      
      
      
      
      
       setVisible(true);
       setSize(800,800);
       setLocation(200,5); 
      
     }
     public void actionPerformed(ActionEvent ae)
     {
         if(ae.getSource()== submit)
         {
             
         
         String account = null;
         if(savings.isSelected())
         {
            account = "savings"; 
         }
         if(current.isSelected())
         {
            account = "current"; 
         }
         if(fixed.isSelected())
         {
            account = "fixed"; 
         }
         if(recurring.isSelected())
         {
            account = "recurring"; 
         }
         Random ran = new Random();
         String card =""+ Math.abs((ran.nextLong()%90000000L)+5467180000000000L);
         String pin = ""+Math.abs((ran.nextLong()%9000L)+1000L);
         
         String services= "";
         if(atm.isSelected())
         {
             services = services+"ATM Card";
         }
         else if(debit.isSelected())
         {
             services = services+"Debit Card";
         }
        else if(mobile.isSelected())
         {
             services = services+"Mobile banking";
         }
        else if(statement.isSelected())
         {
             services = services+"Internet Statement";
         }
        else if(internet.isSelected())
         {
             services = services+"Internet Banking";
         }
        else if(cheque.isSelected())
            {
             services = services+"Cheque book";
         }
        
         String details = "";
          if(details1.isSelected())
         {
             details=details+"User corfirm that above info is correct";
         }
          
         
         try
         {
             
                     
                 if(details.equals(""))
                 {
                     JOptionPane.showMessageDialog(null,"confirm that above details are correct" );
                     return;
                 }
             
         
             Cos c= new Cos();
         
             String query1 = "insert into signup6 value('"+formno+"','"+account+"','"+card+"','"+pin+"','"+services+"')";
             String query2 = "insert into login value('"+formno+"','"+card+"','"+pin+"')";
         c.s.executeUpdate(query1);
         c.s.executeUpdate(query2);
         JOptionPane.showMessageDialog(null, "Card number:"+card+"\n"+"Pin number:"+pin);
        
         }
         catch(Exception e)
                 {
                 System.out.println(e);
                 }
         }
         
         else if(ae.getSource()==cancel)
         {
             
            System.exit(0); 
         }
         
         
           
        
         
         
     }

    
    public static void main(String args[]) {
        new Signup3("");
    }
}
