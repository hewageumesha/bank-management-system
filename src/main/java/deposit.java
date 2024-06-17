import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.Date;

public class deposit extends JFrame implements ActionListener {
    String pin;

    JLabel image;
    JTextField textField;
    JButton button1, button2;
    deposit(String pin) {
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

        JLabel label = new JLabel("ENTER AMOUNT YOU WANT TO DEPOSIT");
        label.setFont(new Font("System", Font.BOLD, 16));
        label.setBounds(370,120,400,35);
        label.setForeground(Color.WHITE);
        image.add(label);

        textField = new JTextField();
        textField.setFont(new Font("Raleway", Font.BOLD, 16));
        textField.setBounds(370,160,320,22);
        textField.setBackground(new Color(88, 92, 92));
        textField.setForeground(Color.WHITE);
        image.add(textField);

        button1 = new JButton("DEPOSIT");
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
        try {
            String amount = textField.getText();
            Date date = new Date();
            if(e.getSource() == button1) {
                if(textField.getText().equals("")) {
                    JOptionPane.showMessageDialog(null,"Please enter the Amount you want to Deposit.");
                } else {
                    connection con1 = new connection();
                    String q = "INSERT INTO bank VALUES('"+pin+"', '"+date+"' , 'Deposit' , '"+amount+"')";
                    con1.statement.executeUpdate(q);
                    JOptionPane.showMessageDialog(null,"Rs. " + amount + " Deposited Successfully");
                    setVisible(false);
                    new main(pin);
                }
            } else if (e.getSource() == button2) {
                setVisible(false);
                new main(pin);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new deposit("");
    }
}
