/*class for login function*/
package electricity.billing.system;

import javax.swing.*;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;

public class Login extends JFrame implements ActionListener{
    JLabel JL1,JL2,JL3, JL4;//declare label JL1 to JL4
    JTextField JTF1; //declare textfield JTF1
    JPasswordField JPF2; //declare passwordfield JPF2
    JButton JB1,JB2, JB3; //declare three buttons from JB1 to JB3
    JPanel JP1,JP2,JP3,JP4; //declare four panels from JP1 to JP4
    Choice C1;//declare choice C1

    Login(){
        //title of windows page of login
        super("Page of Login");
        setLayout(null);
        getContentPane().setBackground(new Color(255,253,208));
        
        //declare and initialize label username
        JL1 = new JLabel("Username");
        JL1.setBounds(300, 20, 100, 20);
        JL1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        add(JL1);

        //declare and initialize label password
        JL2 = new JLabel("Password");
        JL2.setBounds(300, 60, 100, 20);
        JL2.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        add(JL2);
        
        //declare and initialize JTF1 for input of name
        JTF1 = new JTextField(15);
        JTF1.setBounds(400, 20, 150, 20);
        add(JTF1);
        //declare and initialize JPF2 for input of password
        JPF2 = new JPasswordField(15);
        JPF2.setBounds(400, 60, 150, 20);
        add(JPF2);
        
        //declare and initialize label login as
        JL4 = new JLabel("Login as");
        JL4.setBounds(300, 100, 100, 20);
        JL4.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        add(JL4);
        //declare and initialize choice
        C1 = new Choice();
        C1.add("Customer");
        C1.add("Admin");
        C1.setBounds(400, 100, 150, 20);
        add(C1);
        
        //insert image of login
        ImageIcon IC1 = new ImageIcon(ClassLoader.getSystemResource("icon/login.png"));
        Image img1 = IC1.getImage().getScaledInstance(16, 16,Image.SCALE_DEFAULT);
        JB1 = new JButton("Login", new ImageIcon(img1));
        JB1.setBounds(330, 160, 100, 20);
        JB1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        add(JB1);

        //insert logo of cancel to ease the user
        ImageIcon IC2 = new ImageIcon(ClassLoader.getSystemResource("icon/cancel.png"));
        Image img2 = IC2.getImage().getScaledInstance(16, 16,Image.SCALE_DEFAULT);
        JB2 = new JButton("Cancel",new ImageIcon(img2));
        JB2.setBounds(450, 160, 100, 20);
        JB2.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        add(JB2);
        
        //insert logo of signup 
        ImageIcon IC4 = new ImageIcon(ClassLoader.getSystemResource("icon/signup.png"));
        Image img4 = IC4.getImage().getScaledInstance(16, 16,Image.SCALE_DEFAULT);
        JB3 = new JButton("Sign Up",new ImageIcon(img4));
        JB3.setBounds(380, 200, 130, 20);
        JB3.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        add(JB3);
        
        JB1.addActionListener(this);
        JB2.addActionListener(this);
        JB3.addActionListener(this);

        //insert picture of person logo 
        ImageIcon IC3 = new ImageIcon(ClassLoader.getSystemResource("icon/second.png"));
        Image img3 = IC3.getImage().getScaledInstance(250, 250,Image.SCALE_DEFAULT);
        ImageIcon imgc3 = new ImageIcon(img3);
        JL3 = new JLabel(imgc3);
        JL3.setBounds(0, 0, 250, 250);
        add(JL3);
        
        setLayout(new BorderLayout());
    
        setLocation(600,300);
        setSize(640,300);
        setVisible(true);
        
        
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == JB1){
            try{        
                DBConnection c = new DBConnection();
                String str1  = JTF1.getText();//get the name from the user
                String str2  = JPF2.getText();//get the password 
                String user = C1.getSelectedItem();//user choose either customer or admin
                //name, password and choice are stored in str3

                /*retrive data from database*/
                String str3  = "select * from login where username = '"+str1+"' and password = '"+str2+"' and usertype = '"+user+"'";
                ResultSet rs = c.s.executeQuery(str3);
                if(rs.next()){
                    /*validate user input by comparing with the username and password retrived from database
                    where the meter_number is the same*/
                    String meter = rs.getString("meter_number");
                    new Main(meter, user).setVisible(true);
                    this.setVisible(false);

                }else{
                    /*display message when login is unsuccessful*/
                    JOptionPane.showMessageDialog(null, "Login Unsuccessful");
                    JTF1.setText("");
                    JPF2.setText("");
                } 
            }catch(Exception e){
                e.printStackTrace();
                System.out.println("ERROR: "+e);
            }
        }else if(ae.getSource() == JB2){
            this.setVisible(false);
        }else if(ae.getSource() == JB3){
            this.setVisible(false);
            new Signup().setVisible(true);
            
        }
    }
    
    public static void main(String[] args){
        new Login().setVisible(true);
    }

    
}