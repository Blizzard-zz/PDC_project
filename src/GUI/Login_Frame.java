package GUI;

import GUI.Home_Page;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login_Frame extends JFrame implements ActionListener {
    private JTextField jTextField1;//username
    private JPasswordField jPasswordField;//passward
    private JTextField jTextField2;//port
    private JButton jButton;// login
    private JButton jButton2;// exit
    private JPanel jPanel1;
    private JPanel jPanel2;

    public Login_Frame(){
        frame();
    }

    public void frame(){
        jPanel1 =new JPanel();
        jPanel2 =new JPanel();

        jPanel1.setLayout(null);
        jPanel1.setOpaque(false);
        jPanel1.setSize(600,100);

        JLabel lab1 = new JLabel("welcome to XXX E-sports Hotel");
        Font font = new Font("宋体",Font.BOLD,20);
        lab1.setFont(font);
        lab1.setBounds(50,10, 600,40);

        jPanel1.add(lab1);

        jPanel2.setLayout(null);
        jPanel2.setOpaque(false);
        jPanel2.setSize(600,250);

        Font font1 = new Font("宋体",Font.PLAIN,15);
        JLabel lab2 = new JLabel("user_name:");
        lab2.setBounds(135-50,50,350,20);
        lab2.setFont(font1);

        JLabel lab3 = new JLabel("password:");
        lab3.setBounds(143-50,80,350,20);
        lab3.setFont(font1);
//
//        JLabel lab4 = new JLabel("port:");
//        lab4.setBounds(52,110,350,20);
//        lab4.setFont(font1);

        jTextField1 = new JTextField(10);
        jTextField1.setBounds(220-50,50,160,20);

        jPasswordField = new JPasswordField(10);
        jPasswordField.setBounds(220-50,80,160,20);


//        jTextField2 = new JTextField(10);
//        jTextField2.setBounds(120,110,160,20);

        jButton = new JButton("login");
        jButton.setBounds(123, 145-30, 70 ,25);
        jButton2 = new JButton("register");
        jButton2.setBounds(210, 145-30, 100 ,25);

        JLabel lab5 = new JLabel("If you don't have a count, you need to register first");
        Font font5 = new Font("宋体",Font.BOLD,14);
        lab5.setFont(font5);
        lab5.setBounds(10,150, 600,40);


        jPanel2.add(lab2);
        jPanel2.add(lab3);
//        jPanel2.add(lab4);
        jPanel2.add(lab5);
        jPanel2.add(jTextField1);
      //  jPanel2.add(jTextField2);
        jPanel2.add(jPasswordField);
        jPanel2.add(jButton);
        jPanel2.add(jButton2);

        this.add(jPanel1);
        this.add(jPanel2);
        this.setTitle("XXX E-sports Hotel Reservation :)");
        this.setSize(450,250);
        this.setLocation(300,300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);


        jButton.addActionListener(this);
        jButton2.addActionListener(this);
    }




    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == jButton){
            new Home_Page();
        }
        if(e.getSource() == jButton2){
            new Register_Page();
        }
    }
}
