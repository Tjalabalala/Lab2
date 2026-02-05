import java.util.Vector;

public interface ICarStorage<T extends Car> {
    void addCar(T car);
    void removeCar(T car);

    int getCapacity();
    int getCarCount();

    Vector<T> getCars();
}
