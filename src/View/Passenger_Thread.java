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
            if(panel.getCurrent().getTrains() == null){
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }else{
                if(panel.getCurrent().getTrains().getPassengers().size() <
                        panel.getCurrent().getTrains().getMaxCount()){
                    panel.getCurrent().getTrains().getPassengers().add(panel);
                    panel.setTrain(panel.getCurrent().getTrains());
                }
            }
        }
    }
}
