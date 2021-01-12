package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Home_Page extends JFrame implements ActionListener {
    JPanel jPanel1;
    JLabel jLabel_image;
    public Home_Page(){

        jPanel1 = new JPanel();
        jPanel1.setLayout(null);
        jPanel1.setOpaque(false);
        jPanel1.setSize(400,800);

        ImageIcon image= new ImageIcon("C:\\Users\\zzzzzz\\IdeaProjects\\PDC_project\\image\\商城.png");

        jLabel_image = new JLabel(image);
        jLabel_image.setBounds(0,0,400,400);

        jPanel1.add(jLabel_image);
        this.setTitle("Home Page");
        this.add(jPanel1);
        this.setSize(400,800);
        this.setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
