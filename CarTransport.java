import java.awt.*;
import java.util.Stack;
import java.util.Vector;

public class CarTransport extends Truck implements ICarStorage<Car> {
    private final int capacity = 8;
    private Stack<Car> cars = new Stack<>();

    enum RampState { UP, DOWN }
    private RampState ramp = RampState.UP;

    public CarTransport(){
        super(2, 500, Color.GRAY, "Transport", 15);
    }

    @Override
    protected boolean canMove() {
        return this.ramp == RampState.UP;
    }

    @Override
    public void move() {
        super.move();
        for (Car car : this.getCars()){
            car.setX(this.getX());
            car.setY(this.getY());
        }
    }

    public Vector<Car> getCars() { return this.cars; }

    public void raiseRamp(){
        if (this.ramp == RampState.UP) IO.println("Ramp as already up!");
        else this.ramp = RampState.UP;
    }

    public void lowerRamp(){
        if (this.ramp == RampState.DOWN) IO.println("Ramp is already down!");
        else if (this.getCurrentSpeed() != 0) IO.println("Can't lower ramp, vehicle is in motion!");
        else this.ramp = RampState.DOWN;
    }

    public void addCar(Car car){
        if (cars.size() == capacity) IO.println("Cannot load more cars!");
        else if (this.ramp == RampState.UP) IO.println("Cannot load car, the ramp is up!");
        else if (car.getWeight() >= 3) IO.println("That car is too big!");
        else if (Math.pow(Math.pow(car.getX() - this.getX(), 2)+Math.pow(car.getY() - this.getY(), 2), 0.5) >= 10)
            IO.println("This car is too far away!");
        else {
            cars.push(car);
            car.setX(this.getX());
            car.setY(this.getY());
        }
    }

    public void removeCar(Car car){
        if (cars.isEmpty()) IO.println("There are no cars to unload!");
        else if (this.ramp == RampState.UP) IO.println("Cannot unload car, the ramp is up!");
        else if (cars.lastElement() != car) IO.println("Cannot unload car, other cars in the way!");
        else {
            cars.pop();
            double randNum = Math.random()*10;
            car.setX(this.getX() + randNum);
            car.setY(this.getY() + randNum);
        }
    }

}
