import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class connection {
    Connection connection;
    Statement statement;
    public connection() {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank_system", "root", "1234");
            statement = connection.createStatement();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
