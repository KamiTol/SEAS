package SEAS.Model.Service;

import SEAS.Model.Domain.Ticket;
import SEAS.Model.Domain.Train;
import SEAS.Model.Domain.User;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ModuleService extends UnicastRemoteObject implements ModuleServiceInterface{

    protected ModuleService() throws RemoteException {
    }


    @Override
    public boolean buyTicket(Ticket ticket) {
        return false;
    }

    @Override
    public boolean searchTicket(String idTicket) {
        return false;
    }

    @Override
    public boolean addTrain(Train train) {
        return false;
    }

    @Override
    public boolean removeTrain(String idTrain) {
        return false;
    }

    @Override
    public boolean editTrain(Train train) {
        return false;
    }

    @Override
    public boolean addUser(User user) {
        return false;
    }

    @Override
    public boolean delete(String idUser) {
        return false;
    }

    @Override
    public boolean editUser(User user) {
        return false;
    }

    @Override
    public boolean login(String user, String password) {
        return false;
    }
}
