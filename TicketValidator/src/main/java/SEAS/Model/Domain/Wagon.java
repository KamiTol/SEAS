package SEAS.Model.Domain;

import java.io.Serializable;

public class Wagon implements Serializable {
    private String type;
    private int capacityStandar;
    private int capacityExecutive;
    private int capacityPremium;
    private int capacityCargo;

    public Wagon(String type) {
        this.type = type;
        if (type.equals("Passenger")) {
            this.capacityStandar = 22;
            this.capacityExecutive = 8;
            this.capacityPremium = 4;
            this.capacityCargo = 0;
        } else {
            this.capacityStandar = 0;
            this.capacityExecutive = 0;
            this.capacityPremium = 0;
            this.capacityCargo = 80;
        }
    }


}
