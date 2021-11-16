package polymorphism.vehicles;

import java.text.DecimalFormat;

public class Car extends Vehicles{
    private static final double INCREASED_FUEL_CAR = 0.9;

    public Car(double fuelQuantity, double fuelInLittersPerKm) {
        super(fuelQuantity, fuelInLittersPerKm + INCREASED_FUEL_CAR);
    }

    @Override
    public String getDriving(double distance) {
        return super.getDriving(distance);
    }

    @Override
    public void getRefueling(double liters) {
        super.getRefueling(liters);
    }

    @Override
    public String toString() {
        return String.format("%s: %.2f",getClass().getSimpleName(),fuelQuantity);
    }
}
