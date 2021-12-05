package bakery.entities.tables;

import bakery.entities.bakedFoods.interfaces.BakedFood;
import bakery.entities.drinks.interfaces.Drink;
import bakery.entities.tables.interfaces.Table;

import java.util.ArrayList;
import java.util.Collection;

import static bakery.common.ExceptionMessages.INVALID_NUMBER_OF_PEOPLE;
import static bakery.common.ExceptionMessages.INVALID_TABLE_CAPACITY;

public abstract class BaseTable implements Table {
    private Collection<BakedFood> foodOrders;
    private Collection<Drink> drinkOrders;
    private int tableNumber;
    private int capacity;
    private int numberOfPeople;
    private double pricePerPerson;
    private boolean isReserved;
    private double price;

    protected BaseTable(int tableNumber, int capacity, double pricePerPerson) {
        this.tableNumber = tableNumber;
        setCapacity(capacity);
        this.pricePerPerson = pricePerPerson;
        setReserved(false);
        this.foodOrders = new ArrayList<>();
        this.drinkOrders = new ArrayList<>();
        this.price = 0;


    }

    private void setReserved(boolean reserved) {
        isReserved = reserved;
    }

    private void setCapacity(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException(INVALID_TABLE_CAPACITY);
        }
        this.capacity = capacity;
    }

    private void setNumberOfPeople(int numberOfPeople) {
        if (numberOfPeople <= 0) {
            throw new IllegalArgumentException(INVALID_NUMBER_OF_PEOPLE);
        }
        this.numberOfPeople = numberOfPeople;
    }

    @Override
    public int getTableNumber() {
        return this.tableNumber;
    }

    @Override
    public int getCapacity() {
        return this.capacity;
    }

    @Override
    public int getNumberOfPeople() {
        return this.numberOfPeople;
    }

    @Override
    public double getPricePerPerson() {
        return this.pricePerPerson;
    }

    @Override
    public boolean isReserved() {
        return this.isReserved;
    }

    @Override
    public double getPrice() {
        return this.price;
    }

    @Override
    public void reserve(int numberOfPeople) {
        setNumberOfPeople(numberOfPeople);
        this.price = this.getPricePerPerson() * this.getNumberOfPeople();
        setReserved(true);
    }

    @Override
    public void orderFood(BakedFood food) {
        foodOrders.add(food);
    }

    @Override
    public void orderDrink(Drink drink) {
        drinkOrders.add(drink);
    }

    @Override
    public double getBill() {
        double priceAllDrinks = this.drinkOrders.stream().mapToDouble(Drink::getPrice).sum();
        double priceAllFood = this.foodOrders.stream().mapToDouble(BakedFood::getPrice).sum();
        return priceAllDrinks + priceAllFood + this.getPrice();

    }

    @Override
    public void clear() {
        foodOrders.clear();
        drinkOrders.clear();
        setReserved(false);
        this.numberOfPeople = 0;
        this.price = 0;
    }

    @Override
    public String getFreeTableInfo() {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("Table: %d%n", getTableNumber()));
        builder.append(String.format("Type: %s%n", this.getClass().getSimpleName()));
        builder.append(String.format("Capacity: %d%n", getCapacity()));
        builder.append(String.format("Price per Person: %.2f", getPricePerPerson()));

        return builder.toString().trim();

    }
}
