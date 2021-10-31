package workingWithAbstraction.CardRanks;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();

        CardRanks[] cardRanks = CardRanks.values();

        System.out.println(input + ":");

        for (CardRanks cardRank : cardRanks) {
            System.out.printf("Ordinal value: %d; Name value: %s%n", cardRank.ordinal(), cardRank.name());
        }

    }
}
