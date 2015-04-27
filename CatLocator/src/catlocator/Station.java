/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package catlocator;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author Tim Millington
 */
public class Station {
    
    private final int id; 
    private final String name;
    private boolean isOpen = true;
    
    //List allows easier random selection
    private List<Station> openConnections = new ArrayList<>();
    private Set<Station> closedConnections = new HashSet<>();
    
    /*
     * Basic constuctor
     */
    public Station (int id, String name) {
        this.id = id; 
        this.name = name;
    }

    /*
     * Construct from array of String
     * Used to contruct and object from a line in the defined csv line
     * Expects 2 elements in the fields array, with fields[0] as the station id (integer)
     * and fields[1] as the station name (String)
     */
    public Station (String[] fields) throws Exception {
        if (fields.length != 2) {
            throw new Exception("Cannot construct Station from csv line");
        }
        this.id = Integer.parseInt(fields[0]); 
        this.name = fields[1];
    }
    
    public void addConnection(Station connection) {
        openConnections.add(connection);
    }

    public void closeConnection(Station connection) {
        if (openConnections.contains(connection)) {
            openConnections.remove(connection);
            closedConnections.add(connection);
        }
    }

    public List<Station> getOpenConnections() {
        return new ArrayList<>(openConnections);
    }
    
    public int getId() {
        return id;
    }

    public void close() {
        isOpen = false;
        //Remove this station from the connections at stations it is connected to. 
        for (Station station:openConnections) {
            station.closeConnection(this);
        }
        //Even if the connection out is closed, we still have to close the return connection
        for (Station station:closedConnections) {
            station.closeConnection(this);
        }
    }

    public boolean isOpen() {
        return isOpen;
    }

    public String getName() {
        return name;
    }
    
    @Override
    public String toString() {
        return "Station:" + id + " - " + name;
    }
    
    
}
