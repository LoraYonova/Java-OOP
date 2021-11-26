package rpg_lab;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DummyTest {
    private static final int HEALTH = 100;
    private static final int XP = 50;

    private Dummy dummy;
    private Dummy dearDummy;

    @Before
    public void setUp() {
        this.dummy = new Dummy(HEALTH, XP);
        this.dearDummy = new Dummy(0, XP);
    }

    @Test(expected = IllegalStateException.class)
    public void testDeadDummyThrowsWhenAttacked() {
        dearDummy.takeAttack(10);

    }

    @Test(expected = IllegalStateException.class)
    public void testAliveDummyThrowsWhenGivingXP() {
        dummy.giveExperience();
    }

    @Test
    public void testDummyLosesHealthWhenAttacked() {
        int attackPoint = 10;
        dummy.takeAttack(attackPoint);
        assertEquals(HEALTH - attackPoint, dummy.getHealth());
    }

    @Test
    public void testDeadDummyGivesXP() {
        int actual = dearDummy.giveExperience();
        assertEquals(XP, actual);
    }

}