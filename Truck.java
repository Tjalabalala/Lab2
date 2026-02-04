import java.awt.*;

public abstract class Truck extends Car {
    public Truck(int nr, double ep, Color col, String model, double w){
        super(nr, ep, col, model, w);
    }

    @Override
    public double speedFactor() { return getEnginePower() * 0.01; }

    protected abstract boolean canMove();

    @Override
    public void gas(double amount) {
        if (canMove()) super.gas(amount);
        else IO.println("Unable to move truck");
    }
}
