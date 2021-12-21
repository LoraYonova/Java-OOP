package garage;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class GarageTest {
    private Car car1;
    private Car car2;
    private Car car3;
    private Garage garage;


    @Before
    public void setUp() {
        car1 = new Car("Opel", 150, 2000);
        car2 = new Car("Audi", 150, 3000);
        car3 = new Car("Opel", 180, 2500);
        garage = new Garage();

    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddCarWhenCarIsNull() {
        garage.addCar(null);
    }

    @Test
    public void testAddCar() {
        garage.addCar(car1);
    }

    @Test
    public void getTheMostExpensiveCar() {
        garage.addCar(car1);
        garage.addCar(car2);
        Assert.assertEquals(car2, garage.getTheMostExpensiveCar());
    }

    @Test
    public void getTheMostExpensiveCarWhenIsNull() {
        Assert.assertNull(null, garage.getTheMostExpensiveCar());
    }

    @Test
    public void findAllCarsByBrand() {
        garage.addCar(car1);
        garage.addCar(car2);
        garage.addCar(car3);
        List<Car> cars = new ArrayList<>();
        cars.add(car1);
        cars.add(car3);
        Assert.assertEquals(cars, garage.findAllCarsByBrand("Opel"));
    }

    @Test
    public void testFindAllCarsWithMaxSpeedAbove() {
        garage.addCar(car1);
        garage.addCar(car2);
        garage.addCar(car3);
        List<Car> cars = new ArrayList<>();
        cars.add(car3);
        Assert.assertEquals(cars, garage.findAllCarsWithMaxSpeedAbove(160));
    }

    @Test
    public void getCount() {
        garage.addCar(car1);
        garage.addCar(car2);
        Assert.assertEquals(2, garage.getCount());
    }
}
