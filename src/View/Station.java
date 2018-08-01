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
    private int x, y, movX, movY;
    private Station_Thread thread;
    private Train trains;
    private ArrayList<Passenger> passengers;


    public Station(int x, int y){
        thread = new Station_Thread(this);
        thread.start();
        mainPanel = new JPanel();
        mainPanel.setPreferredSize(new Dimension(100, 36));
        img = new ImageIcon(this.getClass().getResource("/images/world.png"));
        image = img.getImage();
        mainPanel.setVisible(true);
        this.setVisible(true);
        movX = 1;
        movY = 1;
        this.x = x;
        this.y = y;
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

    public int getmovX() {
        return movX;
    }

    public void setmovX(int movX) {
        this.movX = movX;
    }

    public int getmovY() {
        return movY;
    }

    public void setmovY(int movY) {
        this.movY = movY;
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
        g.drawImage(image, x, y, null);
    }


}
