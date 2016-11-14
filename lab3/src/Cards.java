import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Cards {
    private int id;
    private int id_card;
    private String name;
    private String cash;

    private int count;
    private ArrayList<Cards> arrayList;

    public Cards() {
    }

    public Cards(int id_card, String name, String cash) {
        this.id_card = id_card;
        this.name = name;
        this.cash = cash;
    }

    public void getAllCards()
            throws SQLException, ClassNotFoundException {
        Connect connect = new Connect();
        Statement statement = connect.getConnection().createStatement();

        String sql_query = "SELECT id, name_card, cash FROM card WHERE id_auth = " + getId();
        arrayList = new ArrayList<Cards>();

        ResultSet resultSet = statement.executeQuery(sql_query);
        while (resultSet.next()) {
            arrayList.add(new Cards(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3)));
        }

        statement.close();
        resultSet.close();
        connect.closeConnect();
    }

    public void getCountCards()
            throws SQLException, ClassNotFoundException {
        Connect connect = new Connect();
        Statement statement = connect.getConnection().createStatement();

        String sql_query_count = "SELECT COUNT(*) FROM card WHERE id_auth = " + getId();

        ResultSet resultSet = statement.executeQuery(sql_query_count);
        while (resultSet.next()) {
            setCount(resultSet.getInt(1));
        }

        resultSet.close();
        statement.close();
        connect.closeConnect();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCash() {
        return cash;
    }

    public void setCash(String cash) {
        this.cash = cash;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public ArrayList<Cards> getArrayList() {
        return arrayList;
    }

    public void setArrayList(ArrayList<Cards> arrayList) {
        this.arrayList = arrayList;
    }

    public int getId_card() {
        return id_card;
    }

    public void setId_card(int id_card) {
        this.id_card = id_card;
    }
}
