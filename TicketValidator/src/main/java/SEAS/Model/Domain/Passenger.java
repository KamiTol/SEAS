package SEAS.Model.Domain;

import java.io.Serializable;

public class Passenger implements Serializable {
    private String id;
    private String name;
    private String surname;
    private String idType;
    private String currentAddress;
    private String phoneNumber;

    public Passenger(String id, String name, String surname, String idType, String currentAddress, String phoneNumber) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.idType = idType;
        this.currentAddress = currentAddress;
        this.phoneNumber = phoneNumber;
    }

    // Getters
    public String getId() { return id; }
    public String getName() { return name; }
    public String getSurname() { return surname; }
    public String getIdType() { return idType; }
    public String getCurrentAddress() { return currentAddress; }
    public String getPhoneNumber() { return phoneNumber; }

    // Setters
    public void setId(String id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setSurname(String surname) { this.surname = surname; }
    public void setIdType(String idType) { this.idType = idType; }
    public void setCurrentAddress(String currentAddress) { this.currentAddress = currentAddress; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }
}
