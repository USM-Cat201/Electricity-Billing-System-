/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package electricity.billing.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class CustomerInfo extends JFrame implements ActionListener{
 
    JTable JT1;
    JButton JB1;
    String x[] = {"Meter","Customer Name","Residental Address","City","State","Customer Email","Customer Phone"};
    String y[][] = new String[40][8];
    int i=0, j=0;
    CustomerInfo(){
        super("Customer Information");
        setSize(1300,700);
        setLocation(450,200);
        
        try{
            DBConnection c1  = new DBConnection();
            String s1 = "select * from customer";
            ResultSet rs  = c1.s.executeQuery(s1);
            while(rs.next()){
                y[i][j++]=rs.getString("customer_meter");
                y[i][j++]=rs.getString("customer_name");//original = meter
                y[i][j++]=rs.getString("customer_address");
                y[i][j++]=rs.getString("customer_city");
                y[i][j++]=rs.getString("customer_state");
                y[i][j++]=rs.getString("customer_email");
                y[i][j++]=rs.getString("customer_phone");
                i++;
                j=0;
            }
            JT1 = new JTable(y,x);
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        
        JB1 = new JButton("Print");
        add(JB1,"South");
        JScrollPane sp = new JScrollPane(JT1);
        add(sp);
        JB1.addActionListener(this);
    }
    public void actionPerformed(ActionEvent ae){
        try{
            JT1.print();
        }catch(Exception e){}
    }
    
    public static void main(String[] args){
        new CustomerInfo().setVisible(true);
    }
    
}
