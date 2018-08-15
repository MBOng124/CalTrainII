package View;

import javax.swing.*;

public class Station_Thread_Monitor extends Thread {
    private Station panel;

    public Station_Thread_Monitor(Station panel){
        this.panel = panel;
    }


    public synchronized void run(){
        while(true){
            try {
                this.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            panel.repaint();

        }
    }

}
