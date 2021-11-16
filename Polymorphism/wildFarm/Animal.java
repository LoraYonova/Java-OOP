package polymorphism.wildFarm;

public abstract class Animal {
    private String animalName;
    private String animalType;
    private Double animalWeight;
    private int foodEaten;

    public abstract void makeSound();

    public void eat(Food food) {
        this.foodEaten += food.getQuantity();

    }

    public Animal(String animalType, String animalName, Double animalWeight) {
        this.animalName = animalName;
        this.animalType = animalType;
        this.animalWeight = animalWeight;
        this.foodEaten = 0;

    }

    public String getAnimalName() {
        return animalName;
    }

    public String getAnimalType() {
        return animalType;
    }

    public Double getAnimalWeight() {
        return animalWeight;
    }

    public int getFoodEaten() {
        return foodEaten;
    }
}
