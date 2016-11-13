package car;

public class Car {
    private int id;
    private String name_auto;
    private String model;
    private int take;

    public Car(int id, String name_auto, String model, int take) {
        this.id = id;
        this.name_auto = name_auto;
        this.model = model;
        this.take = take;
    }

    public Car(int id, String name_auto, String model) {
        this.id = id;
        this.name_auto = name_auto;
        this.model = model;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName_auto() {
        return name_auto;
    }

    public void setName_auto(String name_auto) {
        this.name_auto = name_auto;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getTake() {
        return take;
    }

    public void setTake(int take) {
        this.take = take;
    }
}
