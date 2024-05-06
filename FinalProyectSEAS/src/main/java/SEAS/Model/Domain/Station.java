package SEAS.Model.Domain;

import java.io.Serializable;

public class Station implements Serializable {
    private String id;
    private String name;
    private String location;

    public Station(String id, String name, String location) {
        this.id = id;
        this.name = name;
        this.location = location;
    }

    // Getters

    public String getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getLocation() {
        return location;
    }

    // Setters

    public void setId(String id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setLocation(String location) {
        this.location = location;
    }
}
