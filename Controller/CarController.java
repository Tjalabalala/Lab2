package Controller;

import Model.*;

/*
 * This class represents the Controller part in the MVC pattern.
 * Its responsibilities is to listen to the View and responds in a appropriate manner by
 * modifying the model state and the updating the view.
 */

public class CarController {

    private VehicleSet vehicles;

    public CarController(VehicleSet _vehicles){
        this.vehicles = _vehicles;
    }

    public CarController(){
        this.vehicles = new VehicleSet();
    }

    public void addVehiclesSet(VehicleSet _vehicles){
        this.vehicles = _vehicles;
    }

    //Calls the gas method for the carSet
    public void gas(int amount) {
        vehicles.gasAll(amount);
    }

    public void brake(int amount){
        vehicles.brakeAll(amount);
    }

    public void startEngine(){
        vehicles.startAllEngines();
    }

    public void stopEngine(){
        vehicles.stopAllEngines();
    }

    public void turboOn(){
        vehicles.turboOn();
    }

    public void turboOff(){
        vehicles.turboOff();
    }

    public void lowerBed(){
        vehicles.lowerBed();
    }

    public void raiseBed(){
        vehicles.raiseBed();
    }
}