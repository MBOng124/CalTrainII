package View;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Component extends JPanel {
    protected JPanel mainPanel;
    protected ImageIcon img;
    protected Image image;
    protected BufferedImage bufImg;
    protected JLabel lbl;
    protected int x, y;
    protected Station_Thread thread;
    protected Train trains;
    protected ArrayList<Passenger> passengers;
    protected int count;
    protected static int idCount = 0;
    protected int stationId;


    public Component(int x, int y){
        passengers = new ArrayList<>();
        mainPanel = new JPanel();
        mainPanel.setPreferredSize(new Dimension(100, 36));
        img = new ImageIcon(this.getClass().getResource("/images/world.png"));
        image = img.getImage();
        mainPanel.setVisible(true);
        this.setVisible(true);
        this.x = x;
        this.y = y;
        count = 0;
        this.setStationId(idCount);
        idCount++;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public static int getIdCount() {
        return idCount;
    }

    public int getStationId() {
        return stationId;
    }

    public void setStationId(int stationCount) {
        this.stationId = stationCount;
    }

    public int getXp() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getYp() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public ArrayList<Passenger> getPassengers() {
        return passengers;
    }

    public void setPassengers(ArrayList<Passenger> passengers) {
        this.passengers = passengers;
    }

    protected void addPassengers(Passenger passenger){
        this.passengers.add(passenger);
    }

    protected void setTrains(Train train){
        this.trains = train;
    }

    public Train getTrains() {
        return trains;
    }
}
