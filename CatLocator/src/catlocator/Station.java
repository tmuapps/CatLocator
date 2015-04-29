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
    
    /**
     * A Station can have 0 or more connections to other stations.
     * Connections to open stations can be used by Hopper objects to hop between 
     * Stations
     * 
     * @param id    The station id
     * @param name  The station name
     */
    public Station (int id, String name) {
        this.id = id; 
        this.name = name;
    }

    /**
     *
     * Construct from array of String
     * Used to construct and object from a line in the defined csv line
     * Expects 2 elements in the fields array, with fields[0] as the station id (integer)
     * and fields[1] as the station name (String)
     * @param fields
     * @throws Exception
     */
    public Station (String[] fields) throws Exception {
        if (fields.length != 2) {
            throw new Exception("Cannot construct Station from csv line");
        }
        this.id = Integer.parseInt(fields[0]); 
        this.name = fields[1];
    }
    
    /**
     * Adds a connection to another Station.
     * 
     * @param connection The station to which the connection relates
     */
    public void addConnection(Station connection) {
        if (connection.isOpen()) {
            openConnections.add(connection);
        } else {
            closedConnections.add(connection);
        }
    }

    /**
     * Closes a connection to another station.
     * If closed, the connection is retained to allow this station to "inform"
     * stations it has connections to of it's closure.
     * 
     * @param connection The station to which the connection should be closed
     */
    public void closeConnection(Station connection) {
        if (openConnections.contains(connection)) {
            openConnections.remove(connection);
            closedConnections.add(connection);
        }
    }

    /**
     *
     * @return A copy of the open connections list.
     */
    public List<Station> getOpenConnections() {
        return new ArrayList<>(openConnections);
    }
    
    /**
     * Return this Station's id
     * 
     * @return This Station's id
     */
    public int getId() {
        return id;
    }

    /**
     *
     */
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

    /**
     *
     * @return
     */
    public boolean isOpen() {
        return isOpen;
    }

    /**
     *
     * @return
     */
    public String getName() {
        return name;
    }
    
    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return "Station:" + id + " - " + name;
    }
    
    
}
