import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Auth {
    // static final Logger log = Logger.getLogger(Auth.class);

    private int id;
    private String login;
    private String password;

    public boolean checkAuth()
            throws SQLException, ClassNotFoundException {

        Error e = new Error();

        Connect connect = new Connect();

        PreparedStatement preparedStatement = connect.getConnection().
                prepareStatement("SELECT * FROM auth");

        ResultSet resultSet = preparedStatement.executeQuery();
        boolean flag = false;
        while (resultSet.next()) {
            int id = resultSet.getInt(1);
            String lgn = resultSet.getString(2);
            String psw = resultSet.getString(3);
            if (getLogin().equals(lgn) && getPassword().equals(psw)) {
                //     log.info("Вход выполнен под имененм " + lgn);
                setId(id);
                flag = true;
            }
        }

        preparedStatement.close();
        resultSet.close();
        connect.closeConnect();
        return flag;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId() {
        return id;
    }

    private void setId(int id) {
        this.id = id;
    }
}
