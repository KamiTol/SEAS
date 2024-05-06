package SEAS.Model;

import SEAS.Model.Domain.Ticket;
import SEAS.Model.Service.ModuleServiceInterface;

import java.rmi.Naming;
import java.rmi.RemoteException;

public class BuyModel {
    private String uri;

    public BuyModel(String uri) {
        this.uri = uri;
    }

    public boolean buyTicket(Ticket ticket) throws Exception {
    ModuleServiceInterface moduleService = (ModuleServiceInterface) Naming.lookup(uri);
    return moduleService.buyTicket(ticket);
}
}