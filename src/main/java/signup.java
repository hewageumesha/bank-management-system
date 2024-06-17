import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.Random;
import com.toedter.calendar.JDateChooser;

public class signup extends JFrame implements ActionListener {
    Random random = new Random();
    long first4 = (random.nextLong() % 9000L) + 1000L;
    String first = " " + Math.abs(first4);

    JTextField textName, textAddress, textEmail, textCity, textPostal, textState;
    JDateChooser dateChooser;
    JRadioButton radioButton1, radioButton2, radioButton3, radioButton4, radioButton5;
    JButton next;

    signup() {
        super("Application From");

        URL bankIconURL = ClassLoader.getSystemResource("icon/bank.png");
        if (bankIconURL != null) {
            ImageIcon bank_icon = new ImageIcon(bankIconURL);
            Image bank_image = bank_icon.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
            ImageIcon image_Icon = new ImageIcon(bank_image);
            JLabel image = new JLabel(image_Icon);
            image.setBounds(10, 10, 100, 100);
            add(image);
        }

        JLabel label1 = new JLabel("Application form no: " + first);
        label1.setBounds(290,20,600,40);
        setFont(new Font("Raleway",Font.BOLD,40));
        add(label1);

        JLabel label2 = new JLabel("Page 1");
        label2.setBounds(340,60,600,30);
        setFont(new Font("Raleway",Font.BOLD,24));
        add(label2);

        JLabel label3 = new JLabel("Personal Details");
        label3.setBounds(310,90,500,30);
        setFont(new Font("Raleway",Font.BOLD,22));
        add(label3);

        JLabel fullName = new JLabel("Full Name: ");
        fullName.setBounds(100,140,200,30);
        setFont(new Font("Raleway",Font.BOLD,20));
        add(fullName);

        textName = new JTextField();
        textName.setBounds(250,140,400,30);
        textName.setFont(new Font("Raleway",Font.BOLD,14));
        add(textName);

        JLabel gender = new JLabel("Gender: ");
        gender.setBounds(100,190,200,30);
        setFont(new Font("Raleway",Font.BOLD,20));
        add(gender);

        radioButton1 = new JRadioButton("Male");
        radioButton1.setBounds(250,190,60,30);
        radioButton1.setFont(new Font("Raleway",Font.BOLD,14));
        radioButton1.setBackground(new Color(198, 226, 203));
        add(radioButton1);

        radioButton2 = new JRadioButton("Female");
        radioButton2.setBounds(370,190,90,30);
        radioButton2.setFont(new Font("Raleway",Font.BOLD,14));
        radioButton2.setBackground(new Color(198, 226, 203));
        add(radioButton2);

        ButtonGroup buttonGroup1 = new ButtonGroup();
        buttonGroup1.add(radioButton1);
        buttonGroup1.add(radioButton2);

        JLabel birthday = new JLabel("DOB: ");
        birthday.setBounds(100,240,200,30);
        setFont(new Font("Raleway",Font.BOLD,20));
        add(birthday);

        dateChooser = new JDateChooser();
        dateChooser.setForeground(new Color(105,105,105));
        dateChooser.setBounds(250,240,400,30);
        add(dateChooser);

        JLabel status = new JLabel("Marital Status: ");
        status.setBounds(100,290,200,30);
        setFont(new Font("Raleway",Font.BOLD,20));
        add(status);

        radioButton3 = new JRadioButton("Married");
        radioButton3.setBounds(250,290,100,30);
        radioButton3.setFont(new Font("Raleway",Font.BOLD,14));
        radioButton3.setBackground(new Color(198, 226, 203));
        add(radioButton3);

        radioButton4 = new JRadioButton("Unmarried");
        radioButton4.setBounds(370,290,100,30);
        radioButton4.setFont(new Font("Raleway",Font.BOLD,14));
        radioButton4.setBackground(new Color(198, 226, 203));
        add(radioButton4);

        radioButton5 = new JRadioButton("Other");
        radioButton5.setBounds(500,290,100,30);
        radioButton5.setFont(new Font("Raleway",Font.BOLD,14));
        radioButton5.setBackground(new Color(198, 226, 203));
        add(radioButton5);

        ButtonGroup buttonGroup2 = new ButtonGroup();
        buttonGroup2.add(radioButton3);
        buttonGroup2.add(radioButton4);
        buttonGroup2.add(radioButton5);

        JLabel email = new JLabel("Email Address: ");
        email.setBounds(100,340,200,30);
        setFont(new Font("Raleway",Font.BOLD,20));
        add(email);

        textEmail = new JTextField();
        textEmail.setBounds(250,340,400,30);
        textEmail.setFont(new Font("Raleway",Font.BOLD,14));
        add(textEmail);

        JLabel address = new JLabel("Address: ");
        address.setBounds(100,390,200,30);
        setFont(new Font("Raleway",Font.BOLD,20));
        add(address);

        textAddress = new JTextField();
        textAddress.setBounds(250,390,400,30);
        textAddress.setFont(new Font("Raleway",Font.BOLD,14));
        add(textAddress);

        JLabel city = new JLabel("City: ");
        city.setBounds(100,440,200,30);
        setFont(new Font("Raleway",Font.BOLD,20));
        add(city);

        textCity = new JTextField();
        textCity.setBounds(250,440,400,30);
        textCity.setFont(new Font("Raleway",Font.BOLD,14));
        add(textCity);

        JLabel state = new JLabel("State: ");
        state.setBounds(100,490,200,30);
        setFont(new Font("Raleway",Font.BOLD,20));
        add(state);

        textState = new JTextField();
        textState.setBounds(250,490,400,30);
        textState.setFont(new Font("Raleway",Font.BOLD,14));
        add(textState);

        JLabel Postal = new JLabel("Postal Code: ");
        Postal.setBounds(100,540,200,30);
        setFont(new Font("Raleway",Font.BOLD,20));
        add(Postal);

        textPostal = new JTextField();
        textPostal.setBounds(250,540,400,30);
        textPostal.setFont(new Font("Raleway",Font.BOLD,14));
        add(textPostal);

        next = new JButton("Next");
        next.setBounds(565,600,80,30);
        next.setFont(new Font("Raleway",Font.BOLD,14));
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.addActionListener(this);
        add(next);

        getContentPane().setBackground(new Color(198, 226, 203));
        setLayout(null);
        setSize(750,700);
        setLocation(250,0);
        setUndecorated(true);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        try {
            String form_no = first;
            String name = textName.getText();
            String dob = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();

            String gender = null;
            if(radioButton1.isSelected()) {
                gender = "Male";
            } else if (radioButton2.isSelected()) {
                gender = "Female";
            }

            String email = textEmail.getText();

            String status = null;
            if(radioButton3.isSelected()) {
                gender = "Married";
            } else if (radioButton4.isSelected()) {
                gender = "Unmarried";
            } else if (radioButton5.isSelected()) {
                gender = " Other";
            }

            String address = textAddress.getText();
            String city = textCity.getText();
            String postal = textPostal.getText();
            String state = textState.getText();

            try {
                if(textName.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Fill all the fields.");
                } else {
                    connection con1 = new connection();
                    String q = "INSERT INTO signup VALUES('"+form_no+"', '"+name+"' , '"+gender+"' , '"+dob+"' , '"+status+"' , '"+email+"' , '"+address+"' , '"+city+"' , '"+postal+"' , '"+state+"')";
                    con1.statement.executeUpdate(q);
                    setVisible(false);
                    new signup_new(form_no);
                }

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new signup();
    }
}
