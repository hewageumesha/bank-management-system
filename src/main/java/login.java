import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.sql.ResultSet;

public class login extends JFrame implements ActionListener {
    JLabel label1, label2, label3;
    JTextField textField;
    JPasswordField passwordField;
    JButton sign_in, clear, sign_up;

    login() {
        super("Bank Management System");

        URL bankIconURL = ClassLoader.getSystemResource("icon/bank.png");
        if (bankIconURL != null) {
            ImageIcon bank_icon = new ImageIcon(bankIconURL);
            Image bank_image = bank_icon.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
            ImageIcon image_Icon = new ImageIcon(bank_image);
            JLabel image = new JLabel(image_Icon);
            image.setBounds(270, 10, 300, 100);
            add(image);
        } else {
            System.err.println("Error: Icon 'bank.png' not found");
        }

        URL cardIconURL = ClassLoader.getSystemResource("icon/card.png");
        if (cardIconURL != null) {
            ImageIcon card_icon = new ImageIcon(cardIconURL);
            Image card_image = card_icon.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
            ImageIcon image1_Icon = new ImageIcon(card_image);
            JLabel image1 = new JLabel(image1_Icon);
            image1.setBounds(600, 200, 300, 300);
            add(image1);
        } else {
            System.err.println("Error: Icon 'card.png' not found");
        }

        label1 = new JLabel("WELCOME TO ATM");
        label1.setForeground(Color.WHITE);
        label1.setFont(new Font("AvantGrade", Font.BOLD, 38));
        label1.setBounds(230,125,450,40);
        add(label1);

        label2 = new JLabel("Card No: ");
        label2.setFont(new Font("Ralway",Font.BOLD,28));
        label2.setForeground(Color.WHITE);
        label2.setBounds(150,190,375,30);
        add(label2);

        textField = new JTextField(15);
        textField.setBounds(325,190,230,30);
        textField.setFont(new Font("Arial", Font.BOLD,14));
        add(textField);

        label3 = new JLabel("PIN: ");
        label3.setFont(new Font("Ralway",Font.BOLD,28));
        label3.setForeground(Color.WHITE);
        label3.setBounds(150,250,375,30);
        add(label3);

        passwordField = new JPasswordField(15);
        passwordField.setBounds(325,250,230,30);
        passwordField.setFont(new Font("Arial", Font.BOLD, 14));
        add(passwordField);

        sign_in = new JButton("SIGN IN");
        sign_in.setBounds(325,300,100,30);
        sign_in.setFont(new Font("Arial", Font.BOLD, 14));
        sign_in.setForeground(Color.WHITE);
        sign_in.setBackground(Color.BLACK);
        sign_in.addActionListener(this);
        add(sign_in);

        clear = new JButton("CLEAR");
        clear.setBounds(455,300,100,30);
        clear.setFont(new Font("Arial", Font.BOLD, 14));
        clear.setForeground(Color.WHITE);
        clear.setBackground(Color.BLACK);
        clear.addActionListener(this);
        add(clear);

        sign_up = new JButton("SIGN UP");
        sign_up.setBounds(325,350,230,30);
        sign_up.setFont(new Font("Arial", Font.BOLD, 14));
        sign_up.setForeground(Color.WHITE);
        sign_up.setBackground(Color.BLACK);
        sign_up.addActionListener(this);
        add(sign_up);

        URL backIconURL = ClassLoader.getSystemResource("icon/back_bg.png");
        if (backIconURL != null) {
            ImageIcon back_icon = new ImageIcon(backIconURL);
            Image back_image = back_icon.getImage().getScaledInstance(850, 480, Image.SCALE_DEFAULT);
            ImageIcon image2_Icon = new ImageIcon(back_image);
            JLabel image2 = new JLabel(image2_Icon);
            image2.setBounds(0, 0, 850, 480);
            add(image2);
        } else {
            System.err.println("Error: Icon 'back_bg.png' not found");
        }

        setLayout(null);
        setSize(850, 480);
        setLocation(200,100);
        setUndecorated(true);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            if(e.getSource() == sign_in) {
                connection conn = new connection();
                String card_no = textField.getText();
                String pin = passwordField.getText();
                String q = "SELECT * FROM login WHERE card_no = '"+card_no+"' and pin = '"+pin+"' ";
                ResultSet resultSet = conn.statement.executeQuery(q);
                if(resultSet.next()) {
                    setVisible(false);
                    new main(pin);
                } else {
                    JOptionPane.showMessageDialog(null,"Incorrect Card Number or PIN");
                }
            } else if(e.getSource() == clear) {
                textField.setText("");
                passwordField.setText("");
            } else if(e.getSource() == sign_up) {
                setVisible(false);
                new signup();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new login();
    }
}
