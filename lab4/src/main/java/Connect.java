import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

class Connect {

    Connection connection;

    Connection getConnection() {
        return connection;
    }

    private void setConnection(Connection connection) {
        this.connection = connection;
    }

    Connect() throws SQLException, ClassNotFoundException {
        // log.info("Попытка подключения к бд");
        String url = "jdbc:mysql://localhost:3306/lab3";
        String login = "root";
        String password = "";
        String driver = "com.mysql.jdbc.Driver";
        Class.forName(driver);
        setConnection((Connection) DriverManager.getConnection(url, login, password));
        if (connection != null) {
            System.out.println("Соединение установлено.");
        }
    }

    void closeConnect() {
        try {
            getConnection().close();
            System.out.println("Соединение закрыто");
        } catch (SQLException e) {
            e.printStackTrace();
            //   log.error("Ошибка связанная с БД:\n");
        }
    }
}
