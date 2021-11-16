package polymorphism.vehicles;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] input = scan.nextLine().split("\\s+");
        Vehicles car = new Car(Double.parseDouble(input[1]), Double.parseDouble(input[2]));

        input = scan.nextLine().split("\\s+");
        Vehicles truck = new Truck(Double.parseDouble(input[1]), Double.parseDouble(input[2]));

        int commands = Integer.parseInt(scan.nextLine());

        while (commands-- > 0) {
            input = scan.nextLine().split("\\s+");
            if (input[0].equals("Drive")) {
                double distance = Double.parseDouble(input[2]);

                if (input[1].equals("Car")) {
                    System.out.println(car.getDriving(distance));

                } else if (input[1].equals("Truck")) {
                    System.out.println(truck.getDriving(distance));

                }
            } else if (input[0].equals("Refuel")) {
                double liters = Double.parseDouble(input[2]);

                if (input[1].equals("Car")) {
                    car.getRefueling(liters);

                } else if (input[1].equals("Truck")) {
                    truck.getRefueling(liters);
                }
            }

        }

        System.out.println(car.toString());
        System.out.println(truck.toString());


    }
}
