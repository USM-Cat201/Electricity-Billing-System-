/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package electricity.billing.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.*;

public class AddNewCustomer extends JFrame implements ActionListener{
    JLabel JL1,JL2,JL3,JL4,JL5,JL6,JL7,JL8, JL11;
    JTextField JT1,JT2,JT3,JT4,JT5,JT6,JT7;
    JButton JB1,JB2;
    AddNewCustomer(){
        setLocation(600,200);
        setSize(800,500);
        
        JPanel JP1 = new JPanel();
        JP1.setLayout(null);
        JP1.setBackground(Color.WHITE);
        JP1.setBackground(new Color(173,216,230));
        
        JLabel label = new JLabel("Adding New Customer");
        label.setBounds(100, 10, 350, 35);
        label.setFont(new Font("Helvetica", Font.BOLD, 30));
        label.setForeground(new Color(0,0,139));
        JP1.add(label);
        
        JL1 = new JLabel("Customer Name:");
        JL1.setBounds(100, 80, 100, 20);
        JL1.setFont(new Font("Times New Roman", Font.PLAIN,15));        
        JT1 = new JTextField();
        JT1.setBounds(240, 80, 200, 20);
        JP1.add(JL1);
        JP1.add(JT1);
        
        JL2 = new JLabel("Meter Number:");
        JL2.setBounds(100, 120, 100, 20);
        JL2.setFont(new Font("Times New Roman", Font.PLAIN,15));        
        JL11 = new JLabel();
        JL11.setBounds(240, 120, 200, 20);
        JP1.add(JL2);
        JP1.add(JL11);
        
        JL3 = new JLabel("Residental Address: ");
        JL3.setBounds(100, 160, 125, 20);
        JL3.setFont(new Font("Times New Roman", Font.PLAIN,15));        
        JT3 = new JTextField();
        JT3.setBounds(240, 160, 200, 20);
        JP1.add(JL3);
        JP1.add(JT3);
        
        JL5 = new JLabel("Residenal City: ");
        JL5.setBounds(100, 200, 110, 20);
        JL5.setFont(new Font("Times New Roman", Font.PLAIN,15));
        JT5 = new JTextField();
        JT5.setBounds(240, 200, 200, 20);
        JP1.add(JL5);
        JP1.add(JT5);
        
        JL4 = new JLabel("Residental State: ");
        JL4.setBounds(100, 240, 110, 20);
        JL4.setFont(new Font("Times New Roman", Font.PLAIN,15));
        JT4 = new JTextField();
        JT4.setBounds(240, 240, 200, 20);
        JP1.add(JL4);
        JP1.add(JT4);
        
        JL6 = new JLabel("Customer Email: ");
        JL6.setBounds(100, 280, 110, 20);
        JL6.setFont(new Font("Times New Roman", Font.PLAIN,15));
        JT6 = new JTextField();
        JT6.setBounds(240, 280, 200, 20);
        JP1.add(JL6);
        JP1.add(JT6);
        
        JL7 = new JLabel("Customer Phone: ");
        JL7.setBounds(100, 320, 110, 20);
        JL7.setFont(new Font("Times New Roman", Font.PLAIN,15));
        JT7 = new JTextField();
        JT7.setBounds(240, 320, 200, 20);
        JP1.add(JL7);
        JP1.add(JT7);
        
        JB1 = new JButton("Proceed");
        JB1.setBounds(120, 390, 100, 25);        
        JB2 = new JButton("Cancel");
        JB2.setBounds(250, 390, 100, 25);        
        
        JB1.setBackground(new Color(0,0,139));
        JB1.setForeground(Color.WHITE);
        JB1.setFont(new Font("Times New Roman", Font.PLAIN,15));
        
        JB2.setBackground(Color.WHITE);
        JB2.setForeground(Color.BLACK);
        JB2.setFont(new Font("Times New Roman", Font.PLAIN,15));
        
        JP1.add(JB1);
        JP1.add(JB2);
        setLayout(new BorderLayout());
        
        add(JP1,"Center");
        
        ImageIcon IC1 = new ImageIcon(ClassLoader.getSystemResource("icon/hicon1.png"));
        Image img3 = IC1.getImage().getScaledInstance(300, 300,Image.SCALE_DEFAULT);
        ImageIcon IC2 = new ImageIcon(img3);
        JL8 = new JLabel(IC2);
        
        
        add(JL8,"West");
        //for changing the color of the whole Frame
        getContentPane().setBackground(new Color(255,253,208));
        
        JB1.addActionListener(this);
        JB2.addActionListener(this);
        
        Random ran = new Random();
        long first = (ran.nextLong() % 1000000);
        JL11.setText(""+Math.abs(first));
        
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == JB1){
            String customer_name = JT1.getText();
            String customer_meter = JL11.getText();
            String customer_address = JT3.getText();
            String customer_state = JT4.getText();
            String customer_city = JT5.getText();
            String customer_email = JT6.getText();
            String customer_phone = JT7.getText();

            String str1 = "insert into customer values('"+customer_name+"','"+customer_meter+"','"+customer_address+"','"+customer_city+"','"+customer_state+"','"+customer_email+"','"+customer_phone+"')";
            String str2 = "insert into login values('"+customer_meter+"', '', '', '', '')";
            try{
                DBConnection con1 = new DBConnection();
                con1.s.executeUpdate(str1);
                con1.s.executeUpdate(str2);
                JOptionPane.showMessageDialog(null," New Customer Details Successfully Added");
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
