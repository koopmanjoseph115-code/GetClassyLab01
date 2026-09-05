import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ProductTest {

    Product pr1, pr2, pr3, pr4, pr5, pr6;

    @BeforeEach
    void setUp()
    {
        pr1 = new Product("000001", "Coke", "Cola", 1.50);
        pr2= new Product("000002", "Pepsi", "Cola", 1.50);
        Product.setIDSeed(0);
        pr3= new Product("000003", "Lays", "Chips", 1.00);
        pr4 = new Product( "000004", "Doritos", "Chips", 1.10);
        pr5 = new Product( "000005", "Goldfish", "Crackers", 0.50);
        pr6 = new Product( "000006", "LaCroix", "SparkingWater", 0.50);


    }

    @Test
    /** tests the seed generator after 4 calls, should be 4*/
    void getIDSeed() {
        assertEquals(4, Product.getIDSeed());
    }

    /** Test the constructor with the first instance  p1 */

    @Test
    void getID() {
        assertEquals("000001", pr1.getID());
    }
    @Test
    void getName() {
        assertEquals("Coke", pr1.getName());
    }

    @Test
    void getDescription() {
        assertEquals("Cola", pr1.getDescription());
    }


    @Test
    void getCost() {
        assertEquals(1.50, pr1.getCost(), 0.001);
    }

    /** now we go though all the setters and change P1 to P2 oo we can test the equals with P1 and P2 */
    @Test
    void setID() {
        pr1.setID("000001");
        assertEquals("000001", pr1.getID());
    }

    @Test
    void setName() {
        pr1.setName("Pepsi");
        assertEquals("Pepsi", pr1.getName());
    }

    @Test
    void setDescription() {
        pr1.setDescription("Cola");
        assertEquals("Cola", pr1.getDescription());
    }

    @Test
    void setCost() {
        pr1.setCost(1.50);
        assertEquals(1.50, pr1.getCost(), 0.001);
    }

    @Test
    void equals() {
        pr1.setID("000002");
        pr1.setName("Pepsi");
        pr1.setDescription("Cola");
        pr1.setCost(1.50);
        assertEquals(true, pr1.equals(pr2));
    }

}
