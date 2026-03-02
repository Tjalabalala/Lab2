package Model;

import java.util.ArrayList;

public class VehicleSet {
    private ArrayList<IVehicle> vehicles = new ArrayList<>();
    private ArrayList<ModelListener> actionListeners = new ArrayList<>();

    public VehicleSet(){}
    public VehicleSet(ArrayList<IVehicle> vehicleList){
        vehicles = vehicleList;
    }

    public void gasAll(double amount){
        for (IVehicle vehicle: vehicles){
            vehicle.gas(amount);
        }
    }

    public void moveAll(){
        for (IVehicle vehicle: vehicles){
            vehicle.move();
        }
    }

    public void addVehicle(IVehicle vehicle){
        vehicles.add(vehicle);
    }

    public void removeVehicle(IVehicle vehicle){
        vehicles.remove(vehicle);
    }

    public void notifyAllListeners(){
        for (ModelListener modelListener: actionListeners){
            modelListener.updateOnAction();
        }
    }

    public void addListener(ModelListener listener){
        actionListeners.add(listener);
    }

    public void removeListener(ModelListener listener){
        actionListeners.remove(listener);
    }
}
