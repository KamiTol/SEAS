package SEAS.Model;

import SEAS.Model.Domain.User;
import SEAS.Model.Service.ModuleServiceInterface;

import java.rmi.Naming;
import java.util.List;

public class UserModel {
    String uri;

    public UserModel(String uri){
        this.uri = uri;
    }

    public boolean addUser(String nombres, String apellidos, String usuario, String contraseña, List<String> phoneNumbers) throws Exception{
        String id = (usuario + contraseña).substring(0, 10);
        User user = new User(id, usuario, contraseña, nombres, apellidos, phoneNumbers);
        ModuleServiceInterface moduleService = (ModuleServiceInterface) Naming.lookup(uri);
        return moduleService.addUser(user);
    }

    public boolean deleteUser(String id) throws Exception{
        ModuleServiceInterface moduleService = (ModuleServiceInterface) Naming.lookup(uri);
        return moduleService.deleteUser(id);
    }

    public boolean updateUser(String id, String nombres, String apellidos, String usuario, String contraseña, List<String> phoneNumbers) throws Exception{
        ModuleServiceInterface moduleService = (ModuleServiceInterface) Naming.lookup(uri);
        User user = new User(id, usuario, contraseña, nombres, apellidos, phoneNumbers);
        return moduleService.editUser(user);
    }

    public String[][] getUsers() throws Exception{
        ModuleServiceInterface moduleService = (ModuleServiceInterface) Naming.lookup(uri);
        List<User> users = moduleService.getUsers();
        String [][] usersString = new String[users.size()][6];
        int i=0;
        for (User user : users){
            usersString[i][0] = user.getID();
            usersString[i][1] = user.getName();
            usersString[i][2] = user.getLastName();
            usersString[i][3] = user.getUsername();
            usersString[i][4] = user.getPassword();
            usersString[i][5] = user.getPhoneNumbers().toString();
            i++;
        }
        return usersString;
    }
}
