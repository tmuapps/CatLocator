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
    
    CleverHopper(int id, Station initialStation) {
        super(id, initialStation);
        previousConnectionsFromStations.put(initialStation, new ArrayList<Station>());
    }
    
    /**
     * If possible, hops this hopper to another open station, without using a previously used connection
     * If the only available connections to other stations have already been used, use one.
     * If there are no available connection, stay put.
     */
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
