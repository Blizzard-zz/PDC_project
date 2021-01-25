package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import database.*;

public class hotelpage {
    public hotel hotel;
    static ArrayList<roomtype> roomlist = new ArrayList<>();
    JFrame frame;
    create_table table;
    int exchange;


    JPanel jPanel1;
    JPanel jPanel2;
    JPanel jPanel3;

    JScrollPane scrollPane;


    public hotelpage(String name) {
        System.out.println("name: " + name);
        exchange = 0;
        table = new create_table();
        //name为具体的酒店名字
        jPanel1 = new JPanel();
        jPanel2 = new JPanel();
        jPanel3 = new JPanel();

        jPanel2.setOpaque(false);

        jPanel3.setPreferredSize(new Dimension(500, 1200));

        jPanel2.setSize(550, 200);


        jPanel2.setLayout(null);


        jPanel1.setOpaque(false);
        jPanel1.setPreferredSize(new Dimension(500, 1000));
        jPanel1.setLayout(null);


        //此处为读取name酒店下，所有的roomtype和信息

        hotel = new hotel(name);
        hotel.get_hotel.print();

        roomlist = hotel.show_room_list();


        frame = new JFrame();
        jPanel1.setLayout(null);
        jPanel2.setLayout(null);


        JLabel[] jLabel1 = new JLabel[roomlist.size() * 2];
        JTextArea[] jTextAreas1 = new JTextArea[roomlist.size()];
        JButton[] jButtons1 = new JButton[roomlist.size() * 2];


        for (int i = 0; i < roomlist.size(); i++) {
            if (roomlist.get(i).room_number == 0) {
                exchange++;
                continue;
            }

            int h = i;
            if (exchange != 0) {
                h = i - exchange;

            }
            JPanel WestJP = new JPanel(null);

            WestJP.setBounds(0, 0 + h * 200, 500, 200);

            //将每种房型的第一张图片读取，放进path数组里，路径用path[i]赋值
            String path = roomlist.get(i).path;
            System.out.println("Path: " + path);
            ImageIcon image = new ImageIcon(path);
            image = new ImageIcon(image.getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT));
            jButtons1[2 * i] = new JButton();
            jButtons1[2 * i].setBounds(0, 0, 150, 150);
            jButtons1[2 * i].setIcon(image);
            WestJP.add(jButtons1[2 * i]);


            //将每个房型的名字放在数组里，用name[i]赋值给变量typename
            String typename;
            typename = roomlist.get(i).roomtypename;
            jLabel1[2 * i] = new JLabel(typename);
            jLabel1[2 * i].setBounds(250, 0, 150, 40);
            WestJP.add(jLabel1[2 * i]);


            //读取并计算平均价格
            final double price1 = Math.random();
            final int price2 = (int) (500 + 200 * i + price1 * 100);
            jLabel1[2 * i + 1] = new JLabel("Price: " + price2);
            jLabel1[2 * i + 1].setBounds(400, 150, 200, 50);
            WestJP.add(jLabel1[2 * i + 1]);

            //浏览按钮

            jButtons1[2 * i + 1] = new JButton("book");
            jButtons1[2 * i + 1].setBounds(300, 130, 80, 40);
            WestJP.add(jButtons1[2 * i + 1]);


            //每个房间的介绍，放进数组里，用describe[i]来赋值给description
            String describetion;
            describetion = roomlist.get(i).description;
            jTextAreas1[i] = new JTextArea(describetion, 3, 10);
            jTextAreas1[i].setLineWrap(true);
            jTextAreas1[i].setBounds(250, 50, 200, 68);
            jTextAreas1[i].setLineWrap(true);
            jTextAreas1[i].setEditable(false);
            jTextAreas1[i].setOpaque(false);
            WestJP.add(jTextAreas1[i]);


            int finalI = i;
            jButtons1[2 * i].addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    String typename1 = jLabel1[2 * finalI].getText();
                    //读取点击图片对应的房型名，打开循环浏览图片页面

                    hotel_PICTURE h = new hotel_PICTURE(hotel);

                    h.init(typename1);

                }
            });

            int finalI1 = i;
            jButtons1[2 * i + 1].addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    String typename1=jLabel1[2 * finalI1].getText();
                    //打开预订页面，把选择的房型名字输入
                    new bookpage(typename1, hotel.hotel_name, price2);
                }
            });


            jPanel1.add(WestJP);


        }
        scrollPane = new JScrollPane(
                jPanel1,
                ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER
        );

        scrollPane.getVerticalScrollBar().setUnitIncrement(10);

        frame.add(scrollPane);
        System.out.println("Welcome to " + hotel.hotel_name);
        frame.setTitle("Welcome to " + hotel.hotel_name);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setBounds(100, 200, 550, 650);
        frame.setSize(550, 600);
        frame.setVisible(true);

    }


}
