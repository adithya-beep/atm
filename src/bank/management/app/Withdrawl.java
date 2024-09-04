
package bank.management.app;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.util.*;
public class Withdrawl extends JFrame implements ActionListener{
JButton withdraw,back;
JTextField amount;
String pinnumber;

    Withdrawl(String pinnumber)
    {
        this.pinnumber=pinnumber;
        setLayout(null);
        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
        
        JLabel text=new JLabel("Enter the amount to deposit");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,16));
        text.setBounds(170,300,400,20);
        image.add(text);
        
        amount = new JTextField();
        amount.setFont(new Font("Raleway",Font.BOLD,22));
        amount.setBounds(170,350,320,25);
        image.add(amount);
        
        withdraw = new JButton("WITHDRAW");
        withdraw.setBounds(355,485,150,30);
        withdraw.addActionListener(this);
        image.add(withdraw);
        
        
        back = new JButton("BACK");
        back.setBounds(355,520,150,30);
        back.addActionListener(this);
        image.add(back);
        
        
        
        setSize(900,900);
        setLocation(300,0);
        //setUndecorated(true);
        setVisible(true);
    }
@Override
    public void actionPerformed(ActionEvent ae)
    {
       if(ae.getSource()==withdraw)
       {
          String number=amount.getText();
          Date date=  new Date();
          if(number.equals(""))
          {
              JOptionPane.showMessageDialog(null,"Please enter the amount you want to withdraw");
          
          }
          else
          {
              try{
                  int balance=0;
                  try{
                      Conn c=new Conn();
             ResultSet rs=c.s.executeQuery("select * from bank where pin = '"+pinnumber+"'");
             
             while(rs.next())
             {
               if(rs.getString("type").equals("Deposit"))
               {
                   balance += Integer.parseInt(rs.getString("amount"));
               } 
               else
               {
                   balance -= Integer.parseInt(rs.getString("amount"));
               }
               
             }
         }
         catch(Exception e)
         {
             System.out.println(e);
         }
                  
                if(Integer.parseInt(number)<=balance)
                {
                   int b=Integer.parseInt(number);
              balance-=b;
            String  ba=""+balance;
              Conn conn=new Conn();
              String query="insert into bank values('"+pinnumber+"','"+date+"','Withdrawl','"+number+"'.'"+ba+"')";
//              String query="CREATE TRIGGER insert_transaction1_log " +
//                    "AFTER INSERT ON bank " +
//                    "FOR EACH ROW " +
//                    "BEGIN " +
//                    "INSERT INTO transaction_log  " +
//                    "VALUES ('"+pinnumber+"', '"+date+"','Withdrawl','"+number+"'); " +
//                    "END";

              conn.s.executeUpdate(query);
              JOptionPane.showMessageDialog(null, "Rs "+number+" Withdraw Successfully Done");
                                                                                                                                                                                                System.out.println("Transaction completed");
              setVisible(false);
              new Transactions(pinnumber).setVisible(true);
                }
                else{
                    JOptionPane.showMessageDialog(null, "INSUFFICIENT ACCOUNT BALANCE");
                    return;
                }
                
              }catch(Exception e)
              {
                  System.out.println("depsoit error");
                  System.out.println(e); 
                  
              }
              
              
          }
           
       }
       else if(ae.getSource()==back)
       {
           setVisible(false);
        new Transactions(pinnumber).setVisible(true);
       }
    }
    
    public static void main(String args[]) {
        new Withdrawl("");
        
        
    }
}
