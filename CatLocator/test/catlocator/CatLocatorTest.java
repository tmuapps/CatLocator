/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package catlocator;

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
public class CatLocatorTest {
    
    public CatLocatorTest() {
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
     * Test of main method, of class CatLocator.
     */
    @Test
    public void testMain() throws Exception {
        System.out.println("main");
        String[] args = null;
        CatLocator.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of loseCats method, of class CatLocator.
     */
    @Test
    public void testLoseCats() {
        System.out.println("loseCats");
        int numberOfCatOwnerPairs = 0;
        CatLocator instance = null;
        instance.loseCats(numberOfCatOwnerPairs);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findCats method, of class CatLocator.
     */
    @Test
    public void testFindCats() {
        System.out.println("findCats");
        int maxSteps = 0;
        CatLocator instance = null;
        instance.findCats(maxSteps);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of showResults method, of class CatLocator.
     */
    @Test
    public void testShowResults() {
        System.out.println("showResults");
        CatLocator instance = null;
        instance.showResults();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
