package View;

public class Train_Thread extends Thread{
    public Train panel;

    public Train_Thread(Train train){
        this.panel = train;
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
