/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package catlocator;

import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author red43
 */
public class SimpleHopperTest {
    
    public SimpleHopperTest() {
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
     * Test of hop method, of class SimpleHopper.
     */
    @Test
    public void testHop() {
        System.out.println("hop");
        SimpleHopper instance = null;
        instance.hop();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNextStation method, of class SimpleHopper.
     */
    @Test
    public void testGetNextStation() {
        System.out.println("getNextStation");
        List<Station> stations = null;
        Station expResult = null;
        Station result = SimpleHopper.getNextStation(stations);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
