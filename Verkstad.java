import java.util.ArrayList;
import java.util.Vector;

public class Verkstad<CarType extends Car> implements ICarStorage<CarType> {
    private final int maxStorage;
    private Boolean open;
    private Vector<CarType> cars = new Vector<>();

    public Verkstad(int mStorage){
        this.maxStorage = mStorage;
        this.open = true;
    }

    public void removeCar(CarType car){
        this.cars.remove(car);
    }

    public void addCar(CarType car) {
        if (this.cars.size() >= maxStorage) IO.println("Max capacity reached");
        else this.cars.add(car);
    }

    public Vector<CarType> getCars() {
        return cars;
    }

}