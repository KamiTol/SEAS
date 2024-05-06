package SEAS;

import SEAS.Controller.BuyController;
import SEAS.Model.BuyModel;

public class Main {
    public static void main(String[] args) throws Exception {
        BuyController controller = new BuyController(new BuyModel("//192.168.1.22:1099/moduleService"));
        controller.init();
    }
}