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


    JLabel jLabel;//title

    JPanel jPanel1;
    JLabel jlabel2;

    JPanel jPanel2;


    JButton[] b;
    JLabel[] a;
    JTextArea[] c;
    JButton[] d;
    JLabel[] e;
    JLabel[] f;
    JLabel[] g;

    JButton jButton2;

    JButton jButton6;
    JButton jlabel3;
    JLabel jlabel4;

    JLabel jlabel1;
    JTextArea textArea;

    JScrollPane scrollPane;


    public customer() {

        jPanel1 = new JPanel();
        jPanel2 = new JPanel();

        jPanel2.setOpaque(false);

        jPanel2.setSize(550, 1000);
        jPanel2.setLayout(null);


        jPanel1.setOpaque(false);
        jPanel1.setPreferredSize(new Dimension(500, 1000));

        jPanel1.setLayout(null);


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


            ImageIcon image = new ImageIcon("src/GUI/1.jpg");
            image = new ImageIcon(image.getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT));

            a[3 * i] = new JLabel();
            a[3 * i].setBounds(0, 0, 150, 150);
            a[3 * i].setIcon(image);
            WestJP.add(a[3 * i]);


            //读取酒店名


            String hotelname = "   YFY";
            a[3 * i + 1] = new JLabel(hotelname);
            a[3 * i + 1].setBounds(250, 0, 150, 40);
            WestJP.add(a[3 * i + 1]);


            //读取并计算平均价格
            String price = "  50 ";
            a[3 * i + 2] = new JLabel(price);
            a[3 * i + 2].setBounds(450, 150, 50, 50);
            WestJP.add(a[3 * i + 2]);

            //浏览按钮

            d[i] = new JButton("view");
            d[i].setBounds(300, 110, 80, 40);
            WestJP.add(d[i]);


            //读取介绍
            String describetion = "ABCBADBABD   ";
            c[i] = new JTextArea(describetion, 3, 10);
            c[i].setLineWrap(true);
            c[i].setBounds(250, 50, 200, 68);
            c[i].setLineWrap(true);
            c[i].setEditable(false);
            c[i].setOpaque(false);
            WestJP.add(c[i]);

            jPanel1.add(WestJP);


            int finalI = i;
            d[i].addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {

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


        frame.setTitle("hotel list");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        frame.setSize(550, 400);
        frame.setVisible(true);


    }


    public void listerner1() {

        jlabel3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //获取是那个酒店的按钮被点击
                String hotelname = jPanel1.getName();
                hotelpage h = new hotelpage(hotelname);


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

    public static void main(String[] args) {
        customer c = new customer();
    }


}
