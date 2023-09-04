
package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;
import com.toedter.calendar.JDateChooser;

public class Signupone extends JFrame implements ActionListener {
    JButton next;
    JTextField t1,t2,t3,t5,t6,t7,t8;
    JLabel  formno,name,father,details,dob,gender,email,address,city,state,pincode,marital;
    long random;
    JRadioButton male,female,married,unmarried,other;
    ButtonGroup gendergroup,maritalgroup;
    JDateChooser choose;
    Signupone()
    {
        setLayout(null);
        getContentPane().setBackground(Color.white);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image i2=i1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel l1 = new JLabel(i3);
        l1.setBounds(60,60,100,100);
        add(l1);
        
        Random ran = new Random();
         random = Math.abs(((ran.nextLong()) % 9000L)%1000L);
         formno = new JLabel("APPLICATION FORM NO:"+random);
        formno.setFont(new Font("Times New Roman",Font.BOLD,34));
        formno.setBounds(180,7,500,200);
        add(formno);
        
         details = new JLabel("Personal Details");
        details.setFont(new Font("Times New Roman",Font.BOLD,34));
        details.setBounds(250,120,300,100);
        add(details);
        
        name = new JLabel("NAME:");
        name.setFont(new Font("Times New Roman",Font.BOLD,20));
        name.setBounds(60,200,100,100);
        add(name);
        
        father = new JLabel("FATHER'S NAME:");
        father.setFont(new Font("Times New Roman",Font.BOLD,20));
        father.setBounds(60,250,200,100);
        add(father);
        
      dob = new JLabel("DATE OF BIRTH:");
        dob.setFont(new Font("Times New Roman",Font.BOLD,20));
        dob.setBounds(60,300,200,100);
        add(dob);
         choose = new JDateChooser();
        choose.setBounds(380,330,300,30);
        add(choose);
        
         gender = new JLabel("GENDER:");
        gender.setFont(new Font("Times New Roman",Font.BOLD,20));
        gender.setBounds(60,350,200,100);
        add(gender);
        
       male = new JRadioButton("Male");
        
        male.setBounds(380,380,100,30);
        male.setBackground(Color.WHITE);
        add(male);
        
        female = new JRadioButton("Female");
       female.setBounds(500,380,100,30);
       female.setBackground(Color.WHITE);
        add(female);
        
       gendergroup = new ButtonGroup();
        gendergroup.add(male);
        gendergroup.add(female);
        
        
        email = new JLabel("EMAIL ADDRESS:");
        email.setFont(new Font("Times New Roman",Font.BOLD,20));
        email.setBounds(60,400,200,100);
        add(email);
        
         t3 = new JTextField();
        t3.setBounds(380,430,300,30);
        add(t3);
        
        marital = new JLabel("MARITAL STATUS:");
        marital.setFont(new Font("Times New Roman",Font.BOLD,20));
        marital.setBounds(60,450,300,100);
        add(marital);
        
          married = new JRadioButton("Married");
        
        married.setBounds(380,480,100,30);
        married.setBackground(Color.WHITE);
        add(married);
        
         unmarried= new JRadioButton("Unmarried");
       unmarried.setBounds(500,480,100,30);
       unmarried.setBackground(Color.WHITE);
        add(unmarried);
        
        other= new JRadioButton("Other");
       other.setBounds(630,480,100,30);
       other.setBackground(Color.WHITE);
        add(other);
        
       maritalgroup = new ButtonGroup();
        maritalgroup.add(married);
        maritalgroup.add(unmarried);
        maritalgroup.add(other);
        
        address = new JLabel("ADDRESS:");
        address.setFont(new Font("Times New Roman",Font.BOLD,20));
        address.setBounds(60,500,200,100);
        add(address);
        
        t5 = new JTextField();
        t5.setBounds(380,530,300,30);
        add(t5);
        
       city = new JLabel("CITY:");
        city.setFont(new Font("Times New Roman",Font.BOLD,20));
        city.setBounds(60,550,200,100);
        add(city);
        
         t6 = new JTextField();
        t6.setBounds(380,580,300,30);
        add(t6);
        
       pincode = new JLabel("PIN CODE:");
        pincode.setFont(new Font("Times New Roman",Font.BOLD,20));
        pincode.setBounds(60,600,200,100);
        add(pincode);
        
          t7 = new JTextField();
        t7.setBounds(380,630,300,30);
        add(t7);
        
         state = new JLabel("STATE:");
        state.setFont(new Font("Times New Roman",Font.BOLD,20));
        state.setBounds(60,650,200,100);
        add(state);
        
        t8 = new JTextField();
        t8.setBounds(380,680,300,30);
        add(t8);
        
       
                
        
         t1 = new JTextField();
        t1.setBounds(380,230,300,30);
        add(t1);
        
     t2 = new JTextField();
        t2.setBounds(380,275,300,30);
        add(t2);
        
        
         next = new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raelway",Font.BOLD,20));
        next.setBounds(570,730,100,50);
        next.addActionListener(this);
        add(next);
        
    setSize(800,1000);
    setVisible(true);
    setLocation(300,0);
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        String formno ="" + random;
        String name = t1.getText();
        String father = t2.getText();
        String dob = ((JTextField)choose.getDateEditor().getUiComponent()).getText();
        String gender = null;
        if(male.isSelected())
        {
            gender = "Male";
        }
        else if(female.isSelected())
        {
            gender = "Female";
        }
        String email = t3.getText();
        String marital = null;
        if(married.isSelected())
        {
            marital="Married";
            
        }
        else if(unmarried.isSelected())
        {
            marital="Unmarried";
            
        }
        if(other.isSelected())
        {
            marital="Other";
            
        }
        String address = t5.getText();
       String city  = t6.getText();
        String pincode = t7.getText();
        String state = t8.getText();
        try{
        if(name.equals(""))
        {
            JOptionPane.showMessageDialog(null,"Name is required");
        }
         if(email.equals(""))
        {
            JOptionPane.showMessageDialog(null,"email address is required");
        }
         else
         {
             Cos c = new Cos();
             String query = "insert into signup values('"+formno+"', '"+name+"', '"+father+"', '"+dob+"','"+gender+"','"+email+"','"+marital+"','"+address+"','"+city+"','"+pincode+"','"+state+"' )";
             c.s.executeUpdate(query);
             setVisible(false);
             new Signuptwo(formno).setVisible(true);
         }
    }
        
        catch(Exception e)
                {
                   System.out.println(e);
                }
    }

    
    public static void main(String args[]) {
          new Signupone();
    }
}
