package lab_cdi;

public class Address {
    private String city;
    private String street;
    private int house;

    public Address(String city, String street, int house) {
        this.city = city;
        this.street = street;
        this.house = house;
    }

    @Override
    public String toString() {
        return city + "\t" + street + "\t" + house + "\n";
    }
}
