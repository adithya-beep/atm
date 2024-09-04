

package bank.management.app;

import java.awt.*;
import static java.awt.Color.WHITE;

import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class adminlogin extends JFrame implements ActionListener{
    JButton login,clear;
    JTextField cardtext;
    JPasswordField pintext;
    adminlogin()
    {
        setTitle("AUTOMATED TELLER MACHINE");
        setLayout(null);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image i2=i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);   
        JLabel label=new JLabel(i3);
        label.setBounds(70,10,100,100);
        add(label);
        //text next to image
        JLabel text=new JLabel("  Admin Login ");
        text.setFont(new Font("Osward",Font.BOLD,38));
        text.setBounds(200,40,400,40);
        getContentPane().setBackground(WHITE);
        add(text);
        //
        JLabel cardno=new JLabel("ID:");
        cardno.setFont(new Font("Raleway",Font.BOLD,28));
        cardno.setBounds(120,150,150,30);
        getContentPane().setBackground(WHITE);
        add(cardno);
        //
        cardtext=new JTextField();
        cardtext.setBounds(300,150,230,30);
        cardtext.setFont(new Font("Arial",Font.BOLD,14));
        add(cardtext);
        //
       JLabel pin=new JLabel("PIN:");
        pin.setFont(new Font("Osward",Font.BOLD,28));
        pin.setBounds(120,220,250,30);
        getContentPane().setBackground(WHITE);
        add(pin);
        //
        pintext=new JPasswordField();
        pintext.setBounds(300,220,230,30);
        pintext.setFont(new Font("Arial",Font.BOLD,14));
        add(pintext);
        //
        login=new JButton("SIGN IN");
        login.setBounds(300,300,100,30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        add(login);
        login.addActionListener(this);
        //
        clear=new JButton("CLEAR");
        clear.setBounds(430,300,100,30);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        add(clear);
        clear.addActionListener(this);
        //
        
        
        
        
        setSize(800,  480);
        setVisible(true);
        setLocation(350,200);
        
    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==clear)
        {
          cardtext.setText("");
          pintext.setText("");
            
        }
        else if(ae.getSource()==login)
        {
          Conn conn=new Conn();
          String cardnumber=cardtext.getText();
          String pinnumber=pintext.getText();
          String query="select * from admin where id = '"+cardnumber+"' and password='"+pinnumber+"'";
          try{
              ResultSet rs=conn.s.executeQuery(query);
              if(rs.next())
              {
                  setVisible(false);
                  new adminview(cardnumber).setVisible(true);
                  
                  
              }
              else
              {JOptionPane.showMessageDialog(null,"Incorrect id or password");
                  
              }
                  
                
              
          }catch(Exception e)
          {
              System.out.println(e);
          }
        }
        
    }
    
    public static void main(String args[])
    {
        new adminlogin();//obj created and constructor is called
    }
    
}
