import javax.enterprise.inject.Default;

@Default
public class Address {

    String city = "Minsk";
    String street = "Sverdlova";
    String appart = "13a";


    public String getFullAddress() {
        return getCity() + "\t" + getStreet() + "\t" + getAppart();
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getAppart() {
        return appart;
    }

    public void setAppart(String appart) {
        this.appart = appart;
    }
}
