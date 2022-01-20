/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package electricity.billing.system;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.border.Border;

public class ElectricityBillingSystem extends JFrame implements ActionListener {
    Font font, font1, font2;
    TextArea TA1;
    JButton JB1;
    JLabel JL1;
    String str;

    public ElectricityBillingSystem() {

        setLayout(null);
        JButton JB1 = new JButton("Close");
        add(JB1);
        JB1.setBounds(180, 430, 120, 20);
        JB1.addActionListener(this);

        Font F = new Font("Helvetica", Font.BOLD, 180);
        setFont(F);

        str = "                        About CAT201 Projects"
                + "\nElectricity Billing System is a desktop-based application "
                + "developed in Java programming language. "
                + "\n"
                + "\nGroup Members : "
                + "\nTan Jia Wei 153772"
                + "\nTan Pei Yi 152802"
                + "\nWai Yi Min  153945"
                + "\nLee Joe Xuen 154277"
                + "\nThis project is for assignment purpose.";

        TextArea TA1 = new TextArea(str, 10, 40, Scrollbar.VERTICAL);
        TA1.setEditable(false);
        TA1.setBounds(20, 100, 450, 300);

        add(TA1);

        Font font1 = new Font("Times New Roman", Font.BOLD, 16);
        TA1.setFont(font1);

        Container contentPane = this.getContentPane();
        TA1= new TextArea();

        JLabel JL1 = new JLabel("CAT201 Project");
        add(JL1);
       JL1.setBounds(170, 10, 200, 100);
       JL1.setForeground(Color.red);

        Font font2 = new Font("Times New Roman", Font.BOLD, 20);
        JL1.setFont(font2);

        setBounds(700, 220, 500, 550);

        setLayout(null);
        setVisible(true);
        
    }

    public void actionPerformed(ActionEvent e) {
        dispose();
    }

    public static void main(String args[]) {
        new ElectricityBillingSystem().setVisible(true);
    }

}