package SEAS.Model.Service;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import SEAS.Model.Domain.*;

public interface ModuleServiceInterface extends Remote {
    boolean buyTicket(Ticket ticket) throws RemoteException;
    boolean searchTicket(String idTicket) throws RemoteException;
    boolean addTrain(Train train) throws RemoteException;
    boolean removeTrain(String idTrain) throws RemoteException;
    boolean editTrain(Train train) throws RemoteException;
    List<Train> getTrains() throws RemoteException;
    boolean addUser(User user) throws RemoteException;
    boolean deleteUser(String idUser) throws RemoteException;
    boolean editUser(User user) throws RemoteException;
    List<User> getUsers() throws RemoteException;
    boolean addRoute(Route route) throws RemoteException;
    boolean removeRoute(Route route) throws RemoteException;
    boolean editRoute(Route route) throws RemoteException;
    List<Route> getRoutes() throws RemoteException;
    List<Schedule> getSchedules() throws RemoteException;
    boolean addSchedule(Schedule schedule) throws RemoteException;
    boolean removeSchedule(String id) throws RemoteException;
    boolean updateScheduleDepartureDate(Schedule schedule, String newDate) throws RemoteException;
    boolean login(String user, String password) throws RemoteException;
}