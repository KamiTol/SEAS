package SEAS.controller;

import SEAS.Model.LoginModel;
import SEAS.Model.Server.Server;
import SEAS.view.LoginView;

import javax.swing.*;
import java.rmi.RemoteException;

public class LoginController {
    LoginModel loginModel;
    LoginView loginView;
    Server server = Server.getInstanceOf();

    public LoginController(LoginModel loginModel ) throws RemoteException {
        this.loginModel = loginModel;
        this.loginView = new LoginView(this);
    }

    public void init(){
        loginView.setVisible(true);
    }

    public boolean login(String username, String password) throws Exception {
        if (loginModel.login(username, password)){
            HubController hubController = new HubController();
            hubController.init();
            return true;
        }
        return false;
    }
}
