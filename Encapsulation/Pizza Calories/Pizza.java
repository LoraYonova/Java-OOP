package encapsulaton.pizzaCalories;

import java.util.ArrayList;
import java.util.List;

public class Pizza {
    private String name;
    private Dough dough;
    private List<Topping> toppings;
    private int numberOfToppings;

    public Pizza(String name, int numberOfToppings) {
        this.setName(name);
        this.setToppings(numberOfToppings);
        this.toppings = new ArrayList<>(this.numberOfToppings);
    }


    private void setToppings(int numberOfToppings) {
        if (numberOfToppings < 1 || numberOfToppings > 10) {
           throw new IllegalArgumentException("Number of toppings should be in range [0..10].");

        }
        this.numberOfToppings = numberOfToppings;
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty() || name.trim().length() > 15) {
            throw new IllegalArgumentException("Pizza name should be between 1 and 15 symbols.");
        }

        this.name = name;
    }

    public void setDough(Dough dough) {
        this.dough = dough;
    }

    public String getName() {
        return name;
    }

    public void addTopping(Topping topping) {
        this.toppings.add(topping);

    }

    private double getOverallCalories() {
        return this.dough.calculateCalories() + toppings.stream().mapToDouble(Topping::calculateCalories).sum();
    }

    @Override
    public String toString() {
        return String.format("%s - %.2f", this.name, getOverallCalories());
    }
}
