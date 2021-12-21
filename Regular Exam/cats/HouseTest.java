package cats;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class HouseTest {
    private Cat cat1;
    private Cat cat2;
    private House house;


    @Before
    public void setUp() {
        cat1 = new Cat("Tommy");
        cat2 = new Cat("Tom");
        house = new House("Short", 2);

    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetCapacityWhenCapacityIsNegative() {
        house = new House("Long", -5);
    }

    @Test(expected = NullPointerException.class)
    public void testSetNameWhenNameIsNull() {
        house = new House(null, 10);
    }

    @Test(expected = NullPointerException.class)
    public void testSetNameWhenNameIsEmpty() {
        house = new House("    ", 10);
    }

    @Test
    public void testGetName() {
        Assert.assertEquals("Short", house.getName());
    }

    @Test
    public void testGetCapacity() {
        Assert.assertEquals(2, house.getCapacity());
    }

    @Test
    public void testGetCount() {
        house.addCat(cat1);
        Assert.assertEquals(1, house.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddCatWhenHouseIsFull() {
        house.addCat(cat1);
        house.addCat(cat2);
        house.addCat(new Cat("Jim"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void removeCatWhenCatNotExist() {
        String name = "Moni";
        house.removeCat(name);
        String expected = "Cat with name Moni doesn't exist!";
        String actual = String.format("Cat with name %s doesn't exist!", name);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testRemoveCatWhitCorrectData() {
        house.addCat(cat1);
        house.removeCat(cat1.getName());
        Assert.assertEquals("Tommy", cat1.getName());

    }

    @Test(expected = IllegalArgumentException.class)
    public void testCatForSaleWhenCatNotExist() {
        house.addCat(cat1);
        String expected = "Cat with name Tom doesn't exist!";
        String actual = String.format("Cat with name %s doesn't exist!", cat2.getName());
        house.catForSale(cat2.getName());
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testCatForSaleWhenCurrentData() {
        house.addCat(cat1);
        house.catForSale(cat1.getName());
        cat1.setHungry(false);
        Assert.assertFalse(cat1.isHungry());

    }

    @Test
    public void statistics() {
        house.addCat(cat1);
        house.addCat(cat2);
        String expected = "The cat Tommy, Tom is in the house Short!";
        Assert.assertEquals(expected, house.statistics());
    }


}
