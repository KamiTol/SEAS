package SEAS.Model.Service;

import SEAS.Model.Domain.*;

import java.rmi.Remote;
import java.util.List;

public interface ModuleServiceInterface extends Remote {
    boolean buyTicket(Ticket ticket) throws Exception;
    boolean searchTicket(String idTicket) throws Exception;
    boolean addTrain(Train train) throws Exception;
    boolean removeTrain(String idTrain) throws Exception;
    boolean editTrain(Train train) throws Exception;
    List<Train> getTrains() throws Exception;
    boolean addUser(User user) throws Exception;
    boolean deleteUser(String idUser) throws Exception;
    boolean editUser(User user) throws Exception;
    List<User> getUsers() throws Exception;
    boolean addRoute(Route route) throws Exception;
    boolean removeRoute(Route route) throws Exception;
    boolean editRoute(Route route) throws Exception;
    List<Route> getRoutes() throws Exception;
    List<Schedule> getSchedules() throws Exception;
    boolean addSchedule(Schedule schedule) throws Exception;
    boolean removeSchedule(String id) throws Exception;
    boolean updateScheduleDepartureDate(Schedule schedule, String newDate) throws Exception;
    boolean login(String user, String password) throws Exception;
}
