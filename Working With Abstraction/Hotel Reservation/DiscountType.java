package WorkingWithAbstraction.HotelReservation;

public enum DiscountType {
    VIP(0.20),
    SECOND_VISIT(0.10),
    NONE(0);

    private double discountType;

    DiscountType(double discountType) {
        this.discountType = discountType;
    }

    public double getDiscountType() {
        return discountType;
    }

    public static DiscountType parseDiscount(String discount) {
        switch (discount) {
            case "VIP":
                return VIP;
            case "SecondVisit":
                return SECOND_VISIT;
            case "None":
                return NONE;
            default:
                throw new IllegalArgumentException("Unknown discount type " + discount);
        }
    }

}
