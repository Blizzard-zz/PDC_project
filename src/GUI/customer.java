package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import database.*;

public class customer {


    create_table table;

    public hotel hotel;
    public hotel hotel1;
    public hotel hotel2;

    static ArrayList<hotel> hotels = new ArrayList<>();
    JFrame frame = null;

    JPanel jPanel1;

    JPanel jPanel2;

    JScrollPane scrollPane;

    //此处为顾客登录后打开的第一个界面，传入的参数是用户名


    public customer(String username) {
        table = new create_table();

        jPanel1 = new JPanel();
        jPanel2 = new JPanel();

        jPanel2.setOpaque(false);

        jPanel2.setSize(550, 1000);
        jPanel2.setLayout(null);


        jPanel1.setOpaque(false);
        jPanel1.setPreferredSize(new Dimension(500, 1000));

        jPanel1.setLayout(null);


        //这里需要把所有酒店的名字，介绍，图片传入roomlist2中
        initial_hotel();


//        roomlist2 = hotel.show_room_list();

        frame = new JFrame();
        jPanel1.setLayout(null);
        jPanel2.setLayout(null);


        JLabel[] a = new JLabel[hotels.size() * 3];

        JTextArea[] c = new JTextArea[hotels.size()];
        JButton[] d = new JButton[hotels.size()];

        for (int i = 0; i < hotels.size(); i++) {

            JPanel WestJP = new JPanel(null);
            WestJP.setBounds(0, 0 + i * 200, 500, 200);

            //将每个酒店的图片选一张，路径存入数组里，用path[i]的方式赋值给image
            String path = hotels.get(i).hotel_path;
            ImageIcon image = new ImageIcon(path);
            image = new ImageIcon(image.getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT));

            a[3 * i] = new JLabel();
            a[3 * i].setBounds(0, 0, 150, 150);
            a[3 * i].setIcon(image);
            WestJP.add(a[3 * i]);


            //将每个酒店的名字存入数组里，用name[i]的方式赋值给hotelname
            String hotelname;
            hotelname = hotels.get(i).hotel_name;

            a[3 * i + 1] = new JLabel(hotelname);
            a[3 * i + 1].setBounds(250, 0, 150, 40);
            WestJP.add(a[3 * i + 1]);

            //酒店价格设置在700-1400左右
            final double price1 = Math.random();
            final int price2 = (int) (700 + price1 * 700);
            a[3 * i + 2] = new JLabel(String.valueOf("Average Price: " + price2));
            a[3 * i + 2].setBounds(350, 150, 200, 50);
            WestJP.add(a[3 * i + 2]);

            //浏览按钮
            d[i] = new JButton("view");
            d[i].setBounds(300, 110, 80, 40);
            WestJP.add(d[i]);


            //读取酒店介绍介绍
            String describetion;
            describetion = hotels.get(i).description;
            c[i] = new JTextArea(describetion, 3, 10);
            c[i].setLineWrap(true);
            c[i].setBounds(250, 40, 200, 68);
            c[i].setLineWrap(true);
            c[i].setEditable(false);
            c[i].setOpaque(false);
            WestJP.add(c[i]);

            jPanel1.add(WestJP);

            //此处为打开某个特定酒店页面，显示各种房型
            int finalI = i;
            d[i].addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    //hotelname为读取下来的酒店名字，无需改动

                    String hotelname = a[3 * finalI + 1].getText();
                    System.out.println("hotel_name = " + hotelname);
                    hotelpage h = new hotelpage(hotelname);

                }
            });


        }
        scrollPane = new JScrollPane(
                jPanel1,
                ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER
        );

        scrollPane.getVerticalScrollBar().setUnitIncrement(10);

        frame.add(scrollPane);

        frame.setTitle("welcome to the hotel System  " + username);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLocation(600, 200);
        frame.setSize(550, 650);
        frame.setVisible(true);
    }

    private void initial_hotel() {
        hotel = new hotel("Open the fire");

        hotel1 = new hotel("Eagle");

        hotel2 = new hotel("Dreamers");

        hotels.add(hotel);
        hotels.add(hotel1);
        hotels.add(hotel2);
    }



}
