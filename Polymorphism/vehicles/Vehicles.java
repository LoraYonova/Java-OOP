package polymorphism.vehicles;

import java.text.DecimalFormat;

public abstract class Vehicles {
    protected double fuelQuantity;
    protected double fuelInLittersPerKm;


    protected Vehicles(double fuelQuantity, double fuelInLittersPerKm) {
        this.fuelQuantity = fuelQuantity;
        this.fuelInLittersPerKm = fuelInLittersPerKm;

    }

    protected String getDriving(double distance) {
        if (fuelInLittersPerKm * distance < this.fuelQuantity) {
            this.fuelQuantity -= fuelInLittersPerKm * distance;
            return String.format("%s travelled %s km", getClass().getSimpleName(), new DecimalFormat("#.##").format(distance));
        }
        return String.format("%s needs refueling", getClass().getSimpleName());
    }

    protected void getRefueling(double liters) {
        this.fuelQuantity += liters;

    }


}
