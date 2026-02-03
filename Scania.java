import java.awt.*;

public class Scania extends Car {

    private double truckBedAngle;

    public Scania(){
        super(2, 500, Color.GRAY, "Scania");
        this.truckBedAngle = 0;
    }


    public double getTruckBedAngle(){
        return this.truckBedAngle;
    }

    public void setTruckBedAngle(double deg){
        if (this.getCurrentSpeed() != 0){
            IO.println("Cannot change truck bed if truck is moving");
        }
        else if(deg > 70 || deg < 0){
            IO.println("Truck bed must be between 0-70 degrees");
        }
        else{
            this.truckBedAngle = deg;
        }
    }

    @Override
    public double speedFactor() {
        return getEnginePower() * 0.01;
    }

    @Override
    public void gas(double amount){
        if(this.getTruckBedAngle() == 0) {
            super.gas(amount);
        }
        else{
            IO.println("Cannot move when truck bed is not lowered");
        }
    }


}
