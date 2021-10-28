package WorkingWithAbstraction.HotelReservation;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] input = scan.nextLine().split("\\s+");

        double pricePerDay = Double.parseDouble(input[0]);
        int numberOfDay = Integer.parseInt(input[1]);
        Season season = Season.valueOf(input[2].toUpperCase());
        DiscountType discountType = DiscountType.parseDiscount(input[3]);

        PriceCalculator calculator = new PriceCalculator(pricePerDay, numberOfDay, season, discountType);

        System.out.printf("%.2f%n", calculator.calculatePrice());




    }


}
