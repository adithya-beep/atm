

package bank.management.app;

import java.awt.*;
import static java.awt.Color.WHITE;


import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class userdel extends JFrame implements ActionListener{
    
    JTextField cardtext;
    JTextField pintext;
    Choice ch,cc;
    JButton signup,fetch;
    JLabel mini;
    String id;
    userdel(String id)
    {
        this.id=id;
        setTitle("AUTOMATED TELLER MACHINE");
        setLayout(null);
        JLabel cardno=new JLabel("USERS");
        cardno.setFont(new Font("Raleway",Font.BOLD,28));
        cardno.setBounds(200,40,110,40);
        getContentPane().setBackground(WHITE);
        add(cardno);
        JLabel l12 = new JLabel("Admin id:"+this.id);
        l12.setFont(new Font("Raleway", Font.BOLD, 13));
        l12.setBounds(600,10,150,30);
        add(l12);
        
        ch=new Choice();
        ch.setBounds(340,40,200,40);
        ch.setFont(new Font("Arial",Font.BOLD,14));
        add(ch);
        
        mini= new JLabel();
        
        
        try{
          String str1=ch.getSelectedItem();
          Conn conn=new Conn();
          
          ResultSet rs =conn.s.executeQuery("select * from signup ");
          
          while(rs.next())
          {
             
              ch.add(rs.getString(("formno")));
              
          }
          
          
          
      }catch(Exception e)
      {
          System.out.println(e); 
      }
        
        
        
        
        
        signup=new JButton("delete");
        signup.setBounds(300,80,230,30);
        signup.setBackground(Color.BLACK);
        signup.setForeground(Color.WHITE);
        add(signup);
        signup.addActionListener(this);
        
        fetch=new JButton("fetch");
        fetch.setBounds(300,130,230,30);
        fetch.setBackground(Color.BLACK);
        fetch.setForeground(Color.WHITE);
        add(fetch);
        fetch.addActionListener(this);
        
        
        
         
      mini.setBounds(20,140,400,200);
        
      
      add(mini);
     
        //getContentPane().setBackground(WHITE);
        setSize(850, 820);
        setLocation(350, 0);
        setVisible(true);
        
    }
    public void actionPerformed(ActionEvent ae)
    {
        
       
      if(ae.getSource()==signup){
      try{
          String str1=ch.getSelectedItem();
          Conn conn=new Conn();
          String query="delete from signupthree where formno='"+ch.getSelectedItem()+"'";
          String query1="delete from signup where formno='"+ch.getSelectedItem()+"'";
          String query12="delete from signuptwo where formno='"+ch.getSelectedItem()+"'";
          String query14="delete from login where formno='"+ch.getSelectedItem()+"'";
          conn.s.executeUpdate(query);
          conn.s.executeUpdate(query1);
          conn.s.executeUpdate(query12);
          conn.s.executeUpdate(query14);

          JOptionPane.showMessageDialog(null,"Deleted");
          ch.remove(str1);
          
          
      }catch(Exception e)
      {
          System.out.println(e); 
      }
      
      
        
    }
      else if(ae.getSource()==fetch)
      {
          
          try{
          String str1=ch.getSelectedItem();
          Conn conn=new Conn();
          int bal=0;
          ResultSet rs =conn.s.executeQuery("select * from signup where formno = '"+ch.getSelectedItem()+"'");
          
          while(rs.next())
          {
             
              
                          mini.setText("<html>"+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+rs.getString("formno")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("name")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" +rs.getString("dob")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+rs.getString("email")+"<br><br><html>"); 

          }
          
          
          
      }catch(Exception e)
      {
          System.out.println(e); 
      }
      
      mini.setBounds(20,140,400,200);
          
          
      }
      
    }
    
    
    public static void main(String args[])
    {
        new userdel("");//obj created and constructor is called
    }
    
}
