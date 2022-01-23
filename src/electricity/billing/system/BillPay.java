
package electricity.billing.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class BillPay extends JFrame implements ActionListener{
    JLabel JL1,JL2,JL3,JL4,JL5, JL6;
    JLabel JL11, JL12, JL13, JL14, JL15;
    JTextField JTF1;
    Choice C1,C2;
    JButton JB1,JB2;
    String meter;
    BillPay(String meter){
        this.meter = meter;
        setLayout(null);
        
        setBounds(550, 220, 800, 600);
        
        JLabel label = new JLabel("Bill Payment");
        label.setFont(new Font("Helvetica", Font.BOLD, 30));
        label.setBounds(300, 15, 400, 30);
        label.setForeground(new Color(0,0,139));
        add(label);
        
        JL1 = new JLabel("Meter Number");
        JL1.setBounds(35, 80, 200, 20);
        JL1.setFont(new Font("Times New Roman", Font.PLAIN,15));
        add(JL1);
        
        JLabel L11 = new JLabel();
        L11.setBounds(250, 80, 200, 20);
        add(L11);
        
        JLabel L2 = new JLabel("Customer Name");
        L2.setBounds(35, 140, 200, 20);
        L2.setFont(new Font("Times New Roman", Font.PLAIN,15));
        add(L2);
        
        JLabel L12 = new JLabel();
        L12.setBounds(250, 140, 200, 20);
        add(L12);
        
        JL3 = new JLabel("Billing Month");
        JL3.setBounds(35, 200, 200, 20);
        JL3.setFont(new Font("Times New Roman", Font.PLAIN,15));
        add(JL3);
        
        C1 = new Choice();
        C1.setBounds(250, 200, 200, 20);
        C1.add("January");
        C1.add("February");
        C1.add("March");
        C1.add("April");
        C1.add("May");
        C1.add("June");
        C1.add("July");
        C1.add("August");
        C1.add("September");
        C1.add("October");
        C1.add("November");
        C1.add("December");
        add(C1);
        
        
        JL4 = new JLabel("Units Consumed");
        JL4.setBounds(35, 260, 200, 20);
        JL4.setFont(new Font("Times New Roman", Font.PLAIN,15));
        add(JL4);
        
        JLabel L13 = new JLabel();
        L13.setBounds(250, 260, 200, 20);
        add(L13);
        
        JL5 = new JLabel("Total Bill");
        JL5.setBounds(35, 320, 200, 20);
        JL5.setFont(new Font("Times New Roman", Font.PLAIN,15));
        add(JL5);
        
        JLabel L14 = new JLabel();
        L14.setBounds(250, 320, 200, 20);
        add(L14);
        
        JL6 = new JLabel("Payment Status");
        JL6.setBounds(35, 380, 200, 20);
        JL6.setFont(new Font("Times New Roman", Font.PLAIN,15));
        add(JL6);
        
        JLabel L15 = new JLabel();
        L15.setBounds(250, 380, 200, 20);
        L15.setForeground(Color.RED);
        add(L15);
        
        
        
        try{
            DBConnection c = new DBConnection();
            ResultSet rs = c.s.executeQuery("select * from customer where customer_meter = '"+meter+"'");
            while(rs.next()){
                L11.setText(rs.getString("customer_meter"));
                L12.setText(rs.getString("customer_name"));
            }
            rs = c.s.executeQuery("select * from electricBill where meter = '"+meter+"' AND bill_month = 'January' ");
            while(rs.next()){
                L13.setText(rs.getString("units_used"));
                L14.setText(rs.getString("bill_amount"));
                L15.setText(rs.getString("status"));
            }
        }catch(Exception e){}
        
        C1.addItemListener(new ItemListener(){
            @Override
            public void itemStateChanged(ItemEvent ae){
                try{
                    DBConnection c = new DBConnection();
                    ResultSet rs = c.s.executeQuery("select * from electricBill where meter = '"+meter+"' AND bill_month = '"+C1.getSelectedItem()+"'");
                    while(rs.next()){
                        L13.setText(rs.getString("units_used"));
                        L14.setText(rs.getString("bill_amount"));
                        L15.setText(rs.getString("status"));
                    }
                }catch(Exception e){}
            }
        });
        
        JB1 = new JButton("Submit");
        JB1.setBounds(100, 460, 100, 25);
        JB1.setFont(new Font("Times New Roman", Font.PLAIN,15));
        add(JB1);
        JB2 = new JButton("Return");
        JB2.setBounds(230, 460, 100, 25);
        JB2.setFont(new Font("Times New Roman", Font.PLAIN,15));
        add(JB2);
        
        JB1.setBackground(new Color(0,0,139));
        JB1.setForeground(Color.WHITE);

        JB2.setBackground(Color.WHITE);
        JB2.setForeground(Color.BLACK);
        
        ImageIcon IC1 = new ImageIcon(ClassLoader.getSystemResource("icon/bill.png"));
        Image img2 = IC1.getImage().getScaledInstance(300, 300,Image.SCALE_DEFAULT);
        ImageIcon IC3 = new ImageIcon(img2);
        JLabel L21 = new JLabel(IC3);
        L21.setBounds(375, 120, 550, 300);
        add(L21);
        
        JB1.addActionListener(this);
        JB2.addActionListener(this);
        
        getContentPane().setBackground(new Color(173,216,230));        
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == JB1){
            try{
                DBConnection c = new DBConnection();
                c.s.executeQuery("update electricBill status = 'Paid' where meter = '"+meter+"' AND bill_month = '"+C1.getSelectedItem()+"'");
                
            }catch(Exception e){}
            this.setVisible(false);
            new Payment(meter).setVisible(true);

        }else if(ae.getSource()== JB2){
            this.setVisible(false);
        }        
    }
    
       
    public static void main(String[] args){
        new BillPay("").setVisible(true);
    }
}
