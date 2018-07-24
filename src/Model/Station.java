package Model;

import java.util.ArrayList;

public class Station {
    private int count;
    private static int idCount = 0;
    private int stationId;
    private Trains train;
    private ArrayList<Passenger> passengers;


    public Station(){
        count = 0;
        this.setStationId(idCount);
        idCount++;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public static int getIdCount() {
        return idCount;
    }

    public static void setIdCount(int idCount) {
        Station.idCount = idCount;
    }

    public int getStationId() {
        return stationId;
    }

    public void setStationId(int stationCount) {
        this.stationId = stationCount;
    }

    public void addPassenger(Passenger p){
        passengers.add(p);
    }

    public void setTrain(Trains train) {
        this.train = train;
    }

    public void setPassengers(ArrayList<Passenger> passengers) {
        this.passengers = passengers;
    }

    public Trains getTrain() {
        return train;
    }

    public ArrayList<Passenger> getPassengers() {
        return passengers;
    }

    public Passenger getSinglePassenger(int i){
        return passengers.get(i);
    }
}
