/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package catlocator;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Tim Millington
 */
public class CSVReader {
    interface LineReadListener {
        public void onLineRead (String[] lineAsStringArray) throws Exception;
    }
    
    static void read (String stationFileName, LineReadListener lineReadListener) throws Exception {
	BufferedReader br = null;
	String line = "";
	String comma = ",";
 
        //Load stations
	try {
 
            br = new BufferedReader(new FileReader(stationFileName));
            while ((line = br.readLine()) != null) {

                // Split the line into a String array use comma as separator
                String[] stationFieldArray = line.split(comma);
                if (lineReadListener != null) {
                    lineReadListener.onLineRead(stationFieldArray);
                }

            }
 
	} catch (FileNotFoundException e) {
            throw new Exception("Problem processing csv",e);
	} catch (IOException e) {
            throw new Exception("Problem processing csv",e);
	} catch (Exception e) {
            throw new Exception("Problem processing csv",e);
	} finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    throw new Exception("Problem processing csv",e);
                }
            }
	}
    }
    
}
