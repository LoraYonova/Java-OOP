package interfacesAndAbstraction.borderControl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<Identifiable> list = new ArrayList<>();
        Identifiable identifiable;

        String command = scan.nextLine();

        while (!command.equals("End")) {
            String[] input = command.split("\\s+");

            if (input.length == 3) {
                identifiable = new Citizen(input[0], Integer.parseInt(input[1]), input[2]);

            } else {
                identifiable = new Robot(input[0], input[1]);
            }

            list.add(identifiable);

            command = scan.nextLine();
        }
        String end = scan.nextLine();

        List<String> collect = list.stream().map(Identifiable::getId).collect(Collectors.toList());
        collect.stream().filter(id -> id.startsWith(end, id.length() - end.length())).forEach(System.out::println);
    }
}
