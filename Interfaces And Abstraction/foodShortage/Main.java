package interfacesAndAbstraction.foodShortage;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {
   public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<Buyer> buyers = new ArrayList<>();

        Buyer buyer;
        int n = Integer.parseInt(scan.nextLine());

        while (n-- > 0) {
            String[] input = scan.nextLine().split("\\s+");

            if (input.length == 4) {
                buyer = new Citizen(input[0],Integer.parseInt(input[1]), input[2], input[3]);

            } else {
                buyer = new Rebel(input[0], Integer.parseInt(input[1]), input[2]);

            }
            buyers.add(buyer);
        }

        String names = scan.nextLine();

        while (!names.equals("End")) {
            for (int i = 0; i < buyers.size(); i++) {
                if (buyers.get(i).getName().equals(names)) {
                    buyers.get(i).buyFood();
                }
            }
            names = scan.nextLine();
        }



        int sum = 0;
        for (Buyer buyer1 : buyers) {
            sum += buyer1.getFood();
        }
        System.out.println(sum);




    }
}
