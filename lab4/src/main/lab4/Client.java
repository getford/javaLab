import javax.inject.Inject;
import javax.validation.constraints.NotNull;

public class Client {
    private final Address address;
    @NotNull(message = "Введите имя")
    private String firstName;
    @NotNull(message = "Введите фамилию")
    private String lastName;
    @NotNull(message = "Введите e-mail")
    private String email;
    @NotNull(message = "Введите номер телефона")
    private String phoneNumber;
    @NotNull(message = "Введите дату рождения")
    private String dateOfBirth;
    @NotNull(message = "Введите номер пасспорта")
    private String passport;

    @Inject
    Client(String firstName, String lastName, String email, String phoneNumber, String dateOfBirth, @FullAddressAnn Address address, String passport) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.passport = passport;
    }

    @Override
    public String toString() {
        return firstName + "\t" + lastName + "\t" + email + "\t" + phoneNumber + "\t" + dateOfBirth + "\t" + address + "\t" + passport;
    }

    /*
    public boolean signIn()
            throws SQLException, ClassNotFoundException {
        boolean flag;
        address.getFullAddress();           // инфа из адреса

        String c = address.getCity();
        String s = address.getStreet();
        String a = address.getAppart();

        String query = "INSERT INTO client (fn, ln, em, tel, bday, passport, city, str, appart) VALUES ('"
                + getFirstName() + "','" + getLastName() + "','" + getEmail() + "','"
                + getPhoneNumber() + "','" + getDateOfBirth() + "','" + getPassport() + "','"
                + c + "','" + s + "','" + a + "')";

        Connect connect = new Connect();
        Statement statement = connect.getConnection().createStatement();

        if (!Objects.equals(getFirstName(), "") && !Objects.equals(getLastName(), "") && !Objects.equals(getEmail(), "") &&
                !Objects.equals(getPhoneNumber(), "") && !Objects.equals(getDateOfBirth(), "") && !Objects.equals(getPassport(), "") &&
                !Objects.equals(c, "") && !Objects.equals(s, "") && !Objects.equals(a, "")) {

            statement.executeUpdate(query);

            flag = true;
        } else {
            flag = false;
        }
        return flag;
    }
*/

}
