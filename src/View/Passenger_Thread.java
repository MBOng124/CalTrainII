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
                if(panel.getTrain() == null){
                    if(CalTrain.getStations().get(panel.getStart()).getTrains() != null){
                        CalTrain.getStations().get(panel.getStart()).getTrains().addPassengers(panel);
                        for(int i = 0; i < CalTrain.getStations().get(panel.getStart()).getPassengers().size(); i++){
                            if(CalTrain.getStations().get(panel.getStart()).getPassengers().get(i) == panel){
                                CalTrain.getStations().get(panel.getStart()).getPassengers().set(i, null);
                            }
                        }
                        panel.setVisible(false);
                        CalTrain.getStations().get(panel.getStart()).getTrains().getThread().getCondition().signal();
                    }else{
                        conditon.await();
                    }
                }else{
                    if(CalTrain.getStations().get(panel.getTrain().getThread().getAt()).getStationId() ==
                            panel.getEnd()){
                        CalTrain.getStations().get(panel.getTrain().getThread().getAt())
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
