package Model;

public class Trains implements Runnable{
    private int count;
    private static int idCount = 0;
    private int trainId;


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

}
