package SEAS.Model.Repository;

import SEAS.Model.Domain.Wagon;
import SEAS.Model.shared.FileJsonAdapter;

import java.util.List;

public class WagonRepository {

    private FileJsonAdapter<Wagon> fileJsonAdapter;
    private String path;

    public WagonRepository(String path) {
        this.path = path;
        this.fileJsonAdapter = FileJsonAdapter.getInstance();
    }

    public boolean insert(Wagon wagon){
        List<Wagon> wagons = fileJsonAdapter.getObjects(path, Wagon[].class);
        wagons.add(wagon);
        return fileJsonAdapter.writeObjects(path, wagons);
    }

    public List<Wagon> getWagons(){
        return fileJsonAdapter.getObjects(path, Wagon[].class);
    }
}
