package Model;

import java.awt.*;
import java.util.ArrayList;

public class Vehicle implements Movable {
    private int nrDoors; // Number of doors on the car
    private double enginePower; // Engine power of the car
    private double currentSpeed; // The current speed of the car
    private Color color; // Color of the car
    private String modelName; // The car model name
    private int angle;
    private double posX;
    private double posY;
    private final double weight;
    private double speedfactor;


    public Vehicle(int nr, double ep, Color col, String model, double w) {
        nrDoors = nr;
        enginePower = ep;
        color = col;
        modelName = model;
        angle = 0;
        posX = 0;
        posY = 0;
        stopEngine();
        weight = w;
    }

    public String getModelName() {
        return modelName;
    }

    public int getNrDoors() {
        return nrDoors;
    }

    public double getEnginePower() {
        return enginePower;
    }

    public double getCurrentSpeed() {
        return currentSpeed;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color clr) {
        color = clr;
    }

    public void startEngine() {
        currentSpeed = 0.1;
    }

    public void stopEngine() {
        currentSpeed = 0;
    }

    public double getX() {
        return this.posX;
    }

    public double getY() {
        return this.posY;
    }

    public void setX(double x) {
        this.posX = x;
    }

    public void setY(double y) {
        this.posY = y;
    }

    public int getAngle() {
        return this.angle;
    }

    public double getWeight() {
        return this.weight;
    }

    public void setSpeedFactor(double amount) {
        this.speedfactor = amount;
    }

    public double speedFactor() {
        return speedfactor;
    }

    public void incrementSpeed(double amount) {
        currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount, enginePower);
    }

    public void decrementSpeed(double amount) {
        currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount, 0);
    }

    public void gas(double amount) {
        if (amount >= 0 && amount <= 1) incrementSpeed(amount);
    }

    public void brake(double amount) {
        if(amount >=0&&amount <=1) decrementSpeed(amount);
    }

    public void move(){
        this.posX += this.getCurrentSpeed() * Math.cos(Math.toRadians(getAngle()));
        this.posY += this.getCurrentSpeed() * Math.sin(Math.toRadians(getAngle()));
    }

    public void turnRight(){
        this.angle = (getAngle() - 90)%360;
    }

    public void turnLeft(){
        this.angle = (getAngle() + 90)%360;
    }

    public void checkBorderCollision(int width){
        if ((this.getX() >= width && this.getAngle() == 0) || (this.getX() <= 0 && Math.abs(this.getAngle()) == 180)){
            this.turnRight();
            this.turnRight();
        }
        else this.move();
    }

}
