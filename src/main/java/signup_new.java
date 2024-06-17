import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

public class signup_new extends JFrame implements ActionListener {
    String form_no;

    JRadioButton radioButton1, radioButton2, radioButton3, radioButton4;
    JButton next;
    JComboBox<String> comboBox, comboBox1, comboBox2, comboBox3, comboBox4;
    JTextField textField1;

    signup_new(String form_no) {
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

        JLabel label = new JLabel("Page 2: ");
        label.setFont(new Font("Raleway", Font.BOLD, 20));
        label.setBounds(240, 40, 90, 30);
        add(label);

        JLabel label1 = new JLabel("Additional Details");
        label1.setFont(new Font("Raleway", Font.BOLD, 20));
        label1.setBounds(330, 40, 200, 30);
        add(label1);

        JLabel label2 = new JLabel("Religion");
        label2.setBounds(100, 140, 200, 30);
        label2.setFont(new Font("Raleway", Font.BOLD, 14));
        add(label2);

        String[] religion = {"Buddhist", "Hindu", "Muslim", "Christian", "Other"};
        comboBox = new JComboBox<>(religion);
        comboBox.setBackground(new Color(145, 184, 183));
        comboBox.setFont(new Font("Raleway", Font.BOLD, 14));
        comboBox.setBounds(300, 140, 300, 30);
        add(comboBox);

        JLabel label3 = new JLabel("Category");
        label3.setBounds(100, 190, 200, 30);
        label3.setFont(new Font("Raleway", Font.BOLD, 14));
        add(label3);

        String[] category = {"General", "OBC", "SC", "ST", "Other"};
        comboBox1 = new JComboBox<>(category);
        comboBox1.setBackground(new Color(145, 184, 183));
        comboBox1.setFont(new Font("Raleway", Font.BOLD, 14));
        comboBox1.setBounds(300, 190, 300, 30);
        add(comboBox1);

        JLabel label4 = new JLabel("Income");
        label4.setBounds(100, 240, 200, 30);
        label4.setFont(new Font("Raleway", Font.BOLD, 14));
        add(label4);

        String[] income = {"Null", "< 150 000", "< 250 000", "< 500 000", "< 1 000 000"};
        comboBox2 = new JComboBox<>(income);
        comboBox2.setBackground(new Color(145, 184, 183));
        comboBox2.setFont(new Font("Raleway", Font.BOLD, 14));
        comboBox2.setBounds(300, 240, 300, 30);
        add(comboBox2);

        JLabel label5 = new JLabel("Educational Qualification");
        label5.setBounds(100, 290, 200, 30);
        label5.setFont(new Font("Raleway", Font.BOLD, 14));
        add(label5);

        String[] education = {"Non-Graduate", "Graduate", "Post-Graduate", "Other"};
        comboBox3 = new JComboBox<>(education);
        comboBox3.setBackground(new Color(145, 184, 183));
        comboBox3.setFont(new Font("Raleway", Font.BOLD, 14));
        comboBox3.setBounds(300, 290, 300, 30);
        add(comboBox3);

        JLabel label6 = new JLabel("Occupation");
        label6.setBounds(100, 340, 200, 30);
        label6.setFont(new Font("Raleway", Font.BOLD, 14));
        add(label6);

        String[] occupation = {"Salaried", "Self-Employed", "Business", "Student", "Retired", "Other"};
        comboBox4 = new JComboBox<>(occupation);
        comboBox4.setBackground(new Color(145, 184, 183));
        comboBox4.setFont(new Font("Raleway", Font.BOLD, 14));
        comboBox4.setBounds(300, 340, 300, 30);
        add(comboBox4);

        JLabel label7 = new JLabel("PAN Number");
        label7.setBounds(100, 390, 200, 30);
        label7.setFont(new Font("Raleway", Font.BOLD, 14));
        add(label7);

        textField1 = new JTextField();
        textField1.setBounds(300, 390, 300, 30);
        textField1.setFont(new Font("Raleway", Font.BOLD, 14));
        add(textField1);

        JLabel label8 = new JLabel("Senior Citizen");
        label8.setBounds(100, 440, 200, 30);
        label8.setFont(new Font("Raleway", Font.BOLD, 14));
        add(label8);

        radioButton1 = new JRadioButton("Yes");
        radioButton1.setBounds(300, 440, 100, 30);
        radioButton1.setFont(new Font("Raleway", Font.BOLD, 14));
        radioButton1.setBackground(new Color(145, 184, 183));
        add(radioButton1);

        radioButton2 = new JRadioButton("No");
        radioButton2.setBounds(450, 440, 100, 30);
        radioButton2.setFont(new Font("Raleway", Font.BOLD, 14));
        radioButton2.setBackground(new Color(145, 184, 183));
        add(radioButton2);

        ButtonGroup buttonGroup1 = new ButtonGroup();
        buttonGroup1.add(radioButton1);
        buttonGroup1.add(radioButton2);

        JLabel label9 = new JLabel("Existing Account");
        label9.setBounds(100, 490, 200, 30);
        label9.setFont(new Font("Raleway", Font.BOLD, 14));
        add(label9);

        radioButton3 = new JRadioButton("Yes");
        radioButton3.setBounds(300, 490, 100, 30);
        radioButton3.setFont(new Font("Raleway", Font.BOLD, 13));
        radioButton3.setBackground(new Color(145, 184, 183));
        add(radioButton3);

        radioButton4 = new JRadioButton("No");
        radioButton4.setBounds(450, 490, 100, 30);
        radioButton4.setFont(new Font("Raleway", Font.BOLD, 14));
        radioButton4.setBackground(new Color(145, 184, 183));
        add(radioButton4);

        ButtonGroup buttonGroup2 = new ButtonGroup();
        buttonGroup2.add(radioButton3);
        buttonGroup2.add(radioButton4);

        JLabel label10 = new JLabel("Form No: ");
        label10.setBounds(530, 20, 80, 30);
        label10.setFont(new Font("Raleway", Font.BOLD, 14));
        add(label10);

        JLabel label11 = new JLabel(form_no);
        label11.setBounds(600, 20, 80, 30);
        label11.setFont(new Font("Raleway", Font.BOLD, 14));
        add(label11);

        next = new JButton("Next");
        next.setBounds(525, 570, 80, 30);
        next.setFont(new Font("Raleway", Font.BOLD, 14));
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.addActionListener(this);
        add(next);

        getContentPane().setBackground(new Color(145, 184, 183));
        setLayout(null);
        setSize(740, 700);
        setLocation(250, 0);
        setUndecorated(true);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            String religion = (String) comboBox.getSelectedItem();
            String category = (String) comboBox1.getSelectedItem();
            String income = (String) comboBox2.getSelectedItem();
            String education = (String) comboBox3.getSelectedItem();
            String occupation = (String) comboBox4.getSelectedItem();

            String pan = textField1.getText();

            String citizen = null;
            if (radioButton1.isSelected()) {
                citizen = "Yes";
            } else if (radioButton2.isSelected()) {
                citizen = "No";
            }

            String existing_account = null;
            if (radioButton3.isSelected()) {
                existing_account = "Yes";
            } else if (radioButton4.isSelected()) {
                existing_account = "No";
            }

            if (pan.equals("")) {
                JOptionPane.showMessageDialog(null, "Fill all the fields.");
            } else {
                connection conn = new connection();
                String query = "INSERT INTO signup_new VALUES('" + form_no + "', '" + religion + "', '" + category + "', '" + income + "', '" + education + "', '" + occupation + "', '" + pan + "', '" + citizen + "', '" + existing_account + "')";
                conn.statement.executeUpdate(query);
                setVisible(false);
                new signup_new_new(form_no);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new signup_new("");
    }
}
