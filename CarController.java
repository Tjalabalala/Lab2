import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.util.ArrayList;

/*
 * This class represents the Controller part in the MVC pattern.
 * Its responsibilities is to listen to the View and responds in a appropriate manner by
 * modifying the model state and the updating the view.
 */

public class CarController {
    // member fields:

    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 50;
    // The timer is started with a listener (see below) that executes the statements
    // each step between delays.
    private Timer timer = new Timer(delay, new TimerListener());

    // The frame that represents this instance View of the MVC pattern
    CarView frame;

    ArrayList<Car> cars = new ArrayList<>();
    ArrayList<IDrawable> drawables = new ArrayList<>();
    ArrayList<Workshop> workshops = new ArrayList<>();

    static CarController cc;

    private <T extends Car & IDrawable> void add_car(T car) {
        cars.add(car);
        drawables.add(car);
    }

    //methods:
    public static void main(String[] args) {
        // Instance of this class
        cc = new CarController();

        cc.add_car(new Volvo240());
        cc.add_car(new Saab95());
        cc.add_car(new Scania());

        cc.cars.get(0).setY(300);
        cc.cars.get(1).setY(100); // Saab95
        cc.cars.get(2).setY(200); // Scania

        Workshop<Volvo240> volvoWorkshop = new Workshop<Volvo240>(5, Volvo240.class);
        cc.drawables.add(volvoWorkshop);
        cc.workshops.add(volvoWorkshop);

        // Start a new view and send a reference of self
        cc.frame = new CarView("CarSim 1.0", cc, cc.drawables);

        // Start the timer
        cc.timer.start();
    }

    /* Each step the TimerListener moves all the cars in the list and tells the
     * view to update its images. Change this method to your needs.
     * */
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            for (Car car : cars) {
                if ((car.getX() >= 700 && car.getAngle() == 0) || (car.getX() <= 0 && Math.abs(car.getAngle()) == 180)){
                    car.turnRight();
                    car.turnRight();
                }
                else car.move();
            }
            for (Workshop workshop : workshops) {
                ArrayList<Car> tempList = new ArrayList<>();
                for (Car car: cars){
                    if (car instanceof IDrawable drawableCar
                            && workshop.overlaps(drawableCar)
                            && workshop.tryToLoadCar(car)) {
                        cc.drawables.remove(car);
                        tempList.add(car);
                    }
                }
                for (Car car : tempList) cars.remove(car);
            }
            frame.drawPanel.repaint();
        }
    }

    // Calls the gas method for each car once
    void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (Car car : cars
        ) {
            car.gas(gas);
        }
    }

    void brake(int amount){
        double brake = ((double) amount) / 100;
        for (Car car : cars){
            car.brake(brake);
        }
    }

    void startEngine(){
        for (Car car: cars){
            car.startEngine();
        }
    }

    void stopEngine(){
        for (Car car : cars){
            car.stopEngine();
        }
    }

    void turboOn(){
        for (Car car : cars){
            if (car instanceof hasTurbo turboCar){
                turboCar.setTurboOn();
            }
        }
    }

    void turboOff(){
        for (Car car : cars){
            if (car instanceof hasTurbo turboCar) turboCar.setTurboOff();
        }
    }

    void lowerBed(){
        for (Car car : cars){
            if (car instanceof  hasTruckbed truck) truck.setTruckBedAngle(0);
        }
    }

    void raiseBed(){
        for (Car car : cars){
            if (car instanceof hasTruckbed truck) truck.setTruckBedAngle(70);
        }
    }
}