 package bank.management.system;
import javax.swing.*;
 import java.awt.*;
 import java.awt.event.*; 
import java.sql.*; 
public class Login extends JFrame implements ActionListener {
    JButton b1,b2,b3;
    JTextField t1;
    JPasswordField t2;
    Login()
    {
        setLayout(null);
        getContentPane().setBackground(Color.white);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image i2 = i1.getImage(). getScaledInstance(100,100,Image.SCALE_DEFAULT);
        ImageIcon i3 =new ImageIcon(i2);
        JLabel l1= new JLabel(i3);
        l1.setBounds(70,10,100,100);
        add(l1);
        
        JLabel text=new JLabel("WELCOME TO ATM");
        text.setFont(new Font("Osward",Font.BOLD,36));
        text.setBounds(200,20,400,100);
        add(text);
        
        JLabel cardno=new JLabel("CARD NO:");
        cardno.setFont(new Font("Osward",Font.BOLD,26));
        cardno.setBounds(70,150,200,100);
        add(cardno);
        
         t1 =new JTextField();
        t1.setBounds(230,190,200,30);
        
        add(t1);
        
        
        JLabel pin =new JLabel("PIN:");
        pin.setFont(new Font("Osward",Font.BOLD,26));
        pin.setBounds(70,250,200,100);
        add(pin);
        
        
       
        
         t2 =new JPasswordField();
        t2.setBounds(230,290,200,30);
        
        add(t2);
        
        
        
        
        
         b1 = new JButton("SIGN IN");
        b1.setBounds(100,380,100,30);
        
     b1.addActionListener(this);
     add(b1);
     
         b2 = new JButton("CLEAR");
        b2.setBounds(230,380,100,30);
        
        b2.addActionListener(this);
        add(b2);
        
         b3 = new JButton("SIGN UP");
        b3.setBounds(100,430,230,30);
       
        
        b3.addActionListener(this);
        add(b3);
        
        
        setTitle("ATM MACHINE");
        
        
        
        
        
        
        setSize(600,600);
        setVisible(true);
        setLocation(500,150);
    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()== b1)
        {
            Cos c = new Cos();
            String card = t1.getText();
            String pin   = t2.getText();
            String query= "select * from login where cardnumber = '"+card+"' and pinnumber ='"+pin+"'";
            try
            {
                
            
           ResultSet rs = c.s.executeQuery(query);
          if(rs.next())
           {
               setVisible(false);
               new Transaction(pin).setVisible(true);
           }
          else{
              
          
           JOptionPane.showMessageDialog(null,"Incorrect card no and pin no");
           
        }
            }
        
        catch(Exception e)
        {
                System.out.println(e);
                }
        }
        else if (ae.getSource()== b2)
        {
            t1.setText("");
            t2.setText("");
        }
         else if (ae.getSource()== b3)
         {
             setVisible(false);
             new Signupone().setVisible(true);
        
    }
    }

  
   public static void main(String args[]) {
       Login l1 =  new Login();
    }
}
