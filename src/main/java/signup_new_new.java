import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.Random;

public class signup_new_new extends JFrame implements ActionListener {
    String form_no;

    JButton submit, cancel;
    JCheckBox checkBox1, checkBox2, checkBox3, checkBox4, checkBox5, checkBox6;
    JComboBox comboBox;

    signup_new_new(String form_no) {
        super("Application Form");

        URL bankIconURL = ClassLoader.getSystemResource("icon/bank.png");
        if (bankIconURL != null) {
            ImageIcon bank_icon = new ImageIcon(bankIconURL);
            Image bank_image = bank_icon.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
            ImageIcon image_Icon = new ImageIcon(bank_image);
            JLabel image = new JLabel(image_Icon);
            image.setBounds(40, 20, 100, 100);
            add(image);
        } else {
            System.err.println("Error: Icon 'bank.png' not found");
        }

        this.form_no = form_no;

        JLabel label = new JLabel("Page 3: ");
        label.setFont(new Font("Raleway",Font.BOLD,20));
        label.setBounds(240,40,90,30);
        add(label);

        JLabel label1 = new JLabel("Account Details");
        label1.setFont(new Font("Raleway",Font.BOLD,20));
        label1.setBounds(330,40,200,30);
        add(label1);

        JLabel label2 = new JLabel("From No: ");
        label2.setBounds(530,20,80,30);
        label2.setFont(new Font("Raleway", Font.BOLD, 14));
        add(label2);

        JLabel label3 = new JLabel(form_no);
        label3.setBounds(600,20,80,30);
        label3.setFont(new Font("Raleway", Font.BOLD, 14));
        add(label3);

        JLabel label4 = new JLabel("Account Type ");
        label4.setBounds(100,140,200,30);
        label4.setFont(new Font("Raleway", Font.BOLD, 14));
        add(label4);

        String account_type[] = {"Saving Account", "Current Account" , "Fixed Deposit Account" , "Recurring Deposit Account"};
        comboBox = new JComboBox(account_type);
        comboBox.setBackground(new Color(153, 145, 184));
        comboBox.setFont(new Font("Raleway", Font.BOLD, 14));
        comboBox.setBounds(300,140,350,30);
        add(comboBox);

        JLabel label5 = new JLabel("Card Number ");
        label5.setBounds(100,190,200,30);
        label5.setFont(new Font("Raleway", Font.BOLD, 14));
        add(label5);

        JLabel label6 = new JLabel("(Your 16-Digit Card Number)");
        label6.setBounds(100,220,200,20);
        label6.setFont(new Font("Raleway", Font.BOLD, 12));
        add(label6);

        JLabel label7 = new JLabel("XXXX-XXXX-XXXX-4841");
        label7.setBounds(300,190,300,30);
        label7.setFont(new Font("Raleway", Font.BOLD, 14));
        add(label7);

        JLabel label8 = new JLabel("(It would appear on atm card/cheque Book and Statements)");
        label8.setBounds(300,220,350,20);
        label8.setFont(new Font("Raleway", Font.BOLD, 12));
        add(label8);

        JLabel label9 = new JLabel("PIN");
        label9.setBounds(100,270,200,30);
        label9.setFont(new Font("Raleway", Font.BOLD, 14));
        add(label9);

        JLabel label10 = new JLabel("(4-Digit Password)");
        label10.setBounds(100,300,200,20);
        label10.setFont(new Font("Raleway", Font.BOLD, 12));
        add(label10);

        JLabel label11 = new JLabel("XXXX");
        label11.setBounds(300,270,300,30);
        label11.setFont(new Font("Raleway", Font.BOLD, 14));
        add(label11);

        JLabel label12 = new JLabel("Services Required");
        label12.setBounds(100,350,200,30);
        label12.setFont(new Font("Raleway", Font.BOLD, 14));
        add(label12);

        checkBox1 = new JCheckBox("ATM Card");
        checkBox1.setBackground(new Color(153, 145, 184));
        checkBox1.setFont(new Font("Raleway", Font.BOLD, 14));
        checkBox1.setBounds(300,350,300,30);
        add(checkBox1);

        checkBox2 = new JCheckBox("Internet Banking");
        checkBox2.setBackground(new Color(153, 145, 184));
        checkBox2.setFont(new Font("Raleway", Font.BOLD, 14));
        checkBox2.setBounds(300,380,300,30);
        add(checkBox2);

        checkBox3 = new JCheckBox("Email Alerts");
        checkBox3.setBackground(new Color(153, 145, 184));
        checkBox3.setFont(new Font("Raleway", Font.BOLD, 14));
        checkBox3.setBounds(300,410,300,30);
        add(checkBox3);

        checkBox4 = new JCheckBox("Cheque Book");
        checkBox4.setBackground(new Color(153, 145, 184));
        checkBox4.setFont(new Font("Raleway", Font.BOLD, 14));
        checkBox4.setBounds(300,440,300,30);
        add(checkBox4);

        checkBox5 = new JCheckBox("E Statement");
        checkBox5.setBackground(new Color(153, 145, 184));
        checkBox5.setFont(new Font("Raleway", Font.BOLD, 14));
        checkBox5.setBounds(300,470,300,30);
        add(checkBox5);

        checkBox6 = new JCheckBox("I here by decleares that the above entered details correct to the best of my knowledge.", true);
        checkBox6.setBackground(new Color(153, 145, 184));
        checkBox6.setFont(new Font("Raleway", Font.BOLD, 14));
        checkBox6.setBounds(80,515,650,30);
        add(checkBox6);

        submit = new JButton("Submit");
        submit.setBounds(325,570,110,30);
        submit.setFont(new Font("Raleway",Font.BOLD,14));
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        add(submit);

        cancel = new JButton("Cancel");
        cancel.setBounds(525,570,80,30);
        cancel.setFont(new Font("Raleway",Font.BOLD,14));
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        add(cancel);

        getContentPane().setBackground(new Color(153, 145, 184));
        setLayout(null);
        setSize(740,700);
        setLocation(250,0);
        setUndecorated(true);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            String account_type = (String) comboBox.getSelectedItem();

            Random random = new Random();
            long first7 = (random.nextLong() % 90000000L) + 1409963000000000L;
            String card_no = "" + Math.abs(first7);

            long first3 = (random.nextLong() % 9000L) + 1000L;
            String pin = "" + Math.abs(first3);

            String services = "";
            if(checkBox1.isSelected()) {
                services = services + "ATM Card";
            } else if (checkBox2.isSelected()) {
                services = services + "Internet Banking";
            } else if (checkBox3.isSelected()) {
                services = services + "Email Alerts";
            } else if (checkBox4.isSelected()) {
                services = services + "Cheque Book";
            } else if (checkBox5.isSelected()) {
                services = services + "E Statement";
            }

            try {
                if(e.getSource() == submit) {
                    if(account_type.equals("")) {
                        JOptionPane.showMessageDialog(null, "Fill all the fields.");
                    } else {
                        connection conn =new connection();
                        String query1 = "INSERT INTO signup_new_new VALUES('"+form_no+"', '"+account_type+"', '"+card_no+"', '"+pin+"', '"+services+"')";
                        String query2 = "INSERT INTO login VALUES('"+form_no+"', '"+card_no+"', '"+pin+"')";
                        conn.statement.executeUpdate(query1);
                        conn.statement.executeUpdate(query2);
                        JOptionPane.showMessageDialog(null, "Card Number: " + card_no + "\n Pin: " + pin );
                        setVisible(false);
                        new deposit(pin);
                    }
                } else if (e.getSource() == cancel) {
                    System.exit(0);
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new signup_new_new("");
    }
}
