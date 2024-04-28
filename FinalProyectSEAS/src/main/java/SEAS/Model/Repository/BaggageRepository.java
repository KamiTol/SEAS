package SEAS.Model.Repository;

import SEAS.Model.Domain.Baggage;
import SEAS.Model.shared.FileJsonAdapter;

import java.util.List;

public class BaggageRepository {
    private FileJsonAdapter<Baggage> fileJsonAdapter;
    private String path;

    public BaggageRepository(String path) {
        this.path = path;
        this.fileJsonAdapter = FileJsonAdapter.getInstance();
    }

    public boolean insert(Baggage baggage){
        List<Baggage> baggages = fileJsonAdapter.getObjects(path, Baggage[].class);
        baggages.add(baggage);
        return fileJsonAdapter.writeObjects(path, baggages);
    }

    public boolean delete(String id){
        List<Baggage> baggages = fileJsonAdapter.getObjects(path, Baggage[].class);
        for (Baggage baggage : baggages) {
            if (baggage.getId().equals(id)) {
                baggages.remove(baggage);
                return fileJsonAdapter.writeObjects(path, baggages);
            }
        }
        return false;
    }

    public boolean update(Baggage baggage){
        List<Baggage> baggages = fileJsonAdapter.getObjects(path, Baggage[].class);
        for (Baggage b : baggages) {
            if (b.getId().equals(baggage.getId())) {
                b.setWeight(baggage.getWeight());
                return fileJsonAdapter.writeObjects(path, baggages);
            }
        }
        return false;
    }

    public Baggage getBaggage(String id){
        List<Baggage> baggages = fileJsonAdapter.getObjects(path, Baggage[].class);
        for (Baggage baggage : baggages) {
            if (baggage.getId().equals(id)) {
                return baggage;
            }
        }
        return null;
    }

    public List<Baggage> getBaggages(){
        return fileJsonAdapter.getObjects(path, Baggage[].class);
    }

}
