package christmasRaces.core;

import christmasRaces.core.interfaces.Controller;
import christmasRaces.entities.cars.Car;
import christmasRaces.entities.cars.MuscleCar;
import christmasRaces.entities.cars.SportsCar;
import christmasRaces.entities.drivers.Driver;
import christmasRaces.entities.drivers.DriverImpl;
import christmasRaces.entities.races.Race;

import christmasRaces.entities.races.RaceImpl;
import christmasRaces.repositories.interfaces.Repository;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;


import static christmasRaces.common.ExceptionMessages.*;
import static christmasRaces.common.OutputMessages.*;

public class ControllerImpl implements Controller {
    private Repository<Car> carRepository;
    private Repository<Driver> driverRepository;
    private Repository<Race> raceRepository;
    private Race race;

    public ControllerImpl(Repository<Driver> driverRepository, Repository<Car> carRepository, Repository<Race> raceRepository) {
        this.carRepository = carRepository;
        this.driverRepository = driverRepository;
        this.raceRepository = raceRepository;
    }

    @Override
    public String createDriver(String driver) {
        Driver name = driverRepository.getByName(driver);

        if (name != null) {
            throw new IllegalArgumentException(String.format(DRIVER_EXISTS, driver));
        }

        DriverImpl driver1 = new DriverImpl(driver);
        driverRepository.add(driver1);
        return String.format(DRIVER_CREATED, driver);
    }

    @Override
    public String createCar(String type, String model, int horsePower) {
        Car car = null;
        if (type.equals("Muscle")) {
            car = new MuscleCar(model, horsePower);

        } else if (type.equals("Sports")) {
            car = new SportsCar(model, horsePower);
        }
        Car name = carRepository.getByName(model);
        if (name != null) {
            throw new IllegalArgumentException(String.format(CAR_EXISTS, model));
        }

        carRepository.add(car);

        return String.format(CAR_CREATED, car.getClass().getSimpleName(), model);
    }

    @Override
    public String addCarToDriver(String driverName, String carModel) {
        Driver name = driverRepository.getByName(driverName);
        if (name == null) {
            throw new IllegalArgumentException(String.format(DRIVER_NOT_FOUND, driverName));
        }

        Car carName = carRepository.getByName(carModel);
        if (carName == null) {
            throw new IllegalArgumentException(String.format(CAR_NOT_FOUND, carModel));
        }

        name.addCar(carName);

        return String.format(CAR_ADDED, driverName, carModel);
    }

    @Override
    public String addDriverToRace(String raceName, String driverName) {
        Race name = raceRepository.getByName(raceName);
        if (name == null) {
            throw new IllegalArgumentException(String.format(RACE_NOT_FOUND, raceName));
        }
        Driver name1 = driverRepository.getByName(driverName);
        if (name1 == null) {
            throw new IllegalArgumentException(String.format(DRIVER_NOT_FOUND, driverName));
        }

        name.addDriver(name1);

        return String.format(DRIVER_ADDED, driverName, raceName);
    }

    @Override
    public String startRace(String raceName) {
        Race name = raceRepository.getByName(raceName);
        if (name == null) {
            throw new IllegalArgumentException(String.format(RACE_NOT_FOUND, raceName));
        }

        Collection<Driver> all = driverRepository.getAll();
        if (all.size() < 3) {
            throw new IllegalArgumentException(String.format(RACE_INVALID, raceName, 3));
        }

        Map<Double, String> allWins = new HashMap<>();
        for (Driver driver : all) {
            driver.winRace();
            double points = driver.getCar().calculateRacePoints(name.getLaps());
            allWins.put(points, driver.getName());

        }

        Map<Double, String> newMapSortedByKey = allWins.entrySet().stream()
                .sorted(Map.Entry.<Double, String>comparingByKey().reversed())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));


        List<String> firstThreeWinners = new ArrayList<>();
        for (Map.Entry<Double, String> entry : newMapSortedByKey.entrySet()) {
            if (firstThreeWinners.size() >= 3) {
                break;
            }
            firstThreeWinners.add(entry.getValue());
        }


        StringBuilder out = new StringBuilder();
        out.append(String.format(DRIVER_FIRST_POSITION, firstThreeWinners.get(0), raceName));
        out.append(System.lineSeparator());
        out.append(String.format(DRIVER_SECOND_POSITION, firstThreeWinners.get(1), raceName));
        out.append(System.lineSeparator());
        out.append(String.format(DRIVER_THIRD_POSITION, firstThreeWinners.get(2), raceName));


        return out.toString().trim();
    }

    @Override
    public String createRace(String name, int laps) {
        Race byName = raceRepository.getByName(name);
        if (byName != null) {
            throw new IllegalArgumentException(String.format(RACE_EXISTS, name));
        }
        race = new RaceImpl(name, laps);
        raceRepository.add(race);
        return String.format(RACE_CREATED, name);
    }
}
