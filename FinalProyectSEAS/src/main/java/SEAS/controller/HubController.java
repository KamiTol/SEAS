package SEAS.controller;

import SEAS.Model.RoutesModel;
import SEAS.Model.Server.Server;
import SEAS.Model.TrainModel;
import SEAS.Model.UserModel;
import SEAS.view.HubView;

import java.rmi.RemoteException;

public class HubController {
    HubView hubView;
    Server server = Server.getInstanceOf();

    public HubController() throws RemoteException {
        this.hubView = new HubView(this);
    }

    public void init(){
        hubView.setVisible(true);
    }

    public void startTrainController(){
        TrainController trainController = new TrainController(new TrainModel(server.getUrl()));
        trainController.init();
    }

    public void startUserController() {
        UserModel userModel = new UserModel(server.getUrl());
        UserController userController = new UserController(userModel);
        userController.init();
    }

    public void startRouteController(){
        RouteController routeController = new RouteController(new RoutesModel(server.getUrl()));
        routeController.init();
    }
}
