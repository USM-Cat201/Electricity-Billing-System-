/*class for generate bill function in customer homepage
the bill amount will be retrieved form the database and display when bill is generated*/
package electricity.billing.system;

import javax.swing.*;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;

public class BillGenerator extends JFrame implements ActionListener{
    JButton JB1;//declare button JB1
    JPanel JP1;//declare panel JP1
    JLabel JL1, JL2; //declare two labels which is JL1 and JL2
    JTextArea JTA1; //declare textarea JTA1
    Choice C1; //declare choice option C1
    String meter; //declare string meter
    
    BillGenerator(String meter){
        this.meter = meter;
        setLayout(new BorderLayout());
        setSize(500,650);
        
        JP1 = new JPanel();
        
        JL1 = new JLabel("Generate Bill");
        
        JL2 = new JLabel(meter);
        //initialize the choice from January to December
        C1 = new Choice();
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

        //leave the text so user know that they need to press the button to generate bills
        JTA1 = new JTextArea(50,15);
        JTA1.setText("\tPress 'Generate Bill' button");
        JScrollPane jsp = new JScrollPane(JTA1);
        JTA1.setFont(new Font("Helvetica",Font.BOLD,20));

        //initialize the button so user can generate bill after pressing this button
        JB1 = new JButton("Generate Bills");
        
        JP1.add(JL1);
        JP1.add(JL2);
        JP1.add(C1);
        add(JP1,"North");//the text of generate bill and the month option will be shown at the top of the windows
        
        add(jsp,"Center");
        add(JB1,"South");// the button will be shown at the bottom of windows
        
        JB1.addActionListener(this);
        
        setLocation(750,100);
    }
    public void actionPerformed(ActionEvent ae){
        try{
            DBConnection c = new DBConnection();
   
            String month = C1.getSelectedItem();
            JTA1.setText("ELECTRICITY BILL OF "+month+",2022\n\n\n");
            
            /*select customer details from customer table in database*/
            ResultSet rs = c.s.executeQuery("select * from customer where customer_meter="+meter);
            
            if(rs.next()){
                JTA1.append("\n    Meter Number:       "+rs.getString("customer_meter"));
                JTA1.append("\n    Customer Name:      "+rs.getString("customer_name"));
                JTA1.append("\n    Address:            "+rs.getString("customer_address"));
                JTA1.append("\n    State:              "+rs.getString("customer_state"));
                JTA1.append("\n    City:               "+rs.getString("customer_city"));
                JTA1.append("\n    Email:              "+rs.getString("customer_email"));
                JTA1.append("\n    Phone Number        "+rs.getString("customer_phone"));
                JTA1.append("\n**************************************************");
                JTA1.append("\n");
            }
            /*select meter details from meter_details table in database*/
            rs = c.s.executeQuery("select * from meter_details where meter_number = " + meter);
            
            if(rs.next()){
                JTA1.append("\n    Meter Place :         "+rs.getString("meter_place"));
                JTA1.append("\n    Type of Meter:        "+rs.getString("type_of_meter"));
                JTA1.append("\n    Type of bill:         "+rs.getString("type_of_bill"));
                JTA1.append("\n    Billing Days:         "+rs.getString("billing_day"));
                JTA1.append("\n");
            }
            /*select the amount of taxes from taxes table in database*/
            rs = c.s.executeQuery("select * from taxes");
            if(rs.next()){
                JTA1.append("---------------------------------------------------------------");
                JTA1.append("\n\n");
                JTA1.append("\n Cost per Unit:             RM "+rs.getString("cost_per_unit"));
                JTA1.append("\n Meter Rent Fee:            RM "+rs.getString("rental_meter"));
                JTA1.append("\n Service Taxes:              " +rs.getString("service_tax")+"%");
                JTA1.append("\n KWTBB                       "+rs.getString("KWTBB")+"%");
                JTA1.append("\n");
                
            }
            /*select electricity bill details from electricBill table in database*/
            rs = c.s.executeQuery("select * from electricBill where meter="+meter+" AND bill_month = '"+C1.getSelectedItem()+"'");
            
            if(rs.next()){
                JTA1.append("\n    Billing Month :     \t"+rs.getString("bill_month"));
                JTA1.append("\n    Units Consumed:      \t"+rs.getString("units_used"));
                JTA1.append("\n    Total Charges :     RM \t"+rs.getString("bill_amount"));
                JTA1.append("\n---------------------------------------------------------------");
                JTA1.append("\n    TOTAL AMOUNT PAID : RM  "+rs.getString("bill_amount"));
            }
            
  
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args){
        new BillGenerator("").setVisible(true);
    }
}
