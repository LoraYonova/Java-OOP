package polymorphism.vehiclesExtension;

import java.text.DecimalFormat;

public abstract class Vehicles {
    protected double fuelQuantity;
    protected double fuelInLittersPerKm;
    protected double tankCapacity;


    protected Vehicles(double fuelQuantity, double fuelInLittersPerKm, double tankCapacity) {
        this.fuelQuantity = fuelQuantity;
        this.fuelInLittersPerKm = fuelInLittersPerKm;
        this.tankCapacity = tankCapacity;

    }

    protected String getDriving(double distance) {
        if (fuelInLittersPerKm * distance < this.fuelQuantity) {
            this.fuelQuantity -= fuelInLittersPerKm * distance;
            return String.format("%s travelled %s km", getClass().getSimpleName(), new DecimalFormat("##.##").format(distance));
        }
        return String.format("%s needs refueling", getClass().getSimpleName());
    }

    protected void getRefueling(double liters) {
        if (liters <= 0) {
            System.out.println("Fuel must be a positive number");
            return;
        }
        if (fuelQuantity + liters < tankCapacity) {
            this.fuelQuantity += liters;

        } else {
            System.out.println("Cannot fit fuel in tank");
        }

    }


}
