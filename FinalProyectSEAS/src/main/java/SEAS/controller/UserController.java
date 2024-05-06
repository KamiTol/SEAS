package SEAS.controller;

import SEAS.Model.Server.Server;
import SEAS.Model.UserModel;
import SEAS.view.UserView;

import java.rmi.RemoteException;
import java.util.List;

public class UserController {
    UserModel userModel;
    UserView userView;

    public UserController(UserModel userModel) {
        this.userModel = userModel;
        this.userView = new UserView(this);
    }

    public void init(){
        userView.setVisible(true);
        userView.chargeTable();
    }

    public boolean createUser(String nombres, String apellidos, String usuario, String contraseña, List<String> phoneNumbers) throws Exception {
        return userModel.addUser(nombres, apellidos, usuario, contraseña, phoneNumbers);
    }

    public boolean deleteUser(String id) throws Exception {
        return userModel.deleteUser(id);
    }

    public boolean updateUser(String id, String nombres, String apellidos, String usuario, String contraseña, List<String> phoneNumbers) throws Exception {
        return userModel.updateUser(id, nombres, apellidos, usuario, contraseña, phoneNumbers);
    }

    public String[][] getUsers() throws Exception {
        return userModel.getUsers();
    }


}
