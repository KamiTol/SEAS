package SEAS.Model.Domain;

import java.io.Serializable;

public class Ticket implements Serializable {
    private String id;
    private String purchaseDate;
    private String departureDate;
    private String arrivalDate;
    private String passengerId;
    private String passengerName;
    private String passengerSurname;
    private String passengerIdType;
    private String currentAddress;
    private String phoneNumber;
    private String trainId;
    private String location;
    private String passengerCategory;
    private double fare;
    private String contactPerson;
    private String luggageInfo;

    public Ticket(String id) {
        this.id = id;
    }

    public Ticket(String id, String purchaseDate, String departureDate, String arrivalDate, String passengerId, String passengerName, String passengerSurname, String passengerIdType, String currentAddress, String phoneNumber, String trainId, String location, String passengerCategory, double fare, String contactPerson, String luggageInfo) {
        this.id = id;
        this.purchaseDate = purchaseDate;
        this.departureDate = departureDate;
        this.arrivalDate = arrivalDate;
        this.passengerId = passengerId;
        this.passengerName = passengerName;
        this.passengerSurname = passengerSurname;
        this.passengerIdType = passengerIdType;
        this.currentAddress = currentAddress;
        this.phoneNumber = phoneNumber;
        this.trainId = trainId;
        this.location = location;
        this.passengerCategory = passengerCategory;
        this.fare = fare;
        this.contactPerson = contactPerson;
        this.luggageInfo = luggageInfo;
    }

    // Getters
    public String getId() { return id; }
    public String getPurchaseDate() { return purchaseDate; }
    public String getDepartureDate() { return departureDate; }
    public String getArrivalDate() { return arrivalDate; }
    public String getPassengerId() { return passengerId; }
    public String getPassengerName() { return passengerName; }
    public String getPassengerSurname() { return passengerSurname; }
    public String getPassengerIdType() { return passengerIdType; }
    public String getCurrentAddress() { return currentAddress; }
    public String getPhoneNumber() { return phoneNumber; }
    public String getTrainId() { return trainId; }
    public String getLocation() { return location; }
    public String getPassengerCategory() { return passengerCategory; }
    public double getFare() { return fare; }
    public String getContactPerson() { return contactPerson; }
    public String getLuggageInfo() { return luggageInfo; }

    // Setters
    public void setId(String id) { this.id = id; }
    public void setPurchaseDate(String purchaseDate) { this.purchaseDate = purchaseDate; }
    public void setDepartureDate(String departureDate) { this.departureDate = departureDate; }
    public void setArrivalDate(String arrivalDate) { this.arrivalDate = arrivalDate; }
    public void setPassengerId(String passengerId) { this.passengerId = passengerId; }
    public void setPassengerName(String passengerName) { this.passengerName = passengerName; }
    public void setPassengerSurname(String passengerSurname) { this.passengerSurname = passengerSurname; }
    public void setPassengerIdType(String passengerIdType) { this.passengerIdType = passengerIdType; }
    public void setCurrentAddress(String currentAddress) { this.currentAddress = currentAddress; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }
    public void setTrainId(String trainId) { this.trainId = trainId; }
    public void setLocation(String location) { this.location = location; }
    public void setPassengerCategory(String passengerCategory) { this.passengerCategory = passengerCategory; }
    public void setFare(double fare) { this.fare = fare; }
    public void setContactPerson(String contactPerson) { this.contactPerson = contactPerson; }
    public void setLuggageInfo(String luggageInfo) { this.luggageInfo = luggageInfo; }
}
