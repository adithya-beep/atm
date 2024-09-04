
package bank.management.app;


import static java.awt.Color.WHITE;
import javax.swing.*;

import java.awt.*;

import java.awt.event.*;



public class Signuptwo extends JFrame implements ActionListener {
 
long random;
JButton next;
JComboBox religion,category,income,education,occupation;
JRadioButton syes,sno,eyes,eno;  
JTextField pan,aadhar;   
String formno;
    Signuptwo(String formno)
    {
        this.formno=formno;
        setLayout(null); 
        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");
        //form heading
        
        
        //sub heading
        JLabel additionaldetails=new JLabel("Page 2: Additional Details");
        additionaldetails.setFont(new Font("Raleway",Font.BOLD,22));
        additionaldetails.setBounds(290,80,400,30);
        add(additionaldetails);
        
        JLabel l12 = new JLabel("Form No:"+this.formno);
        l12.setFont(new Font("Raleway", Font.BOLD, 13));
        l12.setBounds(700,10,150,30);
        add(l12);
        //name
        JLabel name=new JLabel("RELIGION:");
        name.setFont(new Font("Raleway",Font.BOLD,20));
        name.setBounds(100,140,110,30);
        add(name);
        
        String valreligion[]={"Hindu","sikh","Christian","Other"};
         religion = new JComboBox(valreligion);
        religion.setBounds(300,140,400,30);
        religion.setBackground(Color.WHITE);
        add(religion);
        
        
        //father name
        JLabel fname=new JLabel("CATEGORY:");
        fname.setFont(new Font("Raleway",Font.BOLD,20));
        fname.setBounds(100,190,200,30);
        add(fname);
        
        String valcategory[]={"General","OBC","SC","ST","others"};
         category=new JComboBox(valcategory);
        category.setBackground(Color.WHITE);
        category.setBounds(300,190,400,30);
        add(category);
        
        
        //dob
        JLabel dob=new JLabel("INCOME:");
        dob.setFont(new Font("Raleway",Font.BOLD,20));
        dob.setBounds(100,240,200,30);
        add(dob);
        
         String incomecategory[]={"Null","<1,50,000","<2,50,000","<5,00,000","Upto 10,00,000"};
        income=new JComboBox(incomecategory);
        income.setBackground(Color.WHITE);
        income.setBounds(300,240,400,30);
        add(income);
        
        
        
             
        
        
        
        //gender
        JLabel Gender=new JLabel("EDUCATIONAL:");
        Gender.setFont(new Font("Raleway",Font.BOLD,20));
        Gender.setBounds(100,290,200,30);
        add(Gender);
        
       
        
        
        
        //email
        JLabel email=new JLabel("QUALIFICATION:");
        email.setFont(new Font("Raleway",Font.BOLD,20));
        email.setBounds(100,315,200,30);
        add(email);
        
         String eduvalues[]={"Non-Graduate","Graduate","Post Graduate","Doctrate","Others"};
         education=new JComboBox(eduvalues);
        education.setBackground(Color.WHITE);
        education.setBounds(300,315,400,30);
        add(education);
        
        

      
        //martial stat
        JLabel mar=new JLabel("OCCUPATION:");
        mar.setFont(new Font("Raleway",Font.BOLD,20));
        mar.setBounds(100,390,200,30);
        add(mar);
        
        
        String occvalues[]={"Salaried","Self Employed","Business","Student","Retired","Others"};
         occupation=new JComboBox(occvalues);
        occupation.setBackground(Color.WHITE);
        occupation.setBounds(300,390,400,30);
        add(occupation);
        
        
        
        
        
        
         
        //address
        JLabel address=new JLabel("PAN NUMBER:");
        address.setFont(new Font("Raleway",Font.BOLD,20));
        address.setBounds(100,440,200,30);
        add(address);
        
        pan=new JTextField();
        pan.setFont(new Font("Raleway",Font.BOLD,14));
        pan.setBounds(300,440,400,30);
        add(pan);
        //city
        JLabel city=new JLabel("AADHAR NUMBER:");
        city.setFont(new Font("Raleway",Font.BOLD,20));
        city.setBounds(100,490,200,30);
        add(city);
        
        aadhar=new JTextField();
        aadhar.setFont(new Font("Raleway",Font.BOLD,14));
        aadhar.setBounds(300,490,400,30);
        add(aadhar);
        //state
        JLabel state=new JLabel("Senior Citizen:");
        state.setFont(new Font("Raleway",Font.BOLD,20));
        state.setBounds(100,540,200,30);
        add(state);
        
        
        syes=new JRadioButton("Yes");
        syes.setBounds(300,540,100,30);
        syes.setBackground(Color.WHITE);
        add(syes);
        
        
        sno=new JRadioButton("No");
         sno.setBounds(450,540,100,30);
        
        sno.setBackground(Color.WHITE);
        add(sno);
        
        
        
         ButtonGroup marsta=new ButtonGroup();
        marsta.add(syes);
        marsta.add(sno);
        
        
      //pin code
        JLabel pincode=new JLabel("Existing Account:");
        pincode.setFont(new Font("Raleway",Font.BOLD,20));
        pincode.setBounds(100,590,200,30);
        add(pincode);
        
        eyes=new JRadioButton("Yes");
        eyes.setBounds(300,590,100,30);
        eyes.setBackground(Color.WHITE);
        add(eyes);
        
        
        eno=new JRadioButton("No");
         eno.setBounds(450,590,100,30);
        
        eno.setBackground(Color.WHITE);
        add(eno);
        
        
        
         ButtonGroup emarsta=new ButtonGroup();
        emarsta.add(eyes);
        emarsta.add(eno);
        
        
        
        
        
        
         
        
        
        
        getContentPane().setBackground(WHITE);
          setSize(850,800);
          setLocation(350,10);
          setVisible(true);
          
          next=new JButton("Next");
          next.setBackground(Color.BLACK);
          next.setForeground(Color.WHITE);
          next.setFont(new Font("Raleway",Font.BOLD,14));
          next.setBounds(620,660,80,30);
          next.addActionListener(this);
          add(next); 
          
          
          
    }
    
@Override
    public void actionPerformed(ActionEvent e)
    {
      //String formno=""+random;  //long so to convert to string +""
      String sreligion=(String)religion.getSelectedItem();
      String scategory=(String)category.getSelectedItem();
      String sincome=(String)income.getSelectedItem();
      String seducation=(String)education.getSelectedItem();
      String soccupation=(String)occupation.getSelectedItem();
      String seniorcitizen=null;
      if(syes.isSelected())
      {
          seniorcitizen="Yes";
      }
      else if(sno.isSelected())
      {
          seniorcitizen="No";
      }
      
      String existingaccount=null;
      if(eyes.isSelected())
      {
          existingaccount="Yes";
      }
      else if(eno.isSelected())
      {
          existingaccount="No";
      }
      
      String span=pan.getText();
      String saadhar=aadhar.getText();
      
      
      try{
          
          if(span.length()<10)
           {
                            JOptionPane.showMessageDialog(null,"enter a valid pan card number(10 digits");
 
           }
          else if(saadhar.length()<12)
           {
                             JOptionPane.showMessageDialog(null,"enter a valid aadhar card number(12 digits");

           }
           
           else{
              Conn c=new Conn();
              String query="insert into signuptwo values('"+formno+"','"+sreligion+"','"+scategory+"','"+sincome+"','"+seducation+"','"+soccupation+"','"+span+"','"+saadhar+"','"+seniorcitizen+"','"+existingaccount+"')";
              c.s.executeUpdate(query);
              //Signupthree Object
              setVisible(false);
              new Signupthree(formno).setVisible(true);
           }
          }catch(Exception a){
          System.out.println("exx");
          System.out.println(a);
      }
      
    }
    public static void main(String args[]) {
        new Signuptwo("");
    }
}
