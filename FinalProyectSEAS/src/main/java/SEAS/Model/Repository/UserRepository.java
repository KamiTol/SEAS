package SEAS.Model.Repository;

import SEAS.Model.Domain.User;
import SEAS.Model.shared.FileJsonAdapter;

import java.util.List;

public class UserRepository {

    private String path;
    private FileJsonAdapter<User> fileJsonAdapter;

    public UserRepository(String path) {
        this.path = path;
        this.fileJsonAdapter = FileJsonAdapter.getInstance();
    }

    public boolean insert(User user){
        List<User> users = fileJsonAdapter.getObjects(path, User[].class);
        users.add(user);
        return fileJsonAdapter.writeObjects(path, users);
    }

    public boolean delete(String id){
        List<User> users = fileJsonAdapter.getObjects(path, User[].class);
        for (User user : users) {
            if (user.getID().equals(id)) {
                users.remove(user);
                return fileJsonAdapter.writeObjects(path, users);
            }
        }
        return false;
    }

    public boolean update(User user){
        List<User> users = fileJsonAdapter.getObjects(path, User[].class);
        for (User u : users) {
            if (u.getID().equals(user.getID())) {
                u.setName(user.getName());
                u.setLastName(user.getLastName());
                u.setUsername(user.getUsername());
                u.setPassword(user.getPassword());
                u.setPhoneNumbers(user.getPhoneNumbers());
                return fileJsonAdapter.writeObjects(path, users);
            }
        }
        return false;
    }

    public User getUser(String id){
        List<User> users = fileJsonAdapter.getObjects(path, User[].class);
        for (User user : users) {
            if (user.getID().equals(id)) {
                return user;
            }
        }
        return null;
    }

    public List<User> getUsers(){
        return fileJsonAdapter.getObjects(path, User[].class);
    }
}
