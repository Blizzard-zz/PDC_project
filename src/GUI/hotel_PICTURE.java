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

public class hotel_PICTURE {
    JFrame frame = null;


    JTextArea textArea;
    public List<String> picturelist = new ArrayList<>();

    JLabel label1 = new JLabel();//用于显示图片


    JButton previousBtn;
    JButton nextBtn;
    JButton returnb;
    BufferedImage bi = null;

    hotel hotel;
    roomtype room;
    int picturenumber = 0;

    public hotel_PICTURE(hotel hotel) {
        this.hotel = hotel;
    }

    //此处是显示对应房型的图片
    public void init(String room_typr_name) {
        //在这加一个循环读取同一个房间类型的所有的图片路径，加入picturelist中
        picturelist.add("src/GUI/1.jpg");
        room = hotel.get_room_type_by_name(room_typr_name);
        String path = room.path;
        picturelist.add(path);

        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 600);
        frame.setLayout(new BorderLayout());


        JPanel ShowJP = new JPanel(new BorderLayout());
        ShowJP.setBorder(BorderFactory.createTitledBorder("the roomtype picture"));
        ShowJP.setPreferredSize(new Dimension(600, 600));

        //对酒店某个房型的介绍的介绍，具体房型用变量roomtye查询
        String introduction;
        introduction = room.description;
        textArea = new JTextArea(introduction, 5, 10);
        Font font1 = new Font("宋体", Font.BOLD, 15);

        //此处显示的是第一个图片，可以直接把设置好的路径改成读取picturelist[0]的图片就成


        ImageIcon image = new ImageIcon("src/GUI/1.jpg");
        image = new ImageIcon(image.getImage().getScaledInstance(350, 350, Image.SCALE_DEFAULT));


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
        nextBtn.setBorderPainted(false);//不绘制边框


        ShowJP.add(previousBtn, BorderLayout.WEST);
        ShowJP.add(nextBtn, BorderLayout.EAST);


        returnb = new JButton("return");

        Font font2 = new Font("宋体", Font.BOLD, 25);
        returnb.setFont(font2);
        returnb.setSize(50, 50);
        returnb.setFocusPainted(false);
        returnb.setBorderPainted(false);


        ShowJP.add(returnb, BorderLayout.SOUTH);


        listerner1();
        listerner2();
        listerner3();
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

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



    //打开文件夹操作
    public void openFile(String path) {


        try {
            File file = new File(path);
            bi = ImageIO.read(file);
            ImageIcon image = new ImageIcon(path);
            image = new ImageIcon(image.getImage().getScaledInstance(350, 350, Image.SCALE_DEFAULT));
            label1.setIcon(image);


        } catch (IOException e) {

            return;
        }


    }


}
