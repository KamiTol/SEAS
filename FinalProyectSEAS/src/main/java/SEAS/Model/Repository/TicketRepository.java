package SEAS.Model.Repository;

import SEAS.Model.Domain.Ticket;
import SEAS.Model.shared.FileJsonAdapter;

import java.io.Serializable;
import java.util.List;

public class TicketRepository implements Serializable {

    private FileJsonAdapter<Ticket> fileJsonAdapter;
    private String path;

    public TicketRepository(String path) {
        this.path = path;
        this.fileJsonAdapter = FileJsonAdapter.getInstance();
    }

    public boolean insert(Ticket ticket){
        List<Ticket> tickets = fileJsonAdapter.getObjects(path, Ticket[].class);
        tickets.add(ticket);
        return fileJsonAdapter.writeObjects(path, tickets);
    }

    public boolean delete(String id){
        List<Ticket> tickets = fileJsonAdapter.getObjects(path, Ticket[].class);
        for (Ticket ticket : tickets) {
            if (ticket.getId().equals(id)) {
                tickets.remove(ticket);
                return fileJsonAdapter.writeObjects(path, tickets);
            }
        }
        return false;
    }

    public Ticket getTicket(String id){
        List<Ticket> tickets = fileJsonAdapter.getObjects(path, Ticket[].class);
        for (Ticket ticket : tickets) {
            if (ticket.getId().equals(id)) {
                return ticket;
            }
        }
        return null;
    }

    public List<Ticket> getTickets(){
        return fileJsonAdapter.getObjects(path, Ticket[].class);
    }
}
