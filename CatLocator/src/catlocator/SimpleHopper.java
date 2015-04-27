/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package catlocator;

import java.util.List;
import java.util.Random;

/**
 *
 * @author Tim Millington
 */
public class SimpleHopper {
    
    static Random random = new Random();

    protected int hopCount = 0;
    protected Station currentStation;
    
    SimpleHopper(Station initialStation) {
        currentStation = initialStation;
    }
    
    public void hop() {
        
        Station nextStation = getNextStation(currentStation.getOpenConnections());
        if (nextStation != null) {
            currentStation = nextStation;
            hopCount++;
        }
        
    }
    
    static Station getNextStation(List<Station> stations) {
        if (stations == null || stations.isEmpty()) {
            return null;
        } else {
            return stations.get(random.nextInt(stations.size()));
        }
    }
    


}
