import com.mysql.jdbc.Connection;
import org.apache.log4j.Logger;

import java.sql.DriverManager;
import java.sql.SQLException;

public class Connect {
    private static final Logger log = Logger.getLogger(Connect.class);

    private Connection connection;

    Connection getConnection() {
        return connection;
    }

    private void setConnection(Connection connection) {
        this.connection = connection;
    }

    Connect()
            throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/db_lab";
        String login = "root";
        String password = "";
        setConnection((Connection) DriverManager.getConnection(url, login, password));
        if (connection != null){
            System.out.println("Соединение установлено.");
    }}

    void closeConnect() {
        try {
            getConnection().close();
            System.out.println("Соединение закрыто");
        } catch (SQLException e) {
            e.printStackTrace();
            log.error("Ошибка связанная с БД:\n");
        }
    }
}
