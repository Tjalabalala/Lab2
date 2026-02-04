import java.util.ArrayList;

public class Verkstad <CarType> {

    private int maxStorage;
    private Boolean open;
    private ArrayList<CarType> carList = new ArrayList<>();

    public Verkstad(int mStorage){
        this.maxStorage = mStorage;
        this.open = true;
    }

    void removeCar(CarType car){
        this.carList.remove(car);
    }

    void addCar(CarType car){
        if(this.carList.size() >= maxStorage){
            IO.println("Max capacity reached");
        }
        else {
            this.carList.add(car);
        }
    }

    ArrayList<CarType> getCarList(){
        return this.carList;
    }

}