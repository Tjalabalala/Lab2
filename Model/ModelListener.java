package Model;

import View.IDrawable;

public interface ModelListener {
    void updateOnAction();
    void removeVehicle(IDrawable drawable);
}
