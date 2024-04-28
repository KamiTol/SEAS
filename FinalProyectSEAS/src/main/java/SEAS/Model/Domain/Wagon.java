package SEAS.Model.Domain;

public class Wagon {
    private String type;
    private int capacity;
    private String fareType;

    public Wagon(String type, int capacity, String fareType) {
        this.type = type;
        this.capacity = capacity;
        this.fareType = fareType;
    }

    // Getters
    public String getType() { return type; }
    public int getCapacity() { return capacity; }
    public String getFareType() { return fareType; }

    // Setters
    public void setType(String type) { this.type = type; }
    public void setCapacity(int capacity) { this.capacity = capacity; }
    public void setFareType(String fareType) { this.fareType = fareType; }
}
