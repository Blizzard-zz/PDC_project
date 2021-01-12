package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Register_Page extends JFrame implements ActionListener {
    JLabel jLabel;//title
    JLabel jLabel1;//username
    JLabel jLabel2;//password
    JLabel jLabel3;//phone number
    JLabel jLabel4;//Employee registration code
    JPanel jPanel1;
    JComboBox jComboBox;
    JButton jButton1;
    JTextField jTextField1;//username
    JTextField jTextField2;//password
    JTextField jTextField3;//phone number
    JTextField jTextField4;//Employee registration code

    public Register_Page(){
        jPanel1 = new JPanel();
        jPanel1.setLayout(null);
        jPanel1.setOpaque(false);
        jPanel1.setSize(600,600);

        jLabel = new  JLabel("XXX E-sports hotel register");
        Font font = new Font("宋体",Font.BOLD,20);
        jLabel.setFont(font);
        jLabel.setBounds(50,10, 600,40);

        String options[] = {"customer","staff"};
        jComboBox = new JComboBox(options);
        jComboBox.setBounds(50,100,100,20);

        jLabel1 = new JLabel("Username");
        jLabel1.setBounds(50,150,100,10);

        jLabel2 = new JLabel("Password");
        jLabel2.setBounds(50,250,100,10);

        jLabel3 = new JLabel("Phone");
        jLabel3.setBounds(50,350,100,10);

        jLabel4 = new JLabel("Employee registration code");
        jLabel4.setBounds(50,450,100,10);


        jTextField1 = new JTextField(10);
        jTextField1.setBounds(150,150,200,20);

        jTextField2 = new JTextField(10);
        jTextField2.setBounds(150,250,200,20);

        jTextField3 = new JTextField(10);
        jTextField3.setBounds(150,350,200,20);

        jTextField4 = new JTextField(10);
        jTextField4.setBounds(150,450,200,20);

        jButton1 = new JButton("submit");
        jButton1.setBounds(150,500,100,30);


        jPanel1.add(jLabel);
        jPanel1.add(jComboBox);
        jPanel1.add(jLabel1);
        jPanel1.add(jLabel2);
        jPanel1.add(jLabel3);
        jPanel1.add(jLabel4);

        jPanel1.add(jTextField1);
        jPanel1.add(jTextField2);
        jPanel1.add(jTextField3);
        jPanel1.add(jTextField4);
        jPanel1.add(jButton1);

        this.add(jPanel1);

        this.setTitle("Register_Page");
        this.setSize(430,600);
        this.setVisible(true);

    }




    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
