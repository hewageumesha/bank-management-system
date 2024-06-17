import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.sql.ResultSet;
import java.util.Date;

public class fastCash extends JFrame implements ActionListener {
    JLabel image;
    JButton button1, button2, button3, button4, button5, button6, button7;
    String pin;

    fastCash(String pin) {
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

        JLabel label = new JLabel("SELECT WITHDRAW AMOUNT");
        label.setForeground(Color.WHITE);
        label.setFont(new Font("System", Font.BOLD, 16));
        label.setBounds(410,140,400,35);
        image.add(label);

        button1 = new JButton("Rs. 100");
        button1.setBounds(340,205,150,25);
        button1.setFont(new Font("System", Font.BOLD, 14));
        button1.setBackground(new Color(88, 92, 92));
        button1.setForeground(Color.WHITE);
        button1.addActionListener(this);
        image.add(button1);

        button2 = new JButton("Rs. 500");
        button2.setBounds(340,240,150,25);
        button2.setFont(new Font("System", Font.BOLD, 14));
        button2.setBackground(new Color(88, 92, 92));
        button2.setForeground(Color.WHITE);
        button2.addActionListener(this);
        image.add(button2);

        button3 = new JButton("Rs. 1 000");
        button3.setBounds(340,275,150,25);
        button3.setFont(new Font("System", Font.BOLD, 14));
        button3.setBackground(new Color(88, 92, 92));
        button3.setForeground(Color.WHITE);
        button3.addActionListener(this);
        image.add(button3);

        button4 = new JButton("Rs. 2 000");
        button4.setBounds(540,205,170,25);
        button4.setFont(new Font("System", Font.BOLD, 14));
        button4.setBackground(new Color(88, 92, 92));
        button4.setForeground(Color.WHITE);
        button4.addActionListener(this);
        image.add(button4);

        button5 = new JButton("Rs. 5 000");
        button5.setBounds(540,240,170,25);
        button5.setFont(new Font("System", Font.BOLD, 14));
        button5.setBackground(new Color(88, 92, 92));
        button5.setForeground(Color.WHITE);
        button5.addActionListener(this);
        image.add(button5);

        button6 = new JButton("Rs. 10 000");
        button6.setBounds(540,275,170,25);
        button6.setFont(new Font("System", Font.BOLD, 14));
        button6.setBackground(new Color(88, 92, 92));
        button6.setForeground(Color.WHITE);
        button6.addActionListener(this);
        image.add(button6);

        button7 = new JButton("BACK");
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
            if (e.getSource() == button7) {
                setVisible(false);
                new main(pin);
            } else {
                String amount = ((JButton)e.getSource()).getText().substring(4);
                connection conn = new connection();
                Date date = new Date();
                try {
                    ResultSet resultSet = conn.statement.executeQuery("SELECT * FROM bank WHERE pin = '"+pin+"'");
                    int balance = 0;
                    while (resultSet.next()) {
                        if(resultSet.getString("type").equals("Deposit")) {
                            balance += Integer.parseInt(resultSet.getString("amount"));
                        } else {
                            balance -= Integer.parseInt(resultSet.getString("amount"));
                        }
                    }

                    if(e.getSource() != button7 && balance < Integer.parseInt(amount)) {
                        JOptionPane.showMessageDialog(null, "Insufficient  balance");
                        return;
                    }

                    conn.statement.executeUpdate("INSERT INTO bank VALUES ('"+pin+"' , '"+date+"' , 'Withdraw' , '"+amount+"')");
                    JOptionPane.showMessageDialog(null, "Rs. " + amount + " Debited successfully");
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        setVisible(false);
        new main(pin);
    }

    public static void main(String[] args) {
        new fastCash("");
    }
}
