import Controller.CarController;
import Model.*;
import View.CarView;

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
    ArrayList<IDrawable> drawables = new ArrayList<>();
    ArrayList<Workshop> workshops = new ArrayList<>();

    static CarController cc;

    static CarApplication ca;

    private <T extends IVehicle & IDrawable> void add_car(T car) {
        cars.addVehicle(car);
        drawables.add(car);
    }

    public static void main(String[] args){
        // Instance of this class
        ca = new CarApplication();

        cc = new CarController(cars);

        ca.add_car(new Volvo240());
        ca.add_car(new Saab95());
        ca.add_car(new Scania());

        ca.cars.get(0).setY(300);
        ca.cars.get(1).setY(100); // Model.Saab95
        ca.cars.get(2).setY(200); // Model.Scania

        Workshop<Volvo240> volvoWorkshop = new Workshop<Volvo240>(5, Volvo240.class);
        ca.drawables.add(volvoWorkshop);
        ca.workshops.add(volvoWorkshop);

        // Start a new view and send a reference of self
        ca.frame = new CarView("CarSim 1.0", cc, ca.drawables);

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
                if(checkWorkshopCollision(car)) iter.remove();
            }
            //IO.println(cars.get(0).getCurrentSpeed());
            frame.drawPanel.repaint();
        }
    }

    private boolean checkWorkshopCollision(IVehicle car) {
        for (Workshop workshop : workshops) {
            if (car instanceof IDrawable drawableCar
                    && workshop.overlaps(drawableCar)
                    && workshop.tryToLoadCar(car)) {
                ca.drawables.remove(car);
                return true;
            }
        }
        return false;
    }

}
