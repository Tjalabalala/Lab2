import java.awt.*;

public class Volvo240 extends Car implements IDrawable {

    private final static double trimFactor = 1.25;
    
    public Volvo240(){
        super(4,100, Color.black, "Volvo240", 1.2);
    }

    public double speedFactor(){
        return getEnginePower() * 0.01 * trimFactor;
    }

    public int getWidth() { return 100; }
    public int getHeight() { return 60; }
    public String getImagePath() { return "pics/Volvo240.jpg"; }

}
