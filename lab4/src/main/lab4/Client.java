import javax.enterprise.inject.Default;
import javax.inject.Inject;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Objects;

public class Client {
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String dateOfBirth;
    private String passport;

    @Inject
    @Default
    Address address;

    public boolean signIn()
            throws SQLException, ClassNotFoundException {
        boolean flag;
        address.getFullAddress();           // инфа из адреса
        String c = address.getCity();
        String s = address.getStreet();
        String a = address.getAppart();

        Connect connect = new Connect();
        Statement statement = connect.getConnection().createStatement();

        if (!Objects.equals(getFirstName(), "") && !Objects.equals(getLastName(), "") && !Objects.equals(getEmail(), "") &&
                !Objects.equals(getPhoneNumber(), "") && !Objects.equals(getDateOfBirth(), "") && !Objects.equals(getPassport(), "") &&
                !Objects.equals(c, "") && !Objects.equals(s, "") && !Objects.equals(a, "")) {

            String query = "INSERT INTO client (fn, ln, em, tel, bday, passport, city, str, appart)" +
                    " VALUES ('" + getFirstName() + "','" + getLastName() + "','" + getEmail() + "','"
                    + getPhoneNumber() + "','" + getDateOfBirth() + "','" + getPassport() + "','" + address.getCity()
                    + "','" + address.getStreet() + "','" + address.getAppart() + "')";

            statement.executeQuery(query);

            flag = true;
        } else {
            flag = false;
        }
        return flag;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }
}
