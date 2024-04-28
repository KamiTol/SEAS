package SEAS.Model.Domain;

public class Train {
    private String name;
    private String id;
    private int loadCapacity;
    private int mileage;

    public Train(String name, String id, int loadCapacity, int mileage) {
        this.name = name;
        this.id = id;
        this.loadCapacity = loadCapacity;
        this.mileage = mileage;
    }

    // Getters
    public String getName() { return name; }
    public String getId() { return id; }
    public int getLoadCapacity() { return loadCapacity; }
    public int getMileage() { return mileage; }

    // Setters
    public void setName(String name) { this.name = name; }
    public void setId(String id) { this.id = id; }
    public void setLoadCapacity(int loadCapacity) { this.loadCapacity = loadCapacity; }
    public void setMileage(int mileage) { this.mileage = mileage; }
}
