import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class statement extends JFrame implements ActionListener {
    String pin;
    JButton button;
    statement(String pin) {
        this.pin = pin;

        getContentPane().setBackground(new Color(255,204,204));
        setLayout(null);
        setSize(400,600);
        setLocation(400,30);
        setUndecorated(true);

        JLabel label = new JLabel();
        label.setBounds(20,140,400,200);
        add(label);

        JLabel label1 = new JLabel("Bank Management System");
        label1.setFont(new Font("System", Font.BOLD, 15));
        label1.setBounds(100,30,200,20);
        add(label1);

        JLabel label2 = new JLabel();
        label2.setBounds(20,80,300,20);
        add(label2);

        JLabel label3 = new JLabel();
        label3.setBounds(20,400,300,20);
        add(label3);

        try {
            connection conn = new connection();
            ResultSet resultSet = conn.statement.executeQuery("SELECT * FROM login WHERE pin = '" + pin + "'");
            if (resultSet.next()) {
                String cardNumber = resultSet.getString("card_no");
                System.out.println("Card number fetched: " + cardNumber);
                if (cardNumber != null && cardNumber.length() >= 12) {
                    label2.setText("Card number: " + cardNumber.substring(0, 4) + "XXXXXXX" + cardNumber.substring(11));
                } else {
                    label2.setText("Card number not found or invalid.");
                }
            } else {
                label2.setText("No matching card number found.");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            label2.setText("Error fetching card number.");
        }

        try {
            int balance = 0;
            connection conn = new connection();
            ResultSet resultSet = conn.statement.executeQuery("SELECT * FROM bank WHERE pin = '" + pin + "'");
            StringBuilder statementHtml = new StringBuilder("<html>");
            while (resultSet.next()) {
                String date = resultSet.getString("date");
                String type = resultSet.getString("type");
                String amount = resultSet.getString("amount");
                statementHtml.append(date).append("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;")
                        .append(type).append("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;")
                        .append(amount).append("<br><br><br>");

                if (type.equals("Deposit")) {
                    balance += Integer.parseInt(amount);
                } else if (type.equals("Withdraw")) {
                    balance -= Integer.parseInt(amount);
                }
            }
            statementHtml.append("</html>");
            label.setText(statementHtml.toString());

            label3.setText("Your total balance is Rs. " + balance);

        } catch (Exception ex) {
            ex.printStackTrace();
            label.setText("Error fetching statement.");
        }

        try {
            int balance = 0;
            connection conn = new connection();
            ResultSet resultSet = conn.statement.executeQuery("SELECT * FROM bank WHERE pin = '"+pin+"'");
            while (resultSet.next()) {
                label.setText(label.getText() + "<html>" + resultSet.getString("date") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + resultSet.getString("type") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + resultSet.getString("amount") + "<br><br><br></html>");

                if(resultSet.getString("type").equals("Deposit")) {
                    balance += Integer.parseInt(resultSet.getString("amount"));
                } else if (resultSet.getString("type").equals("Withdraw")){
                    balance -= Integer.parseInt(resultSet.getString("amount"));
                }
            }

            label3.setText("Your total balance is Rs. " + balance);

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        button = new JButton("EXIT");
        button.setBounds(20,500,100,25);
        button.setFont(new Font("System", Font.BOLD, 14));
        button.setBackground(new Color(88, 92, 92));
        button.setForeground(Color.WHITE);
        button.addActionListener(this);
        add(button);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);
    }

    public static void main(String[] args) {
        new statement("");
    }
}
