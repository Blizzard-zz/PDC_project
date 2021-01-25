package GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class settypr extends JFrame {
    public static hotel roomlist1;
    static ArrayList<roomtype> roomlist2 = new ArrayList<>();


    JLabel jLabel;//title
    JLabel jLabel1;//username
    JLabel jLabel2;//password
    JLabel jLabel3;//phone number
    JLabel jLabel4;//Employee registration code

    JPanel jPanel1;
    JButton[] b;
    JLabel[] a;
    JTextArea[] c;
    JButton[] d;


    JTextField jTextField1;
    JTextField jTextField2;
    JTextField jTextField3;
    JTextField jTextField4;

    JTextArea textArea;


    JButton jButton1;
    JButton jButton2;
    JButton jButton3;
    JButton jButton4;
    JButton jButton5;

    //    public static employeer staff1 = new employeer();

    public settypr() {
        jPanel1 = new JPanel();
        jPanel1.setOpaque(false);
        jPanel1.setSize(600, 600);


        jPanel1.setLayout(null);

        jLabel1 = new JLabel("type name");
        jLabel1.setBounds(100, 100, 100, 40);

        jLabel2 = new JLabel("the floor");
        jLabel2.setBounds(100, 200, 100, 40);

        jLabel3 = new JLabel("describe");
        jLabel3.setBounds(100, 300, 100, 40);

        jLabel4 = new JLabel("room number");
        jLabel4.setBounds(100, 400, 100, 40);


        jTextField1 = new JTextField(10);
        jTextField1.setBounds(300, 100, 200, 30);

        jTextField2 = new JTextField(10);
        jTextField2.setBounds(300, 200, 200, 30);

        textArea = new JTextArea(3, 10);
        textArea.setLineWrap(true);
        textArea.setBounds(300, 300, 200, 68);


        //jTextField3 = new JTextField(10);
        //jTextField3.setBounds(300,300,200,40);

        jTextField4 = new JTextField(10);
        jTextField4.setBounds(300, 400, 200, 30);

        jButton1 = new JButton("add the picture");
        jButton1.setBounds(150, 500, 200, 30);


        jPanel1.add(jLabel1);
        jPanel1.add(jLabel2);
        jPanel1.add(jLabel3);
        jPanel1.add(jLabel4);

        jPanel1.add(jButton1);

        jPanel1.add(textArea);


        jPanel1.add(jTextField1);
        jPanel1.add(jTextField2);
        //jPanel1.add(jTextField3);
        jPanel1.add(jTextField4);
        listerner1();
        this.add(jPanel1);
        listerner1();

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setTitle("room type set");
        this.setSize(800, 600);
        this.setVisible(true);


    }


    public void listerner1() {

        jButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //openpicture  picture =new openpicture();

                //picture.init();

            }
        });


    }


//    public void listerner2() {
//
//        jButton5.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                usepage setpage1 = new usepage();
//
//
//            }
//        });
//
//
//    }


}