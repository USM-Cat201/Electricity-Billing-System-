package electricity.billing.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main extends JFrame implements ActionListener{
    String meter;
    Main(String meter, String people){
        super("Electricity Billing System");
        this.meter = meter;
        
        setSize(1300,800);
        
        /* background image */
        ImageIcon IC1 =  new ImageIcon(ClassLoader.getSystemResource("icon/elect1.jpg"));
        Image img3 = IC1.getImage().getScaledInstance(1350, 750,Image.SCALE_DEFAULT);
        ImageIcon IC3 = new ImageIcon(img3);
        JLabel L1 = new JLabel(IC3);
        add(L1);
       
        /* Features Column for admin homepage */
        JMenuBar Jmb  = new JMenuBar();
        JMenu features = new JMenu("Features");
        JMenuItem JM1 = new JMenuItem("Add New Customer");
        JMenuItem JM2 = new JMenuItem("View Customer Information");
        JMenuItem JM4 = new JMenuItem("Calculate Bill");
        features.setForeground(Color.BLACK);
        
        
        /* Add New Customer */
        JM1.setFont(new Font("monospaced",Font.PLAIN,12));
        ImageIcon icon1 = new ImageIcon(ClassLoader.getSystemResource("icon/icon1.png"));
        Image image1 = icon1.getImage().getScaledInstance(20, 20,Image.SCALE_DEFAULT);
        JM1.setIcon(new ImageIcon(image1));
        JM1.setMnemonic('A');
        JM1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, ActionEvent.CTRL_MASK));
        JM1.setBackground(Color.WHITE);
        
        /* View Customer Information */
        JM2.setFont(new Font("monospaced",Font.PLAIN,12));
        ImageIcon icon2 = new ImageIcon(ClassLoader.getSystemResource("icon/icon2.png"));
        Image image2 = icon2.getImage().getScaledInstance(20, 20,Image.SCALE_DEFAULT);
        JM2.setIcon(new ImageIcon(image2));
        JM2.setMnemonic('I');
        JM2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M, ActionEvent.CTRL_MASK));
        JM2.setBackground(Color.WHITE);
        
        /*Calculate Bill*/
        JM4.setFont(new Font("monospaced",Font.PLAIN,12));
        ImageIcon icon5 = new ImageIcon(ClassLoader.getSystemResource("icon/icon5.png"));
        Image image5 = icon5.getImage().getScaledInstance(20, 20,Image.SCALE_DEFAULT);
        JM4.setIcon(new ImageIcon(image5));
        JM4.setMnemonic('C');
        JM4.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B, ActionEvent.CTRL_MASK));
        JM4.setBackground(Color.WHITE);
        
        
        JM1.addActionListener(this);
        JM2.addActionListener(this);
        JM4.addActionListener(this);
    
        
        /* Information column for customer homepage */
        JMenu menu = new JMenu("Information");
        JMenuItem menu1 = new JMenuItem("Renew Information");
        JMenuItem menu2 = new JMenuItem("View Information");
        
        menu.setForeground(Color.RED);
        
        /* Renew Information */
        menu1.setFont(new Font("Times New Roman",Font.PLAIN,12));
        ImageIcon icon41 = new ImageIcon(ClassLoader.getSystemResource("icon/icon4.png"));
        Image image41 = icon41.getImage().getScaledInstance(20, 20,Image.SCALE_DEFAULT);
        menu1.setIcon(new ImageIcon(image41));
        menu1.setMnemonic('R');
        menu1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, ActionEvent.CTRL_MASK));
        menu1.setBackground(Color.WHITE);
        
        /*View Information*/
        menu2.setFont(new Font("Times New Roman",Font.PLAIN,12));
        ImageIcon icon42 = new ImageIcon(ClassLoader.getSystemResource("icon/icon6.png"));
        Image image42 = icon42.getImage().getScaledInstance(20, 20,Image.SCALE_DEFAULT);
        menu2.setIcon(new ImageIcon(image42));
        menu2.setMnemonic('V');
        menu2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, ActionEvent.CTRL_MASK));
        menu2.setBackground(Color.WHITE);
        
        menu1.addActionListener(this);
        menu2.addActionListener(this);
               
        
        /* Bill column for customer homepage */
        JMenu bills = new JMenu("Bill");
        JMenuItem a1 = new JMenuItem("Pay Bill");
        JMenuItem a2 = new JMenuItem("Generate Bill");
        JMenuItem a3 = new JMenuItem("Bill Details");
        bills.setForeground(Color.RED);
        
        /* Pay Bill */
        a1.setFont(new Font("Times New Roman",Font.PLAIN,12));
        ImageIcon icon4 = new ImageIcon(ClassLoader.getSystemResource("icon/icon13.jfif"));
        Image image4 = icon4.getImage().getScaledInstance(20, 20,Image.SCALE_DEFAULT);
        a1.setIcon(new ImageIcon(image4));
        a1.setMnemonic('P');
        a1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, ActionEvent.CTRL_MASK));
        a1.setBackground(Color.WHITE);
        
        /* Generate Bill*/
        a2.setFont(new Font("Times New Roman",Font.PLAIN,12));
        ImageIcon icon7 = new ImageIcon(ClassLoader.getSystemResource("icon/icon7.png"));
        Image image7 = icon7.getImage().getScaledInstance(20, 20,Image.SCALE_DEFAULT);
        a2.setIcon(new ImageIcon(image7));
        a2.setMnemonic('G');
        a2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, ActionEvent.CTRL_MASK));
        a2.setBackground(Color.WHITE);
    
        
        /* Bill Details*/
        a3.setFont(new Font("Times New Roman",Font.PLAIN,12));
        ImageIcon icon6 = new ImageIcon(ClassLoader.getSystemResource("icon/icon6.png"));
        Image image6 = icon6.getImage().getScaledInstance(20, 20,Image.SCALE_DEFAULT);
        a3.setIcon(new ImageIcon(image6));
        a3.setMnemonic('B');
        a3.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, ActionEvent.CTRL_MASK));
        a3.setBackground(Color.WHITE);
        
        a1.addActionListener(this);
        a2.addActionListener(this);
        a3.addActionListener(this);
        
        /* More Functions Column*/
        JMenu utility = new JMenu("More Functions");
        JMenuItem UTI1 = new JMenuItem("Calculator");
        utility.setForeground(Color.RED); 
        
        /* Calculator*/
        UTI1.setFont(new Font("Times New Roman",Font.PLAIN,12));
        ImageIcon IC8 = new ImageIcon(ClassLoader.getSystemResource("icon/icon9.png"));
        Image img8 = IC8.getImage().getScaledInstance(20, 20,Image.SCALE_DEFAULT);
        UTI1.setIcon(new ImageIcon(img8));
        UTI1.setMnemonic('Q');
        UTI1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));
        UTI1.setBackground(Color.WHITE);
 
        UTI1.addActionListener(this);
        
        /*Logout Column */
        JMenu exit = new JMenu("Logout");
        JMenuItem ex = new JMenuItem("Logout");
        exit.setForeground(Color.BLUE);
        
        /* Logout */
        ex.setFont(new Font("Times New Roman",Font.PLAIN,12));
        ImageIcon IC11 = new ImageIcon(ClassLoader.getSystemResource("icon/icon11.png"));
        Image img11 = IC11.getImage().getScaledInstance(20, 20,Image.SCALE_DEFAULT);
        ex.setIcon(new ImageIcon(img11));
        ex.setMnemonic('Z');
        ex.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z, ActionEvent.CTRL_MASK));
        ex.setBackground(Color.WHITE);
        
        ex.addActionListener(this);
        
        
        // ---------------------------------------------------------------------------------------------
               
        
        features.add(JM1);
        features.add(JM2);
        features.add(JM4);
        
        menu.add(menu1);
        menu.add(menu2);
        
        bills.add(a1);
        bills.add(a2);
        bills.add(a3);
        
  
        utility.add(UTI1);

        exit.add(ex);
         
        if(people.equals("Admin")){
            Jmb.add(features);
        }else{             
            Jmb.add(menu);
            Jmb.add(bills);
        }
        Jmb.add(utility);
        Jmb.add(exit);
        
        setJMenuBar(Jmb);    
        
        setFont(new Font("Senserif",Font.BOLD,16));
        setLayout(new FlowLayout());
        setVisible(false);
    }
    public void actionPerformed(ActionEvent ae){
        String str1 = ae.getActionCommand();
        if(str1.equals("View Customer Information")){
            new CustomerInfo().setVisible(true);
            
        }else if(str1.equals("Add New Customer")){
            new AddNewCustomer().setVisible(true);
            
        }else if(str1.equals("Calculate Bill")){
            new BillsCalculation().setVisible(true);
            
        }else if(str1.equals("Pay Bill")){
            new BillPay(meter).setVisible(true);
           
        }else if(str1.equals("Calculator")){
            try{
                Runtime.getRuntime().exec("calc.exe");
            }catch(Exception e){ }
        }else if(str1.equals("Logout")){
            this.setVisible(false);
            new Login().setVisible(true);
        }else if (str1.equals("Generate Bill")){
            new BillGenerator(meter).setVisible(true);            
        }else if(str1.equals("View Information")){
            new DisplayInformation(meter).setVisible(true);
        }else if(str1.equals("Renew Information")){
            new RenewInformation(meter).setVisible(true);
        }else if(str1.equals("Bill Details")){
            new BillsInformation(meter).setVisible(true);
        }
        
        
    }
    
    
    public static void main(String[] args){
        new Main("", "").setVisible(true);
    }
    
}
