package lab_cdi;

public class FullAddress {
    private String country;
    private String city;
    private String street;
    private int house;

    public FullAddress(String country, String city, String street, int house) {
        this.country = country;
        this.city = city;
        this.street = street;
        this.house = house;
    }

    @Override
    public String toString() {
        return country + "\t" + city + "\t" + street + "\t" + house + "\n";
    }
}
