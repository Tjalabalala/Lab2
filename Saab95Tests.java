import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Saab95Tests {
    @Test
    public void saab95Test() {
        Saab95 saab95 = new Saab95();

        assertEquals(2, saab95.getNrDoors());
        assertEquals(new Color(255, 0, 0), saab95.getColor());
        assertEquals(1.25, saab95.speedFactor());
        assertEquals(125, saab95.getEnginePower());
        assertEquals("Saab95", saab95.getModelName());

        saab95.setTurboOn();
        assertEquals(1.25*1.3, saab95.speedFactor());

        saab95.setTurboOff();
        assertEquals(1.25, saab95.speedFactor());
    }

    @ParameterizedTest
    @ValueSource(doubles = {-250, -1, 0, 1, 50, 250})
    public void carTest(double someVal) {
        Saab95 saab95 = new Saab95();

        saab95.setColor(Color.blue);
        assertEquals(new Color(0, 0, 255), saab95.getColor());

        double beforeSpeed = saab95.getCurrentSpeed();
        saab95.gas(someVal);

        assertTrue(saab95.getCurrentSpeed() >= beforeSpeed);
        assertTrue(0 <= saab95.getCurrentSpeed() && saab95.getCurrentSpeed() <= saab95.getEnginePower());

        beforeSpeed = saab95.getCurrentSpeed();
        saab95.brake(someVal);

        assertTrue(saab95.getCurrentSpeed() <= beforeSpeed);
        assertTrue(0 <= saab95.getCurrentSpeed() && saab95.getCurrentSpeed() <= saab95.getEnginePower());
    }

    @Test
    public void moveTest() {
        Saab95 saab95 = new Saab95();

        saab95.startEngine();
        assertEquals(0.1, saab95.getCurrentSpeed());

        saab95.move();
        saab95.turnRight();
        saab95.move();
        saab95.turnLeft();
        saab95.move();

        assertEquals(saab95.getCurrentSpeed() * 2, saab95.getX());
        assertEquals(-saab95.getCurrentSpeed(), saab95.getY());
    }
}
