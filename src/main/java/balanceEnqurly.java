import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.sql.ResultSet;

public class balanceEnqurly extends JFrame implements ActionListener {
    String pin;

    JLabel image;
    JButton button1;

    balanceEnqurly(String pin) {
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

        JLabel label = new JLabel("Your current balance is Rs ");
        label.setForeground(Color.WHITE);
        label.setFont(new Font("System", Font.BOLD, 16));
        label.setBounds(370,120,400,35);
        image.add(label);

        JLabel label1 = new JLabel();
        label1.setForeground(Color.WHITE);
        label1.setFont(new Font("System", Font.BOLD, 16));
        label1.setBounds(370,150,400,35);
        image.add(label1);

        button1 = new JButton("BACK");
        button1.setBounds(580,310,130,28);
        button1.setFont(new Font("System", Font.BOLD, 16));
        button1.setBackground(new Color(88, 92, 92));
        button1.setForeground(Color.WHITE);
        button1.addActionListener(this);
        add(button1);

        int balance = 0;

        try {
            connection conn = new connection();
            ResultSet resultSet = conn.statement.executeQuery("SELECT * FROM bank WHERE pin = '"+pin+"'");
            while (resultSet.next()) {
                if(resultSet.getString("type").equals("Deposit")) {
                    balance += Integer.parseInt(resultSet.getString("amount"));
                } else {
                    balance -= Integer.parseInt(resultSet.getString("amount"));
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        label1.setText("" + balance);

        setLayout(null);
        setSize(1300,700);
        setLocation(0,0);
        setUndecorated(true);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);
        new main(pin);
    }

    public static void main(String[] args) {
        new balanceEnqurly("");
    }
}
