package View;
/*  STILL LACKS CODE FOR ANIMATION  */
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
            if(panel.getCurrent().getTrains() == null){
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }else{
                if(panel.getTrain() == null){// if the passenger is not in a train
                    if(panel.getCurrent().getTrains().getPassengers().size() <
                            panel.getCurrent().getTrains().getMaxCount()){
                        panel.getCurrent().getTrains().getPassengers().add(panel);
                        panel.setTrain(panel.getCurrent().getTrains());
                        try {
                            this.sleep(500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        panel.setVisible(false);
                        panel.getCurrent().getTrains().getThread().notify();
                    }else if(panel.getCurrent().getTrains().getPassengers().size() >=
                            panel.getCurrent().getTrains().getPassengers().size()){
                        try {
                            this.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }else if(panel.getTrain() != null){// if the passenger is in a train
                        // sets the passenger's current station to that of the train's
                        panel.setCurrent(panel.getTrain().getCurrent());
                        if(panel.getCurrent().getStationId() == panel.getEnd()){
                            //leaves the train and terminates the thread
                        }
                    }
                }
            }
        }
    }
}
