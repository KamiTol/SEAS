package SEAS;

import SEAS.Model.LoginModel;
import SEAS.Model.Server.Server;
import SEAS.Model.Service.ModuleService;
import SEAS.controller.LoginController;
import SEAS.view.LoginView;

import java.rmi.RemoteException;

public class Main {

    public static void main(String[] args) throws Exception {
        Server server = Server.getInstanceOf();
        server.deploy();
        LoginModel loginModel = new LoginModel(server.getUrl());
        LoginController loginController = new LoginController(loginModel);
        loginController.init();
    }
}