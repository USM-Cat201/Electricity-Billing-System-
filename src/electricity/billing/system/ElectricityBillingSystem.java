/*this is not a function class but only a breif description of our system*/
package electricity.billing.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.border.Border;

public class ElectricityBillingSystem extends JFrame implements ActionListener {
    Font font, font1, font2;//declare 3 fonts font, font1 and font2
    TextArea TA1;//declare text area TA1
    JButton JB1;//declare button JB1
    JLabel JL1;//declare label JL1
    String str;//declare string str

    public ElectricityBillingSystem() {

        setLayout(null);
        JButton JB1 = new JButton("Close");//initialize close button
        add(JB1);
        JB1.setBounds(180, 430, 120, 20);
        JB1.addActionListener(this);

        Font F = new Font("Helvetica", Font.BOLD, 180);
        setFont(F);
        //show the message of the CAT201 Project

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
