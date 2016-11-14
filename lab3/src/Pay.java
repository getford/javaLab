import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Pay {

    private int id;
    private int id_card;
    private int cash;

    int pay_cash;       // сумма для оплаты

    public void selectCash() throws SQLException, ClassNotFoundException {
        Connect connect = new Connect();
        Statement statement = connect.getConnection().createStatement();

        String sql_query_cash = "SELECT cash FROM card WHERE id_auth = " + getId() + " and id = " + getId_card();

        ResultSet resultSet = statement.executeQuery(sql_query_cash);
        while (resultSet.next()) {
            setCash(resultSet.getInt(1));
        }
        resultSet.close();
        statement.close();
        connect.closeConnect();
    }

    public void pay() throws SQLException, ClassNotFoundException {
        Connect connect = new Connect();
        Statement statement = connect.getConnection().createStatement();

        int tmp = getCash() - getPay_cash();

        String sql = "UPDATE card set cash = " + tmp + " WHERE id = " + getId() + " and id_card = " + getId_card();
        statement.execute(sql);

        connect.closeConnect();
        statement.close();


    }

    public boolean go() {
        boolean flag = true;
        return flag;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCash() {
        return cash;
    }

    public void setCash(int cash) {
        this.cash = cash;
    }

    public int getId_card() {
        return id_card;
    }

    public void setId_card(int id_card) {
        this.id_card = id_card;
    }

    public int getPay_cash() {
        return pay_cash;
    }

    public void setPay_cash(int pay_cash) {
        this.pay_cash = pay_cash;
    }
}
