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

    static CarController cc;

    static CarApplication ca;

    private void add_car(IVehicle car, int x, int y) {
        car.setX(x);
        car.setY(y);

        add_car(car);
    }

    private void add_car(IVehicle car) {
        cars.addVehicle(car);
        ca.frame.addDrawableVehicle(car);
    }

    public static void main(String[] args){
        // Instance of this class
        ca = new CarApplication();
        cc = new CarController(cars);
        ca.frame = new CarView("CarSim 1.0", cc, ca.drawables);

        ca.add_car(new Volvo240(), 0, 300);
        ca.add_car(new Saab95(), 0, 100);
        ca.add_car(new Scania(), 0, 200);

        Workshop<Volvo240> volvoWorkshop = new Workshop<Volvo240>(5, Volvo240.class);
        ca.drawables.add(volvoWorkshop);
        ca.workshops.add(volvoWorkshop);

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
