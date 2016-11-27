import javax.inject.Inject;
import javax.validation.constraints.NotNull;

public class Address {

    @NotNull
    private String city;
    @NotNull
    private String street;
    @NotNull
    private String appart;

    @Inject
    public Address() {
    }

    public Address(String city, String street, String appart) {
        this.city = city;
        this.street = street;
        this.appart = appart;
    }

    @Override
    public String toString() {
        return city + "\t" + street + "\t" + appart;
    }
}
