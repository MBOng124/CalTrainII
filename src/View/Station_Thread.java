package View;

import javax.swing.*;

public class Station_Thread extends Thread {
    private Station panel;

    public Station_Thread(Station panel){
        this.panel = panel;
    }


    public synchronized void run(){
        while(true){
            try {
                this.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(panel.getXp() >= 30){
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else{
                int x = panel.getXp();
                x += panel.getmovX();
                panel.setX(x);
                panel.repaint();
            }

        }
    }

}
