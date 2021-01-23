package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class hotelpage {
    public static hotel roomlist1;
    static ArrayList<roomtype> roomlist2 = new ArrayList<>();
    JFrame frame = null;


    JButton[] b;
    JLabel[] a;
    JTextArea[] c;
    JButton[] d;

    JLabel jLabel;
    JLabel jlabel1;
    JLabel jlabel2;


    JPanel jPanel1;
    JPanel jPanel2;
    JPanel jPanel3;
    JButton jlabel4;
    JButton jlabel3;


    JButton jButton2;

    JButton jButton6;

    JTextArea textArea;

    JScrollPane scrollPane;


    public hotelpage(String name) {

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


        roomlist1 = new hotel("YFY");
        roomlist2 = roomlist1.show();
        //这边设置个循环读取，把for循环改成while循环
        frame = new JFrame();
        jPanel1.setLayout(null);
        jPanel2.setLayout(null);
        JLabel[] jLabel1 = new JLabel[roomlist2.size() * 2];

        JTextArea[] jTextAreas1 = new JTextArea[roomlist2.size()];
        JButton[] jButtons1 = new JButton[roomlist2.size() * 2];


        for (int i = 0; i < roomlist2.size(); i++) {
            JPanel WestJP = new JPanel(null);
            WestJP.setBounds(0, 0 + i * 200, 500, 200);


            ImageIcon image = new ImageIcon("src/GUI/1.jpg");
            image = new ImageIcon(image.getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT));


            jButtons1[2 * i] = new JButton();


            jButtons1[2 * i].setBounds(0, 0, 150, 150);
            jButtons1[2 * i].setIcon(image);
            WestJP.add(jButtons1[2 * i]);


            //读取酒店名
            String hotelname = "   YFY";
            jLabel1[2 * i] = new JLabel(hotelname);
            jLabel1[2 * i].setBounds(250, 0, 150, 40);
            WestJP.add(jLabel1[2 * i]);


            //读取并计算平均价格
            String price = "  50 ";
            jLabel1[2 * i + 1] = new JLabel(price);
            jLabel1[2 * i + 1].setBounds(450, 150, 50, 50);
            WestJP.add(jLabel1[2 * i + 1]);

            //浏览按钮

            jButtons1[2 * i + 1] = new JButton("book");
            jButtons1[2 * i + 1].setBounds(300, 110, 80, 40);
            WestJP.add(jButtons1[2 * i + 1]);


            //读取介绍
            String describetion = "ABCBADBiABD   ";
            jTextAreas1[i] = new JTextArea(describetion, 3, 10);
            jTextAreas1[i].setLineWrap(true);
            jTextAreas1[i].setBounds(250, 50, 200, 68);
            jTextAreas1[i].setLineWrap(true);
            jTextAreas1[i].setEditable(false);
            jTextAreas1[i].setOpaque(false);
            WestJP.add(jTextAreas1[i]);


            jButtons1[2 * i].addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {

                    hotel_PICTURE h = new hotel_PICTURE();
                    h.init("yfy");

                }
            });

            jButtons1[2 * i + 1].addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {

                    bookpage b = new bookpage();

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

        frame.setTitle("hotel list");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        frame.setSize(550, 400);
        frame.setVisible(true);


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
