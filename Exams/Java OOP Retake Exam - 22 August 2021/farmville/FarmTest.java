package farmville;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class FarmTest {
    private List<Animal> animals;
    private Farm farm;
    private Animal animalHorse;
    private Animal animalPig;
    private Animal animalChicken;

    @Before
    public void set() {
        animalHorse = new Animal("Horse", 20);
        animalPig = new Animal("Pig", 15);
        animalChicken = new Animal("Chicken", 10);
        farm = new Farm("Farm", 2);

    }


    @Test(expected = NullPointerException.class)
    public void testConstructorWhenNameIsNull() {
        farm = new Farm(null, 5);
    }

    @Test(expected = NullPointerException.class)
    public void testConstructorWhenNameIsEmpty() {
        farm = new Farm("     ", 5);
    }

    @Test
    public void testConstructorWhenNameIsCorrect() {
        Assert.assertEquals("Farm", farm.getName());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorWhenCapacityIsLessThanZero() {
        farm = new Farm("Farm", -1);
    }

    @Test
    public void testConstructorWhenCapacityIsCorrect() {
        Assert.assertEquals(2, farm.getCapacity());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddWhenAnimalsSizeIsEqualToCapacityThrowException() {
        farm.add(animalHorse);
        farm.add(animalPig);
        farm.add(animalChicken);
    }

    @Test
    public void testAddAnimalInFarm() {
        farm.add(animalHorse);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddAnimalWhenThereIsAlreadyExistInFarm() {
        farm.add(animalHorse);
        farm.add(animalHorse);
    }

    @Test
    public void testRemoveAnimalFromFarm() {
        farm.add(animalHorse);
        Assert.assertEquals(true, farm.remove("Horse"));
    }

    @Test
    public void testCount() {
        farm.add(animalChicken);

        Assert.assertEquals(1, farm.getCount());
    }






}
