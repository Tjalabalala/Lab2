package Model;

import java.awt.*;

public abstract class Car implements IVehicle, I2dObject {
    private int nrDoors;
    private Vehicle vehicle;

    public int getNrDoors() {
        return nrDoors;
    }

    public Car(int nr, double ep, Color col, String model, double w) {
        vehicle = new Vehicle(nr, ep, col, model, w){
            @Override
            public double speedFactor(){
                return Car.this.speedFactor();
            }
        };
    }

    public String getModelName() {
        return vehicle.getModelName();
    }

    public double getEnginePower() {
        return vehicle.getEnginePower();
    }

    public double getCurrentSpeed() {
        return vehicle.getCurrentSpeed();
    }

    public Color getColor() {
        return vehicle.getColor();
    }

    public void setColor(Color clr) {
        vehicle.setColor(clr);
    }

    public void startEngine() {
        vehicle.startEngine();
    }

    public void stopEngine() {
        vehicle.stopEngine();
    }

    public double getX() {
        return vehicle.getX();
    }

    public double getY() {
        return vehicle.getY();
    }

    public void setX(double x) {
        vehicle.setX(x);
    }

    public void setY(double y) {
        vehicle.setY(y);
    }

    public int getAngle() {
        return vehicle.getAngle();
    }

    public double getWeight() {
        return vehicle.getWeight();
    }

    public void incrementSpeed(double amount) {
        vehicle.incrementSpeed(amount);
    }

    public void decrementSpeed(double amount) {
        vehicle.decrementSpeed(amount);
    }

    public void gas(double amount) {
        vehicle.gas(amount);
    }

    public void brake(double amount) {
        vehicle.brake(amount);
    }

    public double speedFactor() {
        return vehicle.speedFactor();
    }

    public void move() {
        vehicle.move();
    }

    public void turnRight(){
        vehicle.turnRight();
    }

    public void turnLeft(){
        vehicle.turnLeft();
    }

    public void checkBorderCollision(int width){
        vehicle.checkBorderCollision(width);
    }

}
