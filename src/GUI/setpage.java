package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class setpage extends JFrame {
    public static roomlist roomlist1;
    static ArrayList<roomtype> roomlist2 = new ArrayList<>();


    JLabel jLabel;//title
    JLabel jLabel1;//username
    JLabel jLabel2;//password
    JLabel jLabel3;//phone number
    JLabel jLabel4;//Employee registration code
    JPanel jPanel1;

    JComboBox jComboBox;
    JButton jButton2;
    JButton jButton3;
    JButton jButton4;
    JButton jButton5;
    JButton jButton6;

    public static client client1 = new client();

    //    public static employeer staff1=new employeer();
    public setpage() {
        jPanel1 = new JPanel();
        jPanel1.setOpaque(false);
        jPanel1.setSize(600, 600);

        roomlist1 = new roomlist();

        roomlist2 = roomlist1.show();
        //这边设置个循环读取，把for循环改成while循环

        jPanel1.setLayout(null);
        for (int i = 0; i < roomlist2.size(); i++) {
            String show = roomlist2.get(i).roomtypename + "     " + roomlist2.get(i).roomunmber;
            jLabel = new JLabel(show);
            Font font = new Font("宋体", Font.BOLD, 20);
            jLabel.setFont(font);
            jLabel.setBounds(50, 10 + i * 40, 600, 40);
            jPanel1.add(jLabel);

            jButton5 = new JButton("view the picture");
            jPanel1.add(jButton5);
            jButton5.setBounds(200, 10 + i * 40, 200, 40);

            jButton6 = new JButton("set the picture");
            jPanel1.add(jButton6);
            jButton6.setBounds(400, 10 + i * 40, 200, 40);
            listerner3();
        }
        jButton2 = new JButton("add roomtype");
        jPanel1.add(jButton2);
        jButton2.setBounds(100, 500, 200, 40);

        jButton4 = new JButton("Refresh");
        jPanel1.add(jButton4);
        jButton4.setBounds(300, 500, 200, 40);

        jButton3 = new JButton("delate roomtype");
        jPanel1.add(jButton3);
        jButton3.setBounds(500, 500, 200, 40);


        listerner1();
        listerner2();


        this.add(jPanel1);

        this.setTitle("room type information");
        this.setSize(800, 600);
        this.setVisible(true);


    }


    public void listerner1() {

        jButton4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jPanel1.removeAll();
                jPanel1.updateUI();

            }
        });


    }

    public void listerner2() {

        jButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                settypr setpage1 = new settypr();


            }
        });


    }

    public void listerner3() {

        jButton6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openpicture picture = new openpicture();
                String typename = jLabel.getText();
                picture.init(typename);

            }
        });


    }


}