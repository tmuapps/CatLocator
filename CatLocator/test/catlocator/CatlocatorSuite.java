/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package catlocator;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author red43
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({catlocator.CSVReaderTest.class, catlocator.SimpleHopperTest.class, catlocator.CatLocatorTest.class, catlocator.CleverHopperTest.class, catlocator.StationTest.class})
public class CatlocatorSuite {

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }
    
}
