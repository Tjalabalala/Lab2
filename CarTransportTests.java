import org.junit.jupiter.api.Test;

import java.awt.*;
import java.util.Vector;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CarTransportTests {
    @Test
    public void carTransportTest() {
        CarTransport carTransport = new CarTransport();

        assertEquals(CarTransport.RampState.UP, carTransport.getRamp());
        assertEquals(8, carTransport.getCapacity());

        carTransport.gas(0.5);
        carTransport.setRamp(CarTransport.RampState.DOWN);
        assertEquals(CarTransport.RampState.UP, carTransport.getRamp());

        Vector<Car> testCars = new Vector<>();
        for (int i = 0; i < 10; i++) testCars.add(new Saab95());

        carTransport.addCar(testCars.getFirst());

        assertEquals(0, carTransport.getCarCount());

        carTransport.brake(0.5);
        carTransport.setRamp(CarTransport.RampState.DOWN);
        assertEquals(CarTransport.RampState.DOWN, carTransport.getRamp());

        for (Car car : testCars) carTransport.addCar(car);
        assertEquals(carTransport.getCapacity(), carTransport.getCarCount());

        carTransport.setRamp(CarTransport.RampState.UP);
        carTransport.gas(0.5);
        carTransport.move();

        assertEquals(carTransport.getX(), testCars.firstElement().getX());
        assertEquals(carTransport.getY(), testCars.firstElement().getY());

        carTransport.brake(0.5);
        carTransport.setRamp(CarTransport.RampState.DOWN);

        carTransport.removeCar(testCars.lastElement());
        assertEquals(carTransport.getCapacity(), carTransport.getCarCount());

        for (int i = carTransport.getCapacity()-1; i >= 0; i--)
            carTransport.removeCar(testCars.get(i));

        assertEquals(0, carTransport.getCarCount());
    }
}
