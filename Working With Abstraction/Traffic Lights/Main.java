package workingWithAbstraction.TrafficLights;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<String> input = Arrays.stream(scan.nextLine().split("\\s+")).collect(Collectors.toList());

        int n = Integer.parseInt(scan.nextLine());
        while (n-- > 0) {
            for (int i = 0; i < input.size(); i++) {
                TrafficLight trafficLight = TrafficLight.valueOf(input.get(i));
                TrafficLight result = trafficLight.changeLight(input.get(i));
                input.set(i, result.name());
                System.out.print(result + " ");
            }
            System.out.println();


        }

    }
}
