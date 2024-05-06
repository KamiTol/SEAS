package SEAS.Model.Domain;

import java.io.Serializable;

public class Schedule implements Serializable {
    private String id;
    private String departureDate;
    private String arrivalDate;
    private Route route;

    public Schedule(String departureDate, Route route) {
        this.id = departureDate + route.getStart() + route.getEnd();
        this.departureDate = departureDate;
        this.route = route;
    }

    // Getters

    public String getId() {
        return id;
    }

    public String getDepartureDate() {
        return departureDate;
    }

    public String getArrivalDate() {
        return arrivalDate;
    }

    public Route getRoute() {
        return route;
    }

    // Setters

    public void setId(String id) {
        this.id = id;
    }

    public void setDepartureDate(String departureDate) {
        this.departureDate = departureDate;
    }

    public void setArrivalDate(String arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public void setRoute(Route route) {
        this.route = route;
    }
}