package View;

import Model.*;

public class DrawableVehicle implements IDrawable {
    public final IVehicle vehicle;
    private String path;

    public DrawableVehicle(IVehicle _vehicle) {
        vehicle = _vehicle;

        if (vehicle instanceof Saab95) {
            path = "/pics/Saab95.jpg";
        } else if (vehicle instanceof Volvo240) {
            path = "/pics/Volvo240.jpg";
        } else if (vehicle instanceof Scania) {
            path = "/pics/Scania.jpg";
        }
    }

    @Override
    public String getImagePath() {
        return path;
    }

    @Override
    public int getWidth() {
        return vehicle.getWidth();
    }

    @Override
    public int getHeight() {
        return vehicle.getHeight();
    }

    @Override
    public double getX() {
        return vehicle.getX();
    }

    @Override
    public double getY() {
        return vehicle.getY();
    }
}
