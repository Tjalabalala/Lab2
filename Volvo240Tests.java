import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Volvo240Tests {
    @Test
    public void volvo240Test() {
        Volvo240 volvo240 = new Volvo240();

        assertEquals(4, volvo240.getNrDoors());
        assertEquals(new Color(0, 0, 0), volvo240.getColor());
        assertEquals(1.25, volvo240.speedFactor());
        assertEquals(100, volvo240.getEnginePower());

        assertEquals(1 * 1.25, volvo240.speedFactor());
    }
}
