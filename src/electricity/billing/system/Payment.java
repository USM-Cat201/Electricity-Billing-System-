/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package electricity.billing.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Payment extends JFrame implements ActionListener{
    String meter;
    JButton JB1;
    Payment(String meter){
        this.meter = meter;
        JEditorPane JEP = new JEditorPane();
        JEP.setEditable(false);   
        
        JB1 = new JButton("Return");
        JB1.setBackground(Color.DARK_GRAY);
        JB1.setForeground(Color.WHITE);
        JB1.setBounds(500, 20, 120, 25);
        JB1.addActionListener(this);
        JB1.setFont(new Font("Times New Roman",Font.PLAIN,15));
        JEP.add(JB1);

        try {
            JEP.setPage("https://www.tnb.com.my/residential/payment-methods");
        }catch (Exception e) {
            JEP.setContentType("text/html");
            JEP.setText("<html>Could not load</html>");
        } 

        JScrollPane scrollPane = new JScrollPane(JEP);     
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().add(scrollPane);
        setPreferredSize(new Dimension(800,600));
        setSize(800,800);
        setLocation(250,120);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        this.setVisible(false);
        new BillPay(meter).setVisible(true);
    }
    public static void main(String[] args){
        new Payment("").setVisible(true);
    }
}

