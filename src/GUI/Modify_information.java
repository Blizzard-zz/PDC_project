package GUI;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.ArrayList;

import database.*;

public class Modify_information extends JFrame {


    public hotel hetol2;
    ArrayList<roomtype> roomlist2;
    create_table table;

    JFrame frame;

    JPanel jPanel1;

    JButton jButton3;
    JButton jButton5;
    static JButton head;


    //此处是根据选择的酒店，来修改type的信息，传入的是酒店名
    public Modify_information(String hotelname) {
        table = new create_table();
        frame = new JFrame();
        jPanel1 = new JPanel();
        jPanel1.setOpaque(false);
        jPanel1.setSize(900, 600);

        //这两行语句是用来把酒店内的酒店类型传入roomlist2数组里的
        hetol2 = new hotel(hotelname);
        System.out.println("modify: " + hotelname);
        roomlist2 = hetol2.show_room_list();


        jPanel1.setLayout(null);


        //头像框
        head = new JButton();
        ImageIcon image = new ImageIcon("src/GUI/5.jpg");
        transferAlpha("src/GUI/5.jpg");
        image = new ImageIcon(image.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
        head.setBounds(0, 0, 100, 100);
        jPanel1.add(head);


        JButton[] b = new JButton[roomlist2.size()];
        JLabel[] a = new JLabel[roomlist2.size()];
        JTextArea[] c = new JTextArea[roomlist2.size() * 2];
        JButton[] d = new JButton[roomlist2.size()];

        //此处的i小于需改成存放酒店类型数组的长度
        for (int i = 0; i < roomlist2.size(); i++) {

            //show里存放的是对应的类型名字
            String show = roomlist2.get(i).roomtypename;
            //show1里存放的是剩余的房间数量
            String show1 = String.valueOf(roomlist2.get(i).room_number);


            c[i * 2] = new JTextArea(show);
            Font font = new Font("宋体", Font.BOLD, 20);
            c[i * 2].setFont(font);
            c[i * 2].setBounds(0, 120 + i * 60, 150, 40);
            jPanel1.add(c[i * 2]);

            a[i] = new JLabel("剩余房间数量");
            a[i].setBounds(200, 120 + i * 60, 200, 40);
            a[i].setFont(font);
            jPanel1.add(a[i]);

            c[i * 2 + 1] = new JTextArea(show1);

            c[i * 2 + 1].setFont(font);
            c[i * 2 + 1].setBounds(350, 120 + i * 60, 100, 40);
            jPanel1.add(c[i * 2 + 1]);


            b[i] = new JButton("comfirm modify");
            jPanel1.add(b[i]);
            b[i].setBounds(550, 120 + i * 60, 150, 40);

            d[i] = new JButton("set picture");
            jPanel1.add(d[i]);
            d[i].setBounds(700, 120 + i * 60, 150, 40);

            //以下为确认按钮的事件
            int finalI = i;
            b[i].addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {

                    String typename = c[finalI * 2].getText();
                    String roomnumber = c[finalI * 2 + 1].getText();
                    try {
                        int b = Integer.valueOf(roomnumber).intValue();

                        hotel hotel = new hotel(hotelname);
                        hotel.get_hotel.print();

                        //此处需加入存入语句，typename为读取的类型名字，roomnumber为读取的剩余房间数
                        hotel.get_hotel.set(typename, b);

                        table.hotel.insert(hotel.get_hotel);

                    } catch (NumberFormatException a) {
                        a.printStackTrace();
                        int option2 = JOptionPane.showConfirmDialog(null, "Wrong number of rooms", "提交提示", JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);
                    }
                }
            });

            //此处为浏览图片按钮，无需改动
            int finalI1 = i;
            d[i].addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {

                    //System.out.println(c[finalI1 * 2].getText());
                    view_the_picture v = new view_the_picture(hetol2);
                    v.init(c[finalI1 * 2].getText());

                }

            });


        }

        jButton5 = new JButton("comfirm");
        jPanel1.add(jButton5);
        jButton5.setBounds(100, 500, 200, 40);


        jButton3 = new JButton("exit");
        jPanel1.add(jButton3);
        jButton3.setBounds(500, 500, 200, 40);


        listerner2();
        listerner3();


        frame.add(jPanel1);


        frame.setTitle(hotelname + " information");
        frame.setSize(900, 600);
        frame.setVisible(true);

    }




    public void listerner2() {

        jButton5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                frame.dispose();

            }
        });


    }


    public void listerner3() {

        jButton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();


            }
        });


    }


    //此处为头像框修改方法，无需改动
    public static void transferAlpha(String PATH1) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

        File file = new File(PATH1);

        InputStream is;

        try {
            is = new FileInputStream(file);


            BufferedImage bi = ImageIO.read(is);

            Image image = (Image) bi;

            ImageIcon imageIcon = new ImageIcon(image);

            BufferedImage bufferedImage1 = new BufferedImage(imageIcon

                    .getIconWidth(), imageIcon.getIconHeight(),

                    BufferedImage.TYPE_4BYTE_ABGR);

            Graphics2D g2D = (Graphics2D) bufferedImage1.getGraphics();

            g2D.drawImage(imageIcon.getImage(), 0, 0, imageIcon

                    .getImageObserver());

            int alpha = 0;

            for (int j1 = bufferedImage1.getMinY(); j1 < bufferedImage1

                    .getHeight(); j1++) {
                for (int j2 = bufferedImage1.getMinX(); j2 < bufferedImage1

                        .getWidth(); j2++) {
                    int rgb = bufferedImage1.getRGB(j2, j1);

                    int R = (rgb & 0xff0000) >> 16;

                    int G = (rgb & 0xff00) >> 8;

                    int B = (rgb & 0xff);

                    if (((255 - R) < 30) && ((255 - G) < 30) && ((255 - B) < 30)) {
                        rgb = ((alpha + 1) << 24) | (rgb & 0x00ffffff);

                    }

                    bufferedImage1.setRGB(j2, j1, rgb);

                }

            }

            g2D.drawImage(bufferedImage1, 0, 0, imageIcon.getImageObserver());
            String path = "src/GUI/6.jpg";
            ImageIO.write(bufferedImage1, "png", new File(path));//直接输出文件
            ImageIcon i = new ImageIcon(path);
            i = new ImageIcon(i.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));

            head.setIcon(i);



        } catch (Exception e) {
            e.printStackTrace();

        }


    }


}










