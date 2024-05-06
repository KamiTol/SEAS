package SEAS.Model;

import SEAS.Model.Domain.Ticket;
import SEAS.Model.Service.ModuleServiceInterface;

import java.rmi.Naming;

public class ValidatorModel {
    private String uri;

    public ValidatorModel(String uri) {
        this.uri = uri;
    }

    public Ticket validateTicket(Ticket ticket) throws Exception {
    ModuleServiceInterface moduleService = (ModuleServiceInterface) Naming.lookup(uri);
    return moduleService.searchTicket(ticket.getId()) ? ticket : null;
}
}