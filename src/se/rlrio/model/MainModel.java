package se.rlrio.model;


import se.rlrio.bean.User;
import se.rlrio.model.service.UserService;
import se.rlrio.model.service.UserServiceImpl;

import java.util.List;

public class MainModel implements Model {
    private ModelData modelData = new ModelData();
    private UserService userService = new UserServiceImpl();

    @Override
    public ModelData getModelData() {
        return modelData;
    }

    @Override
    public void loadUsers() {
        modelData.setDisplayDeletedUserList(false);
        modelData.setUsers(getAllUsers());
    }

    public void loadDeletedUsers() {
        List<User> users = userService.getAllDeletedUsers();
        modelData.setDisplayDeletedUserList(true);
        modelData.setUsers(users);
    }

    public void loadUserById(long userId) {
        User user = userService.getUsersById(userId);
        modelData.setActiveUser(user);
    }

    public void deleteUserById(long id) {
        userService.deleteUser(id);
        loadUsers();
    }

    private List<User> getAllUsers() {
        List<User> userList100 = userService.getUsersBetweenLevels(1, 100);
        return userService.filterOnlyActiveUsers(userList100);
    }

    public void changeUserData(String name, long id, int level) {
        userService.createOrUpdateUser(name, id, level);
        loadUsers();
    }
}

