/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package electricity.billing.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class DisplayInformation extends JFrame implements ActionListener{
    JButton JB1;
    DisplayInformation(String meter){
        setBounds(600,250, 850, 650);
        getContentPane().setBackground(new Color(250,128,114));
        setLayout(null);
        
        JLabel label = new JLabel("DISPLAY CUSTOMER INFORMATION");
        label.setBounds(200, 0, 550, 40);
        label.setFont(new Font("Helvetica", Font.BOLD, 25));
        label.setForeground(new Color(0,0,139));
        add(label);
        
        JLabel JL1 = new JLabel("Name:");
        JL1.setBounds(70, 140, 100, 20);
        JL1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        add(JL1);
        
        JLabel JL11 = new JLabel();
        JL11.setBounds(200, 140, 100, 20);
        add(JL11);
        
        JLabel JL2 = new JLabel("Meter Number:");
        JL2.setBounds(70, 80, 100, 20);
        JL2.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        add(JL2);
        
        JLabel JL12 = new JLabel();
        JL12.setBounds(200, 80, 100, 20);
        add(JL12);
        
        JLabel JL3 = new JLabel("Residental Address:");
        JL3.setBounds(500, 80, 150, 20);
        JL3.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        add(JL3);
        
        JLabel JL13 = new JLabel();
        JL13.setBounds(650, 80, 100, 20);
        add(JL13);
        
        JLabel JL4 = new JLabel("Residental City:");
        JL4.setBounds(500, 140, 100, 20);
        JL4.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        add(JL4);
        
        JLabel JL14 = new JLabel();
        JL14.setBounds(650, 140, 100, 20);
        add(JL14);
        
        JLabel JL5 = new JLabel("Residental State:");
        JL5.setBounds(500, 200, 100, 20);
        JL5.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        add(JL5);
        
        JLabel JL15 = new JLabel();
        JL15.setBounds(650, 200, 100, 20);
        add(JL15);
        
        JLabel JL6 = new JLabel("Email:");
        JL6.setBounds(70, 200, 100, 20);
        JL6.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        add(JL6);
        
        JLabel JL16 = new JLabel();
        JL16.setBounds(200, 200, 200, 20);
        add(JL16);
        
        JLabel JL7 = new JLabel("Phone:");
        JL7.setBounds(70, 260, 100, 20);
        JL7.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        add(JL7);
        
        JLabel JL17 = new JLabel();
        JL17.setBounds(200, 260, 100, 20);
        add(JL17);
        
        try{
            DBConnection con1 = new DBConnection();
            ResultSet rs = con1.s.executeQuery("select * from customer where customer_meter = '"+meter+"'");
            while(rs.next()){
                JL11.setText(rs.getString(1));
                JL12.setText(rs.getString(2));
                JL13.setText(rs.getString(3));
                JL14.setText(rs.getString(4));
                JL15.setText(rs.getString(5));
                JL16.setText(rs.getString(6));
                JL17.setText(rs.getString(7));
                
            }
        }catch(Exception e){}
        
        JB1 = new JButton("Return");
        JB1.setBackground(Color.DARK_GRAY);
        JB1.setForeground(Color.WHITE);
        JB1.setBounds(350, 340, 100, 25);
        JB1.addActionListener(this);
        JB1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        add(JB1);
        
        ImageIcon IC1 = new ImageIcon(ClassLoader.getSystemResource("icon/viewcustomer.png"));
        Image img2 = IC1.getImage().getScaledInstance(600, 300, Image.SCALE_DEFAULT);
        ImageIcon IC3 = new ImageIcon(img2);
        JLabel JL8  = new JLabel(IC3);
        JL8.setBounds(20, 350, 600, 300);
        add(JL8);
    }
    
    public void actionPerformed(ActionEvent ae){
        this.setVisible(false);
    }
    
    public static void main(String[] args){
        new DisplayInformation("").setVisible(true);
    }
}
