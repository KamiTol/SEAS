import SEAS.Controller.ValidatorController;
import SEAS.View.ValidatorView;

public class Main {
    public static void main(String[] args) {
        String uri = "//192.168.1.22:1099/moduleService";
        ValidatorController validatorController = new ValidatorController(uri);
        ValidatorView validatorView = validatorController.getValidatorView();
        validatorView.setVisible(true);
    }
}