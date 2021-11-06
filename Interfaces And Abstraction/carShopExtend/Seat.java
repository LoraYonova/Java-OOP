package interfacesAndAbstraction.carShopExtend;


public class Seat extends CarImpl implements Sellable{
    Double price;

    public Seat(String model, String color, Integer horsePower, String countryProduced, Double price) {
        super(model, color, horsePower, countryProduced);
        this.price = price;
    }

    @Override
    public Double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return super.toString() + System.lineSeparator()
                + model + " sell for " + price;
    }
}
