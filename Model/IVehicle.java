package Model;

import java.awt.*;

public interface IVehicle extends Movable, I2dObject {
    public String getModelName();
    public double getEnginePower();
    public double getCurrentSpeed();
    public Color getColor();
    public void setColor(Color clr);
    public void startEngine();

    public void stopEngine();

    public void setX(double x);
    public void setY(double y);
    public int getAngle();

    public double speedFactor(); // impl detail??

    public double getWeight();

    public void incrementSpeed(double amount);

    public void decrementSpeed(double amount);
    public void gas(double amount);
    public void brake(double amount);
    public void checkBorderCollision(int width);
}
