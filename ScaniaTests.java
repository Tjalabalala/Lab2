import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class ScaniaTests {
    @ParameterizedTest
    @ValueSource(ints = {0, 10, 35, 70, -1, 100})
    public void scaniaTest(int angle) {
        Scania scania = new Scania();

        assertEquals("Scania", scania.getModelName());
        assertEquals(0, scania.getTruckBedAngle());

        scania.setTruckBedAngle(angle);

        if (angle <= 70 && angle >= 0) assertEquals(angle, scania.getTruckBedAngle());
        else assertNotEquals(angle, scania.getTruckBedAngle());
    }

    @Test
    public void truckTest() {
        Scania scania = new Scania();

        assertEquals(5, scania.speedFactor());

        scania.gas(0.5);

        scania.setTruckBedAngle(10);
        assertEquals(0, scania.getTruckBedAngle());

        scania.brake(0.5);

        scania.setTruckBedAngle(10);
        assertEquals(10, scania.getTruckBedAngle());

        scania.gas(0.5);

        assertEquals(0, scania.getCurrentSpeed());
    }
}
