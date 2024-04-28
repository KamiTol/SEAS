package SEAS.Model.Service;

import SEAS.Model.Domain.Ticket;
import SEAS.Model.Domain.Train;
import SEAS.Model.Domain.User;
import java.rmi.Remote;

public interface ModuleServiceInterface extends Remote {
    boolean buyTicket(Ticket ticket);
    boolean searchTicket(String idTicket);
    boolean addTrain(Train train);
    boolean removeTrain(String idTrain);
    boolean editTrain(Train train);
    boolean addUser(User user);
    boolean delete(String idUser);
    boolean editUser(User user);
    boolean login(String user, String password);

}
