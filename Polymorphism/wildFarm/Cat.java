package polymorphism.wildFarm;

import java.text.DecimalFormat;

public class Cat extends Felime{
    private String bread;

    public Cat(String animalType, String animalName, Double animalWeight, String livingRegion, String bread) {
        super(animalType, animalName, animalWeight, livingRegion);
        this.bread = bread;
    }

    @Override
    public void makeSound() {
        System.out.println("Meowwww");
    }

    @Override
    public void eat(Food food) {
        super.eat(food);
    }

    @Override
    public String toString() {
        return String.format("%s[%s, %s, %s, %s, %d]",
                getAnimalType(), getAnimalName(),
                bread,new DecimalFormat("##.##").format(getAnimalWeight()),
                getLivingRegion(), getFoodEaten());
    }
}
