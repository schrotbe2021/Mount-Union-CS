/*
    Ben Schroth
    PA5 - Dr. Weber CSC 220
    12/7/2018
    ClothingItem JUnit test
*/
package clothing;

import javafx.scene.paint.Color;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class ClothingStackTest {
    
    public ClothingStackTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of push method, of class ClothingStack.
     */
    @org.junit.Test
    public void testPush() {
        System.out.println("\npush");
        ClothingItem item = new ClothingItem("Shirt", Color.BLUE, true);
        ClothingStack instance = new ClothingStack();
        instance.push(item);
        System.out.println(item.toString());
        assertEquals(item, instance.peek());
    }

    /**
     * Test of pop method, of class ClothingStack.
     */
    @org.junit.Test
    public void testPop() {
        System.out.println("\npop");
        ClothingStack instance = new ClothingStack();
        ClothingItem expResult = new ClothingItem("Shirt", Color.BLUE, true);
        instance.push(expResult);
        ClothingItem result = instance.pop();
        System.out.println(expResult.toString());
        System.out.println(result.toString());
        assertEquals(expResult, result);
    }

    /**
     * Test of peek method, of class ClothingStack.
     */
    @org.junit.Test
    public void testPeek() {
        System.out.println("\npeek");
        ClothingStack instance = new ClothingStack();
        ClothingItem expResult = new ClothingItem("Shirt", Color.BLUE, true);
        instance.push(expResult);
        ClothingItem result = instance.peek();
        System.out.println(expResult.toString() + expResult.getColor());
        System.out.println(result.toString() + result.getColor());
        assertEquals(expResult, result);
    }

    /**
     * Test of hasNext method, of class ClothingStack.
     */
    @org.junit.Test
    public void testHasNext() {
        System.out.println("\nhasNext");
        ClothingStack instance = new ClothingStack();
        ClothingItem head = new ClothingItem("Shirt", Color.BLUE, true);
        ClothingItem next = new ClothingItem("Sweatshirt", Color.RED, false);
        instance.push(next);
        instance.push(head);
        boolean expResult = true;
        boolean result = instance.hasNext();
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class ClothingStack.
     */
    @org.junit.Test
    public void testToString() {
        System.out.println("\ntoString");
        ClothingStack instance = new ClothingStack();
        ClothingItem item = new ClothingItem("Shirt", Color.BLUE, true);
        instance.push(item);
        String expResult = item.toString();
        String result = instance.toString();
        System.out.println(item.toString());
        System.out.println(instance.toString());
        assertEquals(expResult, result);
    }

    /**
     * Test of itemsOfColor method, of class ClothingStack.
     */
    @org.junit.Test
    public void testItemsOfColor() {
        System.out.println("\nitemsOfColor");
        Color color = Color.RED;
        ClothingStack instance = new ClothingStack();
        ClothingItem item = new ClothingItem("Shirt", Color.RED, true);
        instance.push(item);
        ClothingItem[] expResult = {item};
        ClothingItem[] result = instance.itemsOfColor(color);
        System.out.println("is this working");
        assertArrayEquals(expResult, result);
    }

    /**
     * Test of numberOfItemsWashableAtHighTemperature method, of class ClothingStack.
     */
    @org.junit.Test
    public void testNumberOfItemsWashableAtHighTemperature() {
        System.out.println("\nnumberOfItemsWashableAtHighTemperature");
        ClothingStack instance = new ClothingStack();
        ClothingItem item = new ClothingItem("Shirt", Color.BLUE, true);
        instance.push(item);
        int expResult = 1;
        int result = instance.numberOfItemsWashableAtHighTemperature();
        assertEquals(expResult, result);
    }
    
} // end of JUnit testing
