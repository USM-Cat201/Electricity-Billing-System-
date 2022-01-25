
package electricity.billing.system;

import javax.swing.*;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;

public class BillPay extends JFrame implements ActionListener{
    JLabel JL1,JL2,JL3,JL4,JL5, JL6; //declare label JL1 to JL6
    JLabel JL11, JL12, JL13, JL14, JL15; //declare label JL11 to JL15
    JTextField JTF1;//declare a text field
    Choice C1,C2; //declare two choices C1 and C2
    JButton JB1,JB2; //declare button JB1 and JB2
    String meter; //declare meter with string data type

    BillPay(String meter){
        this.meter = meter;
        setLayout(null);
        //set bounds(int x, int y, int width, int height)
        setBounds(550, 220, 800, 600);
        
        //Title of Bill Payment will be shown
        JLabel label = new JLabel("Bill Payment");
        label.setFont(new Font("Helvetica", Font.BOLD, 30));
        label.setBounds(300, 15, 400, 30);
        label.setForeground(new Color(0,0,139));
        add(label);
        
        //initialize JL1 meter number
        JL1 = new JLabel("Meter Number");
        JL1.setBounds(35, 80, 200, 20);
        JL1.setFont(new Font("Times New Roman", Font.PLAIN,15));
        add(JL1);
        
        JLabel JL11 = new JLabel();
        JL11.setBounds(250, 80, 200, 20);
        add(JL11);
        
        //initialize JL2 name of customer
        JLabel JL2 = new JLabel("Customer Name");
        JL2.setBounds(35, 140, 200, 20);
        JL2.setFont(new Font("Times New Roman", Font.PLAIN,15));
        add(JL2);
        //The name of customer will be shown 
        JLabel JL12 = new JLabel();
        JL12.setBounds(250, 140, 200, 20);
        add(JL12);
        
        //initialize JL3 billing month
        JL3 = new JLabel("Billing Month");
        JL3.setBounds(35, 200, 200, 20);
        JL3.setFont(new Font("Times New Roman", Font.PLAIN,15));
        add(JL3);
        //initialize choice from January to December to let user choose
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
        
        //initialize JL4 units consumed in that month the user chose
        JL4 = new JLabel("Units Consumed");
        JL4.setBounds(35, 260, 200, 20);
        JL4.setFont(new Font("Times New Roman", Font.PLAIN,15));
        add(JL4);
        // the unit consumed will be shown
        JLabel JL13 = new JLabel();
        JL13.setBounds(250, 260, 200, 20);
        add(JL13);
        
        //initialize JL5 total amount of the bill
        JL5 = new JLabel("Total Bill");
        JL5.setBounds(35, 320, 200, 20);
        JL5.setFont(new Font("Times New Roman", Font.PLAIN,15));
        add(JL5);
        //the total amount of bill will be shown 
        JLabel JL14 = new JLabel();
        JL14.setBounds(250, 320, 200, 20);
        add(JL14);
        
        //initialize JL6 payment status 
        JL6 = new JLabel("Payment Status");
        JL6.setBounds(35, 380, 200, 20);
        JL6.setFont(new Font("Times New Roman", Font.PLAIN,15));
        add(JL6);
        //the payment status will be shown
        JLabel JL15 = new JLabel();
        JL15.setBounds(250, 380, 200, 20);
        JL15.setForeground(Color.RED);
        add(JL15);
        
        
        
        try{
            DBConnection c = new DBConnection();
            //the data will be selected from the table customer
            ResultSet rs = c.s.executeQuery("select * from customer where customer_meter = '"+meter+"'");
            while(rs.next()){
                JL11.setText(rs.getString("customer_meter"));
                JL12.setText(rs.getString("customer_name"));
            }
            rs = c.s.executeQuery("select * from electricBill where meter = '"+meter+"' AND bill_month = 'January' ");
            while(rs.next()){
                JL13.setText(rs.getString("units_used"));
                JL14.setText(rs.getString("bill_amount"));
                JL15.setText(rs.getString("status"));
            }
        }catch(Exception e){}
        
        C1.addItemListener(new ItemListener(){
            @Override
            public void itemStateChanged(ItemEvent ae){
                try{
                    DBConnection c = new DBConnection();
                    ResultSet rs = c.s.executeQuery("select * from electricBill where meter = '"+meter+"' AND bill_month = '"+C1.getSelectedItem()+"'");
                    while(rs.next()){
                        JL13.setText(rs.getString("units_used"));
                        JL14.setText(rs.getString("bill_amount"));
                        JL15.setText(rs.getString("status"));
                    }
                }catch(Exception e){}
            }
        });
        //initialize button JB1 as submit
        JB1 = new JButton("Submit");
        JB1.setBounds(100, 460, 100, 25);
        JB1.setFont(new Font("Times New Roman", Font.PLAIN,15));
        add(JB1);
        //initialize button JB2 as return
        JB2 = new JButton("Return");
        JB2.setBounds(230, 460, 100, 25);
        JB2.setFont(new Font("Times New Roman", Font.PLAIN,15));
        add(JB2);
        //set background color of submit button as dark blue
        JB1.setBackground(new Color(0,0,139));
        //set font color of submit button as white color
        JB1.setForeground(Color.WHITE);

        //set background color of return button as white color
        JB2.setBackground(Color.WHITE);
        //set font color of return button as black color
        JB2.setForeground(Color.BLACK);
        
        //insert image of billing to ease the user know this windows is bill payment windows
        ImageIcon IC1 = new ImageIcon(ClassLoader.getSystemResource("icon/bill.png"));
        Image img2 = IC1.getImage().getScaledInstance(300, 300,Image.SCALE_DEFAULT);
        ImageIcon IC3 = new ImageIcon(img2);
        JLabel L21 = new JLabel(IC3);
        L21.setBounds(375, 120, 550, 300);
        add(L21);
        
        JB1.addActionListener(this);
        JB2.addActionListener(this);
        //set the background color of the windows as light blue
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
