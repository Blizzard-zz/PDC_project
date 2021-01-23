package GUI;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Login_Frame extends JFrame {
    private JTextField jTextField1;//username
    private JPasswordField jPasswordField;//passward


    private JButton jButton;// login
    private JButton jButton2;// exit
    private JPanel jPanel1;
    private JPanel jPanel2;


    JLabel lab1;
    JLabel lab2;
    JLabel lab3;
    JLabel lab5;

    JCheckBox checkBox01;


    public Login_Frame() {

        frame();
    }

    public void frame() {


        jPanel1 = new JPanel();
        jPanel2 = new JPanel();

        jPanel1.setLayout(null);
        jPanel1.setOpaque(false);
        jPanel1.setSize(600, 100);

        JLabel lab1 = new JLabel("welcome to XXX E-sports Hotel");
        Font font = new Font("宋体", Font.BOLD, 20);
        lab1.setFont(font);
        lab1.setBounds(50, 10, 600, 40);

        jPanel1.add(lab1);

        jPanel2.setLayout(null);
        jPanel2.setOpaque(false);
        jPanel2.setSize(600, 250);

        Font font1 = new Font("宋体", Font.PLAIN, 15);
        JLabel lab2 = new JLabel("user_name:");
        lab2.setBounds(135 - 50, 50, 350, 20);
        lab2.setFont(font1);

        JLabel lab3 = new JLabel("password:");
        lab3.setBounds(143 - 50, 80, 350, 20);
        lab3.setFont(font1);

        jTextField1 = new JTextField(10);
        jTextField1.setBounds(220 - 50, 50, 160, 20);


        jPasswordField = new JPasswordField(10);
        jPasswordField.setBounds(220 - 50, 80, 160, 20);


        jButton = new JButton("login");
        jButton.setBounds(123, 145 - 30, 70, 25);

        jButton2 = new JButton("register");
        jButton2.setBounds(210, 145 - 30, 100, 25);


        checkBox01 = new JCheckBox("staff");
        checkBox01.setBounds(320, 100, 60, 60);


        JLabel lab5 = new JLabel("If you don't have a count, you need to register first");
        Font font5 = new Font("宋体", Font.BOLD, 14);
        lab5.setFont(font5);
        lab5.setBounds(10, 150, 600, 40);


        jPanel2.add(lab2);
        jPanel2.add(lab3);

        jPanel2.add(lab5);
        jPanel2.add(jTextField1);

        jPanel2.add(jPasswordField);
        jPanel2.add(jButton);
        jPanel2.add(jButton2);

        jPanel2.add(checkBox01);

        this.add(jPanel1);
        this.add(jPanel2);

        listerner1();
        this.setTitle("XXX E-sports Hotel Reservation :)");

        this.setSize(450, 250);


        this.setLocation(300, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);


    }

    public void listerner1() {

        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (checkBox01.isSelected())
                    System.out.println(1);
                else
                    System.out.println(2);
            }
        });


    }

    public void listerner2() {

        jButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jPanel1.removeAll();
                jPanel1.updateUI();

            }
        });

    }


    public static void main(String[] args) {


        Login_Frame login = new Login_Frame();


    }


}




