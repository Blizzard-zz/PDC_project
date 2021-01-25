package GUI;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import java.awt.Graphics2D;

import java.awt.Image;

import java.io.ByteArrayOutputStream;

import java.io.FileInputStream;

import java.io.InputStream;
import java.util.Arrays;

import javax.swing.ImageIcon;

public class setpage extends JFrame {
    public hotel hotel;
    public hotel hotel1;
    public hotel hotel3;
    public hotel transfer_hotel;
    ArrayList<hotel> hotels = new ArrayList<>();
    ArrayList<roomtype> room_list;

    JFrame frame;

    JPanel jPanel1;

    JLabel[] jLabel1;
    JButton[] jButtons2;
    JButton[] jButtons3;
    JToggleButton[] jButtons1;

    ButtonGroup bg;

    JButton jButton4;
    JButton jButton5;

    static JButton head;


    File file;
    BufferedImage bi = null;

    //需要读取所有的酒店名字，和第一个酒店内的全部房间类型，数量，以及该房间类型对应的图片

    public setpage() {
        frame = new JFrame();

        jPanel1 = new JPanel();
        jPanel1.setOpaque(false);
        jPanel1.setSize(1000, 600);
        //读取所有的酒店，加进列表里


        //此处读取第一个hotel的名字，并搜索第一个酒店内的所有房间类型，替换成roolist2

        initial_hotel();
        room_list = new ArrayList<>();
        room_list = hotels.get(0).show_room_list();
        //以上roomlist2的代码赋值后，原先代码可以直接删除


        jPanel1.setLayout(null);


        //此处图片为显示的第一个头像，
        head = new JButton();
        ImageIcon image = new ImageIcon("src/GUI/5.jpg");
        transferAlpha("src/GUI/5.jpg");
        image = new ImageIcon(image.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));


        head.setBounds(0, 0, 100, 100);

        jPanel1.add(head);


        jLabel1 = new JLabel[room_list.size() * 2];
        jButtons2 = new JButton[room_list.size() * 2];
        jButtons3 = new JButton[room_list.size()];

        //接下来的所有roomlist2出现的地方，需要换成酒店名字所存的数组
        jButtons1 = new JToggleButton[hotels.size()];
        bg = new ButtonGroup();
        for (int i = 0; i < hotels.size(); i++) {

            jButtons1[i] = new JToggleButton(hotels.get(i).hotel_name);
            jButtons1[i].setBackground(Color.gray);
            jButtons1[i].setBounds(0, 120 + i * 60, 150, 60);
            bg.add(jButtons1[i]);
            jPanel1.add(jButtons1[i]);


            int finalI1 = i;

            jButtons1[i].addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {

                    remove(room_list);


                    //此处返回的是选中的酒店名
                    String HOTELNAME = jButtons1[finalI1].getText();
                    System.out.println(HOTELNAME);
                    //根据酒店名字，搜索该酒店的类型，把输入房间类型的数组换成当前酒店的数组
                    hotel hotel = new hotel(HOTELNAME);
                    //此处更新为选中酒店的房间类型数组
                    transfer_hotel = hotel;
                    room_list = hotel.show_room_list();

//                    System.out.println(room_list.toString());
                    add(room_list);
                    //System.out.println(room_list);

                    frame.validate();
                    //frame.setVisible(true);


                    jPanel1.updateUI();


                }


            });

        }


        //到此处截至，以上所有roomlist2替换


        //以下所有的roomlist2存放的为房间类型的数组

        this.add(room_list);
