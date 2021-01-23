package GUI;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.ArrayList;

public class Modify_information extends JFrame implements ActionListener {


    public static hotel hetol2;
    static ArrayList<roomtype> roomlist2 = new ArrayList<>();
    static ArrayList<roomtype> hotellist = new ArrayList<>();


    JFrame frame;
    JLabel jLabel;//title
    JLabel jLabel1;//username
    JLabel jLabel2;//password

    JPanel jPanel1;


    JTextArea textArea1;
    JTextArea textArea2;
    JTextArea textArea3;
    JTextArea textArea4;

    ButtonGroup bg;

    JComboBox jComboBox;
    JToggleButton jButton2;

    JButton[] b;
    JLabel[] a;
    JTextArea[] c;
    JButton[] d;
    JButton jButton3;
    JButton jButton4;
    JButton jButton5;
    JButton jButton6;
    static JButton head;


    File file;
    BufferedImage bi = null;//用于存储临时打开的图片流


    //    public static employeer staff1=new employeer();
    public Modify_information(String hotelname) {
        frame = new JFrame();
        jPanel1 = new JPanel();
        jPanel1.setOpaque(false);
        jPanel1.setSize(900, 600);


        hetol2 = new hotel(hotelname);

        roomlist2 = hetol2.show();


        jPanel1.setLayout(null);


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

        for (int i = 0; i < 5; i++) {
            String show = roomlist2.get(i).roomtypename;
            String show1 = String.valueOf(roomlist2.get(i).roomunmber);


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
            //b[i].addActionListener(this);

            int finalI = i;
            b[i].addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {

                    String typename = c[finalI * 2].getText();
                    String roomnumber = c[finalI * 2 + 1].getText();
                    try {

                        int b = Integer.valueOf(roomnumber).intValue();
                        System.out.println(b);
                        //存入房间类型和数量


                    } catch (NumberFormatException a) {

                        a.printStackTrace();
                        int option2 = JOptionPane.showConfirmDialog(null, "Wrong number of rooms", "提交提示", JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);

                    }
                }
            });


            int finalI1 = i;
            d[i].addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    System.out.println(c[finalI1 * 2].getText());
                    view_the_picture v = new view_the_picture();
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


        frame.setTitle("room type information");
        frame.setSize(900, 600);
        frame.setVisible(true);

    }

    public void actionPerformed(ActionEvent e) {
        String ButtonName = e.getActionCommand();
        if (ButtonName.equals("打开图片")) {

        }


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

    public void listerner4() {

        head.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openFile();//打开文件

            }
        });


    }

    public void listerner5() {

        jButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String HOTELNAME = jButton2.getName();

                //根据酒店名字，搜索该酒店的类型，把输入房间类型的数组换成当前酒店的数组
                hotel hotel1 = new hotel(HOTELNAME);


                roomlist2 = hotel1.show();

                jPanel1.updateUI();


            }
        });


    }

    public void listerner6() {

        jButton5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String typename = textArea1.getText();
                String roomnumber = textArea2.getText();
                try {

                    int b = Integer.valueOf(roomnumber).intValue();
                    System.out.println(b);
                    //存入房间类型和数量
                } catch (NumberFormatException a) {

                    a.printStackTrace();
                    int option2 = JOptionPane.showConfirmDialog(null, "Wrong number of rooms", "提交提示", JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);

                }
                //


            }
        });


    }

    public void openFile() {


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
                    return;
                } else {
                    String path = file.getPath();
                    System.out.println(path);
                    transferAlpha(path);
                    /*ImageIcon image = new ImageIcon(path);
                    image = new ImageIcon(image.getImage().getScaledInstance(550, 550, Image.SCALE_DEFAULT));


                    head.setIcon(image);*/            //设置JLabel的显示图片

                }
            } catch (IOException e) {
                //e.printStackTrace();
                return;
            }


        }
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
            String path = "src/GUI/6.jpg";
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










