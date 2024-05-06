package SEAS.Model.Domain;

import java.io.Serializable;
import java.util.Date;

public class Train implements Serializable {
    private String name;
    private String id;
    private int loadCapacity;
    private int mileage;
    private Wagon[] wagon;
    private TrainType type;

    public Train(String id, String name, int loadCapacity, int mileage, Wagon[] wagon, TrainType type) {
        this.name = name;
        this.id = id;
        this.loadCapacity = loadCapacity;
        this.mileage = mileage;
        this.wagon = wagon;
        this.type = type;
    }

    public Train(String name, int loadCapacity, TrainType type) {
        this.id = "T" + name + new Date().getTime();
        this.name = name;
        this.mileage = 0;
        this.loadCapacity = loadCapacity;
        this.wagon = new Wagon[loadCapacity];
        this.type = type;
        for (int i = 0; i < loadCapacity/3*2; i++) {
            this.wagon[i] = new Wagon("Passenger");
        }
        for (int i = loadCapacity/3; i < loadCapacity; i++) {
            this.wagon[i] = new Wagon("Cargo");
        }
    }

    public Train(String id, String name, int loadCapacity, TrainType type) {
        this.id = id;
        this.name = name;
        this.mileage = 0;
        this.loadCapacity = loadCapacity;
        this.wagon = new Wagon[loadCapacity];
        this.type = type;
        for (int i = 0; i < loadCapacity/3*2; i++) {
            this.wagon[i] = new Wagon("Passenger");
        }
        for (int i = loadCapacity/3; i < loadCapacity; i++) {
            this.wagon[i] = new Wagon("Cargo");
        }
    }

    // Getters
    public String getName() { return name; }
    public String getId() { return id; }
    public int getLoadCapacity() { return loadCapacity; }
    public int getMileage() { return mileage; }

    public TrainType getType() {
        return type;
    }

    // Setters
    public void setName(String name) { this.name = name; }
    public void setId(String id) { this.id = id; }
    public void setLoadCapacity(int loadCapacity) { this.loadCapacity = loadCapacity; }
    public void setMileage(int mileage) { this.mileage = mileage; }
    public Wagon[] getWagon() { return wagon; }
    public void setWagon(Wagon[] wagon) { this.wagon = wagon; }

    public void setType(TrainType type) {
        this.type = type;
    }
}
