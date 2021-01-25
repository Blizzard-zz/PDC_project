package GUI_1;


import database.*;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;

import javax.swing.JButton;

import javax.swing.JComboBox;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

public class SwingRegister extends JFrame implements ActionListener {


    JButton btn;
    JButton btn3;


    JComboBox jComboBox;
    JComboBox jComboBox1;
    JTextField nameTxt;
    JLabel pwdLbl;
    JLabel genderLbl;

    boolean same = false;
    public create_table table;
    public String select;
    public String select1;
    public String username;
    public String first_name;
    public String last_name;
    public String phone_number;
    public String password1;
    public String password2;
    public String staff_register;
    public String security_question;
    JPasswordField pwd;
    JPasswordField id;
    JLabel firstname;
    JTextField firstname1;
    JLabel lastname;
    JTextField lastname1;
    JLabel phone;
    JTextField phone1;
    JLabel qusetion;
    JTextField qusetion1;
    JLabel asLbl;
    JLabel register1;
    JTextField register;
    JLabel ediLbl;
    public ArrayList<String> list;

    public SwingRegister() {
        this.init();
        list = new ArrayList<>();
        list.add("ADLKOJ908");
        list.add("LAKNE736");
        list.add("ASLFE834");
        list.add("XIULK835");
        list.add("ASJHF957");
        table = new create_table();
    }

