import org.junit.jupiter.api.Test;

import java.awt.*;
import java.util.Vector;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WorkshopTests {
    @Test
    public void workshopTest() {
        Vector<Car> testCars = new Vector<>();
        for (int i = 0; i < 10; i++) testCars.add(new Volvo240());

        Workshop<Car> genericWorkshop = new Workshop<>(5);

        for (Car car : testCars) genericWorkshop.addCar(car);
        assertEquals(5, genericWorkshop.getCarCount());

        for (int i = 0; i < 5; i++) genericWorkshop.removeCar(testCars.get(i));
        assertEquals(0, genericWorkshop.getCarCount());

        Workshop<Volvo240> volvoWorkshop = new Workshop<>(2);
        Volvo240 volvo = new Volvo240();
        volvoWorkshop.addCar(volvo);

        assertEquals(volvo, volvoWorkshop.getCars().firstElement());

        assertEquals(2, volvoWorkshop.getCapacity());
    }
}
