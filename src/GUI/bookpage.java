package GUI;

import database.create_table;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class bookpage extends JFrame {
    public static hotel roomlist1;
    static ArrayList<roomtype> roomlist2 = new ArrayList<>();
    JFrame frame;
    create_table table;
    JComboBox edicb;
    JComboBox edicb1;
    JComboBox edicb2;
    JComboBox edicb3;


    JLabel jLabel;

    JLabel jLabel1;
    JLabel jLabel2;
    JLabel jLabel3;
    JLabel jLabel4;
    JLabel jLabel5;
    JLabel jLabel6;
    JLabel jLabel7;

    JButton[] b;
    JLabel[] a;
    JTextArea[] c;
    JButton[] d;


    JPanel jPanel1;


    JPanel jPanel2;


    JButton jButton2;
    JButton jButton3;
    JButton jButton6;
    JButton jlabel3;

    JTextArea textArea1;
    JTextArea textArea2;
    JTextArea textArea3;
    JTextArea textArea4;


    JScrollPane scrollPane;
    JScrollPane scrollPane1;

    String room_type_name;
    String hotel_name;

    public bookpage(String typenmae, String hotel_name) {
        table = new create_table();
        this.room_type_name = typenmae;
        this.hotel_name = hotel_name;
        frame = new JFrame();
        jPanel1 = new JPanel();
        jPanel1.setPreferredSize(new Dimension(500, 500));

        Font font = new Font("宋体", Font.BOLD, 20);


        jPanel1.setLayout(null);


        jLabel5 = new JLabel("Check in date:");
        jLabel5.setBounds(50, 50, 100, 20);

        jPanel1.add(jLabel5);

        edicb = new JComboBox();
        edicb.addItem("January");
        edicb.addItem("February");
        edicb.addItem("March");
        edicb.addItem("April");
        edicb.addItem("May");
        edicb.addItem("June");
        edicb.addItem("July");
        edicb.addItem("August");
        edicb.addItem("September");
        edicb.addItem("October");
        edicb.addItem("November");
        edicb.addItem("December");


        edicb.setBounds(50, 70, 100, 20);


        jPanel1.add(edicb);


        edicb1 = new JComboBox();
        for (int i = 1; i <= 31; i++)
            edicb1.addItem(i);

        edicb1.setBounds(150, 70, 100, 20);


        jPanel1.add(edicb1);


        jLabel6 = new JLabel("Check out date:");
        jLabel6.setBounds(50, 120, 100, 20);

        jPanel1.add(jLabel6);


        edicb2 = new JComboBox();
        edicb2.addItem("January");
        edicb2.addItem("February");
        edicb2.addItem("March");
        edicb2.addItem("April");
        edicb2.addItem("May");
        edicb2.addItem("June");
        edicb2.addItem("July");
        edicb2.addItem("August");
        edicb2.addItem("September");
        edicb2.addItem("October");
        edicb2.addItem("November");
        edicb2.addItem("December");

        edicb2.setBounds(50, 150, 100, 20);
        jPanel1.add(edicb2);


        edicb3 = new JComboBox();
        for (int i = 1; i <= 31; i++)
            edicb3.addItem(i);

        edicb3.setBounds(150, 150, 100, 20);
        jPanel1.add(edicb3);


        jLabel1 = new JLabel("Room Number:");
        jLabel1.setBounds(50, 200, 150, 20);


        textArea1 = new JTextArea("1");
        textArea1.setBounds(200, 200, 100, 30);


        jLabel2 = new JLabel("Resident Name:");
        jLabel2.setBounds(50, 250, 150, 20);


        //读取用户首姓名和尾姓名
        String name = "";
        textArea2 = new JTextArea(name);
        textArea2.setBounds(200, 250, 100, 30);

        jLabel3 = new JLabel("Cell-phone Number:");
        jLabel3.setBounds(50, 300, 150, 20);


        //读取用户电话号码
        String phonenumber = "";
        textArea3 = new JTextArea(phonenumber);
        textArea3.setBounds(200, 300, 100, 30);


        jLabel4 = new JLabel("Please check in after 2 pm. Thank you");
        jLabel4.setBounds(10, 330, 500, 50);
        jLabel4.setFont(font);

        jButton2 = new JButton("confirm");
        jButton2.setBounds(40, 400, 130, 30);
        jButton2.setFont(new Font("Calibri", Font.BOLD, 22));


        jPanel1.add(jButton2);


        jButton3 = new JButton("exit");
        jButton3.setBounds(350, 400, 75, 30);
        jButton3.setFont(new Font("Calibri", Font.BOLD, 22));


        jPanel1.add(jButton3);


        jPanel1.add(jLabel1);
        jPanel1.add(textArea1);

        jPanel1.add(jLabel2);
        jPanel1.add(textArea2);

        jPanel1.add(jLabel3);
        jPanel1.add(textArea3);

        jPanel1.add(jLabel4);


        frame.add(jPanel1);

        listerner1();
        listerner2();

        frame.setTitle("Make a room reservation");
        frame.setSize(500, 500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLocation(500, 200);
        frame.setVisible(true);


        edicb.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {

                    int data = changedate(edicb.getSelectedIndex());
                    edicb1.removeAllItems();

                    for (int i = 0; i < data; i++) {
                        edicb1.addItem(String.valueOf(i + 1));

                    }
                    jPanel1.updateUI();

                }
            }
        });


        edicb2.addItemListener(new ItemListener() {

            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {

                    int data = changedate(edicb2.getSelectedIndex());
                    edicb3.removeAllItems();
                    for (int i = 0; i < data; i++) {
                        edicb3.addItem(String.valueOf(i + 1));

                    }

                    jPanel1.updateUI();
                }
            }
        });


    }


    public void listerner1() {

        jButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int month = edicb.getSelectedIndex();
                int specificdate = edicb1.getSelectedIndex();

                int month1 = edicb2.getSelectedIndex();
                int specificdate1 = edicb3.getSelectedIndex();

                if (month > month1) {
                    int option2 = JOptionPane.showConfirmDialog(null, "You have chosen the wrong date", "提交提示", JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);
                } else {
                    int date = (month1 - month) * 30 + specificdate1 - specificdate;
                    int option = JOptionPane.showConfirmDialog(null, "You have a reservation for " + String.valueOf(date) + " days", "提交提示", JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);

                    if (option == 2) {

                    } else {

                        //存入数据
                        int input_number = Integer.parseInt(textArea1.getText());//房间数
                        textArea2.getText();//姓名
                        textArea3.getText();//电话

                        hotel hotel = new hotel(hotel_name);
                        hotel.get_hotel.print();

                        int room_number = hotel.get_hotel.get_number(room_type_name);
                        System.out.println("剩余 " + room_type_name + " 数量：" + room_number);
                        room_number = room_number - input_number;
                        System.out.println("减去后的房间数量：" + room_number);
                        hotel.get_hotel.set(room_type_name, room_number);
                        table.hotel.insert(hotel.get_hotel);

                        //该typenmae下房间数-1
                        frame.dispose();

                    }


                }


            }


        });


    }

    public void listerner2() {

        jButton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });
    }

    public int changedate(int monthes) {

        int[] a = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        return a[monthes];

    }


}













