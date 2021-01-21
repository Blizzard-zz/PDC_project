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
import java.util.List;

public class view_the_picture {
    JFrame frame = null;


    JTextArea textArea;
    public List<String> picturelist = new ArrayList<>();

    JLabel label1 = new JLabel();//用于显示图片


    JButton previousBtn;
    JButton nextBtn;
    JButton returnb;
    BufferedImage bi = null;//用于存储临时打开的图片流
    JButton comfirm;
    JButton openFile;
    File file;
    int picturenumber = 0;

    public void init(String typrname) {
        //在这加一个循环读取typrname下的图片路径，加入picturelist中
        picturelist.add("C:\\Users\\yfy\\Desktop\\2.png");
        picturelist.add("C:\\Users\\yfy\\Desktop\\1.jpg");
        Font font = new Font("宋体", Font.BOLD, 20);


        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 600);
        frame.setLayout(new BorderLayout());

        //主面板
        JPanel ShowJP = new JPanel(new BorderLayout());
        ShowJP.setBorder(BorderFactory.createTitledBorder("显示"));
        ShowJP.setPreferredSize(new Dimension(600, 600));

        String introduction = "abcasfasfaaa";
        textArea = new JTextArea(introduction, 5, 10);
        Font font1 = new Font("宋体", Font.BOLD, 30);

        //此处显示的是第一个图片，可以直接把设置好的路径改成读取picturelist[0]的图片就成
        ImageIcon image = new ImageIcon("C:\\Users\\yfy\\Desktop\\1.jpg");
        image = new ImageIcon(image.getImage().getScaledInstance(350, 350, Image.SCALE_DEFAULT));


        label1.setIcon(image);


        frame.add(ShowJP, BorderLayout.CENTER);

        //四个图片面板
        JPanel WestJP = new JPanel(new FlowLayout());
        ShowJP.add(WestJP, BorderLayout.CENTER);
        WestJP.setPreferredSize(new Dimension(500, 500));
        WestJP.add(label1, BorderLayout.CENTER);


        textArea.setFont(font1);
        textArea.setLineWrap(true);
        textArea.setEditable(false);
        textArea.setOpaque(false);
        //textArea.setHorizontalAlignment(JTextField.CENTER);
        WestJP.add(textArea, BorderLayout.SOUTH);


        JToolBar toolBar = new JToolBar("测试工具栏");

        // 创建 工具栏按钮
        previousBtn = new JButton(new ImageIcon("D:\\left.png"));
        previousBtn.setFocusPainted(false);
        previousBtn.setContentAreaFilled(false);
        previousBtn.setBorderPainted(false);//不绘制边框


        nextBtn = new JButton(new ImageIcon("D:\\right.png"));

        nextBtn.setContentAreaFilled(false);
        nextBtn.setBorderPainted(false);//不绘制边框


        ShowJP.add(previousBtn, BorderLayout.WEST);
        ShowJP.add(nextBtn, BorderLayout.EAST);


        returnb = new JButton("confirm");

        Font font2 = new Font("宋体", Font.BOLD, 25);
        returnb.setFont(font2);
        returnb.setSize(50, 50);
        returnb.setFocusPainted(false);
        returnb.setBorderPainted(false);


        ShowJP.add(returnb, BorderLayout.SOUTH);


        listerner1();
        listerner2();
        listerner3();
        frame.setVisible(true);

    }

    public void listerner1() {

        previousBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                picturenumber = picturenumber + 1;
                if (picturenumber >= picturelist.size() - 1) {
                    picturenumber = picturelist.size() - picturenumber;
                }

                if (picturelist.get(picturenumber) != null)
                    openFile(picturelist.get(picturenumber));//打开文件

            }
        });


    }

    public void listerner2() {

        nextBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                picturenumber = picturenumber - 1;
                if (picturenumber < 0) {
                    picturenumber = picturelist.size() + picturenumber;
                }

                if (picturelist.get(picturenumber) != null)
                    openFile(picturelist.get(picturenumber));//打开文件

            }
        });


    }

    public void listerner3() {

        returnb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });


    }

    //实现按钮监听事件
    public void actionPerformed(ActionEvent e) {
        String ButtonName = e.getActionCommand();
        if (ButtonName.equals("打开图片")) {

        }


    }

    //打开文件夹操作
    public void openFile(String path) {


        try {
            File file = new File(path);
            bi = ImageIO.read(file);
            ImageIcon image = new ImageIcon(path);
            image = new ImageIcon(image.getImage().getScaledInstance(350, 350, Image.SCALE_DEFAULT));
            label1.setIcon(image);            //设置JLabel的显示图片


        } catch (IOException e) {
            //e.printStackTrace();
            return;
        }


    }

    public static void main(String[] args) {
        view_the_picture p = new view_the_picture();
        p.init("yfy");
    }


}
