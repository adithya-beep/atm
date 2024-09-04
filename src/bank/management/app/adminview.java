

package bank.management.app;

import java.awt.*;
import static java.awt.Color.WHITE;


import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class adminview extends JFrame implements ActionListener{
    
    JTextField cardtext;
    JTextField pintext;
    Choice ch,cc;
    JButton signup,fetch;
    JLabel mini;
    String id;
    adminview(String id)
    {
        this.id=id;
        setTitle("AUTOMATED TELLER MACHINE");
        setLayout(null);
        JLabel cardno=new JLabel("Type");
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
        ch.add("Withdrawl");
        ch.add("Deposit");
        signup=new JButton("Search");
        signup.setBounds(300,80,230,30);
        signup.setBackground(Color.BLACK);
        signup.setForeground(Color.WHITE);
        add(signup);
        signup.addActionListener(this);
        fetch=new JButton("USER DELETE");
        fetch.setBounds(300,130,230,30);
        fetch.setBackground(Color.BLACK);
        fetch.setForeground(Color.WHITE);
        add(fetch);
        fetch.addActionListener(this);
        
        mini= new JLabel();
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
          int bal=0;
          ResultSet rs =conn.s.executeQuery("select * from bank where type = '"+str1+"'");
          
          while(rs.next())
          {
              //String str22=rs.getString("pin");
              //ResultSet r=conn.s.executeQuery("select cardnumber from login where pin= '"+str22+"'");
              //r.next();
              
              //String str222=r.getString("cardnumber");
              //System.out.println(str222);
              
              
            mini.setText(mini.getText()+"<html>"+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+rs.getString("date")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("type")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" +rs.getString("amount")+"<br><br><html>"); 
          }
          
          
          
      }catch(Exception e)
      {
          System.out.println(e); 
      }
      
      mini.setBounds(20,140,400,200);
        
    }
      else if(ae.getSource()==fetch)
      {
          setVisible(false);
          new userdel(id).setVisible(true);
                  
      }
      
    }
    
    
    public static void main(String args[])
    {
        new adminview("");//obj created and constructor is called
    }
    
}
