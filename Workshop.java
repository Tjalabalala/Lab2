import java.util.Vector;

public class Workshop<CarType extends Car> implements ICarStorage<CarType>, IDrawable {
    private final int capacity;
    private Class<CarType> model = null;
    public int getCapacity() { return capacity; }

    private Vector<CarType> cars = new Vector<>();
    public int getCarCount() { return cars.size(); }

    public Workshop(int mStorage){
        capacity = mStorage;
    }

    public Workshop(int mStorage, Class<CarType> carClass){
        capacity = mStorage;
        this.model = carClass;
    }

    public void removeCar(CarType car){
        cars.remove(car);
    }

    public void tryLoad(Car car) {
        if (model.isInstance(car)) {       // type check
            CarType typedCar = model.cast(car);  // safe cast internally
            this.addCar(typedCar);
        }
    }

    public void addCar(CarType car) {
        if (cars.size() >= capacity) IO.println("Max capacity reached");
        else cars.add(car);
    }

    public Class<CarType> getModel(){
        return this.model;
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