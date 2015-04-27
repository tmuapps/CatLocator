/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package catlocator;

import catlocator.CSVReader.LineReadListener;
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
public class CSVReaderTest {
    
    public CSVReaderTest() {
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
     * Test of read method, of class CSVReader.
     */
    @Test
    public void testRead() throws Exception {
        System.out.println("read");
        String stationFileName = "";
        LineReadListener lineReadListener = null;
        CSVReader.read(stationFileName, lineReadListener);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
