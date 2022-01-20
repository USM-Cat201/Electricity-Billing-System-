/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package electricity.billing.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class RenewInformation extends JFrame implements ActionListener{
    JTextField JT1, JT2, JT3, JT4, JT5, JT6, JT7;
    JLabel JL1, JL2;
    JButton JB1, JB2;
    String meter;
    RenewInformation(String meter){
        this.meter = meter;
        
        setBounds(500, 220, 1050, 450);
        setLayout(null);
        getContentPane().setBackground(new Color(225,240,223));
        
        JLabel label = new JLabel("RENEW CUSTOMER INFORMATION");
        label.setBounds(80, 15, 500, 30);
        label.setFont(new Font("Helvetica", Font.BOLD, 25));
        label.setForeground(new Color(0,0,139));
        add(label);
        
        JLabel L1 = new JLabel("Customer Name");
        L1.setBounds(30, 70, 100, 20);
        L1.setFont(new Font("Times New Roman",Font.PLAIN,15));
        add(L1);
        
        JL1 = new JLabel();
        JL1.setBounds(230, 70, 200, 20);
        add(JL1);
        
        JLabel L2 = new JLabel("Meter Number");
        L2.setBounds(30, 110, 100, 20);
        L2.setFont(new Font("Times New Roman",Font.PLAIN,15));
        add(L2);
        
        JL2 = new JLabel();
        JL2.setBounds(230, 110, 200, 20);
        add(JL2);
        
        JLabel L3 = new JLabel("Customer Address");
        L3.setBounds(30, 150, 150, 20);
        L3.setFont(new Font("Times New Roman",Font.PLAIN,15));
        add(L3);
        
        JT1 = new JTextField();
        JT1.setBounds(230, 150, 200, 20);
        add(JT1);
        
        JLabel L4 = new JLabel("City");
        L4.setBounds(30, 190, 100, 20);
        L4.setFont(new Font("Times New Roman",Font.PLAIN,15));
        add(L4);
        
        JT2 = new JTextField();
        JT2.setBounds(230, 190, 200, 20);
        add(JT2);
        
        JLabel L5 = new JLabel("State");
        L5.setBounds(30, 230, 100, 20);
        L5.setFont(new Font("Times New Roman",Font.PLAIN,15));
        add(L5);
        
        JT3 = new JTextField();
        JT3.setBounds(230, 230, 200, 20);
        add(JT3);
        
        JLabel L6 = new JLabel("Customer Email");
        L6.setBounds(30, 270, 100, 20);
        L6.setFont(new Font("Times New Roman",Font.PLAIN,15));
        add(L6);
        
        JT4 = new JTextField();
        JT4.setBounds(230, 270, 200, 20);
        add(JT4);
        
        JLabel L7 = new JLabel("Customer Phone");
        L7.setBounds(30, 310, 100, 20);
        L7.setFont(new Font("Times New Roman",Font.PLAIN,15));
        add(L7);
        
        JT5 = new JTextField();
        JT5.setBounds(230, 310, 200, 20);
        add(JT5);
        
        JB1 = new JButton("Renew");
        JB1.setBackground(new Color(0,0,139));
        JB1.setForeground(Color.WHITE);
        JB1.setBounds(70, 360, 100, 25);
        JB1.setFont(new Font("Times New Roman",Font.PLAIN,15));
        JB1.addActionListener(this);
        add(JB1);
        
        JB2 = new JButton("Return");
        JB2.setBackground(Color.DARK_GRAY);
        JB2.setForeground(Color.WHITE);
        JB2.setBounds(230, 360, 100, 25);
        JB2.setFont(new Font("Times New Roman",Font.PLAIN,15));
        JB2.addActionListener(this);
        add(JB2);
        
        try{
            DBConnection c = new DBConnection();
            ResultSet rs = c.s.executeQuery("select * from customer where customer_meter = '"+meter+"'");
            while(rs.next()){
                JL1.setText(rs.getString(1));
                JL2.setText(rs.getString(2));
                JT1.setText(rs.getString(3));
                JT2.setText(rs.getString(4));
                JT3.setText(rs.getString(5));
                JT4.setText(rs.getString(6));
                JT5.setText(rs.getString(7));
                
            }
        }catch(Exception e){}
        
        ImageIcon IC1 = new ImageIcon(ClassLoader.getSystemResource("icon/renew.png"));
        Image img2  = IC1.getImage().getScaledInstance(400, 300, Image.SCALE_DEFAULT);
        ImageIcon IC2 = new ImageIcon(img2);
        JLabel JL8  = new JLabel(IC2);
        JL8.setBounds(550, 50, 400, 300);
        add(JL8);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == JB1){
            String str1 = JL1.getText();
            String str2 = JL2.getText();
            String str3 = JT1.getText();
            String str4 = JT2.getText();
            String str5 = JT3.getText();
            String str6 = JT4.getText();
            String str7 = JT5.getText();
            
            try{
                DBConnection c = new DBConnection();
                c.s.executeUpdate("update customer set customer_address = '"+str3+"', customer_city = '"+str4+"', customer_state = '"+str5+"', customer_email = '"+str6+"', customer_phone = '"+str7+"' where customer_meter = '"+meter+"'");
                JOptionPane.showMessageDialog(null, "Customer Details Updated Successfully");
                this.setVisible(false);
                
            }catch(Exception e){}
            
        }else if(ae.getSource() == JB2){
            this.setVisible(false);
        }
    }
    
    public static void main(String[] args){
        new RenewInformation("").setVisible(true);
        
    }
}
