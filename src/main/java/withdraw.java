import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.sql.ResultSet;
import java.util.Date;

public class withdraw extends JFrame implements ActionListener {
    String pin;

    JLabel image;
    JTextField textField;
    JButton button1, button2;

    withdraw(String pin) {
        super("Bank Management System");

        URL bankIconURL = ClassLoader.getSystemResource("icon/atm.png");
        if (bankIconURL != null) {
            ImageIcon bank_icon = new ImageIcon(bankIconURL);
            Image bank_image = bank_icon.getImage().getScaledInstance(1300, 630, Image.SCALE_DEFAULT);
            ImageIcon image_Icon = new ImageIcon(bank_image);
            image = new JLabel(image_Icon);
            image.setBounds(0, 0, 1300, 630);
            add(image);
        }

        JLabel label = new JLabel("MAXIMUM WITHDRAW IS RS. 10 000");
        label.setForeground(Color.WHITE);
        label.setFont(new Font("System", Font.BOLD, 16));
        label.setBounds(370,120,400,35);
        image.add(label);

        JLabel label1 = new JLabel("PLEASE ENTER YOUR AMOUNT");
        label1.setForeground(Color.WHITE);
        label1.setFont(new Font("System", Font.BOLD, 16));
        label1.setBounds(370,150,400,35);
        image.add(label1);

        textField = new JTextField();
        textField.setBackground(new Color(88, 92, 92));
        textField.setForeground(Color.WHITE);
        textField.setFont(new Font("Raleway", Font.BOLD, 16));
        textField.setBounds(370,190,320,22);
        image.add(textField);

        button1 = new JButton("WITHDRAW");
        button1.setBounds(580,275,130,28);
        button1.setFont(new Font("System", Font.BOLD, 16));
        button1.setBackground(new Color(88, 92, 92));
        button1.setForeground(Color.WHITE);
        button1.addActionListener(this);
        add(button1);

        button2 = new JButton("BACK");
        button2.setBounds(580,310,130,28);
        button2.setFont(new Font("System", Font.BOLD, 16));
        button2.setBackground(new Color(88, 92, 92));
        button2.setForeground(Color.WHITE);
        button2.addActionListener(this);
        add(button2);

        this.pin = pin;

        setLayout(null);
        setSize(1300,700);
        setLocation(0,0);
        setUndecorated(true);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == button1) {
            try {
                String amount = textField.getText();
                Date date = new Date();
                if(textField.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Please enter the amount you want to withdraw");
                } else {
                    connection conn = new connection();
                    String q = "SELECT * FROM bank WHERE pin = '"+pin+"'";
                    ResultSet resultSet = conn.statement.executeQuery(q);
                    int balance = 0;
                    while(resultSet.next()) {
                        if(resultSet.getString("type").equals("Deposit")) {
                            balance += Integer.parseInt(resultSet.getString("amount"));
                        } else {
                            balance -= Integer.parseInt(resultSet.getString("amount"));
                        }
                    }
                    if(balance < Integer.parseInt(amount)) {
                        JOptionPane.showMessageDialog(null,"Insufficient Balance");
                        return;
                    }

                    conn.statement.executeUpdate("INSERT INTO bank VALUES ('"+pin+"' , '"+date+"' , 'Withdraw' , '"+amount+"')");
                    JOptionPane.showMessageDialog(null, "Rs. "+amount+" Debited Successfully");
                    setVisible(false);
                    new main(pin);
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else if (e.getSource() == button2) {
            setVisible(false);
            new main(pin);
        }
    }

    public static void main(String[] args) {
        new withdraw("");
    }
}
