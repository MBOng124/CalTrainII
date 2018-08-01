package View;

public class Train_Thread extends Thread{
    public Train panel;
    private int initX, initY;

    public Train_Thread(Train train){
        this.panel = train;
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
            if(panel.getXp() - initX >= 30){
                try {
                    initX = panel.getXp();
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
