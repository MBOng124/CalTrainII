package Model;

import java.util.ArrayList;

public class Trains extends Thread{
    private int count;
    private int maxCount;
    private static int idCount = 0;
    private int trainId;
    private ArrayList<Passenger> passengers;
    private Station station;


    public Trains(int maxCount){
        count = 0;
        this.setTrainId(idCount);
        idCount++;
        passengers = new ArrayList<>();
        this.maxCount = maxCount;
    }

    public synchronized void start(){

    }

    @Override
    public synchronized void run() {
        if(this.passengers.size() < maxCount && this.station.getPassengers().size() > 0){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        if(this.passengers.size() == maxCount || station.getPassengers().size() == 0){
            //move to next station
            try {
                this.moveNext();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }

    private void moveNext() throws InterruptedException {
        System.out.println("Train has moved to the next line");
        this.join();
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

    public int getMaxCount() {
        return maxCount;
    }

    public void setMaxCount(int maxCount) {
        this.maxCount = maxCount;
    }

    public Station getStation() {
        return station;
    }

    public void setStation(Station station) {
        this.station = station;
    }

}
