package View;

import java.util.Date;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*  STILL LACKS CODE FOR ANIMATION  */
public class Train_Thread_Monitor extends Thread{
    public Train panel;
    private int initX, initY;
    private int at = 0;
    private Terminal terminal;
    private Lock lock;
    private Condition condition, trainAhead, trainGone;
    private boolean animate, waiting;
    private long time;

    public Train_Thread_Monitor(Train train){
        time = System.currentTimeMillis();
        this.panel = train;
        lock = new ReentrantLock();
        condition = lock.newCondition();
        trainAhead = lock.newCondition();
        trainGone = lock.newCondition();
        animate = true;
        waiting = true;
    }

    public synchronized void run(){
        initX = panel.getXp();
        initY = panel.getYp();
        lock.lock();
        try {
            synchronized (this){
                this.wait();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
        CalTrain.getStations().get(at).setTrains(panel);
        while(true){
            try {
                this.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            lock.lock();
            //System.out.println("Train: "+panel.getXp()+" Population: "+panel.getPassengers().size());
            //System.out.println(CalTrain.getStations().get(at).getTrains());
            try{
                if(!animate){
                    condition.awaitNanos(1000000000);
                    if((at+1)%CalTrain.getStations().size() == 9){
                        initX = 0;
                        initY = 545;
                        panel.setY(initY);
                        panel.setX(initX);
                    }else if((at+1)%CalTrain.getStations().size() == 0){
                        initX = 0;
                        initY = 245;
                        panel.setY(initY);
                        panel.setX(initX);
                    }
                    if(CalTrain.getStations().get(at) instanceof Station){
                        stationOperation();
                    }else if(CalTrain.getStations().get(at) instanceof SubStation){
                        moveTrain();
                    }else if(CalTrain.getStations().get(at) instanceof Terminal){
                        moveTrain();
                    }
                }else if(animate){
                    if(panel.getXp() - initX >= 80){
                        animate = false;
                        initX = panel.getXp();
                    }else{
                        int x = panel.getXp();
                        x += panel.getmovX();
                        panel.setX(x);
                        panel.repaint();
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }

        }
    }

    private void stationOperation() throws InterruptedException {
        if(CalTrain.getStations().get(at).getPassengers().size() > 0&&
                panel.getPassengers().size() < panel.getMaxCount()){
            if(CalTrain.getStations().get(at).getPassengers().size() > 0){
                CalTrain.getStations().get(at).getPassengers().get(0).setTrain(panel);
                panel.addPassengers(CalTrain.getStations().get(at).getPassengers().get(0));
                CalTrain.getStations().get(at).getPassengers().remove(0);
            }

        }else{
            if(panel.getPassengers().size() > 0){
                for(int i = 0; i < panel.getPassengers().size(); i++){
                    if(at == panel.getPassengers().get(i).getEnd()){
                        condition.awaitNanos(1000000000);
                        //panel.getPassengers().remove(i);
                    }
                }
            }
            moveTrain();
        }
    }

    private void moveTrain() throws InterruptedException {
        if(CalTrain.getStations().get((at+1)%CalTrain.getStations().size()).getTrains() == null) {
            if(at % CalTrain.getStations().size() < CalTrain.getStations().size()){
                CalTrain.getStations().get(at%CalTrain.getStations().size()).setTrains(null);
                CalTrain.getStations().get((at + 1)%CalTrain.getStations().size()).setTrains(panel);
                at = (at+1)%CalTrain.getStations().size();
                animate = true;
                System.out.println("["+(System.currentTimeMillis() - time)+"]"+" Train: "+panel.getStationId()+" "+CalTrain.getStations().get(at).getStationId()+" Population: "+panel.getPassengers().size());
            }
            if(at % CalTrain.getStations().size() >= CalTrain.getStations().size()){
                CalTrain.getStations().get(at%CalTrain.getStations().size()).setTrains(null);
                System.out.println("Arrived at last station bye");
                animate = true;
                this.join();
            }
        }else{
            System.out.println("Train: "+panel.getStationId()+" Train ahead");
        }
    }


    public synchronized void notifyThread(){
        this.notify();
    }

    public int getAt() {
        return at;
    }

    public Lock getLock() {
        return lock;
    }

    public Condition getCondition() {
        return condition;
    }
}
