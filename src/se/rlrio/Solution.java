package se.rlrio;


import se.rlrio.controller.Controller;
import se.rlrio.model.MainModel;
import se.rlrio.model.Model;
import se.rlrio.view.EditUserView;
import se.rlrio.view.UsersView;

public class Solution {
    public static void main(String[] args) {
        Model model = new MainModel();
        UsersView usersView = new UsersView();
        EditUserView editUserView = new EditUserView();
        Controller controller = new Controller();

        usersView.setController(controller);
        controller.setModel(model);
        controller.setUsersView(usersView);

        usersView.fireEventShowAllUsers();

        editUserView.setController(controller);
        controller.setEditUserView(editUserView);
        usersView.fireEventOpenUserEditForm(126L);
        editUserView.fireEventUserDeleted(124L);
        editUserView.fireEventUserChanged("Titov", 126L, 4);
        usersView.fireEventShowDeletedUsers();

    }
}
