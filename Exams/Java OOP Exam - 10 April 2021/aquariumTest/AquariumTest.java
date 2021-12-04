package aquarium;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class AquariumTest {

    private Aquarium aquarium;
    private Fish f;
    private Fish f1;
    private Fish f2;

    @Before
    public void set() {
        aquarium = new Aquarium("aqua", 10);
        f = new Fish("name");
        f1 = new Fish("name1");
        f2 = new Fish("name2");
    }

    @Test(expected = NullPointerException.class)
    public void testNameWhenIsNullThrowException() {
        aquarium = new Aquarium(null, 2);
    }

    @Test(expected = NullPointerException.class)
    public void testNameWhenIsEmpty() {
        aquarium = new Aquarium("      ", 5);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCapacityWhenIsLessThanZeroThrowException() {
        aquarium = new Aquarium("Saltwater", -1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddWhenAquariumIsFullThrowException() {
        Aquarium aquarium1 = new Aquarium("name", 2);
        aquarium1.add(f);
        aquarium1.add(f1);
        aquarium1.add(f2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveWhenFishDoNotExistThrowException() {
        aquarium.add(f);
        aquarium.remove("name1");

    }

    @Test
    public void testRemoveWhitCurrentFishName() {
        aquarium.add(f);
        String name = f.getName();
        aquarium.remove(name);
        Assert.assertEquals("name", name);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSellFishWhenFishDoesNotExistThrowException() {
        aquarium.sellFish(null);
    }


    @Test
    public void testSellFishWhitCurrentFishName() {
        aquarium.add(f);
        aquarium.sellFish(f.getName());
        Assert.assertFalse(f.isAvailable());

    }

    @Test
    public void testReport() {
        aquarium.add(f);
        aquarium.add(f1);
        String expected = "Fish available at aqua: name, name1";

        Assert.assertEquals(expected, aquarium.report());

    }

    @Test
    public void testGetCountTheSizeOfTheFish() {
        aquarium.add(f);
        aquarium.add(f1);
        int expected = 2;
        Assert.assertEquals(expected, aquarium.getCount());
    }

    @Test
    public void testCapacity() {
        Aquarium aquarium1 = new Aquarium("name", 2);
        aquarium1.add(f1);
        aquarium1.add(f2);
        Assert.assertEquals(2, aquarium1.getCapacity());
    }
}
