package SEAS.Model;

import SEAS.Model.Domain.Train;
import SEAS.Model.Domain.TrainType;
import SEAS.Model.Service.ModuleServiceInterface;

import java.rmi.Naming;
import java.util.List;

public class TrainModel {
    String uri;

    public TrainModel(String uri){
        this.uri = uri;
    }

    public boolean addTrain(String name, String capacity, TrainType type) throws Exception{
        ModuleServiceInterface moduleService = (ModuleServiceInterface) Naming.lookup(uri);
        Train train = new Train(name, Integer.parseInt(capacity), type);
        return moduleService.addTrain(train);
    }


    public boolean removeTrain(String id) throws Exception{
        ModuleServiceInterface moduleService = (ModuleServiceInterface) Naming.lookup(uri);
        return moduleService.removeTrain(id);
    }

    public boolean updateTrain(String id, String name, String capacidad, TrainType type) throws Exception{
        ModuleServiceInterface moduleService = (ModuleServiceInterface) Naming.lookup(uri);
        Train train = new Train(id, name, Integer.parseInt(capacidad), type);
        return moduleService.editTrain(train);
    }


    public String[][] getTrains() throws Exception{
        ModuleServiceInterface moduleService = (ModuleServiceInterface) Naming.lookup(uri);
        List<Train> trains = moduleService.getTrains();
        String[][] data = new String[trains.size()][4];
        for (int i = 0; i < trains.size(); i++) {
            data[i][0] = trains.get(i).getId();
            data[i][1] = trains.get(i).getName();
            data[i][2] = String.valueOf(trains.get(i).getLoadCapacity());
            data[i][3] = String.valueOf(trains.get(i).getMileage());
        }
        return data;
    }
}
