package Application;

import Controller.CarController;
import Model.*;
import View.CarView;
import View.IDrawable;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.ListIterator;

public class CarApplication {

    // member fields:

    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 50;
    // The timer is started with a listener (see below) that executes the statements
    // each step between delays.
    private Timer timer = new Timer(delay, new CarApplication.TimerListener());

    // The frame that represents this instance View of the MVC pattern
    CarView frame;

    static VehicleSet cars = new VehicleSet();
    static WorkshopSet workshops = new WorkshopSet();
    ArrayList<IDrawable> drawables = new ArrayList<>();
    //ArrayList<Workshop> workshops = new ArrayList<>();

    static CarController cc;

    static CarApplication ca;

    private <T extends IVehicle & IDrawable> void add_car(T car, int x, int y) {
        car.setX(x);
        car.setY(y);

        add_car(car);
    }

    private <T extends IVehicle & IDrawable> void add_car(T car) {
        cars.addVehicle(car);
        drawables.add(car);
    }

    public static void main(String[] args){
        // Instance of this class
        ca = new CarApplication();
        cc = new CarController(cars);

        ca.add_car(new Volvo240(), 0, 300);
        ca.add_car(new Saab95(), 0, 100);
        ca.add_car(new Scania(), 0, 200);

        Workshop<Volvo240> volvoWorkshop = new Workshop<Volvo240>(5, Volvo240.class);
        ca.drawables.add(volvoWorkshop);
        ca.workshops.add(volvoWorkshop);

        // Start a new view and send a reference of self
        ca.frame = new CarView("CarSim 1.0", cc, ca.drawables);
        cars.addListener(ca.frame);
        workshops.addActionListener(ca.frame);
        // Start the timer
        ca.timer.start();
    }

    /* Each step the TimerListener moves all the cars in the list and tells the
     * view to update its images. Change this method to your needs.
     * */
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            ListIterator<IVehicle> iter = cars.getVehicles().listIterator();

            while(iter.hasNext()) {
                IVehicle car = iter.next();
                car.checkBorderCollision(700);
            }
            for (IVehicle car : workshops.checkWorkshopCollision(cars)){
                cars.removeVehicle(car);
            }
            //IO.println(cars.get(0).getCurrentSpeed());
            cars.moveAll();
        }
    }


}
