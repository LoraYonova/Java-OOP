package interfacesAndAbstraction.ferrari;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();
        Ferrari ferrari = new Ferrari(input);

        System.out.println(ferrari.toString());




    }
}
