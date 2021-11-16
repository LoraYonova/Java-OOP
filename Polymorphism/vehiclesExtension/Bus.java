package polymorphism.vehiclesExtension;

public class Bus extends Vehicles {
    private static final double INCREASED_FUEL = 1.4;

    private boolean emptyBus;


    public Bus(double fuelQuantity, double fuelInLittersPerKm, double tankCapacity) {
        super(fuelQuantity, fuelInLittersPerKm, tankCapacity);
        this.emptyBus = true;
    }

    public void setEmptyBus(boolean emptyBus) {
        if (this.emptyBus == emptyBus) {
            return;
        }

        if (this.emptyBus) {
            super.fuelInLittersPerKm += INCREASED_FUEL;

        } else {
            super.fuelInLittersPerKm -= INCREASED_FUEL;

        }

        this.emptyBus = emptyBus;
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
        return String.format("%s: %.2f", getClass().getSimpleName(), fuelQuantity);
    }
}
