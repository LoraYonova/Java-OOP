package encapsulaton.shoppingSpree;

import javax.swing.plaf.synth.SynthRadioButtonMenuItemUI;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<String, Person> persons = new LinkedHashMap<>();
        Map<String, Product> products = new HashMap<>();

            String[] names = scan.nextLine().split(";");
            for (String element : names) {
                String[] informationForPerson = element.split("=");
                String name = informationForPerson[0];
                double money = Double.parseDouble(informationForPerson[1]);
                try {
                Person person = new Person(name, money);
                persons.put(name, person);

                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                    return;
                }
            }

            String[] nameProducts = scan.nextLine().split(";");

            for (String element : nameProducts) {
                String[] informationForProduct = element.split("=");
                String name = informationForProduct[0];
                double cost = Double.parseDouble(informationForProduct[1]);

                try {
                Product product = new Product(name, cost);
                products.put(name, product);

                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                    return;
                }

            }

           String command = scan.nextLine();

            while (command.equals("END")) {
                String[] commandPart = command.split("\\s+");
                String name = commandPart[0];
                String nameProduct = commandPart[1];

                try {
                persons.get(name).buyProduct(products.get(nameProduct));

                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }

                command = scan.nextLine();
            }

        for (Person person : persons.values()) {
            System.out.print(person.getName() + " - ");
            if(person.getProducts().isEmpty()) {
                System.out.println("Nothing bought");
            } else {
                System.out.println(person.getProducts().stream().map(Product::getName).collect(Collectors.joining(", ")));
            }
        }


    }


}
