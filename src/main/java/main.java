import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.jar.JarFile;

public class main extends JFrame implements ActionListener {
    JLabel image;
    JButton button1, button2, button3, button4, button5, button6, button7;
    String pin;
    main(String pin) {
        super("Bank Management System");

        this.pin = pin;

        URL bankIconURL = ClassLoader.getSystemResource("icon/atm.png");
        if (bankIconURL != null) {
            ImageIcon bank_icon = new ImageIcon(bankIconURL);
            Image bank_image = bank_icon.getImage().getScaledInstance(1300, 630, Image.SCALE_DEFAULT);
            ImageIcon image_Icon = new ImageIcon(bank_image);
            image = new JLabel(image_Icon);
            image.setBounds(0, 0, 1300, 630);
            add(image);
        }

        JLabel label = new JLabel("PLEASE SELECT YOUR TRANSACTION");
        label.setFont(new Font("System", Font.BOLD, 16));
        label.setBounds(370,120,400,35);
        label.setForeground(Color.WHITE);
        image.add(label);

        button1 = new JButton("DEPOSIT");
        button1.setBounds(340,205,150,25);
        button1.setFont(new Font("System", Font.BOLD, 14));
        button1.setBackground(new Color(88, 92, 92));
        button1.setForeground(Color.WHITE);
        button1.addActionListener(this);
        image.add(button1);

        button2 = new JButton("FAST CASH");
        button2.setBounds(340,240,150,25);
        button2.setFont(new Font("System", Font.BOLD, 14));
        button2.setBackground(new Color(88, 92, 92));
        button2.setForeground(Color.WHITE);
        button2.addActionListener(this);
        image.add(button2);

        button3 = new JButton("PIN CHANGE");
        button3.setBounds(340,275,150,25);
        button3.setFont(new Font("System", Font.BOLD, 14));
        button3.setBackground(new Color(88, 92, 92));
        button3.setForeground(Color.WHITE);
        button3.addActionListener(this);
        image.add(button3);

        button4 = new JButton("CASH WITHDRAW");
        button4.setBounds(540,205,170,25);
        button4.setFont(new Font("System", Font.BOLD, 14));
        button4.setBackground(new Color(88, 92, 92));
        button4.setForeground(Color.WHITE);
        button4.addActionListener(this);
        image.add(button4);

        button5 = new JButton("MINI STATEMENT");
        button5.setBounds(540,240,170,25);
        button5.setFont(new Font("System", Font.BOLD, 14));
        button5.setBackground(new Color(88, 92, 92));
        button5.setForeground(Color.WHITE);
        button5.addActionListener(this);
        image.add(button5);

        button6 = new JButton("BALANCE ENQUIRY");
        button6.setBounds(540,275,170,25);
        button6.setFont(new Font("System", Font.BOLD, 14));
        button6.setBackground(new Color(88, 92, 92));
        button6.setForeground(Color.WHITE);
        button6.addActionListener(this);
        image.add(button6);

        button7 = new JButton("EXIT");
        button7.setBounds(540,310,170,25);
        button7.setFont(new Font("System", Font.BOLD, 14));
        button7.setBackground(new Color(88, 92, 92));
        button7.setForeground(Color.WHITE);
        button7.addActionListener(this);
        image.add(button7);

        setLayout(null);
        setSize(1300,700);
        setLocation(0,0);
        setUndecorated(true);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            if(e.getSource() == button1) {
                setVisible(false);
                new deposit(pin);
            } else if (e.getSource() == button2) {
                setVisible(false);
                new fastCash(pin);
            } else if (e.getSource() == button3) {
                setVisible(false);
                new changePin(pin);
            } else if (e.getSource() == button4) {
                setVisible(false);
                new withdraw(pin);
            } else if (e.getSource() == button5) {
                setVisible(false);
                new statement(pin);
            } else if (e.getSource() == button6) {
                setVisible(false);
                new balanceEnqurly(pin);
            } else if (e.getSource() == button7) {
                System.exit(0);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new main("");
    }
}
