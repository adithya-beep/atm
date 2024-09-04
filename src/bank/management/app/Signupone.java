
package bank.management.app;


import static java.awt.Color.WHITE;
import javax.swing.*;
import java.util.*;
import java.awt.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;



 class Signupone extends JFrame implements ActionListener {
long random;
JTextField namet,namef,mail,addr,cit,sta,pcode;
JButton next;
JRadioButton marr,nmarr,oth,male,female;
JDateChooser datechooser;
    
    
    Signupone()
    {
        setLayout(null); 
        Random ran=new Random();
        random=Math.abs((ran.nextLong()%900L)+1000L);
        //form heading
        JLabel formno=new JLabel("APPLICATION FORM NO. "+random);
        formno.setFont(new Font("Raleway",Font.BOLD,38));
        formno.setBounds(140,20,600,40);
        add(formno);
        //sub heading
        JLabel persondetails=new JLabel("Page 1: Personal Details");
        persondetails.setFont(new Font("Raleway",Font.BOLD,22));
        persondetails.setBounds(290,80,400,30);
        add(persondetails);
        //name
        JLabel name=new JLabel("NAME:");
        name.setFont(new Font("Raleway",Font.BOLD,20));
        name.setBounds(100,140,100,30);
        add(name);
        
        namet=new JTextField();
        namet.setFont(new Font("Raleway",Font.BOLD,14));
        namet.setBounds(300,140,400,30);
        add(namet);
        //father name
        JLabel fname=new JLabel("FATHER'S NAME:");
        fname.setFont(new Font("Raleway",Font.BOLD,20));
        fname.setBounds(100,190,200,30);
        add(fname);
        
        namef=new JTextField();
        namef.setFont(new Font("Raleway",Font.BOLD,14));
        namef.setBounds(300,190,400,30);
        add(namef);
        
        
        //dob
        JLabel dob=new JLabel("Date Of Birth:");
        dob.setFont(new Font("Raleway",Font.BOLD,20));
        dob.setBounds(100,240,200,30);
        add(dob);
        datechooser=new JDateChooser();
        datechooser.setBounds(300,240,400,30);
        add(datechooser);
        datechooser.setForeground(new Color(105,105,105));
             
        
        
        
        //gender
        JLabel Gender=new JLabel("Gender:");
        Gender.setFont(new Font("Raleway",Font.BOLD,20));
        Gender.setBounds(100,290,200,30);
        add(Gender);
        
        male=new JRadioButton("Male");
        male.setBounds(300,290,60,30);
        add(male);
        male.setBackground(Color.WHITE);
        female=new JRadioButton("Female");
         female.setBounds(450,290,120,30);
        add(female);
        female.setBackground(Color.WHITE);
        // makes sure only one value is selected
        ButtonGroup gendergroup=new ButtonGroup();
        gendergroup.add(male);
        gendergroup.add(female);
        
        
        //email
        JLabel email=new JLabel("Email Address:");
        email.setFont(new Font("Raleway",Font.BOLD,20));
        email.setBounds(100,340,200,30);
        add(email);
        
        mail=new JTextField();
        mail.setFont(new Font("Raleway",Font.BOLD,14));
        mail.setBounds(300,340,400,30);
        add(mail);
            
      
        //martial stat
        JLabel mar=new JLabel("Maritial Status:");
        mar.setFont(new Font("Raleway",Font.BOLD,20));
        mar.setBounds(100,390,200,30);
        add(mar);
        
        
        marr=new JRadioButton("Married");
        marr.setBounds(300,390,100,30);
        marr.setBackground(Color.WHITE);
        add(marr);
        
        
        nmarr=new JRadioButton("Unmarried");
         nmarr.setBounds(450,390,100,30);
        
        nmarr.setBackground(Color.WHITE);
        add(nmarr);
        
        oth=new JRadioButton("Other");
        oth.setBounds(630,390,100,30);
       
        oth.setBackground(Color.WHITE);
         add(oth);
        
         ButtonGroup marsta=new ButtonGroup();
        marsta.add(marr);
        marsta.add(nmarr);
        marsta.add(oth);
        
        
         
        //address
        JLabel address=new JLabel("Address:");
        address.setFont(new Font("Raleway",Font.BOLD,20));
        address.setBounds(100,440,200,30);
        add(address);
        
        addr=new JTextField();
        addr.setFont(new Font("Raleway",Font.BOLD,14));
        addr.setBounds(300,440,400,30);
        add(addr);
        //city
        JLabel city=new JLabel("City:");
        city.setFont(new Font("Raleway",Font.BOLD,20));
        city.setBounds(100,490,200,30);
        add(city);
        
        cit=new JTextField();
        cit.setFont(new Font("Raleway",Font.BOLD,14));
        cit.setBounds(300,490,400,30);
        add(cit);
        //state
        JLabel state=new JLabel("State:");
        state.setFont(new Font("Raleway",Font.BOLD,20));
        state.setBounds(100,540,200,30);
        add(state);
        
        sta=new JTextField();
        sta.setFont(new Font("Raleway",Font.BOLD,14));
        sta.setBounds(300,540,400,30);
        add(sta);
      //pin code
        JLabel pincode=new JLabel("Pin Code:");
        pincode.setFont(new Font("Raleway",Font.BOLD,20));
        pincode.setBounds(100,590,200,30);
        add(pincode);
        
        pcode=new JTextField();
        pcode.setFont(new Font("Raleway",Font.BOLD,14));
        pcode.setBounds(300,590,400,30);
        add(pcode);
        //
        
        
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
      String formno=""+random;  //long so to convert to string +""
      String name=namet.getText();
      String fname=namef.getText();
      String dob=((JTextField)datechooser.getDateEditor().getUiComponent()).getText();
      String gender=null;
      if(male.isSelected())
      {
          gender="Male";
      }
      else if(female.isSelected())
      {
          gender="Female";
      }
      String email=mail.getText();
      String marital=null;
      if(marr.isSelected())
      {
          marital="Married";
      }
      else if(nmarr.isSelected())
      {
          marital="Unmarried";
      }
      else if(oth.isSelected())
      {
          marital="Other";
      }
      String address=addr.getText();
      String city=cit.getText();
      String state=sta.getText();
      String pin=pcode.getText();
      
      try{
          
          if(name.equals("")){
              JOptionPane.showMessageDialog(null,"Name is required");
          }
          else if(fname.equals("")){
              JOptionPane.showMessageDialog(null,"Fathers Name is required");
          }
          else if(dob.equals("")){
              JOptionPane.showMessageDialog(null,"DOB is required");
          }
          else if(gender.equals("")){
              JOptionPane.showMessageDialog(null,"Select gender");
          }
          else if(fname.equals("")){
              JOptionPane.showMessageDialog(null,"Fathers Name is required");
          }
          else if(email.equals("")){
              JOptionPane.showMessageDialog(null,"email is required");
          }
          else if(marital.equals("")){
              JOptionPane.showMessageDialog(null,"Select marital status");
          }
          else if(address.equals("")){
              JOptionPane.showMessageDialog(null,"address is required");
          }
          else if(city.equals("")){
              JOptionPane.showMessageDialog(null,"city is required");
          }
          else if(state.equals("")){
              JOptionPane.showMessageDialog(null,"state is required");
          }
          else if(pin.equals("")){
              JOptionPane.showMessageDialog(null,"pin is required");
          }
         
          else{
              Conn c=new Conn();
              String query="insert into signup values('"+formno+"','"+name+"','"+fname+"','"+dob+"','"+gender+"','"+email+"','"+marital+"','"+address+"','"+city+"','"+pin+"','"+state+"')";
              c.s.executeUpdate(query);
              
              
              setVisible(false);
              new Signuptwo(formno).setVisible(true);
          }  
          
          }catch(Exception a){
          System.out.println("exx");
          System.out.println(a);
      }
      
    }
    public static void main(String args[]) {
        new Signupone();
    }
}
