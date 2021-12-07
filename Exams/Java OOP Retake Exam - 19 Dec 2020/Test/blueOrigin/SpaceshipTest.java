package blueOrigin;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SpaceshipTest {

    private Astronaut astronaut1;
    private Astronaut astronaut2;
    private Spaceship spaceship;


    @Before
    public void setUp() {
        this.astronaut1 = new Astronaut("Jack", 40);
        this.astronaut2 = new Astronaut("Jake", 30);
        this.spaceship = new Spaceship("SS", 2);
    }

    @Test(expected = NullPointerException.class)
    public void testCtorWhenNameIsNullThrowException() {
        spaceship = new Spaceship(null, 10);
    }

    @Test(expected = NullPointerException.class)
    public void testCtorWhenNameIsEmptyThrowException() {
        spaceship = new Spaceship("     ", 10);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCtorWhenCapacityIsThanLessZero() {
        spaceship = new Spaceship("SS", -1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddAstronautWhenIsEqualToTheCapacityThrowException() {
        spaceship.add(astronaut1);
        spaceship.add(astronaut2);
        spaceship.add(new Astronaut("Liam", 10));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddAstronautWhenAlreadyExistThrowException() {
        Astronaut astronaut = new Astronaut("Jack", 20);
        spaceship.add(astronaut1);
        spaceship.add(astronaut);
        String expected = "Astronaut Jack is already in!";
        Assert.assertEquals(expected, astronaut.getName());

    }

    @Test
    public void testAddAstronautWhitCorrectData() {
        spaceship.add(astronaut1);
    }

    @Test
    public void testRemoveAstronautWhenExist() {
        spaceship.add(astronaut1);
        boolean remove = spaceship.remove(astronaut1.getName());
        Assert.assertTrue("true", remove);
    }

    @Test
    public void testRemoveAstronautWhenNotExist() {
        spaceship.add(astronaut1);
        boolean remove = spaceship.remove(astronaut2.getName());

        Assert.assertFalse("false", remove);
    }

    @Test
    public void testGetCount() {
        spaceship.add(astronaut1);
        spaceship.add(astronaut2);
        Assert.assertEquals(2, spaceship.getCount());
    }

    @Test
    public void testGetCapacity() {
        Assert.assertEquals(2, spaceship.getCapacity());
    }

    @Test
    public void testGetName() {
        Assert.assertEquals("SS", spaceship.getName());
    }




}
