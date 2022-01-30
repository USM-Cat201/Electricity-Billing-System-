/*class for sign up function*/
package electricity.billing.system;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;

public class Signup extends JFrame implements ActionListener{
    JPanel JP1;//declare panel JP1
    JTextField JT1, JT2, JT3, JT4;//declare textfield JT1 TO JT4
    Choice C1;//declare choice C1
    JButton JB1, JB2;//declare button JB1 and JB2

    Signup(){

        //setbounds(int x, int y, int width, int height)
        setBounds(600, 250, 750, 400);
       
        JP1 = new JPanel();
        //set the size of panel
        JP1.setBounds(30, 30, 650, 300);
        JP1.setLayout( null);
        //set background color and font color
        JP1.setBackground(new Color(255,240,223));
        JP1.setForeground(new Color(34, 139, 34));
        //set the design of title
        JP1.setBorder(new TitledBorder(new LineBorder(new Color(173, 216, 230), 2), "Create Account", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 139)));
        add(JP1);

        //declare and initialize username
        JLabel JL1 = new JLabel("Username:");
        //set the font color of username 
        JL1.setForeground(Color.DARK_GRAY);
        //set font style 
        JL1.setFont(new Font("Times New Roman", Font.BOLD, 14));
        JL1.setBounds(100, 50, 100, 20);
        JP1.add(JL1);
        //declare and initialize textfield for input of username
        JT1 = new JTextField();
        JT1.setBounds(260, 50, 150, 20);
        JP1.add(JT1);
        
        //declare and initialize name 
        JLabel JL2 = new JLabel("Name: ");
        JL2.setForeground(Color.DARK_GRAY);
        JL2.setFont(new Font("Times New Roman", Font.BOLD, 14));
        JL2.setBounds(100, 90, 110, 20);
        JP1.add(JL2);
        //declare and initialize textfield for input of name
        JT2 = new JTextField();
        JT2.setBounds(260, 90, 150, 20);
        JP1.add(JT2);
        
        //declare and initialize password
        JLabel JL3 = new JLabel("Password: ");
        JL3.setForeground(Color.DARK_GRAY);
        JL3.setFont(new Font("Times New Roman", Font.BOLD, 14));
        JL3.setBounds(100, 130, 150, 20);
        JP1.add(JL3);
        //declare and initialize textfield for input of password
        JT3 = new JTextField();
        JT3.setBounds(260, 130, 150, 20);
        JP1.add(JT3);
        
        //declare and initialize type of account created either admin or customer
        JLabel JL4 = new JLabel("Create Account As: ");
        JL4.setForeground(Color.DARK_GRAY);
        JL4.setFont(new Font("Times New Roman", Font.BOLD, 14));
        JL4.setBounds(100, 170, 140, 20);
        JP1.add(JL4);
        
        //declare and initialize meter number
        JLabel JL5 = new JLabel("Meter Number:");
        JL5.setForeground(Color.DARK_GRAY);
        JL5.setFont(new Font("Times New Roman", Font.BOLD, 14));
        JL5.setBounds(100, 210, 100, 20);
        JL5.setVisible(false);
        JP1.add(JL5);
        //declare and initialize textfield for input of meter number
        JT4 = new JTextField();
        JT4.setBounds(260, 210, 150, 20);
        JT4.setVisible(false);
        JP1.add(JT4);
        
       
        //declare and initialize choice either admin or customer
        C1 = new Choice();
        C1.add("Admin");
        C1.add("Customer");
        C1.setBounds(260, 170, 150, 20);
        JP1.add(C1);
        
        C1.addItemListener(new ItemListener(){
           public void itemStateChanged(ItemEvent ae){
               String user = C1.getSelectedItem();
               if(user.equals("Customer")){
                   JL5.setVisible(true);
                   JT4.setVisible(true);
               }else{
                   JL5.setVisible(false);
                   JT4.setVisible(false);
               }
           } 
        });
        
        //declare and initialize create button
        JB1 = new JButton("Create");
        JB1.setBackground(new Color(0,0,139));
        JB1.setForeground(Color.WHITE);
        JB1.setBounds(140, 290, 120, 30);
        JB1.addActionListener(this);
        JB1.setFont(new Font("Times New Roman",Font.PLAIN,15));
        JP1.add(JB1);
        //declare and initialize return button
        JB2 = new JButton("Return");
        JB2.setBackground(Color.DARK_GRAY);
        JB2.setForeground(Color.WHITE);
        JB2.setBounds(300, 290, 120, 30);
        JB2.addActionListener(this);
        JB2.setFont(new Font("Times New Roman",Font.PLAIN,15));
        JP1.add(JB2);
        
        //insert image to ease the understanding of user
        ImageIcon IC1 = new ImageIcon(ClassLoader.getSystemResource("icon/signupImage.png"));
        Image img2 = IC1.getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT);
        ImageIcon IC3 = new ImageIcon(img2);
        JLabel JL6 = new JLabel(IC3);
        JL6.setBounds(450, 30, 250, 250);
        JP1.add(JL6);
    }
    
    public void actionPerformed(ActionEvent ae){
        //if user press create button
        if(ae.getSource() == JB1){
            String username = JT1.getText();
            String fullname = JT2.getText();
            String password = JT3.getText();
            String usertype = C1.getSelectedItem();
            String meter_number = JT4.getText();
            try{
                DBConnection C = new DBConnection();
                String str = null;
                if(usertype.equals("Admin")){
                    //if user choose as admin, meter_number, username,fullname, password and user type will be inserted
                    str = "insert into login values('"+meter_number+"', '"+username+"', '"+fullname+"', '"+password+"', '"+usertype+"')";
                }else{
                    //if the option is customer
                    str = "update login set username = '"+username+"', fullname = '"+fullname+"',password = '"+password+"', usertype = '"+usertype+"' where meter_number = '"+JT4.getText()+"'";
                }
                
                C.s.executeUpdate(str);
                JOptionPane.showMessageDialog(null, "Account is successfully created! ");//message displayed
                this.setVisible(false);
                new Login().setVisible(true);
            }catch(Exception e){
                
            }
        } else if(ae.getSource()== JB2){
            this.setVisible(false);
            new Login().setVisible(true);
        }
    }
    
    public static void main(String[] args){
        new Signup().setVisible(true);
    }
}

