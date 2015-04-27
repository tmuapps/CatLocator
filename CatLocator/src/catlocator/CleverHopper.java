/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package catlocator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Tim Millington
 */
public class CleverHopper extends SimpleHopper{

    //Remember which connections have been used from which stations
    private Map<Station, List<Station>> previousConnectionsFromStations = new HashMap<>();
    
    CleverHopper(Station initialStation) {
        super(initialStation);
        previousConnectionsFromStations.put(initialStation, new ArrayList<Station>());
    }
    
    @Override
    public void hop() {
        
        //Get a list of acceptable connections
        List<Station> acceptableConnections = currentStation.getOpenConnections();
        List<Station> previousConnections = previousConnectionsFromStations.get(this.currentStation);
        acceptableConnections.removeAll(previousConnections);
        
        //If there are no connections not already used, accept an already used one
        if (acceptableConnections.isEmpty()) {
            acceptableConnections = currentStation.getOpenConnections();
        }
        
        //Randomly select the station to hop to, and hop to it if there is one available
        Station nextStation = getNextStation(acceptableConnections);
        if (nextStation != null) {
            currentStation = nextStation;
            previousConnections.add(currentStation);
            previousConnectionsFromStations.put(currentStation, new ArrayList<Station>());
            hopCount++;
        }
        
    }
    
    
}
