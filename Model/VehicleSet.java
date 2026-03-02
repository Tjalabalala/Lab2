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
        double gas = ((double) amount) / 100;
        for (IVehicle vehicle: vehicles){
            vehicle.gas(gas);
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

    public void brakeAll(double amount){
        double brake = amount / 100;
        for (IVehicle vehicle : vehicles){
            vehicle.brake(brake);
        }
    }

    public void startAllEngines(){
        for (IVehicle vehicle : vehicles){
            vehicle.startEngine();
        }
    }

    public void stopAllEngines(){
        for (IVehicle vehicle : vehicles){
            vehicle.stopEngine();
        }
    }

    public void turboOn(){
        for (IVehicle vehicle : vehicles){
            if (vehicle instanceof hasTurbo turboCar){
                turboCar.setTurboOn();
            }
        }
    }

    public void turboOff(){
        for (IVehicle vehicle : vehicles){
            if (vehicle instanceof hasTurbo turboCar) turboCar.setTurboOff();
        }
    }

    public void lowerBed(){
        for (IVehicle vehicle : vehicles){
            if (vehicle instanceof  hasTruckbed truck) truck.setTruckBedAngle(0);
        }
    }

    public void raiseBed(){
        for (IVehicle vehicle : vehicles){
            if (vehicle instanceof hasTruckbed truck) truck.setTruckBedAngle(70);
        }
    }
}
