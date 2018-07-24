package Model;

public class Passenger extends Thread{
    private static int idCount = 0;
    private int passegerId;

    public Passenger(){
        this.setPassegerId(idCount);
        idCount++;
    }

    public static int getIdCount() {
        return idCount;
    }

    public static void setIdCount(int idCount) {
        Passenger.idCount = idCount;
    }

    public int getPassegerId() {
        return passegerId;
    }

    public void setPassegerId(int passegerId) {
        this.passegerId = passegerId;
    }
}
