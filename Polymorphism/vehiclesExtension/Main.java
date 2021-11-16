package polymorphism.vehiclesExtension;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] input = scan.nextLine().split("\\s+");
        Vehicles car = new Car(Double.parseDouble(input[1]), Double.parseDouble(input[2]), Double.parseDouble(input[3]));

        input = scan.nextLine().split("\\s+");
        Vehicles truck = new Truck(Double.parseDouble(input[1]), Double.parseDouble(input[2]), Double.parseDouble(input[3]));

        input = scan.nextLine().split("\\s+");
        Vehicles bus = new Bus(Double.parseDouble(input[1]), Double.parseDouble(input[2]), Double.parseDouble(input[3]));

        int commands = Integer.parseInt(scan.nextLine());

        Map<String, Vehicles> vehicle = new LinkedHashMap<>();
        vehicle.put("Car", car);
        vehicle.put("Truck", truck);
        vehicle.put("Bus", bus);

        while (commands-- > 0) {
            input = scan.nextLine().split("\\s+");
            String line = input[1];
            if (input[0].equals("Drive")) {
                double distance = Double.parseDouble(input[2]);
                if (bus instanceof Bus) {
                    ((Bus) bus).setEmptyBus(false);
                }
                System.out.println(vehicle.get(line).getDriving(distance));

            } else if (input[0].equals("Refuel")) {
                double liters = Double.parseDouble(input[2]);
                vehicle.get(line).getRefueling(liters);

            } else if (input[0].equals("DriveEmpty")) {
                double distance = Double.parseDouble(input[2]);
                    if(bus instanceof Bus) {
                       ((Bus) bus).setEmptyBus(true);
                    }
                    System.out.println(vehicle.get(line).getDriving(distance));
            }

        }
            System.out.println(car.toString());
            System.out.println(truck.toString());
            System.out.println(bus.toString());
    }
}
