package SEAS.controller;

import SEAS.Model.Domain.Train;
import SEAS.Model.Domain.TrainType;
import SEAS.Model.TrainModel;
import SEAS.view.TrainView;

public class TrainController {
    TrainModel trainModel;
    TrainView trainView;

    public TrainController(TrainModel trainModel){
        this.trainModel = trainModel;
        this.trainView = new TrainView(this);
        trainView.chargeTable();
    }

    public void init(){
        trainView.setVisible(true);
    }

    public boolean addTrain(String name, String capacidad, TrainType type) throws Exception {
        return trainModel.addTrain(name, capacidad, type);
    }

    public boolean removeTrain(String id) throws Exception {
        return trainModel.removeTrain(id);
    }

    public boolean editTrain(String id, String name, String capacidad, TrainType type) throws Exception {
        return trainModel.updateTrain(id, name, capacidad, type);
    }

    public String[][] getTrains() throws Exception {
        return trainModel.getTrains();
    }

}