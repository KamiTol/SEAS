package SEAS.Model.Repository;

import SEAS.Model.Domain.Train;
import SEAS.Model.shared.FileJsonAdapter;

import java.util.List;

public class TrainRepository {

    private FileJsonAdapter<Train> fileJsonAdapter;
    private String path;

    public TrainRepository(String path) {
        this.path = path;
        this.fileJsonAdapter = FileJsonAdapter.getInstance();
    }

    public boolean insert(Train train){
        List<Train> trains = fileJsonAdapter.getObjects(path, Train[].class);
        trains.add(train);
        return fileJsonAdapter.writeObjects(path, trains);
    }

    public boolean delete(String id){
        List<Train> trains = fileJsonAdapter.getObjects(path, Train[].class);
        for (Train train : trains) {
            if (train.getId().equals(id)) {
                trains.remove(train);
                return fileJsonAdapter.writeObjects(path, trains);
            }
        }
        return false;
    }

    public boolean update(Train train){
        List<Train> trains = fileJsonAdapter.getObjects(path, Train[].class);
        for (Train t : trains) {
            if (t.getId().equals(train.getId())) {
                t.setName(train.getName());
                t.setMileage(train.getMileage());
                return fileJsonAdapter.writeObjects(path, trains);
            }
        }
        return false;
    }

    public Train getTrain(String id){
        List<Train> trains = fileJsonAdapter.getObjects(path, Train[].class);
        for (Train train : trains) {
            if (train.getId().equals(id)) {
                return train;
            }
        }
        return null;
    }

    public List<Train> getTrains(){
        return fileJsonAdapter.getObjects(path, Train[].class);
    }
}
