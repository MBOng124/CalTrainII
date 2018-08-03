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
            if(panel.getCurrent() instanceof Station){
                if(panel.getPassengers().size() == panel.getMaxCount() ||
                        panel.getCurrent().getPassengers().size() == 0){
                    if(panel.getNext().getTrains() == null){
                        //move train
                    }else {
                        try {
                            this.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                }else{
                    try {
                        this.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }else if(panel.getCurrent() instanceof SubStation){
                if(panel.getNext().getTrains() == null){
                        //move train
                }

                if(panel.getNext().getTrains() != null){
                    try {
                        this.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }else if(panel.getCurrent() instanceof Terminal){
                if(panel.getNext().getTrains() == null){
                    //move train
                }else{
                    try {
                        this.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }

        }
    }

}
