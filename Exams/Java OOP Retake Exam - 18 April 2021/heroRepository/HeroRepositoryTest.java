package heroRepository;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class HeroRepositoryTest {

    private Hero hero1;
    private Hero hero2;
    private HeroRepository heroRepository;

    @Before
    public void set() {
        heroRepository = new HeroRepository();
        hero1 = new Hero("Hero", 2);
        hero2 = new Hero("Hulk", 5);

    }

    @Test(expected = NullPointerException.class)
    public void testCreateHeroWhenNameIsNullThrowException() {
        heroRepository.create(null);

    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreateWhenHeroNameAlreadyExistThrowException() {
        heroRepository.create(hero1);
        heroRepository.create(hero1);
    }

    @Test
    public void testCreateCorrectHeroName() {
        heroRepository.create(hero1);

        String expected = "Successfully added hero Hero with level 2";
        String actual = String.format("Successfully added hero %s with level %d", hero1.getName(), hero1.getLevel());
        Assert.assertEquals(expected, actual);

    }

    @Test(expected = NullPointerException.class)
    public void testRemoveWhenNameIsNullThrowException() {
        heroRepository.remove(null);
    }

    @Test(expected = NullPointerException.class)
    public void testRemoveWhenNameIsEmptyThrowException() {
        heroRepository.remove("     ");
    }

    @Test
    public void testRemoveWhitCurrentName() {
        heroRepository.create(hero1);
        heroRepository.remove("Hero");

    }

    @Test
    public void testGetHeroWithHighestLevel() {
        heroRepository.create(hero1);
        heroRepository.create(hero2);
        Hero level = heroRepository.getHeroWithHighestLevel();
        Assert.assertEquals(5, level.getLevel());

    }

    @Test
    public void testGetHeroWhitName() {
        heroRepository.create(hero1);
       String expected = "Hero";
        Hero hero = heroRepository.getHero(hero1.getName());
        Assert.assertEquals(expected, hero.getName());
    }

    @Test
    public void testGetCountOfHeroes() {
        heroRepository.create(hero1);
        heroRepository.create(hero2);
        Assert.assertEquals(2, heroRepository.getCount());
    }

}
