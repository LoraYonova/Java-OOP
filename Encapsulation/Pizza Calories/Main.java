package encapsulaton.pizzaCalories;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);


            String[] inputPizza = scan.nextLine().split(" ");
            String pizzaName = inputPizza[1];
            int numberOfToppings = Integer.parseInt(inputPizza[2]);
            Pizza pizza = null;
            try {
                pizza = new Pizza(pizzaName, numberOfToppings);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                return;
            }
            String[] inputDough = scan.nextLine().split("\\s+");
            String flourType = inputDough[1];
            String bakingTechnique = inputDough[2];
            double weightInGrams = Double.parseDouble(inputDough[3]);

            try {
            Dough dough = new Dough(flourType, bakingTechnique, weightInGrams);
             pizza.setDough(dough);

            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                return;
            }

            String command = scan.nextLine();

            while (!command.equals("END")) {
                String[] topping = command.split("\\s+");
                String toppingType = topping[1];
                double weightGrams = Double.parseDouble(topping[2]);
                try {
                Topping toppings = new Topping(toppingType, weightGrams);
                pizza.addTopping(toppings);

                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                    return;
                }

                command = scan.nextLine();
            }
            System.out.println(pizza);



    }
}
