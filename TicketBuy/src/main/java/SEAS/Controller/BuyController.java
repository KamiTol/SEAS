package SEAS.Controller;

import SEAS.Model.BuyModel;
import SEAS.Model.Domain.Ticket;
import SEAS.View.BuyView;

import javax.swing.*;

public class BuyController {
    private BuyView view;
    private BuyModel model;

    public BuyController(BuyModel model) throws Exception {
        this.model = model;
        this.view = new BuyView(this);
    }

    public void init(){
        view.setVisible(true);
    }

    public boolean buyTicket(String passengerId, String passengerName, String contactPerson, String contactSurname, String passengerIdType, String currentAddress, String phoneNumber, String seatType, String luggageWeight, String contactPhone, String initialStation, String finalStation, boolean customRoute) throws Exception {
        Ticket ticket = new Ticket(passengerId, null, null, null, passengerName, contactPerson, contactSurname, passengerIdType, currentAddress, phoneNumber, null, initialStation, finalStation, 0.0, contactPhone, luggageWeight);
        boolean success = model.buyTicket(ticket);
        String successMessage;
        if (success) {
            successMessage = "Ticket comprado con éxito";
        } else {
            successMessage = "La compra del ticket ha fallado";
        }
        JOptionPane.showMessageDialog(null, successMessage);
        return success;
    }
}