package bankSafe;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

public class BankVaultTest {

    private BankVault bankVault;
    private Item item1;
    private Item item2;

    @Before
    public void set() {
        bankVault = new BankVault();
        item1 = new Item("Cold1", "abc");
        item2 = new Item("Cold2", "123");
    }


    @Test(expected = IllegalArgumentException.class)
    public void testAddItemWhenCellDoesNotExistThrowException() throws OperationNotSupportedException {

        bankVault.addItem("A5", item1);
    }


    @Test(expected = IllegalArgumentException.class)
    public void testAddItemWhenCellAlreadyExistThrowException() throws OperationNotSupportedException {
        bankVault.addItem("A1", item1);
        bankVault.addItem("A1", item2);

    }

    @Test(expected = OperationNotSupportedException.class)
    public void testAddItemWhenItemAlreadyExistThrowException() throws OperationNotSupportedException {
        bankVault.addItem("A1", item1);
        bankVault.addItem("A2", item1);
    }

    @Test
    public void testAddItemWhitCorrectCellAndItem() throws OperationNotSupportedException {
        String expected = "Item:abc saved successfully!";
        String actual = bankVault.addItem("A1", item1);
        Assert.assertEquals(expected, actual);
        Assert.assertTrue(bankVault.getVaultCells().containsValue(item1));
    }


    @Test(expected = IllegalArgumentException.class)
    public void testRemoveItemWhenCellDoesNotExistThrowException() {
        bankVault.removeItem("A5", item1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveItemWhenItemNotExist() {
        bankVault.removeItem("A5", item2);
    }

    @Test
    public void testRemoveItemWhitCorrectElement() throws OperationNotSupportedException {
        bankVault.addItem("A1", item1);
        String expected = "Remove item:abc successfully!";
        String actual = bankVault.removeItem("A1", item1);
        Assert.assertEquals(expected, actual);
        Assert.assertNull(bankVault.getVaultCells().get("A1"));

    }

    @Test
    public void testGetOwner() throws OperationNotSupportedException {
        bankVault.addItem("A1", item1);
        String owner = item1.getOwner();
        Assert.assertEquals("Cold1", owner);

    }

}
