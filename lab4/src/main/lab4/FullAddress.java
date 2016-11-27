import javax.inject.Inject;
import javax.validation.constraints.NotNull;

@FullAddressAnn
public class FullAddress extends Address {

    @NotNull
    private String city;
    @NotNull
    private String street;
    @NotNull
    private String appart;
    @NotNull
    private String room;

    @Inject
    public FullAddress(String city, String street, String appart, String room) {
        this.city = city;
        this.street = street;
        this.appart = appart;
        this.room = room;
    }

    @Override
    public String toString() {
        return city + "\t" + street + "\t" + appart + "\t" + room;
    }

    public static void main(String[] args) {
        FullAddress fullAddress = new FullAddress("MINSK", "Sverdlova", "13a", "413");
        Address address = new Address("MINSK", "Sverdlova", "13a");
        Client client = new Client("Vladimir","Zhigalo", "awdawd",
                "+375292010505", "29.09.1996", fullAddress, "123456789");
        System.out.println(client.toString());
    }
}
