public interface Iramp {
    abstract void raiseRamp(int angle);
    abstract void lowerRamp(int angle);
    abstract double getTruckBedAngle();
    abstract void gas(double amount);
}
