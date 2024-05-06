package SEAS.Model.Repository;

import SEAS.Model.Domain.Station;
import SEAS.Model.shared.FileJsonAdapter;

import java.util.List;

public class StationRepository {
    private FileJsonAdapter<Station> fileJsonAdapter;
    private String path;

    public StationRepository(String path) {
        this.path = path;
        this.fileJsonAdapter = FileJsonAdapter.getInstance();
    }

    public boolean insert(Station station){
        List<Station> stations = fileJsonAdapter.getObjects(path, Station[].class);
        stations.add(station);
        return fileJsonAdapter.writeObjects(path, stations);
    }

    public boolean delete(String id){
        List<Station> stations = fileJsonAdapter.getObjects(path, Station[].class);
        for (Station station : stations) {
            if (station.getId().equals(id)) {
                stations.remove(station);
                return fileJsonAdapter.writeObjects(path, stations);
            }
        }
        return false;
    }

    public Station getStation(String id){
        List<Station> stations = fileJsonAdapter.getObjects(path, Station[].class);
        for (Station station : stations) {
            if (station.getId().equals(id)) {
                return station;
            }
        }
        return null;
    }

    public List<Station> getStations(){
        return fileJsonAdapter.getObjects(path, Station[].class);
    }
}