    public void init() {
        this.setTitle("Register");
        this.setBounds(100, 100, 500, 600);
        this.createUI();
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    public void createUI() {
        JPanel panel = new JPanel();

        Border border = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
        TitledBorder tBorder = BorderFactory.createTitledBorder(border, "Register Page", TitledBorder.CENTER, TitledBorder.TOP);
        panel.setBorder(tBorder);
        panel.setLayout(null);
        this.add(panel);

        JLabel nameLbl = new JLabel("Account:");
        nameLbl.setBounds(60, 50, 80, 30);
        panel.add(nameLbl);
        nameLbl.setFont(new Font("Calibri", Font.BOLD, 18));

        nameTxt = new JTextField();
        nameTxt.setBounds(230, 50, 200, 30);
        username = nameTxt.getText();
        panel.add(nameTxt);

        pwdLbl = new JLabel("Password:");
        pwdLbl.setBounds(60, 90, 100, 30);
        panel.add(pwdLbl);
        pwdLbl.setFont(new Font("Calibri", Font.BOLD, 18));

        pwd = new JPasswordField();
        pwd.setBounds(230, 90, 200, 30);
        password1 = String.valueOf(pwd.getPassword());
        panel.add(pwd);


        genderLbl = new JLabel("Confirm Password:");
        genderLbl.setBounds(60, 130, 160, 30);
        panel.add(genderLbl);
        genderLbl.setFont(new Font("Calibri", Font.BOLD, 18));

        id = new JPasswordField();
        id.setBounds(230, 130, 200, 30);
        password2 = String.valueOf(id.getPassword());
        panel.add(id);

        same = judge_same(password1, password2);

        firstname = new JLabel("Firstname:");
        firstname.setBounds(60, 170, 90, 30);
        panel.add(firstname);
        firstname.setFont(new Font("Calibri", Font.BOLD, 18));

        firstname1 = new JTextField();
        firstname1.setBounds(230, 170, 200, 30);
        first_name = firstname1.getText();
        panel.add(firstname1);


        lastname = new JLabel("Lastname:");
        lastname.setBounds(60, 210, 90, 30);
        panel.add(lastname);
        lastname.setFont(new Font("Calibri", Font.BOLD, 18));


        lastname1 = new JTextField();
        lastname1.setBounds(230, 210, 200, 30);
        last_name = lastname1.getText();
        panel.add(lastname1);


        phone = new JLabel("Phone Number:");
        phone.setBounds(60, 250, 120, 30);
        panel.add(phone);
        phone.setFont(new Font("Calibri", Font.BOLD, 18));


        phone1 = new JTextField();
        phone1.setBounds(230, 250, 200, 30);
        phone_number = phone1.getText();
        panel.add(phone1);

        jComboBox1 = new JComboBox();
        jComboBox1.addItem("What's your father's name?");

        jComboBox1.setBounds(230, 290, 210, 30);
        select1 = (String) jComboBox1.getSelectedItem();
        System.out.println(select1);
        jComboBox1.addActionListener(this);
        panel.add(jComboBox1);

        qusetion1 = new JTextField();
        qusetion1.setBounds(230, 330, 200, 30);
        security_question = qusetion1.getText();
        panel.add(qusetion1);

        asLbl = new JLabel("Answer:");
        asLbl.setBounds(60, 330, 90, 30);
        panel.add(asLbl);
        asLbl.setFont(new Font("Calibri", Font.BOLD, 18));

        ediLbl = new JLabel("Identify:");
        ediLbl.setBounds(60, 370, 90, 30);
        panel.add(ediLbl);
        ediLbl.setFont(new Font("Calibri", Font.BOLD, 18));

        jComboBox = new JComboBox();
        jComboBox.addItem("Customer");
        jComboBox.addItem("Staff");
        jComboBox.setBounds(230, 370, 120, 30);
        select = (String) jComboBox.getSelectedItem();
        System.out.println(select);
        jComboBox.addActionListener(this);
        panel.add(jComboBox);


        register1 = new JLabel("Register:");
        register1.setBounds(60, 410, 90, 30);
        panel.add(register1);
        register1.setFont(new Font("Calibri", Font.BOLD, 18));

        register = new JTextField();
        register.setBounds(230, 410, 200, 30);
        panel.add(register);
        staff_register = register.getText();

        btn = new JButton("Submit");
        btn.setBounds(100, 470, 100, 40);
        btn.addActionListener(this);
        btn.setFont(new Font("Calibri", Font.BOLD, 22));

        panel.add(btn);

        btn3 = new JButton("Exit");
        btn3.setBounds(280, 470, 70, 40);
        panel.add(btn3);
        btn3.addActionListener(this);
        btn3.setFont(new Font("Calibri", Font.BOLD, 22));
    }

    private boolean judge_same(String password1, String password2) {
        boolean same = false;
        if (password1.equals(password2)) {
            same = true;
        }
        return same;
    }

//    public static void main(String[] args) {
//        SwingRegister sw = new SwingRegister();
//        sw.setVisible(true);
//    }

    @Override
    public void actionPerformed(ActionEvent e) {

        //select
        if (e.getSource() == jComboBox) {
            select = (String) jComboBox.getSelectedItem();
            System.out.println(select);
        }
        //question
        if (e.getSource() == jComboBox1) {
            select1 = (String) jComboBox1.getSelectedItem();
            System.out.println(select1);
        }
        //submit
        if (e.getSource() == btn) {
            int option = JOptionPane.showConfirmDialog(null, "Are you sure？", "Notes", JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);

            password1 = String.valueOf(pwd.getPassword());
            password2 = String.valueOf(id.getPassword());
            same = judge_same(password1, password2);
            username = nameTxt.getText();
            first_name = firstname1.getText();
            last_name = lastname1.getText();
            phone_number = phone1.getText();
            security_question = qusetion1.getText();
            staff_register = register.getText();
            boolean is_empty = is_empty();
            if (option == JOptionPane.OK_OPTION) {
                if (is_empty) {

                } else {
                    if (same) {
                        //写入数据
                        if (select.equals("Customer")) {
                            System.out.println(username + " " + first_name + " " + last_name + " " + phone_number + " " + password1 + " " + security_question);
                            table.customer.insert(username, first_name, last_name, phone_number, password1, security_question);
                            System.out.println("Customer submit!!");
                        } else if (select.equals("Staff")) {
                            if (list.contains(staff_register)) {
                                System.out.println(username + " " + first_name + " " + last_name + " " + phone_number + " " + password1 + " " + staff_register + " " + security_question);
                                table.staff.insert(username, first_name, last_name, phone_number, password1, staff_register, security_question);
                                System.out.println("Staff submit!!");
                            }
                        }
//                        System.out.println("OK!submit!!");
//                        System.exit(0);

                    } else {
                        JOptionPane.showMessageDialog(null, "The two passwords are inconsistent," +
                                "please input again.", "incorrect!", JOptionPane.ERROR_MESSAGE);

                    }

                }

            } else {
                System.out.println("NO!cancel!!");
            }


        }

        //exit
        if (e.getSource() == btn3) {
//            this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            this.dispose();
        }


    }

    public boolean is_empty() {
        boolean _empty = false;
        password1 = String.valueOf(pwd.getPassword());
        password2 = String.valueOf(id.getPassword());
        same = judge_same(password1, password2);
        username = nameTxt.getText();
        first_name = firstname1.getText();
        last_name = lastname1.getText();
        phone_number = phone1.getText();
        security_question = qusetion1.getText();
        if (username.length() == 0 || first_name.length() == 0 || last_name.length() == 0) {
            JOptionPane.showMessageDialog(null, "Name can't be empty," +
                    "please input again.", "incorrect!", JOptionPane.ERROR_MESSAGE);
            _empty = true;
        } else if (password1.length() == 0 || password2.length() == 0) {
            JOptionPane.showMessageDialog(null, "Passwords can't be empty," +
                    "please input again.", "incorrect!", JOptionPane.ERROR_MESSAGE);
            _empty = true;
        } else if (phone_number.length() == 0) {
            JOptionPane.showMessageDialog(null, "Phone_number can't be empty," +
                    "please input again.", "incorrect!", JOptionPane.ERROR_MESSAGE);
            _empty = true;
        } else if (security_question.length() == 0) {
            JOptionPane.showMessageDialog(null, "Question answer can't be empty," +
                    "please input again.", "incorrect!", JOptionPane.ERROR_MESSAGE);
            _empty = true;
        }
        return _empty;
    }
}


