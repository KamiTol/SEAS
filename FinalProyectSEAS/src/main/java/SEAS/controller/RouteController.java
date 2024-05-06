package SEAS.controller;

import SEAS.Model.Domain.Station;
import SEAS.Model.RoutesModel;
import SEAS.view.RoutesView;

import java.util.List;

public class RouteController {
    RoutesView routesView;
    RoutesModel routesModel;

    public RouteController(RoutesModel routesModel) {
        this.routesModel = routesModel;
        this.routesView = new RoutesView(this);
    }

    public void init() {
        routesView.setVisible(true);
    }

    public boolean addSchedule(String salida, List<String> stations) throws Exception {
        return routesModel.addSchedule(salida, stations);
    }

    public boolean deleteSchedule(String id) throws Exception {
        return routesModel.removeSchedule(id);
    }

    public boolean updateScheduleDepartureDate(String id, String newDate) throws Exception {
        return routesModel.updateScheduleDepartureDate(id, newDate);
    }

    public String[][] getSchedules() throws Exception {
        return routesModel.getSchedules();
    }
}
