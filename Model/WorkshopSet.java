package Model;

import View.IDrawable;

import java.util.ArrayList;

public class WorkshopSet {
    private ArrayList<Workshop> workshops;
    private ArrayList<ModelListener> actionListeners = new ArrayList<>();

    public WorkshopSet(){
        workshops = new ArrayList<Workshop>();
    }
    public WorkshopSet(ArrayList<Workshop> _workshops){
        workshops = _workshops;
    }

    public Workshop get(int index){
        return workshops.get(index);
    }

    public ArrayList<Workshop> getAll(){
        return this.workshops;
    }

    public void add(Workshop workshop){
        this.workshops.add(workshop);
    }

    public void addActionListener(ModelListener listener){
        this.actionListeners.add(listener);
    }

    public void removeActionListener(ModelListener listener){
        this.actionListeners.remove(listener);
    }

    public ArrayList<IVehicle> checkWorkshopCollision(VehicleSet vehicles){
        ArrayList<IVehicle> _vehicles = new ArrayList<IVehicle>();
        for (Workshop workshop : workshops) {
            for (IVehicle vehicle : vehicles.getVehicles()){
                if (workshop.overlaps(vehicle) && workshop.tryToLoadCar(vehicle)) {
                    if (vehicle instanceof IDrawable drawable){
                        for (ModelListener modelListener: actionListeners){
                            modelListener.removeVehicle(drawable);
                            _vehicles.add(vehicle);
                        }
                    };
                }
            }
        }
        return _vehicles;
    }

}
