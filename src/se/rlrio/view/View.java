package se.rlrio.view;


import se.rlrio.controller.Controller;
import se.rlrio.model.ModelData;

public interface View {
    void refresh(ModelData modelData);

    void setController(Controller controller);

}
