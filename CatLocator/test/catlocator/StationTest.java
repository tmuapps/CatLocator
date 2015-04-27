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
public class StationTest {
    
    public StationTest() {
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
     * Test of addConnection method, of class Station.
     */
    @Test
    public void testAddConnection() {
        System.out.println("addConnection");
        Station connection = null;
        Station instance = null;
        instance.addConnection(connection);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of closeConnection method, of class Station.
     */
    @Test
    public void testCloseConnection() {
        System.out.println("closeConnection");
        Station connection = null;
        Station instance = null;
        instance.closeConnection(connection);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getOpenConnections method, of class Station.
     */
    @Test
    public void testGetOpenConnections() {
        System.out.println("getOpenConnections");
        Station instance = null;
        List expResult = null;
        List result = instance.getOpenConnections();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getId method, of class Station.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        Station instance = null;
        int expResult = 0;
        int result = instance.getId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of close method, of class Station.
     */
    @Test
    public void testClose() {
        System.out.println("close");
        Station instance = null;
        instance.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isOpen method, of class Station.
     */
    @Test
    public void testIsOpen() {
        System.out.println("isOpen");
        Station instance = null;
        boolean expResult = false;
        boolean result = instance.isOpen();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getName method, of class Station.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        Station instance = null;
        String expResult = "";
        String result = instance.getName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Station.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Station instance = null;
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
