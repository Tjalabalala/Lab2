import java.awt.*;

public class Saab95 extends Car implements hasTurbo{

    private boolean turboOn;
    
    public Saab95(){
	    turboOn = false;
        super(2, 125, Color.red, "Saab95", 1.2);
    }

    public double speedFactor(){
        double turbo = 1;
        if(turboOn) turbo = 1.3;
        return getEnginePower() * 0.01 * turbo;
    }

    @Override
    public void setTurboOn() {
        turboOn = true;
    }
    @Override
    public void setTurboOff() {
        turboOn = false;
    }

}
