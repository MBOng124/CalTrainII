package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Station extends JPanel {
    private JPanel mainPanel;
    private ImageIcon img;
    private Image image;
    private BufferedImage bufImg;
    private JLabel lbl;
    private int x, y;
    private Station_Thread thread;
    private Train trains;
    private ArrayList<Passenger> passengers;
    private int count;
    private static int idCount = 0;
    private int stationId;


    public Station(int x, int y){
        thread = new Station_Thread(this);
        thread.start();
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

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.setBounds(x, y, 36, 36);
        g.drawImage(image, x, y, null);
    }


}
