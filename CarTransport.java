import java.awt.*;
import java.util.Stack;
import java.util.Vector;

public class CarTransport extends Truck implements ICarStorage<Car> {
    private final int capacity = 8;
    private Stack<Car> cars = new Stack<>();

    public enum RampState { UP, DOWN }
    private RampState ramp = RampState.UP;
    public CarTransport(){
        super(2, 500, Color.GRAY, "Transport", 15);
    }
    public RampState getRamp() { return ramp; }
    public int getCapacity() { return capacity; }

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
    public int getCarCount() { return cars.size(); }
    public Vector<Car> getCars() { return (Vector<Car>) cars.clone(); }

    public void setRamp(RampState state) {
        if (getRamp() == state)
            IO.println("Ramp already in state: " + (getRamp() == RampState.UP ? "UP" : "DOWN"));
        else if (getCurrentSpeed() != 0 && state == RampState.DOWN)
            IO.println("Can't lower ramp while the vehicle is in motion");
        else this.ramp = state;
    }
    public void addCar(Car car){
        if (cars.size() >= capacity) IO.println("Cannot load more cars!");
        else if (getRamp() == RampState.UP) IO.println("Cannot load car, the ramp is up!");
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
        else if (getRamp() == RampState.UP) IO.println("Cannot unload car, the ramp is up!");
        else if (cars.lastElement() != car) IO.println("Cannot unload car, other cars in the way!");
        else {
            cars.pop();
            double randNum = Math.random()*10;
            car.setX(this.getX() + randNum);
            car.setY(this.getY() + randNum);
        }
    }
}
