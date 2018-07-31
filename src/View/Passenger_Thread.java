package View;

public class Passenger_Thread extends Thread{
    public Passenger panel;

    public Passenger_Thread(Passenger passenger){
        this.panel = passenger;
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
