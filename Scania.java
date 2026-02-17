import java.awt.*;

public class Scania extends Truck implements hasTruckbed{
    private double truckBedAngle = 0;

    public Scania(){
        super(2, 500, Color.GRAY, "Scania", 30);
    }

    public double getTruckBedAngle(){
        return this.truckBedAngle;
    }

    public void setTruckBedAngle(double deg){
        if (this.getCurrentSpeed() != 0) IO.println("Cannot change truck bed if truck is moving");
        else if(deg > 70 || deg < 0) IO.println("Truck bed must be between 0-70 degrees");
        else this.truckBedAngle = deg;
    }

    @Override
    protected boolean canMove() {
        return getTruckBedAngle() == 0;
    }
}
