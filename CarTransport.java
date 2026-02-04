import java.awt.*;
import java.util.Stack;

public class CarTransport extends Car{
    private Stack<Car> carList = new Stack<>();
    private boolean rampUp;
    private final int capacity;

    public CarTransport(){
        super(2, 500, Color.GRAY, "Transport", 15);
        capacity = 8;
    }

    public double speedFactor(){
        return getEnginePower() * 0.01;
    }
    @Override
    public void move(){
        this.setX(this.getX() + this.getCurrentSpeed() * Math.cos(Math.toRadians(getAngle())));
        this.setY(this.getY() + this.getCurrentSpeed() * Math.sin(Math.toRadians(getAngle())));
        for (Car car : this.getCars()){
            car.setX(this.getX());
            car.setY(this.getY());
        }
    }

    public Stack<Car> getCars(){
        return this.carList;
    }

    public void raiseRamp(){
        if (this.rampUp){
            IO.println("Ramp as already up!");
        }
        else {
            this.rampUp = true;
        }
    }

    public void lowerRamp(){
        if (!this.rampUp){
            IO.println("Ramp is already down!");
        }
        else if (this.getCurrentSpeed() != 0){
            IO.println("Can't lower ramp, vehicle is in motion!");
        }
        else {
            this.rampUp = false;
        }
    }

    public void loadCar(Car car){
        if (carList.size() == capacity){
            IO.println("Cannot load more cars");
        } else if (car.getWeight() >= 3){
            IO.println("That car is too big!");
        } else if (Math.pow(Math.pow(car.getX() - this.getX(), 2)+Math.pow(car.getY() - this.getY(), 2), 0.5) >= 10){
            IO.println("This car is too far away!");
        }
        else{
            carList.push(car);
            car.setX(this.getX());
            car.setY(this.getY());
        }
    }

    public void unloadCar(){
        if (carList.isEmpty()){
            IO.println("There are no cars to unload!");
        }
        else {
            Car car = carList.pop();
            double randNum = Math.random()*10;
            car.setX(this.getX() + randNum);
            car.setY(this.getY() + randNum);
        }
    }

}
