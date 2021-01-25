package GUI;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.awt.image.*;
import javax.imageio.ImageIO;
import javax.swing.filechooser.FileFilter;

public class openpicture implements ActionListener {
    JFrame frame = null;
    JLabel label = new JLabel();//用于显示图片
    JLabel labelRGB = new JLabel("");
    BufferedImage bi = null;//用于存储临时打开的图片流
    JButton comfirm;
    JButton openFile;
    File file;
    String path1 = null;
    String room_type_name;
    hotel hotel;

    //此处用于为传入的roomtype添加新的图片，
    public openpicture(String type_name, hotel hotel) {
        this.room_type_name = type_name;
        this.hotel = hotel;

    }


    public void init(String typrname) {
        this.room_type_name = typrname;
        openFile = new JButton("open picture");
        comfirm = new JButton("confirm");
        Font font = new Font("宋体", Font.BOLD, 20);
        comfirm.setFont(font);
        openFile.setFont(font);

        openFile.addActionListener(this);


        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1100, 800);
        frame.setLayout(new BorderLayout());

        JPanel ShowJP = new JPanel(new BorderLayout());
        ShowJP.setBorder(BorderFactory.createTitledBorder("add the picture"));
        ShowJP.setPreferredSize(new Dimension(1100, 800));

        frame.add(ShowJP, BorderLayout.CENTER);

        JPanel WestJP = new JPanel(new FlowLayout());
        ShowJP.add(WestJP, BorderLayout.NORTH);
        WestJP.setPreferredSize(new Dimension(550, 550));
        WestJP.add(label, BorderLayout.CENTER);

        FlowLayout layout = new FlowLayout(1, 400, 100);
        JPanel EastJP = new JPanel(layout);
        frame.add(EastJP, BorderLayout.SOUTH);
        EastJP.setPreferredSize(new Dimension(550, 200));


        openFile.setSize(200, 100);
        comfirm.setSize(50, 50);

        EastJP.add(openFile, BorderLayout.WEST);
        EastJP.add(comfirm, BorderLayout.EAST);
        listerner1();

        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    }

    public void listerner1() {

        comfirm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (path1 == null) {
                    frame.dispose();
                } else {
                    //此处存入path1，为新添加图片,类型名称为roomtype


                    frame.dispose();

                }

            }
        });


    }


    public void actionPerformed(ActionEvent e) {
        String ButtonName = e.getActionCommand();
        if (ButtonName.equals("打开图片")) {
            System.out.println("打开图片:");
            openFile();
        }

    }

    public void openFile() {


        JFileChooser jf = new JFileChooser();// 实例化文件选择器

        jf.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        jf.setFileFilter(new FileFilter() {// FileFilter 为抽象类


            @Override
            public String getDescription() {// 显示为指定后缀名的文件

                return ".jpg";
            }

            @Override
            public boolean accept(File f) {// 判断文件是否已jpg结尾
                if (f.getName().endsWith("jpg")) {
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

                if (bi == null || bi.getHeight() <= 0 || bi.getWidth() <= 0) {
                    label.setText("您选择的不是一张图片，请从新选择！");
                    return;
                } else {
                    String path = file.getPath();
                    System.out.println(path);
                    ImageIcon image = new ImageIcon(path);
                    image = new ImageIcon(image.getImage().getScaledInstance(550, 550, Image.SCALE_DEFAULT));


                    label.setIcon(image);
                    path1 = file.getPath();
                }
            } catch (IOException e) {
                return;
            }


        }
    }


}