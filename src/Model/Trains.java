package Model;

import java.util.ArrayList;

public class Trains implements Runnable{
    private int count;
    private static int idCount = 0;
    private int trainId;
    private ArrayList<Passenger> passengers;


    public Trains(){
        count = 0;
        this.setTrainId(idCount);
        idCount++;
    }

    public synchronized void start(){

    }

    public synchronized void stop(){

    }

    @Override
    public void run() {

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
        Trains.idCount = idCount;
    }

    public int getTrainId() {
        return trainId;
    }

    public void setTrainId(int trainId) {
        this.trainId = trainId;
    }

    public void addPassenger(Passenger p){
        passengers.add(p);
    }

    public void setPassengers(ArrayList<Passenger> passengers) {
        this.passengers = passengers;
    }

    public ArrayList<Passenger> getPassengers() {
        return passengers;
    }

    public Passenger getSinglePassenger(int i){
        return passengers.get(i);
    }

}
