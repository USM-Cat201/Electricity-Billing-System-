
package electricity.billing.system;

import javax.swing.*;
import java.sql.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;


public class AddNewCustomer extends JFrame implements ActionListener{
    JLabel JL1,JL2,JL3,JL4,JL5,JL6,JL7,JL8, JL11;//declare label JL1 to JL8 for eight different statement
    JTextField JT1,JT2,JT3,JT4,JT5,JT6,JT7;//declare text field JT1 to JT7 for user to type the corresponding answer 
    JButton JB1,JB2;//declare two buttons JB1 and JB2 for user to click
    
    AddNewCustomer(){
        setLocation(600,200);//set a location for this AddNewCustomer windows
        setSize(800,500);// set size for the windows
        
        //Declare and set the design of panel JP1
        JPanel JP1 = new JPanel();
        JP1.setLayout(null);
        JP1.setBackground(new Color(173,216,230));//background with light blue
        
        //declare label and put Adding New Customer as title  
        JLabel label = new JLabel("Adding New Customer");
        label.setBounds(100, 10, 350, 35);
        label.setFont(new Font("Helvetica", Font.BOLD, 30));
        label.setForeground(new Color(0,0,139));
        JP1.add(label);
        
        //declare JL1 customer name so the user will know what they should type 
        JL1 = new JLabel("Customer Name:");
        JL1.setBounds(100, 80, 100, 20);
        JL1.setFont(new Font("Times New Roman", Font.PLAIN,15));        
        JT1 = new JTextField();//declare JT1 for input of customer name
        JT1.setBounds(240, 80, 200, 20);
        JP1.add(JL1);
        JP1.add(JT1);
        
        //declare JL2 meter number
        JL2 = new JLabel("Meter Number:");
        JL2.setBounds(100, 120, 100, 20);
        JL2.setFont(new Font("Times New Roman", Font.PLAIN,15));        
        JL11 = new JLabel();
        JL11.setBounds(240, 120, 200, 20);
        JP1.add(JL2);
        JP1.add(JL11);
        
        //declare JL3 address of user
        JL3 = new JLabel("Residental Address: ");
        JL3.setBounds(100, 160, 125, 20);
        JL3.setFont(new Font("Times New Roman", Font.PLAIN,15));        
        JT3 = new JTextField();//declare JT3 for input of customer's address
        JT3.setBounds(240, 160, 200, 20);
        JP1.add(JL3);
        JP1.add(JT3);
        
        //declare JL5 city of the customer
        JL5 = new JLabel("Residenal City: ");
        JL5.setBounds(100, 200, 110, 20);
        JL5.setFont(new Font("Times New Roman", Font.PLAIN,15));
        JT5 = new JTextField();//declare JT5 for input of customer's address
        JT5.setBounds(240, 200, 200, 20);
        JP1.add(JL5);
        JP1.add(JT5);
        
        //declare JL4 state of the customer
        JL4 = new JLabel("Residental State: ");
        JL4.setBounds(100, 240, 110, 20);
        JL4.setFont(new Font("Times New Roman", Font.PLAIN,15));
        JT4 = new JTextField();//declare JT4 for input of customer's state
        JT4.setBounds(240, 240, 200, 20);
        JP1.add(JL4);
        JP1.add(JT4);
        
        //declare JL6 email of the customer
        JL6 = new JLabel("Customer Email: ");
        JL6.setBounds(100, 280, 110, 20);
        JL6.setFont(new Font("Times New Roman", Font.PLAIN,15));
        JT6 = new JTextField();//declare JT6 for input of customer's email
        JT6.setBounds(240, 280, 200, 20);
        JP1.add(JL6);
        JP1.add(JT6);

        //declare JL7 phone number of the customer
        JL7 = new JLabel("Customer Phone: ");
        JL7.setBounds(100, 320, 110, 20);
        JL7.setFont(new Font("Times New Roman", Font.PLAIN,15));
        JT7 = new JTextField();//declare JT7 for input of customer's phone number
        JT7.setBounds(240, 320, 200, 20);
        JP1.add(JL7);
        JP1.add(JT7);
        
        //initialize button JB1 as proceed,when user click this button, a new customer will be added
        JB1 = new JButton("Proceed");
        JB1.setBounds(120, 390, 100, 25);  
        //initialize button JB2 as cancel,when user click this button, the operation before will be canceled and 
        //there is no new customer be added
        JB2 = new JButton("Cancel");
        JB2.setBounds(250, 390, 100, 25);        
        
        //set background design of proceed button as dark blue
        JB1.setBackground(new Color(0,0,139));
        //set the font color of proceed button as white color
        JB1.setForeground(Color.WHITE);
        JB1.setFont(new Font("Times New Roman", Font.PLAIN,15));
        
        //set background design of cancel button as white color
        JB2.setBackground(Color.WHITE);
        //set the font color of cancel button as black color
        JB2.setForeground(Color.BLACK);
        JB2.setFont(new Font("Times New Roman", Font.PLAIN,15));
        
        JP1.add(JB1);
        JP1.add(JB2);
        setLayout(new BorderLayout());
        add(JP1,"Center");
        
        //insert an image to ease the customer understand what the windows function
        //this windows functions as add new customer
        ImageIcon IC1 = new ImageIcon(ClassLoader.getSystemResource("icon/hicon1.png"));
        Image img3 = IC1.getImage().getScaledInstance(300, 300,Image.SCALE_DEFAULT);
        ImageIcon IC2 = new ImageIcon(img3);
        JL8 = new JLabel(IC2);
        add(JL8,"West");
        getContentPane().setBackground(new Color(255,253,208));
        
        JB1.addActionListener(this);
        JB2.addActionListener(this);
        
        Random ran = new Random();
        long first = (ran.nextLong() % 1000000);
        JL11.setText(""+Math.abs(first));
        
    }
    public void actionPerformed(ActionEvent ae){
        //if proceed button is pressed, the information of customer will be stored and a new customer is added
        if(ae.getSource() == JB1){

            String customer_name = JT1.getText();
            String customer_meter = JL11.getText();
            String customer_address = JT3.getText();
            String customer_state = JT4.getText();
            String customer_city = JT5.getText();
            String customer_email = JT6.getText();
            String customer_phone = JT7.getText();
   
            //the information will be insert to the table login and table customer in database
            String str1 = "insert into customer values('"+customer_name+"','"+customer_meter+"','"+customer_address+"','"+customer_city+"','"+customer_state+"','"+customer_email+"','"+customer_phone+"')";
            String str2 = "insert into login values('"+customer_meter+"', '', '', '', '')";
            try{
                DBConnection con1 = new DBConnection();
                con1.s.executeUpdate(str1);
                con1.s.executeUpdate(str2);
                JOptionPane.showMessageDialog(null," New Customer Details Successfully Added");//dialog will be displayed if customer is added successfully 
                this.setVisible(false);
                new MeterDetails(customer_meter).setVisible(true);

            }catch(Exception ex){
                 ex.printStackTrace();
            }
        }else if(ae.getSource() ==JB2){
                this.setVisible(false);
                }
    }
    
    
    public static void main(String[] args){
        new AddNewCustomer().setVisible(true);
    }
}
