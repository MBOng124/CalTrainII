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
            System.out.println(CalTrain.getStations().get(0));
            System.out.println("Train: "+panel.getXp()+" "+CalTrain.getStations().get(at).getStationId());
            System.out.println("Train: "+panel.getXp()+" Population: "+panel.getPassengers().size());
            //System.out.println(CalTrain.getStations().get(at).getTrains());
            try{
                System.out.println("Waiting");
                condition.awaitNanos(1000000000);
                if(CalTrain.getStations().get(at) instanceof Station){
                    if(CalTrain.getStations().get(at).getPassengers().size() > 0&&
                            panel.getPassengers().size() < panel.getMaxCount()){
                        if(CalTrain.getStations().get(at).getPassengers().size() > 0){
                            panel.addPassengers(CalTrain.getStations().get(at).getPassengers().get(0));
                            CalTrain.getStations().get(at).getPassengers().remove(0);
                        }

                    }else{
                        if(panel.getPassengers().size() > 0){
                            for(int i = 0; i < panel.getPassengers().size(); i++){
                                if(at == panel.getPassengers().get(i).getEnd()){
                                    panel.getPassengers().remove(i);
                                }
                            }
                        }
                        if(CalTrain.getStations().get((at+1)%CalTrain.getStations().size()).getTrains() == null) {
                            if(at % CalTrain.getStations().size() < CalTrain.getStations().size()){
                                CalTrain.getStations().get(at%CalTrain.getStations().size()).setTrains(null);
                                CalTrain.getStations().get((at + 1)%CalTrain.getStations().size()).setTrains(panel);
                                at = (at+1)%CalTrain.getStations().size();
                            }
                            if(at % CalTrain.getStations().size() >= CalTrain.getStations().size()){
                                CalTrain.getStations().get(at%CalTrain.getStations().size()).setTrains(null);
                                System.out.println("Arrived at last station bye");
                                this.join();
                            }
                        }
                    }
                }else if(CalTrain.getStations().get(at) instanceof SubStation){
                    if(CalTrain.getStations().get((at+1)%CalTrain.getStations().size()).getTrains() == null) {
                        if(at % CalTrain.getStations().size() < CalTrain.getStations().size()){
                            CalTrain.getStations().get(at%CalTrain.getStations().size()).setTrains(null);
                            CalTrain.getStations().get((at + 1)%CalTrain.getStations().size()).setTrains(panel);
                            at = (at+1)%CalTrain.getStations().size();
                        }
                        if(at % CalTrain.getStations().size() >= CalTrain.getStations().size()){
                            CalTrain.getStations().get(at%CalTrain.getStations().size()).setTrains(null);
                            System.out.println("Arrived at last station bye");
                            this.join();
                        }
                    }else{
                        System.out.println("Train ahead");
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }

        }
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
