import java.awt.*;
import java.util.Stack;

public class CarTransport extends Car{
    private Stack<Car> carList = new Stack<>();
    private boolean rampUp;
    private int capacity;

    public CarTransport(){
        super(2, 500, Color.GRAY, "Transport");
    }

    public double speedFactor(){
        return getEnginePower() * 0.01;
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
        } else{
            carList.push(car);
        }
    }

    public void unloadCar(){
        if (carList.isEmpty()){
            IO.println("There are no cars to unload!");
        }
        else {
            carList.pop();
        }
    }

}
