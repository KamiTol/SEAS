package SEAS.Model.Domain;

import java.io.Serializable;

public class Baggage implements Serializable {
    private String id;
    private double weight;

    public Baggage(String id, double weight) {
        this.id = id;
        this.weight = weight;
    }

    // Getters
    public String getId() { return id; }
    public double getWeight() { return weight; }

    // Setters
    public void setId(String id) { this.id = id; }
    public void setWeight(double weight) { this.weight = weight; }
}
