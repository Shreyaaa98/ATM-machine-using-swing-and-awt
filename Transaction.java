
package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;



public class Transaction extends JFrame implements ActionListener{
    JButton exit,deposit,withdraw,pinchange,balance,fast,mini;
    String pin;
     Transaction(String pin)
     {
this.pin=pin;
             ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(800,800,   Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l1 = new JLabel(i3);
        l1.setBounds(0,0,800,800);
        add(l1);
        
        JLabel details = new JLabel("Please select your transaction");
        details.setFont(new Font("Raleway",Font.BOLD,16));
        details.setForeground(Color.WHITE);
        details.setBounds(180,250,400,30);
       l1.add(details);
       
       
       deposit = new JButton("Deposit");
       
       deposit.setBounds(150,300,120,30);
       l1.add(deposit);
       deposit.addActionListener(this);
       
       withdraw = new JButton("Cash Withdrawl");
       
       withdraw.setBounds(280,300,150,30);
       withdraw.addActionListener(this);
       l1.add(withdraw);
       
     fast = new JButton("Fast Cash");
       
       fast.setBounds(150,340,120,30);
       fast.addActionListener(this);
       l1.add(fast);
       
        mini = new JButton("Mini Statement");
       
       mini.setBounds(280,340,150,30);
       mini.addActionListener(this);
       l1.add(mini);
        pinchange = new JButton("Pin Change");
       
       pinchange.setBounds(150,380,120,30);
       l1.add(pinchange);
       pinchange.addActionListener(this);
       
       balance= new JButton("Balance Enquiry");
       
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
         if(ae.getSource()==withdraw)
         {
             setVisible(false);
          new Withdrawl(pin).setVisible(true);
         }
         if(ae.getSource()==mini)
         {
            new MiniStatement(pin).setVisible(true); 
         }
         if(ae.getSource()==pinchange)
         {
             setVisible(false);
          new PinChange(pin).setVisible(true);
         }
         if(ae.getSource()==balance)
         {
             setVisible(false);
          new BalanceEnquiry(pin).setVisible(true);
         }
         if(ae.getSource()==fast)
         {
             setVisible(false);
          new FastCash(pin).setVisible(true);
             
         }
         else  if(ae.getSource()==deposit)
         {
          setVisible(false);
          new Deposit(pin).setVisible(true);
         }
     }

    
    public static void main(String args[]) {
        new Transaction("");
    }
}
