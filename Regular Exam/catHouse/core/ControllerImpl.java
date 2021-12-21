package catHouse.core;

import catHouse.entities.cat.Cat;
import catHouse.entities.cat.LonghairCat;
import catHouse.entities.cat.ShorthairCat;
import catHouse.entities.houses.House;
import catHouse.entities.houses.LongHouse;
import catHouse.entities.houses.ShortHouse;
import catHouse.entities.toys.Ball;
import catHouse.entities.toys.Mouse;
import catHouse.entities.toys.Toy;
import catHouse.repositories.ToyRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;



import static catHouse.common.ConstantMessages.*;
import static catHouse.common.ExceptionMessages.*;

public class ControllerImpl implements Controller {
    private ToyRepository toys;
    private Collection<House> houses;
    private House house;
    private Toy toy;
    private Map<String, House> mapHouse;
    private Cat cat;


    public ControllerImpl() {
        this.toys = new ToyRepository();
        this.houses = new ArrayList<>();
        this.mapHouse = new HashMap<>();
    }

    @Override
    public String addHouse(String type, String name) {
        if (type.equals("LongHouse")) {
            house = new LongHouse(name);

        } else if (type.equals("ShortHouse")) {
            house = new ShortHouse(name);

        } else {
            throw new NullPointerException(INVALID_HOUSE_TYPE);
        }
        houses.add(house);

        mapHouse.put(type, house);

        return String.format(SUCCESSFULLY_ADDED_HOUSE_TYPE, type);
    }

    @Override
    public String buyToy(String type) {
        if (type.equals("Ball")) {
            toy = new Ball();
        } else if (type.equals("Mouse")) {
            toy = new Mouse();
        } else {
            throw new IllegalArgumentException(INVALID_TOY_TYPE);
        }

        toys.buyToy(toy);

        return String.format(SUCCESSFULLY_ADDED_TOY_TYPE, type);
    }

    @Override
    public String toyForHouse(String houseName, String toyType) {
        Toy toysFirst = toys.findFirst(toyType);

        if (toysFirst == null) {
            throw new IllegalArgumentException(String.format(NO_TOY_FOUND, toyType));
        }

        toys.removeToy(toysFirst);
        House house = houses.stream().filter(h -> h.getName().equals(houseName)).findFirst().get();
        house.buyToy(toysFirst);

        return String.format(SUCCESSFULLY_ADDED_TOY_IN_HOUSE, toyType, houseName);
    }

    @Override
    public String addCat(String houseName, String catType, String catName, String catBreed, double price) {
        if (catType.equals("ShorthairCat")) {
            cat = new ShorthairCat(catName, catBreed, price);

        } else if (catType.equals("LonghairCat")) {
            cat = new LonghairCat(catName, catBreed, price);

        } else {
            throw new IllegalArgumentException(INVALID_CAT_TYPE);
        }


        House house = mapHouse.values().stream().filter(n -> n.getName().equals(houseName)).findFirst().get();
        String name = house.getClass().getSimpleName();

        String substring = name.substring(0, 4);
        String catsType = catType.substring(0, 4);

        if (!substring.equals(catsType)) {
            return UNSUITABLE_HOUSE;
        }
        House house1 = houses.stream().filter(h -> h.getName().equals(houseName)).findFirst().get();
        house1.addCat(cat);

        return String.format(SUCCESSFULLY_ADDED_CAT_IN_HOUSE, catType, houseName);
    }

    @Override
    public String feedingCat(String houseName) {
        House house = houses.stream().filter(n -> n.getName().equals(houseName)).findFirst().get();
        house.feeding();
        return String.format(FEEDING_CAT, house.getCats().size());
    }

    @Override
    public String sumOfAll(String houseName) {
        House house1 = houses.stream().filter(n -> n.getName().equals(houseName)).findFirst().get();

        double sumCat = house1.getCats().stream().mapToDouble(Cat::getPrice).sum();
        double sumToy = house1.getToys().stream().mapToDouble(Toy::getPrice).sum();
        return String.format(VALUE_HOUSE, houseName, sumCat + sumToy);
    }

    @Override
    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        for (House house1 : houses) {
           sb.append(house1.getStatistics());
           sb.append(System.lineSeparator());
        }

        return sb.toString().trim();
    }
}
