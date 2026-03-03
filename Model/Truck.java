package Model;

import java.awt.*;

public abstract class Truck implements IVehicle, Movable, I2dObject {

    public Truck(int nr, double ep, Color col, String model, double w){
        vehicle = new Vehicle(nr, ep, col, model, w){
            @Override
            public double speedFactor(){
                return Truck.this.speedFactor();
            }
        };
    }

    private Vehicle vehicle;
    private int nrDoors = 2;

    public double speedFactor() { return vehicle.getEnginePower() * 0.01; }

    public int getNrDoors(){ return this.nrDoors;}

    protected abstract boolean canMove();

    public void gas(double amount) {
        if (canMove()) vehicle.gas(amount);
        else IO.println("Unable to move truck");
    }

    public void move() {
        vehicle.move();
    }

    public void turnLeft() {
        vehicle.turnLeft();
    }

    public void turnRight() {
        vehicle.turnRight();
    }

    public double getX(){
        return vehicle.getX();
    }

    public double getY(){
        return vehicle.getY();
    }

    public double getCurrentSpeed(){
        return vehicle.getCurrentSpeed();
    }

    public void setX(double x){
        vehicle.setX(x);
    }

    public void setY(double y){
        vehicle.setY(y);
    }

    public String getModelName(){
        return vehicle.getModelName();
    }

    public double getEnginePower(){
        return vehicle.getEnginePower();
    }

    public Color getColor(){
        return vehicle.getColor();
    }

    public void setColor(Color color){
        vehicle.setColor(color);
    }

    public void startEngine(){
        vehicle.startEngine();
    }

    public void stopEngine(){
        vehicle.stopEngine();
    }

    public int getAngle(){
        return vehicle.getAngle();
    }
    public double getWeight(){
        return vehicle.getWeight();
    }
    public void incrementSpeed(double amount){
        vehicle.incrementSpeed(amount);
    }

    public void decrementSpeed(double amount){
        vehicle.decrementSpeed(amount);
    }

    public void brake(double amount){
        vehicle.brake(amount);
    }

    public void checkBorderCollision(int width){
        vehicle.checkBorderCollision(width);
    }
}
