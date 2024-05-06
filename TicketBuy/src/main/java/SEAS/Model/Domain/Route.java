package SEAS.Model.Domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Route implements Serializable {
    private String start;
    private String end;
    private int distance;
    private List<Station> stations;

    public Route(String start, String end, int distance) {
        this.start = start;
        this.end = end;
        this.distance = distance;
        this.stations = new ArrayList<>();
    }

    public Route(String start, String end, int distance, List<Station> stations) {
        this.start = start;
        this.end = end;
        this.distance = distance;
        this.stations = stations;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public List<Station> getStations() {
        return stations;
    }

    public void addStation(Station station) {
        this.stations.add(station);
    }

    public void removeStation(Station station) {
        this.stations.remove(station);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Route route = (Route) o;
        return start.equals(route.start) && end.equals(route.end);
    }

    @Override
    public int hashCode() {
        return Objects.hash(start, end);
    }
}
