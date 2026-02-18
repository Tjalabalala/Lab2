import java.util.Vector;

public class Workshop<CarType extends Car> implements ICarStorage<CarType>, IDrawable {
    private final int capacity;
    public int getCapacity() { return capacity; }

    private Vector<CarType> cars = new Vector<>();
    public int getCarCount() { return cars.size(); }

    public Workshop(int mStorage){
        capacity = mStorage;
    }

    public void removeCar(CarType car){
        cars.remove(car);
    }

    public void addCar(CarType car) {
        if (cars.size() >= capacity) IO.println("Max capacity reached");
        else cars.add(car);
    }

    // this clone is expensive on larger collections
    // however, this is in exchange for keeping control of cars within workshop, "read-only" copy
    public Vector<CarType> getCars() {
        return (Vector<CarType>) cars.clone();
    }

    public double getX() { return 300; }
    public double getY() { return 300; }
    public int getWidth() { return 101; }
    public int getHeight() { return 96; }
    public String getImagePath() { return "pics/volvoBrand.jpg"; }
}