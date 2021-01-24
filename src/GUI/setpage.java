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

import javax.swing.ImageIcon;

public class setpage extends JFrame {
    public static hotel hetol2;
    static ArrayList<roomtype> roomlist2 = new ArrayList<>();
    static ArrayList<roomtype> hotellist = new ArrayList<>();

    JFrame frame;

    JLabel jLabel;

    JPanel jPanel1;

    JButton[] b;
    JLabel[] a;
    JTextArea[] c;
    JButton[] d;

    ButtonGroup bg;

    JComboBox jComboBox;
    JToggleButton jButton2;

    JButton jButton3;
    JButton jButton4;
    JButton jButton5;
    JButton jButton6;
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
        String hotelname = "";
        hetol2 = new hotel(hotelname);
        roomlist2 = hetol2.show();
        //以上roomlist2的代码赋值后，原先代码可以直接删除


        jPanel1.setLayout(null);



        //此处图片为显示的第一个头像，
        head = new JButton();
        ImageIcon image = new ImageIcon("src/GUI/5.jpg");
        transferAlpha("src/GUI/5.jpg");
        image = new ImageIcon(image.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));


        head.setBounds(0, 0, 100, 100);

        jPanel1.add(head);



        //接下来的所有roomlist2出现的地方，需要换成酒店名字所存的数组
        JToggleButton[] jButtons1 = new JToggleButton[roomlist2.size()];
        bg = new ButtonGroup();
        for (int i = 0; i < roomlist2.size(); i++) {

            jButtons1[i] = new JToggleButton(roomlist2.get(i).roomtypename);
            jButtons1[i].setBackground(Color.gray);
            jButtons1[i].setBounds(0, 120 + i * 60, 150, 60);
            bg.add(jButtons1[i]);
            jPanel1.add(jButtons1[i]);


            int finalI1 = i;
            jButtons1[i].addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    //此处返回的是选中的酒店名
                    String HOTELNAME = jButtons1[finalI1].getName();

                    //根据酒店名字，搜索该酒店的类型，把输入房间类型的数组换成当前酒店的数组
                    hotel hotel1 = new hotel(HOTELNAME);
                    //此处更新为选中酒店的房间类型数组
                    roomlist2 = hotel1.show();
                    //以上两行代码完成房间类型数组的赋值后可以删除



                    jPanel1.updateUI();

                }
            });

        }
        //到此处截至，以上所有roomlist2替换




        //以下所有的roomlist2存放的为房间类型的数组
        JLabel[] jLabel1 = new JLabel[roomlist2.size() * 2];
        JButton[] jButtons2 = new JButton[roomlist2.size() * 2];
        JButton[] jButtons3 = new JButton[roomlist2.size()];

        for (int i = 0; i < roomlist2.size(); i++) {
            //show里存放的为房间类型名称的数组，通过roolist2[i]调用赋值
            String show = roomlist2.get(i).roomtypename;

            //此处存放的是各个房间类型的剩余房间数量，
            String show1 = "剩余房间数量" + String.valueOf(roomlist2.get(i).roomunmber);


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


                    view_the_picture h = new view_the_picture();

                    System.out.println(typename);
                    h.init(typename);


                }
            });

            jButtons2[2 * i + 1].addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    //此处为添加图片的按钮,无需修改
                    openpicture picture = new openpicture();
                    String typename = jLabel1[2 * finalI].getText();

                    picture.init(typename);

                    System.out.println(1111);

                }
            });

            jButtons3[i].addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    //此处为修改信息的按钮，无需改动
                    int hotelname = 0;

                    for (int a = 0; a < roomlist2.size(); a++) {
                        if (jButtons1[a].isSelected()) {
                            hotelname = a;
                            break;
                        }

                    }

                    Modify_information m = new Modify_information(jButtons1[hotelname].getName());


                }
            });


        }

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
                settypr setpage1 = new settypr();


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
                    head.setText("您选择的不是一张图片，请从新选择！");
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

        } finally {
        }


    }

}





