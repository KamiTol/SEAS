package SEAS.Model.Repository;

import SEAS.Model.Domain.Passenger;
import SEAS.Model.shared.FileJsonAdapter;

import java.util.List;

public class PassengerRepository {

    private FileJsonAdapter<Passenger> fileJsonAdapter;
    private String path;

    public PassengerRepository(String path) {
        this.path = path;
        this.fileJsonAdapter = FileJsonAdapter.getInstance();
    }

    public boolean insert(Passenger passenger){
        List<Passenger> passengers = fileJsonAdapter.getObjects(path, Passenger[].class);
        passengers.add(passenger);
        return fileJsonAdapter.writeObjects(path, passengers);
    }

    public boolean delete(String id){
        List<Passenger> passengers = fileJsonAdapter.getObjects(path, Passenger[].class);
        for (Passenger passenger : passengers) {
            if (passenger.getId().equals(id)) {
                passengers.remove(passenger);
                return fileJsonAdapter.writeObjects(path, passengers);
            }
        }
        return false;
    }

    public boolean update(Passenger passenger){
        List<Passenger> passengers = fileJsonAdapter.getObjects(path, Passenger[].class);
        for (Passenger p : passengers) {
            if (p.getId().equals(passenger.getId())) {
                p.setName(passenger.getName());
                p.setSurname(passenger.getSurname());
                p.setIdType(passenger.getIdType());
                p.setCurrentAddress(passenger.getCurrentAddress());
                p.setPhoneNumber(passenger.getPhoneNumber());
                return fileJsonAdapter.writeObjects(path, passengers);
            }
        }
        return false;
    }

    public Passenger getPassenger(String id){
        List<Passenger> passengers = fileJsonAdapter.getObjects(path, Passenger[].class);
        for (Passenger passenger : passengers) {
            if (passenger.getId().equals(id)) {
                return passenger;
            }
        }
        return null;
    }

    public List<Passenger> getPassengers(){
        return fileJsonAdapter.getObjects(path, Passenger[].class);
    }
}
