package halfLife;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class PlayerTest {
    private Gun gun1;
    private Gun gun2;
    private Player player;

    @Before
    public void setUp() {
        this.gun1 = new Gun("Buffalo", 10);
        this.gun2 = new Gun("Makarov", 15);
        player = new Player("Atanas", 50);
    }

    @Test(expected = NullPointerException.class)
    public void testCtorWhenNameIsNullThrowException() {
        player = new Player(null, 10);
    }

    @Test(expected = NullPointerException.class)
    public void testCtorWhenNameIsEmptyThrowException() {
        player = new Player("    ", 10);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCtorWhenHealthIsThanLessZero() {
        player = new Player("Atanas", -1);
    }

    @Test(expected = NullPointerException.class)
    public void testAddGunWhenGunIsNullThrowException() {
        player.addGun(null);
    }

    @Test
    public void testAddGunWhitCorrectData() {
        player.addGun(gun1);
    }

    @Test
    public void testRemoveGun() {
        player.addGun(gun1);
        String name = gun1.getName();
        boolean b = player.removeGun(gun1);
        Assert.assertTrue(name, b);

    }

    @Test
    public void testGetGun() {
        player.addGun(gun1);
        Gun gun = player.getGun(gun1.getName());

        Assert.assertEquals("Buffalo", gun.getName());
    }

    @Test
    public void testGetUsername() {
        Assert.assertEquals("Atanas", player.getUsername());
    }

    @Test
    public void testGetHealth() {
        Assert.assertEquals(50, player.getHealth());
    }

    @Test
    public void testGetGuns() {
        player.addGun(gun1);
        player.addGun(gun2);

        Assert.assertEquals(2, player.getGuns().size());

    }

    @Test(expected = IllegalStateException.class)
    public void testTakeDamageWhenHealthIsZeroThrowException() {
       Player player1 = new Player("Atanas", 0);
        player1.takeDamage(10);
        Assert.assertEquals(0, player.getHealth());

    }

    @Test
    public void testTakeDamageWhenHealthSubtractDamageIsLessThanZero() {
        player.takeDamage(55);
        Assert.assertEquals(0, player.getHealth());
    }

    @Test
    public void testTakeDamage() {
        player.takeDamage(10);
        Assert.assertEquals(40, player.getHealth());
    }

    @Test
    public void testGetBullets() {
        player.addGun(gun1);
        Assert.assertEquals(10, gun1.getBullets());
    }
}
