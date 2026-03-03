package Model;

import View.IDrawable;

import java.awt.*;

public class Volvo240 extends Car {
    private final static double trimFactor = 1.25;
    
    public Volvo240(){
        super(4,100, Color.black, "Model.Volvo240", 1.2);
    }

    public double speedFactor(){
        return getEnginePower() * 0.01 * trimFactor;
    }

    public int getWidth() { return 100; }
    public int getHeight() { return 60; }
}
