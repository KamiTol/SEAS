package SEAS.Model;

import SEAS.Model.Domain.Graph;
import SEAS.Model.Domain.Route;
import SEAS.Model.Domain.Schedule;
import SEAS.Model.Service.ModuleServiceInterface;

import java.rmi.Naming;
import java.util.List;

public class RoutesModel {

    String uri;

    public RoutesModel(String uri){
        this.uri = uri;
    }

    public String[][] getSchedules() throws Exception {
        ModuleServiceInterface moduleServiceInterface = (ModuleServiceInterface) Naming.lookup(uri);
        List<Schedule> schedules = moduleServiceInterface.getSchedules();
        String[][] data = new String[schedules.size()][4];
        for (int i = 0; i < schedules.size(); i++) {
            data[i][0] = schedules.get(i).getId();
            data[i][1] = schedules.get(i).getDepartureDate();
            data[i][2] = schedules.get(i).getRoute().getStart();
            data[i][3] = schedules.get(i).getRoute().getEnd();
        }
        return data;
    }

    public boolean addSchedule(String salida, List<String> stations) throws Exception {
        ModuleServiceInterface moduleServiceInterface = (ModuleServiceInterface) Naming.lookup(uri);
        Schedule schedule = new Schedule(salida, new Route(stations.getFirst(), stations.getLast(), new Graph().getTotalDistance(stations)));
        return moduleServiceInterface.addSchedule(schedule);
    }

    public boolean removeSchedule(String id) throws Exception {
        ModuleServiceInterface moduleServiceInterface = (ModuleServiceInterface) Naming.lookup(uri);
        return moduleServiceInterface.removeSchedule(id);
    }

    public boolean updateScheduleDepartureDate(String id, String newDate) throws Exception {
        ModuleServiceInterface moduleServiceInterface = (ModuleServiceInterface) Naming.lookup(uri);
        Schedule schedule = moduleServiceInterface.getSchedules().stream().filter(s -> s.getId().equals(id)).findFirst().orElse(null);
        return moduleServiceInterface.updateScheduleDepartureDate(schedule, newDate);
    }
}
