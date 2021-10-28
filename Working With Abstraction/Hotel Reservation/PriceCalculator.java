package WorkingWithAbstraction.HotelReservation;

public class PriceCalculator {
    private double pricePerDay;
    private int numberOfDay;
    private Season season;
    private DiscountType discountType;

    public PriceCalculator(double pricePerDay, int numberOfDay, Season season, DiscountType discountType) {
        this.pricePerDay = pricePerDay;
        this.numberOfDay = numberOfDay;
        this.season = season;
        this.discountType = discountType;
    }
    public double calculatePrice() {
        return (pricePerDay * season.getSeason()) * numberOfDay * (1 - discountType.getDiscountType());
    }
}
