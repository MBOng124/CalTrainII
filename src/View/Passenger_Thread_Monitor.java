package View;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Passenger_Thread_Monitor extends Thread{
    private Passenger panel;
    private int initX, initY;
    private Lock lock;
    private Condition conditon;
    private boolean animate, entry, exit;

    public Passenger_Thread_Monitor(Passenger passenger){
        this.panel = passenger;
        lock = new ReentrantLock();
        conditon = lock.newCondition();
        entry = false;
        exit = false;
    }

    public synchronized void run(){
        initX = panel.getXp();
        initY = panel.getYp();
        while(true){
            try {
                this.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            lock.lock();
            try{
                if(!entry && !exit){
                    conditon.awaitNanos(1000000000);
                    /*System.out.println("Passenger "+panel.getXp()+" "+panel.getTrain()+" ");*/
                    if(panel.getTrain() == null){
                        //System.out.println("A");
                        if(CalTrain.getStations().get(panel.getStart()).getTrains() != null){
                            Train train = CalTrain.getStations().get(panel.getStart()).getTrains();
                            if(train.getPassengers().size() < train.getMaxCount()){
                                train.addPassengers(panel);
                                panel.setTrain(CalTrain.getStations().get(panel.getStart()).getTrains());
                                System.out.println("Passenger: "+panel.getId()+" Boarded Train");
                                entry = true;
                                animate = true;
                            }
                            //signal for entry animation
                        }else{

                        }
                    }else{
                        if(CalTrain.getStations().get(panel.getTrain().getThread().getAt()).getStationId() ==
                                panel.getEnd()){
                            panel.setX(panel.getTrain().getXp());
                            panel.getTrain().getPassengers().remove(panel);
                            panel.setTrain(null);
                            System.out.println("Got to destination");
                            exit = true;
                            int end = panel.getEnd();
                            if(end <= 4){
                                System.out.println(end);
                                panel.setX(panel.getEnd()%5-161);
                            }
                            if(end > 4){
                                panel.setX((panel.getEnd()%5 -1)-161);
                            }
                            //signal for exit animation
                        }
                    }
                }if(entry){
                    if(panel.getYp() - initY >= 30){
                        initY = panel.getYp();
                        entry = false;
                        animate = false;
                        this.sleep(1000);
                        panel.setVisible(false);
                    }else{
                        int y = panel.getYp();
                        y+= panel.getmovY();
                        panel.setY(y);
                        panel.repaint();
                    }

                }if(exit){
                    System.out.println("hello");
                    panel.setVisible(true);
                    this.sleep(1000);
                    System.out.println(initY - panel.getYp() >= 30);
                    if(initY - panel.getYp() >= 30){
                        exit = false;
                        panel.setVisible(false);
                        this.join();
                    }else{
                        int y = panel.getYp();
                        y-= panel.getmovY();
                        panel.setY(y);
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

    public Lock getLock() {
        return lock;
    }

    public Condition getConditon() {
        return conditon;
    }

    public boolean isAnimate() {
        return animate;
    }

    public void setAnimate(boolean animate) {
        this.animate = animate;
    }
}
