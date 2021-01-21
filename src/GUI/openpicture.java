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

    public void init(String typrname) {
        openFile = new JButton("打开图片");
        comfirm = new JButton("确认图片");
        Font font = new Font("宋体", Font.BOLD, 20);
        comfirm.setFont(font);
        openFile.setFont(font);

        openFile.addActionListener(this);

        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1100, 800);
        frame.setLayout(new BorderLayout());

        //主面板
        JPanel ShowJP = new JPanel(new BorderLayout());
        ShowJP.setBorder(BorderFactory.createTitledBorder("显示"));
        ShowJP.setPreferredSize(new Dimension(1100, 800));

        //ShowJP.add(openFile);


        frame.add(ShowJP, BorderLayout.CENTER);

        //显示面板
        JPanel WestJP = new JPanel(new FlowLayout());
        ShowJP.add(WestJP, BorderLayout.NORTH);
        WestJP.setPreferredSize(new Dimension(550, 550));
        WestJP.add(label, BorderLayout.CENTER);

        FlowLayout layout = new FlowLayout(1, 400, 100);
        JPanel EastJP = new JPanel(layout);
        //ShowJP.add(EastJP,BorderLayout.SOUTH);
        frame.add(EastJP, BorderLayout.SOUTH);
        EastJP.setPreferredSize(new Dimension(550, 200));

        //openFile.setBounds(600,100,50,50);
        //comfirm.setBounds(600,100,50,50);
        //EastJP.setLayout(null);

        //openFile.setBounds(600, 600, 100, 50);

        //comfirm.setBounds(200,200 ,50,50);

        openFile.setSize(200, 100);
        comfirm.setSize(50, 50);

        EastJP.add(openFile, BorderLayout.WEST);
        EastJP.add(comfirm, BorderLayout.EAST);
        listerner1();
        //EastJP.add(comfirm);

        frame.setVisible(true);
    }

    public void listerner1() {

        comfirm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //return file.getPath();
                //type 名在输入里有
                frame.dispose();

            }
        });


    }


    //实现按钮监听事件
    public void actionPerformed(ActionEvent e) {
        String ButtonName = e.getActionCommand();
        if (ButtonName.equals("打开图片")) {
            System.out.println("打开图片:");
            openFile();//打开文件
        }

    }

    //打开文件夹操作
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
			/*获取文件是否为图片，如果能够正常的获取到一张图片的宽高属性，
			那肯定这是一张图片，因为非图片文件是获取不到它的宽高属性的*/
                if (bi == null || bi.getHeight() <= 0 || bi.getWidth() <= 0) {
                    label.setText("您选择的不是一张图片，请从新选择！");
                    return;
                } else {
                    String path = file.getPath();
                    System.out.println(path);
                    ImageIcon image = new ImageIcon(path);
                    image = new ImageIcon(image.getImage().getScaledInstance(550, 550, Image.SCALE_DEFAULT));


                    label.setIcon(image);            //设置JLabel的显示图片

                }
            } catch (IOException e) {
                //e.printStackTrace();
                return;
            }


        }
    }

    public static void main(String[] args) {
        openpicture picture = new openpicture();
        //picture.init();
    }

}