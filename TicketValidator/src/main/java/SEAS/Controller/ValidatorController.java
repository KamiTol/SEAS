package SEAS.Controller;

import SEAS.Model.ValidatorModel;
import SEAS.Model.Domain.Ticket;
import SEAS.View.ValidatorView;

public class ValidatorController {
    private ValidatorModel validatorModel;
    private ValidatorView validatorView;

    public ValidatorController(String uri) {
        this.validatorModel = new ValidatorModel(uri);
        this.validatorView = new ValidatorView();
        this.validatorView.setValidatorController(this);
    }

    public Ticket validateTicket(Ticket ticket) {
    try {
        return validatorModel.validateTicket(ticket);
    } catch (Exception e) {
        e.printStackTrace();
        return null;
    }
}

    public ValidatorView getValidatorView() {
        return validatorView;
    }
}