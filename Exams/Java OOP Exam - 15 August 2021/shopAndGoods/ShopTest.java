package shopAndGoods;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;


public class ShopTest {
    private Shop shop;
    private Goods goods1;
    private Goods goods2;


    @Before
    public void set() {
        shop = new Shop();
        goods1 = new Goods("Banana", "123ab");
        goods2 = new Goods("Bread", "123ba");

    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddGoodsWhenDoesNotContainsKeyThrowException() throws OperationNotSupportedException {
        shop.addGoods("Shelves13", goods1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddGoodsWhenShelvesIsNotNull() throws OperationNotSupportedException {
       shop.addGoods("Shelves1", goods1);
       shop.addGoods("Shelves1", goods2);

    }

    @Test(expected = OperationNotSupportedException.class)
    public void testAddGoodsWhenItemExist() throws OperationNotSupportedException {
        shop.addGoods("Shelves1", goods1);
        shop.addGoods("Shelves2", goods1);
    }

    @Test
    public void testAddGoodsWhenIsSuccessful() throws OperationNotSupportedException {
        String expected = "Goods: 123ab is placed successfully!";
        String actual =  shop.addGoods("Shelves1", goods1);
        Assert.assertEquals(expected, actual);
        Assert.assertEquals(goods1, shop.getShelves().get("Shelves1"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveGoodsWhenShelveDoesNotExist() {
        shop.removeGoods("Shelves", goods1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveGoodsWhenGoodsDoesNotExist() throws OperationNotSupportedException {
        shop.addGoods("Shelves1", goods2);
        shop.removeGoods("Shelves1", goods1);
    }

    @Test
    public void testRemoveGoodsWithTheCorrectData() throws OperationNotSupportedException {
        shop.addGoods("Shelves1", goods1);
        shop.removeGoods("Shelves1", goods1);
    }

    @Test
    public void testRemoveGoodsWhenIsSuccessful() throws OperationNotSupportedException {
        shop.addGoods("Shelves1", goods1);
        String actual =  this.shop.removeGoods("Shelves1", goods1);
        String expected = "Goods: 123ab is removed successfully!";
        Assert.assertEquals(expected,actual);
        Assert.assertNull(null, shop.getShelves().get("Shelves1"));
    }
}

