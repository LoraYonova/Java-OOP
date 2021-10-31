package workingWithAbstraction.CardSuit;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();

        CardSuit[] cardSuits = CardSuit.values();
        System.out.println(input + ":");
        for (CardSuit cardSuit : cardSuits) {
            System.out.println("Ordinal value: " + cardSuit.ordinal() + "; " + "Name value: " + cardSuit.name());
        }


    }
}
