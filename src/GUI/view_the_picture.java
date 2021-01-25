package GUI;

import javax.imageio.ImageIO;
import javax.swing.*;
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
    int picturenumber = 0;
    roomtype room;
    hotel hotel;

    public view_the_picture(hotel hotel) {
        System.out.println("view_hotel: " + hotel.hotel_name);
        this.hotel = hotel;
    }

    //这个是根据输入的房间类型，读取对应的图片，加在picturelist里

    public void init(String typrname) {
        //在这加一个循环读取typrname下的图片路径，加入picturelist中
        room = hotel.get_room_type_by_name(typrname);
        String path = room.path;
        picturelist.add(path);
        picturelist.add("src/GUI/1.jpg");
        Font font = new Font("宋体", Font.BOLD, 25);


        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 600);
        frame.setLayout(new BorderLayout());

        JPanel ShowJP = new JPanel(new BorderLayout());
        ShowJP.setBorder(BorderFactory.createTitledBorder("view the  " + typrname + "  picture"));
        ShowJP.setFont(font);
        ShowJP.setPreferredSize(new Dimension(600, 600));


        //这边读取的是对这个房间类型的介绍，直接赋值给introduction就行
        String introduction;
        introduction = room.description;
        textArea = new JTextArea(introduction, 5, 10);
        Font font1 = new Font("宋体", Font.BOLD, 15);

        //此处显示的是第一个图片，可以直接把设置好的路径改成读取picturelist[0]的图片就成
        ImageIcon image = new ImageIcon("src/GUI/1.jpg");
        image = new ImageIcon(image.getImage().getScaledInstance(350, 350, Image.SCALE_DEFAULT));


        //以下无需改动
        //以下无需改动
        //以下无需改动
        //以下无需改动
        //以下无需改动

        label1.setIcon(image);


        frame.add(ShowJP, BorderLayout.CENTER);

        JPanel WestJP = new JPanel(new FlowLayout());
        ShowJP.add(WestJP, BorderLayout.CENTER);
        WestJP.setPreferredSize(new Dimension(500, 500));
        WestJP.add(label1, BorderLayout.CENTER);


        textArea.setFont(font1);
        textArea.setLineWrap(true);
        textArea.setEditable(false);
        textArea.setOpaque(false);
        WestJP.add(textArea, BorderLayout.SOUTH);


        previousBtn = new JButton(new ImageIcon("src/GUI/left.png"));
        previousBtn.setFocusPainted(false);
        previousBtn.setContentAreaFilled(false);
        previousBtn.setBorderPainted(false);//不绘制边框


        nextBtn = new JButton(new ImageIcon("src/GUI/right.png"));

        nextBtn.setContentAreaFilled(false);
        nextBtn.setBorderPainted(false);


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

        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

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
        }


    }


}
