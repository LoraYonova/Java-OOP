package bakery.core;

import bakery.common.enums.BakedFoodType;
import bakery.common.enums.DrinkType;
import bakery.common.enums.TableTYpe;
import bakery.core.interfaces.Controller;
import bakery.entities.bakedFoods.Bread;
import bakery.entities.bakedFoods.Cake;
import bakery.entities.bakedFoods.interfaces.BakedFood;
import bakery.entities.drinks.Tea;
import bakery.entities.drinks.Water;
import bakery.entities.drinks.interfaces.Drink;
import bakery.entities.tables.InsideTable;
import bakery.entities.tables.OutsideTable;
import bakery.entities.tables.interfaces.Table;
import bakery.repositories.interfaces.DrinkRepository;
import bakery.repositories.interfaces.FoodRepository;
import bakery.repositories.interfaces.TableRepository;

import java.util.List;
import java.util.stream.Collectors;

import static bakery.common.ExceptionMessages.FOOD_OR_DRINK_EXIST;
import static bakery.common.ExceptionMessages.TABLE_EXIST;
import static bakery.common.OutputMessages.*;


public class ControllerImpl implements Controller {
    private final FoodRepository<BakedFood> foodRepository;
    private final DrinkRepository<Drink> drinkRepository;
    private final TableRepository<Table> tableRepository;

    private BakedFood food;
    private Drink drink;
    private Table table;
    private double bill;



    public ControllerImpl(FoodRepository<BakedFood> foodRepository, DrinkRepository<Drink> drinkRepository, TableRepository<Table> tableRepository) {
        this.foodRepository = foodRepository;
        this.drinkRepository = drinkRepository;
        this.tableRepository = tableRepository;

    }


    @Override
    public String addFood(String type, String name, double price) {

        if (foodRepository.getByName(name) != null) {
            throw new IllegalArgumentException(String.format(FOOD_OR_DRINK_EXIST, type, name));
        }

        if (type.equals(BakedFoodType.Bread.name())) {
            food = new Bread(name, price);
        } else if (type.equals(BakedFoodType.Cake.name())) {
            food = new Cake(name, price);
        }
        foodRepository.add(food);

        return String.format(FOOD_ADDED, name, type);
    }

    @Override
    public String addDrink(String type, String name, int portion, String brand) {

        if ((drinkRepository.getByNameAndBrand(name, brand) != null)) {
            throw new IllegalArgumentException(String.format(FOOD_OR_DRINK_EXIST, type, name));
        }

        if (type.equals(DrinkType.Tea.name())) {
           drink = new Tea(name, portion, brand);

       } else if (type.equals(DrinkType.Water.name())) {
           drink = new Water(name, portion, brand);

       }

        drinkRepository.add(drink);
        return String.format(DRINK_ADDED, name, brand);
    }

    @Override
    public String addTable(String type, int tableNumber, int capacity) {
        if (tableRepository.getByNumber(tableNumber) != null) {
            throw new IllegalArgumentException(String.format(TABLE_EXIST, tableNumber));
        }

        if (type.equals(TableTYpe.InsideTable.name())) {
            table = new InsideTable(tableNumber, capacity);
        } else if (type.equals(TableTYpe.OutsideTable.name())) {
            table = new OutsideTable(tableNumber, capacity);
        }
            tableRepository.add(table);
        return String.format(TABLE_ADDED, tableNumber);
    }

    @Override
    public String reserveTable(int numberOfPeople) {
        table = this.tableRepository
                .getAll().stream().filter(table -> (!table.isReserved())
                        && (table.getCapacity() >= numberOfPeople))
                .findFirst().orElse(null);

        if (table == null) {
            return String.format(RESERVATION_NOT_POSSIBLE, numberOfPeople);
        }

        table.reserve(numberOfPeople);
        return String.format(TABLE_RESERVED, table.getTableNumber(), numberOfPeople);
    }

    @Override
    public String orderFood(int tableNumber, String foodName) {

        if (tableRepository.getByNumber(tableNumber) == null || !tableRepository.getByNumber(tableNumber).isReserved()) {
            return String.format(WRONG_TABLE_NUMBER, tableNumber);
        }

       food = foodRepository.getByName(foodName);

        if (food == null) {
            return String.format(NONE_EXISTENT_FOOD, foodName);
        }
        tableRepository.getByNumber(tableNumber).orderFood(foodRepository.getByName(foodName));

        return String.format(FOOD_ORDER_SUCCESSFUL, tableNumber, foodName);
    }

    @Override
    public String orderDrink(int tableNumber, String drinkName, String drinkBrand) {
        if (tableRepository.getByNumber(tableNumber) == null || !tableRepository.getByNumber(tableNumber).isReserved()) {
            return String.format(WRONG_TABLE_NUMBER, tableNumber);
        }

        drink = drinkRepository.getByNameAndBrand(drinkName, drinkBrand);

        if (drink == null) {
            return String.format(NON_EXISTENT_DRINK, drinkName, drinkBrand);
        }
        tableRepository.getByNumber(tableNumber).orderDrink(drinkRepository.getByNameAndBrand(drinkName,drinkBrand));

        return String.format(DRINK_ORDER_SUCCESSFUL, tableNumber, drinkName, drinkBrand);

    }

    @Override
    public String leaveTable(int tableNumber) {
        table = tableRepository.getByNumber(tableNumber);
        double bill = table.getBill();
        table.clear();
        this.bill += bill;
        return String.format(BILL, tableNumber, bill);
    }

    @Override
    public String getFreeTablesInfo() {
        StringBuilder message = new StringBuilder();
        List<String> collect = tableRepository.getAll()
                .stream().filter(t -> (!t.isReserved()))
                .map(Table::getFreeTableInfo)
                .collect(Collectors.toList());
        for (String s : collect) {
            message.append(s);
            message.append(System.lineSeparator());
        }

        return message.toString().trim();
    }

    @Override
    public String getTotalIncome() {

        return String.format(TOTAL_INCOME, this.bill);
    }
}
