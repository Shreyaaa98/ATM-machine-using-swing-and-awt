
package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Signuptwo extends JFrame implements ActionListener {
    JLabel label,religion,income,education,qualification,occupation,pan,aadhar,senior,exist,category;
    JComboBox cb1,cb2,cb3,cb4;
    JTextField t1,t2,t3;
    JRadioButton yes1,no1,yes2,no2;
    JButton next;
    String formno;
    
     Signuptwo(String formno)
    {
        this.formno=formno;
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
      label = new JLabel("Page 2: ADDITIONAL DETAILS");
      label.setBounds(200,15,400,50);
      label.setFont(new Font("Raleway",Font.BOLD,26));
      add(label);
      
       religion = new JLabel("Religion:");
      religion.setBounds(70,100,200,30);
      religion.setFont(new Font("Raleway", Font.BOLD,24));
      add(religion);
      
      String valReligion[] = {"Hindu","Muslim", "Sikh","Others"};
      cb1 = new JComboBox(valReligion);
      cb1.setBounds(270,100,350,25);
      add(cb1);
      
       category = new JLabel("Category:");
      category.setBounds(70,150,200,30);
      category.setFont(new Font("Raleway", Font.BOLD,24));
      add(category);
      
      String valcategory[] = {"General","OBC", "SC","ST"};
      cb2 = new JComboBox(valcategory);
      cb2.setBounds(270,150,350,25);
      add(cb2);
      
      income= new JLabel("Income:");
      income.setBounds(70,200,200,30);
      income.setFont(new Font("Raleway", Font.BOLD,24));
      add(income);
      
      t1 = new JTextField();
              t1.setBounds(270,210,350,25);
              add(t1);
      
       education = new JLabel("Educational");
      education.setBounds(70,250,200,30);
      education.setFont(new Font("Raleway", Font.BOLD,24));
      add(education);
      
      qualification = new JLabel("Qualification:");
      qualification.setBounds(70,280,200,30);
      qualification.setFont(new Font("Raleway", Font.BOLD,24));
      add(qualification);
      
      String valeducation[] = { "Intermediate","Graduation","PostGraduation"};
     cb3 = new JComboBox(valeducation);
      cb3.setBounds(270,265,350,25);
      add(cb3);
      
       occupation = new JLabel("Occupation:");
      occupation.setBounds(70,340,200,30);
      occupation.setFont(new Font("Raleway", Font.BOLD,24));
      add(occupation);
      
      String valoccupation[] = { "Salaried","Non-salaried"};
      cb4 = new JComboBox(valoccupation);
      cb4.setBounds(270,340,350,25);
      add(cb4);
      
      pan= new JLabel("PAN No:");
      pan.setBounds(70,400,200,30);
      pan.setFont(new Font("Raleway", Font.BOLD,24));
      add(pan);
      
       t2 = new JTextField();
              t2.setBounds(270,410,350,25);
              add(t2);
      
      aadhar= new JLabel("Aadhar No:");
      aadhar.setBounds(70,460,200,30);
      aadhar.setFont(new Font("Raleway", Font.BOLD,24));
      add(aadhar);
       t3= new JTextField();
              t3.setBounds(270,470,350,25);
              add(t3);
      
       senior= new JLabel("Senior Citizen:");
      senior.setBounds(70,520,200,30);
      senior.setFont(new Font("Raleway", Font.BOLD,24));
      add(senior);
      
       yes1 = new JRadioButton("Yes");
      yes1.setBounds(270,520,100,30);
      yes1.setBackground(Color.WHITE);
      add(yes1);
      
      no1 = new JRadioButton("No");
      no1.setBounds(390,520,200,30);
      no1.setBackground(Color.WHITE);
      add(no1);
      
      ButtonGroup seniorgroup = new ButtonGroup();
      seniorgroup.add(yes1);
      seniorgroup.add(no1);
      
      
      
      
      
     exist= new JLabel("Existing Account:");
      exist.setBounds(70,580,270,30);
      exist.setFont(new Font("Raleway", Font.BOLD,20));
      add(exist);
      
      ButtonGroup existgroup = new ButtonGroup();
      existgroup.add(yes2);
      existgroup.add(no2);
      
       yes2 = new JRadioButton("Yes");
      yes2.setBounds(270,580,100,30);
      yes2.setBackground(Color.WHITE);
      add(yes2);
      
      no2 = new JRadioButton("No");
      no2.setBounds(390,580,200,30);
      no2.setBackground(Color.WHITE);
      add(no2);
      
      next = new JButton("Next");
      next.setBounds(650,630,110,50);
      next.setFont(new Font("Raleway",Font.BOLD,22));
      next.setBackground(Color.BLACK);
      next.setForeground(Color.WHITE);
      next.addActionListener(this);
      add(next);
      
      
     
      
      
      
      
    
      
      
      
      
              
              
              
       setVisible(true);
       setSize(800,800);
       setLocation(200,5);       
      
    }
     public void actionPerformed(ActionEvent ae)
     {
         String income = t1.getText();
         String pan = t2.getText();
         String aadhar =  t3.getText();
         String senior = null;
         if(yes1.isSelected())
         {
             senior="Yes";
             
         }
         else if(no1.isSelected())
         {
             senior = "No";
         }
         String exist = null;
         if(yes2.isSelected())
         {
             exist="Yes";
             
         }
         else if(no2.isSelected())
         {
             exist = "No";
         }
         String religion = (String)cb1.getSelectedItem();
         String category = (String)cb2.getSelectedItem();
         String education = (String)cb3.getSelectedItem();
         String occupation= (String)cb4.getSelectedItem();
         try{
             Cos c = new Cos();
             String query = "insert into signuptwo values('"+formno+"','"+religion+"', '"+category+"', '"+income+"', '"+education+"','"+occupation+"','"+pan+"','"+aadhar+"','"+senior+"','"+exist+"')";
             c.s.executeUpdate(query);
             setVisible(false);
             new Signup3(formno).setVisible(true);
         }
         catch(Exception e)
                {
                   System.out.println(e);
                }
         
         
     }

    
    public static void main(String args[]) {
       new Signuptwo("");
    }
}
