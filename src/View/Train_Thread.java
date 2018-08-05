package View;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*  STILL LACKS CODE FOR ANIMATION  */
public class Train_Thread extends Thread{
    public Train panel;
    private int initX, initY;
    private int at = 0;
    private Terminal terminal;
    private Lock lock;
    private Condition condition;

    public Train_Thread(Train train){
        this.panel = train;
        lock = new ReentrantLock();
        condition = lock.newCondition();
    }

    public void run(){
        initX = panel.getXp();
        initY = panel.getYp();
        CalTrain.getStations().get(at).setTrains(panel);
        while(true){
            try {
                this.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            lock.lock();
            System.out.println("Train: "+panel.getXp()+" "+at);
            System.out.println(CalTrain.getStations().get(at).getTrains());
            try{
                if(CalTrain.getStations().get(at+1).getTrains() == null) {
                    if(at < 15){
                        CalTrain.getStations().get(at).setTrains(null);
                        CalTrain.getStations().get(at + 1).setTrains(panel);
                        at++;
                    }
                    if(at >= 15){
                        CalTrain.getStations().get(at).setTrains(null);
                        System.out.println("Arrived at last station bye");
                        this.join();
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println("Unlocked");
                lock.unlock();
            }

        }
    }

}
