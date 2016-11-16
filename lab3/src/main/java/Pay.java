import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Pay {

    private int id;
    private int cash;
    private String id_card;
    private String name;

    private int pay_cash;       // сумма для оплаты

    public boolean selectInfoCard()
            throws SQLException, ClassNotFoundException {
        boolean flag = false;
        int tmp = Integer.parseInt(getId_card());

        if (tmp >= 0) {
            Connect connect = new Connect();
            Statement statement = connect.getConnection().createStatement();

            String sql_query_info = "SELECT name_card, cash FROM card WHERE id = " + tmp;

            ResultSet resultSet = statement.executeQuery(sql_query_info);

            while (resultSet.next()) {
                setName(resultSet.getString(1));
                setCash(resultSet.getInt(2));
            }
            resultSet.close();
            statement.close();
            connect.closeConnect();

            flag = true;
        }
        return flag;
    }

    public boolean pay()       // оплата
            throws SQLException, ClassNotFoundException {
        Error e = new Error();
        boolean flag = false;
        int tmp = getCash() - getPay_cash();
        if (getCash() < getPay_cash()) {
            e.errors("ERROR_PAY");
        }
        if (tmp >= 0 && tmp <= Integer.parseInt(getId_card())) {
            Connect connect = new Connect();
            Statement statement = connect.getConnection().createStatement();
            String sql = "UPDATE card set cash = " + tmp + " WHERE id = " + getId_card();
            statement.execute(sql);

            connect.closeConnect();
            statement.close();
            flag = true;
        } else {
            e.errors("ERROR_NUM_CARD");
        }
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

    private void setCash(int cash) {
        this.cash = cash;
    }

    public String getId_card() {
        return id_card;
    }

    public void setId_card(String id_card) {
        this.id_card = id_card;
    }

    public int getPay_cash() {
        return pay_cash;
    }

    public void setPay_cash(int pay_cash) {
        this.pay_cash = pay_cash;
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }
}
