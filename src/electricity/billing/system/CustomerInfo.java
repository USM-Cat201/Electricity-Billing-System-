package electricity.billing.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class CustomerInfo extends JFrame implements ActionListener{
 
    JTable JT1;//declare table JT1
    JButton JB1;//declare button JB1
    String x[] = {"Meter","Customer Name","Residental Address","City","State","Customer Email","Customer Phone"};
    String y[][] = new String[40][8];
    int i=0, j=0;
    CustomerInfo(){
        super("Customer Information");//title of Customer Information will be shown on the top 
        //specify the position
        setSize(1300,700);
        setLocation(450,200);
        
        try{
            DBConnection c1  = new DBConnection();
            //data will be retrieved from the table Customer in database and shown 
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
        
        //declare and intialize print button 
        JB1 = new JButton("Print");
        add(JB1,"South");// print button is placed at the bottom 
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
