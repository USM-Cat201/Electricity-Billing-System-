
/*this is the class for displaying bill information in a table form*/
package electricity.billing.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;

public class BillsInformation extends JFrame{
 
    JTable JT1;//declare table JT1
    //declare and initialize string meter number, month, units used, total amount of bills and payment status
    String x[] = {"Meter No","Month","Units used per month ","Total Amount of bills "," Payment Status"};
    String y[][] = new String[40][8];
    int i=0, j=0;
    BillsInformation(String meter){
        super("Bills");
        //set the size of panel
        setSize(900,650);
        setLocation(500,250);
        setLayout(null);
        getContentPane().setBackground(Color.LIGHT_GRAY);//set the background of panel as light gray
        
        JT1 = new JTable(y,x);//initialize JT1
        
        try{
            DBConnection c  = new DBConnection();
            String str1 = "select * from electricBill where meter = " + meter;
            ResultSet rs  = c.s.executeQuery(str1);
            
            JT1.setModel(DbUtils.resultSetToTableModel(rs));
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        
        JScrollPane span = new JScrollPane(JT1);
        span.setBounds(50, 50, 700, 450);
        add(span);
        
    }
    
    public static void main(String[] args){
        new BillsInformation("").setVisible(true);
    }
    
}
