package View;

import javax.swing.*;
import java.util.ArrayList;

public class Terminal extends Station{
    private ArrayList<Train> trains;
    private Terminal_Thread terminal;

    public Terminal(int x, int y) {
        super(x, y);
        trains = new ArrayList<>();
        terminal = new Terminal_Thread(this);
        terminal.start();
    }


    public ArrayList<Train> getAllTrains() {
        return trains;
    }

    public void setTrains(ArrayList<Train> trains) {
        this.trains = trains;
    }

    public void addTrains(Train train){
        this.trains.add(train);
    }


}
