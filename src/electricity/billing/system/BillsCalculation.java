/*this is the class for bill calculation function in admin homepage*/
package electricity.billing.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class BillsCalculation extends JFrame implements ActionListener{
    JLabel JL1,JL2,JL3,JL4,JL5; //declare FIVE labels from JL1 to JL5
    JTextField TF1; //declare one text field TF1
    Choice C1,C2; //declare two choices C1 and C2
    JButton JB1,JB2; //declare two buttons JB1 and JB2
    JPanel JP; //declare panel
    BillsCalculation(){
        
        //Display background of the BillsCalculation page.
        JP = new JPanel();
        JP.setLayout(null);
        JP.setBackground (new Color(255,253,208));
        
        //Display the text "Electricity Bills Calculations"
        JL1 = new JLabel("Electricity Bills Calculations");
        JL1.setBounds(30, 10, 400, 50);
        JL1.setForeground(new Color(0,0,138));
                
        //Display the text "Meter No"        
        JL2 = new JLabel("Meter No");
        JL2.setBounds(60, 70, 120, 30); 
        JL2.setFont(new Font("Times New Roman",Font.PLAIN,15));
        
        //Display the text "Customer Name"
        JLabel L6 = new JLabel("Customer Name");
        L6.setBounds(60, 120, 120, 30);
        L6.setFont(new Font("Times New Roman",Font.PLAIN,15));
        
        //Display the text "Customer Address"
        JLabel L7 = new JLabel("Customer Address");
        L7.setBounds(60, 170, 120, 30);
        L7.setFont(new Font("Times New Roman",Font.PLAIN,15));
        
        //Display the text "Month"
        JL3 = new JLabel("Month");
        JL3.setBounds(60, 220, 120, 30);
        JL3.setFont(new Font("Times New Roman",Font.PLAIN,15));
        
        //Display the text "Unit used per month"
        JL5 = new JLabel("Unit used per month");
        JL5.setBounds(60, 270, 140, 30);
        JL5.setFont(new Font("Times New Roman",Font.PLAIN,15));
        
        //Get the customer meter_number from database and let the admin choose
        C1 = new Choice();
        C1.setBounds(200, 75, 180, 30);
        try{
            DBConnection c = new DBConnection();
            ResultSet rs = c.s.executeQuery("select * from customer");
            while(rs.next()){
                C1.add(rs.getString("customer_meter"));
            }
        }catch(Exception e){}
        
        JLabel L11 = new JLabel();
        L11.setBounds(200, 124, 180, 20);
        JP.add(L11);
        
        JLabel L12 = new JLabel();
        L12.setBounds(200, 174, 180, 20);
        JP.add(L12);
        
        //Display the name and address of the customer from database that admin choose from customer meter number
        try{
            DBConnection c = new DBConnection();
            ResultSet rs = c.s.executeQuery("select * from customer where customer_meter = '"+C1.getSelectedItem()+"'");
            while(rs.next()){
                L11.setText(rs.getString("customer_name"));
                L12.setText(rs.getString("customer_address"));
            }
        }catch(Exception e){}
        
        
        C1.addItemListener(new ItemListener(){
            public void itemStateChanged(ItemEvent ae){
                try{
                    DBConnection c = new DBConnection();
                    ResultSet rs = c.s.executeQuery("select * from customer where customer_meter = '"+C1.getSelectedItem()+"'");
                    while(rs.next()){
                        L11.setText(rs.getString("customer_name"));
                        L12.setText(rs.getString("customer_address"));
                    }
                }catch(Exception e){}
            }
        });
        
        TF1 = new JTextField();
        TF1.setBounds(200, 274, 180, 20);
        
        //Choose the month that wanted to enter the unit used.
        C2 = new Choice();
        C2.setBounds(200, 224, 180, 20);
        C2.add("January");
        C2.add("February");
        C2.add("March");
        C2.add("April");
        C2.add("May");
        C2.add("June");
        C2.add("July");
        C2.add("August");
        C2.add("September");
        C2.add("October");
        C2.add("November");
        C2.add("December");
        
        //Display the "Proceed" and "Cancel" button. 
        //The units_used by customer will added to database if "Proceed" is clicked
        JB1 = new JButton("Proceed");
        JB1.setBounds(110, 360, 110, 30);
        JB2 = new JButton("Cancel");
        JB2.setBounds(240, 360, 110, 30);
        
        JB1.setBackground(new Color(0,0,139));
        JB1.setForeground(Color.WHITE);
        JB1.setFont(new Font("Times New Roman",Font.PLAIN,15));

        JB2.setBackground(Color.WHITE);
        JB2.setForeground(Color.BLACK);
        JB2.setFont(new Font("Times New Roman",Font.PLAIN,15));
        
        //Display the icon 
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/hicon2.png"));
        Image i2 = i1.getImage().getScaledInstance(180, 230,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JL4 = new JLabel(i3);
        
        
        
        JL1.setFont(new Font("Helvetica",Font.PLAIN,30));
        //Move the label to center
        JL1.setHorizontalAlignment(JLabel.CENTER);
        
        
        JP.add(JL1);
        JP.add(JL2);
        JP.add(L6);
        JP.add(L7);
        JP.add(C1);
        JP.add(JL5);
        JP.add(C2);
        JP.add(JL3);
        JP.add(TF1);
        JP.add(JB1);
        JP.add(JB2);
        
        setLayout(new BorderLayout(5,40));
        
        
        add(JP,"Center");
        add(JL4,"East");
        
        
        JB1.addActionListener(this);
        JB2.addActionListener(this);
        
        getContentPane().setBackground(new Color(173,216,230));        
        setSize(750,500);
        setLocation(300,100);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == JB1){
            String meter = C1.getSelectedItem();
            String units_used = TF1.getText();
            String months = C2.getSelectedItem();

            //Declare the variables
            int units_consumed = Integer.parseInt(units_used);

            float bill_amount = 0.0f;
            float total_amount_1;
            float total_amount_2;
            float total_amount_3;
            
            //Demonstrate the calculation of total amount of bill_amount
            try{
                DBConnection c = new DBConnection();
                ResultSet rs = c.s.executeQuery("select * from taxes");
                while(rs.next()){
                    total_amount_1 = units_consumed * Float.parseFloat(rs.getString("cost_per_unit")); // 120 * 7
                    total_amount_1 += Float.parseFloat(rs.getString("rental_meter"));
                    total_amount_2 = total_amount_1 * Float.parseFloat(rs.getString("service_tax"));
                    total_amount_3 = total_amount_1 * Float.parseFloat(rs.getString("KWTBB"));
                    bill_amount = total_amount_1 + total_amount_2 + total_amount_3;
                }
            }catch(Exception e){}

            String q = "insert into electricBill values('"+meter+"','"+months+"','"+units_used+"','"+bill_amount+"', 'Not Paid')";

            try{
                DBConnection c1 = new DBConnection();
                c1.s.executeUpdate(q);
                JOptionPane.showMessageDialog(null,"Electric bill succesfully updated");
                this.setVisible(false);
            }catch(Exception aee){
                aee.printStackTrace();
            }

        }else if(ae.getSource()== JB2){
            this.setVisible(false);
        }        
    }
    
       
    public static void main(String[] args){
        
        new BillsCalculation().setVisible(true);
    }
}
