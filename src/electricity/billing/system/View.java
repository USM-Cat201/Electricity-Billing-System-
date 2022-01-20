/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package electricity.billing.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class View {
    public static void main(String[] args){
        fframe FR1 = new fframe();
        FR1.setVisible(true);
        int i;
        int y=1;
        for(i=2; i<=600; i+=4, y+=1){
            FR1.setLocation(800 - ((i+y)/2), 500 - (i/2));
            FR1.setSize(i+y,i);
            try{
                Thread.sleep(10);
            }catch(Exception e){}
        }
        
    }
}
class fframe extends JFrame implements Runnable{
    Thread TH1;
    fframe(){
        super("Electric Billing Software");
        setLayout(new FlowLayout());
        ImageIcon IC1 = new ImageIcon(ClassLoader.getSystemResource("icon/elect.jpg"));
        Image img1 = IC1.getImage().getScaledInstance(730, 550,Image.SCALE_DEFAULT);
        ImageIcon IC2 = new ImageIcon(img1);
        
        
        JLabel JL1 = new JLabel(IC2);
        add(JL1);
        TH1 = new Thread(this);
        TH1.start();
    }
    public void run(){
        try{
            Thread.sleep(100);
            this.setVisible(false);
            
            Login l = new Login();
            l.setVisible(true);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}