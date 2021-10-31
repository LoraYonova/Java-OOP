package workingWithAbstraction.CardsWithPower;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String nameRank = scan.nextLine();
        String nameSuit = scan.nextLine();

        RankPower rankPower = RankPower.valueOf(nameRank);
        SuitPower suitPower = SuitPower.valueOf(nameSuit);

        System.out.printf("Card name: %s of %s; Card power: %d", rankPower.name(), suitPower.name(), rankPower.getRankPower() + suitPower.getSuitPower());


    }
}