//        room_list = hotels.get(0).show_room_list();
        System.out.println("size = " + room_list.size());


        jButton5 = new JButton("add roomtype");
        jPanel1.add(jButton5);
        jButton5.setBounds(100, 500, 200, 40);

        jButton4 = new JButton("Refresh");
        jPanel1.add(jButton4);
        jButton4.setBounds(300, 500, 200, 40);


        listerner1();
        listerner2();

        listerner4();


        frame.add(jPanel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setTitle("room type information");
        frame.setSize(1000, 600);
        frame.setVisible(true);

    }

    private void initial_hotel() {
        hotel = new hotel("Open the fire");

        hotel1 = new hotel("Eagle");

        hotel3 = new hotel("Dreamers");

        transfer_hotel = null;
        hotels.add(hotel);
        hotels.add(hotel1);
        hotels.add(hotel3);
    }


    public void listerner1() {

        jButton4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                jPanel1.updateUI();

            }
        });


    }

    public void listerner2() {

        jButton5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //此处为添加房间类型的按钮，无需改动
                new settypr();

            }
        });


    }


    public void listerner4() {

        head.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //此处为修改头像框按钮，无需改动
                openFile();//打开文件

            }
        });


    }

    public void add(ArrayList<roomtype> room_list) {

        for (int i = 0; i < room_list.size(); i++) {
//            System.out.println(123456);
            //System.out.println("i = " + i);
//            room_list = hotels.get(i).show_room_list();
            //show里存放的为房间类型名称的数组，通过roolist2[i]调用赋值
            String show = room_list.get(i).roomtypename;

            //此处存放的是各个房间类型的剩余房间数量，
            String show1 = "Number of rooms remaining" + String.valueOf(room_list.get(i).room_number);
            System.out.println(show + "  " + "number = " + show1);

            jLabel1[2 * i] = new JLabel(show);
            Font font = new Font("宋体", Font.BOLD, 20);
            jLabel1[2 * i].setFont(font);
            jLabel1[2 * i].setBounds(200, 120 + i * 60, 300, 40);
            jPanel1.add(jLabel1[2 * i]);

            jLabel1[2 * i + 1] = new JLabel(show1);

            jLabel1[2 * i + 1].setFont(font);
            jLabel1[2 * i + 1].setBounds(350, 120 + i * 60, 300, 40);
            jPanel1.add(jLabel1[2 * i + 1]);


            jButtons2[2 * i] = new JButton("view picture");
            jPanel1.add(jButtons2[2 * i]);
            jButtons2[2 * i].setBounds(550, 120 + i * 60, 150, 40);

            jButtons2[2 * i + 1] = new JButton("set picture");
            jPanel1.add(jButtons2[2 * i + 1]);
            jButtons2[2 * i + 1].setBounds(700, 120 + i * 60, 150, 40);

            jButtons3[i] = new JButton("modify");
            jPanel1.add(jButtons3[i]);
            jButtons3[i].setBounds(850, 120 + i * 60, 100, 40);

            int finalI = i;
            int finalI1 = i;
            jButtons2[2 * i].addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    //此处返回的是选中房间类型名称，不需要改动
                    String typename = jLabel1[2 * finalI1].getText();


                    view_the_picture h = new view_the_picture(transfer_hotel);

                    System.out.println(typename);
                    h.init(typename);


                }
            });

            jButtons2[2 * i + 1].addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    //此处为添加图片的按钮,无需修改

                    String typename = jLabel1[2 * finalI].getText();
                    openpicture picture = new openpicture(typename, hotel);
                    picture.init(typename);

                    System.out.println(1111);

                }
            });

            jButtons3[i].addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    //此处为修改信息的按钮，无需改动
                    int hotelname = 0;

                    for (int a = 0; a < hotels.size(); a++) {
                        if (jButtons1[a].isSelected()) {
                            hotelname = a;
                            break;
                        }

                    }

                    new Modify_information(jButtons1[hotelname].getText());


                }
            });


        }

    }


    public void remove(ArrayList<roomtype> room_list) {

        for (int i = 0; i < room_list.size(); i++) {
            jPanel1.remove(jLabel1[2 * i]);
            jPanel1.remove(jLabel1[2 * i + 1]);
            jPanel1.remove(jButtons2[2 * i]);
            jPanel1.remove(jButtons2[2 * i + 1]);
            jPanel1.remove(jButtons3[i]);

        }


    }


    //以下都无需改动
    public String openFile() {


        //在这里选中图片文件，更改背景
        JFileChooser jf = new JFileChooser();// 实例化文件选择器

        jf.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        // 设置文件过滤
        jf.setFileFilter(new FileFilter() {// FileFilter 为抽象类


            @Override
            public String getDescription() {// 显示为指定后缀名的文件

                return ".jpg";
            }

            @Override
            public boolean accept(File f) {// 判断文件是否已jpg结尾
                if (f.getName().endsWith("jpg") || f.getName().endsWith("png")) {
                    return true;
                } else {
                    return false;
                }
            }
        });
        jf.showOpenDialog(null);// 设置打开时的窗口


        if (jf.getSelectedFile() != null) {

            try {
                file = jf.getSelectedFile();
                bi = ImageIO.read(file);
			/*获取文件是否为图片，如果能够正常的获取到一张图片的宽高属性，
			那肯定这是一张图片，因为非图片文件是获取不到它的宽高属性的*/
                if (bi == null || bi.getHeight() <= 0 || bi.getWidth() <= 0) {
                    head.setText("You have not selected a picture, please choose a new one!");
                    return null;
                } else {
                    String path = file.getPath();
                    System.out.println(path);
                    transferAlpha(path);


                }
            } catch (IOException e) {

                return null;
            }


        }
        return jf.getSelectedFile().getPath();
    }

    public static void transferAlpha(String PATH1) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

        File file = new File(PATH1);

        InputStream is;

        try {
            is = new FileInputStream(file);

//如果是MultipartFile类型，那么自身也有转换成流的方法：is = file.getInputStream();

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
            String path = "src/GUI/11.jpg";
            ImageIO.write(bufferedImage1, "png", new File(path));//直接输出文件
            ImageIcon i = new ImageIcon(path);
            i = new ImageIcon(i.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));

            head.setIcon(i);


// ImageIO.write(bufferedImage, "png", byteArrayOutputStream);//转换成byte数组

        } catch (Exception e) {
            e.printStackTrace();

        }


    }

}






