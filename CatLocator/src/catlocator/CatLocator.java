/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package catlocator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Tim Millington
 */
public class CatLocator {

    public static final int MAX_STEPS = 100000;
    
    //All the stations in the network. Using the map ensures uniqueness of station Id
    //and allows station look-up from it's id
    private Map<Integer,Station> stations = new HashMap<>();
    
    //Map cats to owners, which can be lost or together.
    private Map<SimpleHopper,CleverHopper> catOwnerPairsLost = new HashMap<>();
    private Map<SimpleHopper,CleverHopper> catOwnerPairsTogether = new HashMap<>();
    
    /**
     * @param args the command line arguments
     * We expect strings to represent:
     *  An integer number of cat/owner pairs to create and lose
     *  The file name of the stations csv
     *  The file name of the connections csv
     */
    public static void main(String[] args) throws Exception {
        // Check we have 3 parameters
        if (args.length == 3) {
            
            int numberOfCatOwnerPairs = 0;
            try {
                numberOfCatOwnerPairs = Integer.parseInt(args[0]);
            } catch (NumberFormatException e) {
            }
            if (numberOfCatOwnerPairs > 0) {
                //We have a positive integer number of cat/owner pairs
                String stationFileName = args[1];
                String connectionFileName = args[2];

                //Construct the catLocator class
                CatLocator catLocator = new CatLocator(stationFileName, connectionFileName);
                catLocator.loseCats(numberOfCatOwnerPairs);
                catLocator.findCats(MAX_STEPS);
                catLocator.showResults();
            } else {
                throw new Exception("Invalid number of Cat / Owner pairs: " + args[0]
                        + "\n - Please specify a positive integer");
            }
        } else {
            throw new Exception("Please specify command line parameters:"
                    + "\n - (int) Number of Cat / Owner pairs"
                    + "\n - Stations File Name"
                    + "\n - Connections File Name"
            );
        }
    }
    
    CatLocator (String stationFileName, String connectionFileName) throws Exception{

        //Load the Stations file
        CSVReader.read(stationFileName, new CSVReader.LineReadListener() {

            @Override
            public void onLineRead(String[] stationFieldArray) throws Exception {
                try {
                    Station newStation = new Station(stationFieldArray);
                    stations.put(newStation.getId(),newStation);
                } catch (Exception e) {
                    throw new Exception("Problem creating station: ",e);
                }
            }

        });

        //Load the Connections file
        CSVReader.read(connectionFileName, new CSVReader.LineReadListener(){

            @Override
            public void onLineRead(String[] connectionFieldArray) throws Exception {
                try {
                    int stationAId = Integer.parseInt(connectionFieldArray[0]);
                    int stationBId = Integer.parseInt(connectionFieldArray[1]);
                    Station stationA = stations.get(stationAId);
                    Station stationB = stations.get(stationBId);
                    if (stationA != null && stationB != null) {
                        //Assume connections are two way
                        stationA.addConnection(stationB);
                        stationB.addConnection(stationA);
                    }
                } catch (Exception e) {
                    throw new Exception("Problem creating connection",e);
                }
            }
            
        });
        
    }
    
    public void loseCats(int numberOfCatOwnerPairs) {
        
        List<Station> allStations = new ArrayList<>((stations.values()));
        for (int i = 0; i<numberOfCatOwnerPairs; i++) {
            //Get the initial station for the new cat
            Station catInitialStation = SimpleHopper.getNextStation(allStations);
            
            //Instantiate a cat, placing it at the new station
            SimpleHopper cat = new SimpleHopper(catInitialStation);
            
            //Get the initial station for the cat's owner
            Station ownerInitialStation = SimpleHopper.getNextStation(allStations);
            
            //Make sure the owner station is different to the cat's
            //Keep trying stations until the owner an cat are at different stations
            //Note that this will loop if there is only one station!
            //We assume there a at least several stations.
            while (ownerInitialStation == catInitialStation) {
                ownerInitialStation = SimpleHopper.getNextStation(allStations);
            }

            //Instantiate the cat's owner, placing it at the new station
            CleverHopper owner = new CleverHopper(ownerInitialStation);
            
            //Store the cat owner pairs in the lost list.
            catOwnerPairsLost.put(cat, owner);
        }
        
    }
    
    public void findCats(int maxSteps) {
        
        //Limit the number of hops; otherwise, while there are still lost cats 
        for (int i = 0; i<MAX_STEPS && !catOwnerPairsLost.isEmpty(); i++) {
            
            //For every cat/owner pair that are in the lost list
            Iterator<Map.Entry<SimpleHopper,CleverHopper>> it = catOwnerPairsLost.entrySet().iterator();
            while (it.hasNext()) {
                
                Map.Entry<SimpleHopper,CleverHopper> pair = it.next();
                SimpleHopper cat = pair.getKey();
                CleverHopper owner = pair.getValue();
                
                //Make cat and owner hop.
                cat.hop();
                owner.hop();
                //See which cats have been found
                if (cat.currentStation == owner.currentStation) {
                    //Owner finds cat!!!
                    //Remove from the lost list
                    it.remove();
                    //Add to the together list
                    catOwnerPairsTogether.put(cat, owner);
                    //Close the station (immediately?)
                    owner.currentStation.close();
                }
                
            }
        }
             
    }
    
    public void showResults() {
        //Total number of stations: 
        System.out.println("Total number of stations: " + (stations.size()));

        //Total number of cats: 
        System.out.println("Total number of cats: " + (catOwnerPairsLost.size() + catOwnerPairsTogether.size()));
        //Number of cats found:
        System.out.println("Number of cats found: " + catOwnerPairsTogether.size());
        //Average number of movements required to find a cat: 34
        Iterator<Map.Entry<SimpleHopper,CleverHopper>> it = catOwnerPairsTogether.entrySet().iterator();
        float totalHops = 0f;
        while (it.hasNext()) {
            Map.Entry<SimpleHopper,CleverHopper> pair = it.next();
            //Accumulate the number of hops taken to find cats in order to find the average
            totalHops += pair.getValue().hopCount;
        }
        System.out.println("Average number of movements required to find a cat: " + (totalHops/catOwnerPairsTogether.size()));
    }

}

