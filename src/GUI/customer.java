package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class customer {


    public static hotel roomlist1;
    static ArrayList<roomtype> roomlist2 = new ArrayList<>();
    JFrame frame = null;



    JPanel jPanel1;

    JPanel jPanel2;




    JScrollPane scrollPane;

    //此处为顾客登录后打开的第一个界面，传入的参数是用户名


    public customer(String username) {

        jPanel1 = new JPanel();
        jPanel2 = new JPanel();

        jPanel2.setOpaque(false);

        jPanel2.setSize(550, 1000);
        jPanel2.setLayout(null);


        jPanel1.setOpaque(false);
        jPanel1.setPreferredSize(new Dimension(500, 1000));

        jPanel1.setLayout(null);




        //这里需要把所有酒店的名字，介绍，图片传入roomlist2中
        roomlist1 = new hotel("YFY");
        roomlist2 = roomlist1.show();

        frame = new JFrame();
        jPanel1.setLayout(null);
        jPanel2.setLayout(null);


        JLabel[] a = new JLabel[roomlist2.size() * 3];

        JTextArea[] c = new JTextArea[roomlist2.size()];
        JButton[] d = new JButton[roomlist2.size()];

        for (int i = 0; i < roomlist2.size(); i++) {
            JPanel WestJP = new JPanel(null);
            WestJP.setBounds(0, 0 + i * 200, 500, 200);

            //将每个酒店的图片选一张，路径存入数组里，用path[i]的方式赋值给image
            ImageIcon image = new ImageIcon("src/GUI/1.jpg");
            image = new ImageIcon(image.getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT));

            a[3 * i] = new JLabel();
            a[3 * i].setBounds(0, 0, 150, 150);
            a[3 * i].setIcon(image);
            WestJP.add(a[3 * i]);


            //将每个酒店的名字存入数组里，用name[i]的方式赋值给hotelname
            String hotelname = "   YFY";
            a[3 * i + 1] = new JLabel(hotelname);
            a[3 * i + 1].setBounds(250, 0, 150, 40);
            WestJP.add(a[3 * i + 1]);

            //酒店价格设置在700-1400左右
            final double price1 = Math.random();
            final int price2 = (int)(700+price1*700);
            a[3 * i + 2] = new JLabel(String.valueOf(price2));
            a[3 * i + 2].setBounds(450, 150, 50, 50);
            WestJP.add(a[3 * i + 2]);

            //浏览按钮
            d[i] = new JButton("view");
            d[i].setBounds(300, 110, 80, 40);
            WestJP.add(d[i]);


            //读取酒店介绍介绍
            String describetion = "ABCBADBABD   ";
            c[i] = new JTextArea(describetion, 3, 10);
            c[i].setLineWrap(true);
            c[i].setBounds(250, 50, 200, 68);
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

                    String hotelname = a[3 * finalI + 1].getName();
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


        frame.setTitle("welcome to the hotel System  "+username);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        frame.setSize(550, 400);
        frame.setVisible(true);


    }








    public static void main(String[] args) {

        customer c = new customer("yfy");
    }


}
