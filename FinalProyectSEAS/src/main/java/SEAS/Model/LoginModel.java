package SEAS.Model;

import SEAS.Model.Service.ModuleServiceInterface;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class LoginModel {
    private String uri;

    public LoginModel(String uri) {
        this.uri = uri;
    }

    public boolean login(String username, String password) throws Exception {
        ModuleServiceInterface moduleService = (ModuleServiceInterface) Naming.lookup(uri);
        return moduleService.login(username, password);
    }
}
