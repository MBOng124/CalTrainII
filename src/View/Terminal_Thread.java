package View;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Terminal_Thread extends Thread {
    private Lock lock;
    private Condition condition;
    private Terminal terminal;

    public Terminal_Thread(Terminal terminal){
        lock = new ReentrantLock();
        condition = lock.newCondition();
        this.terminal = terminal;
    }


    public synchronized void run(){
        try {
            this.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        while(true){
            lock.lock();
            try{
                if(terminal.getAllTrains().size() > 0){
                    if(CalTrain.getStations().get(1).getTrains() == null){
                        synchronized (this){
                            terminal.getAllTrains().get(0).getThread().notifyThread();
                            System.out.println();
                            terminal.getAllTrains().remove(0);
                        }
                    }
                }
            }finally {
                lock.unlock();
            }
        }
    }
}
