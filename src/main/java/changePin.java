import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

public class changePin extends JFrame implements ActionListener {
    String pin;

    JLabel image;
    JButton button1, button2;
    JPasswordField passwordField, passwordField1;

    changePin(String pin) {
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

        this.pin = pin;

        JLabel label = new JLabel("CHANGE YOUR PIN");
        label.setForeground(Color.WHITE);
        label.setFont(new Font("System", Font.BOLD, 16));
        label.setBounds(450,120,400,35);
        image.add(label);

        JLabel label1 = new JLabel("NEW PIN: ");
        label1.setForeground(Color.WHITE);
        label1.setFont(new Font("System", Font.BOLD, 16));
        label1.setBounds(340,170,400,35);
        image.add(label1);

        passwordField = new JPasswordField();
        passwordField.setFont(new Font("Raleway", Font.BOLD, 16));
        passwordField.setBounds(510,175,150,22);
        passwordField.setBackground(new Color(88, 92, 92));
        passwordField.setForeground(Color.WHITE);
        image.add(passwordField);

        JLabel label2 = new JLabel("RE-ENTER NEW PIN: ");
        label2.setForeground(Color.WHITE);
        label2.setFont(new Font("System", Font.BOLD, 16));
        label2.setBounds(340,210,400,35);
        image.add(label2);

        passwordField1 = new JPasswordField();
        passwordField1.setFont(new Font("Raleway", Font.BOLD, 16));
        passwordField1.setBounds(510,215,150,22);
        passwordField1.setBackground(new Color(88, 92, 92));
        passwordField1.setForeground(Color.WHITE);
        image.add(passwordField1);

        button1 = new JButton("CHANGE");
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

        setLayout(null);
        setSize(1300,700);
        setLocation(0,0);
        setUndecorated(true);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            String pin1 = passwordField.getText();
            String pin2 = passwordField1.getText();

            if(!pin1.equals(pin2)) {
                JOptionPane.showMessageDialog(null, "Entered PIN does not match");
                return;
            }
            if(e.getSource() == button1) {
                if(passwordField.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Enter New PIN");
                    return;
                }
                if(passwordField1.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "Re-Enter New PIN");
                    return;
                }

                connection conn = new connection();
                String q1 = "UPDATE bank SET pin = '"+pin1+"' WHERE pin = '"+pin+"'";
                String q2 = "UPDATE login SET pin = '"+pin1+"' WHERE pin = '"+pin+"'";
                String q3 = "UPDATE signup_new_new SET pin = '"+pin1+"' WHERE pin = '"+pin+"'";
                conn.statement.executeUpdate(q1);
                conn.statement.executeUpdate(q2);
                conn.statement.executeUpdate(q3);
                JOptionPane.showMessageDialog(null, "PIN changed successfully");
                setVisible(false);
                new main(pin);

            } else if (e.getSource() == button2) {
                setVisible(false);
                new main(pin);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new changePin("");
    }
}
