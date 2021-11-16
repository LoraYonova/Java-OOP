package polymorphism.vehicles;

public class Truck extends Vehicles {
    private static final double INCREASED_FUEL_TRUCK = 1.6;

    public Truck(double fuelQuantity, double fuelInLittersPerKm) {
        super(fuelQuantity, fuelInLittersPerKm + INCREASED_FUEL_TRUCK);
    }

    @Override
    public String getDriving(double distance) {
        return super.getDriving(distance);
    }

    @Override
    public void getRefueling(double liters) {
        super.getRefueling(liters * 0.95);
    }

    @Override
    public String toString() {
        return String.format("%s: %.2f",getClass().getSimpleName(), fuelQuantity);
    }

}
