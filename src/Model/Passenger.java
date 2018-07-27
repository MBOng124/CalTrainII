package Model;

public class Passenger extends Thread{
    private static int idCount = 0;
    private int passegerId;
    private int start;//the index where the passenger will start
    private int destination;//the index where the passenger will start
    private Station station;

    public Passenger(int start, int destination){
        this.setPassegerId(idCount);
        idCount++;
        this.start = start;
        this.destination = destination;
    }

    @Override
    public synchronized void run(){
        if(station.getTrain() == null){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public int getStart() {
        return start;
    }

    public int getDestination() {
        return destination;
    }

    public void setDestination(int destination) {
        this.destination = destination;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public static int getIdCount() {
        return idCount;
    }

    public static void setIdCount(int idCount) {
        Passenger.idCount = idCount;
    }

    public int getPassegerId() {
        return passegerId;
    }

    public void setPassegerId(int passegerId) {
        this.passegerId = passegerId;
    }
}
