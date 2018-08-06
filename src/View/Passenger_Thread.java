package View;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*  STILL LACKS CODE FOR ANIMATION  */
public class Passenger_Thread extends Thread{
    private Passenger panel;
    private int initX, initY;
    private Lock lock;
    private Condition conditon;

    public Passenger_Thread(Passenger passenger){
        this.panel = passenger;
        lock = new ReentrantLock();
        conditon = lock.newCondition();
    }

    public synchronized void run(){
        while(true){
            try {
                this.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            lock.lock();
            try{
                System.out.println("Passenger "+panel.getXp()+" "+panel.getTrain()+" ");
                System.out.println(panel.getTrain());
                if(panel.getTrain() == null){
                    //System.out.println("A");
                    if(CalTrain.getStations().get(panel.getStart()).getTrains() != null){
                        CalTrain.getStations().get(panel.getStart()).getTrains().addPassengers(panel);
                        panel.setTrain(CalTrain.getStations().get(panel.getStart()).getTrains());
                        System.out.println("Passenger: "+panel.getXp()+" Boarded Train");
                        panel.setVisible(false);
                        //signal for entry animation
                    }else{

                    }
                }else{
                    if(CalTrain.getStations().get(panel.getTrain().getThread().getAt()).getStationId() ==
                            panel.getEnd()){
                        panel.setTrain(null);
                        System.out.println("Got to destination");
                        this.join();
                        //signal for exit animation
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }

    public Lock getLock() {
        return lock;
    }

    public Condition getConditon() {
        return conditon;
    }
}
