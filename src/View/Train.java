package View;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Train extends JPanel {
    private JPanel mainPanel;
    private ImageIcon img;
    private Image image;
    private int x, y, movX, movY;
    private Train_Thread thread;
    private Component current, next;
    private final int maxCount;
    private JLabel stationLbl;
    private ArrayList<Component> stations;
    private ArrayList<Passenger> passengers;

    public Train(int x, int y, int maxCount, ArrayList<Component> stations){
        System.out.println("Train Created");
        thread = new Train_Thread(this);
        thread.start();
        mainPanel = new JPanel();
        mainPanel.setPreferredSize(new Dimension(36, 36));
        img = new ImageIcon(this.getClass().getResource("/images/train2.png"));
        image = img.getImage();
        movX = 1;
        this.x = x;
        this.y = y;
        this.maxCount = maxCount;
        this.stations = stations;
        mainPanel.setOpaque(false);
        this.setOpaque(false);
        stationLbl = new JLabel();
        stationLbl.setBounds(x, y, 36, 36);
        mainPanel.add(stationLbl);
        stationLbl.setVisible(true);
        passengers = new ArrayList<>();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, x, y, null);
        //this.setBounds(x, y, 36, 360);
        //g.drawRect(x, y, 36, 36);

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

    public Train_Thread getThread() {
        return thread;
    }

    public Component getCurrent() {
        return current;
    }

    public void setCurrent(Component current) {
        this.current = current;
    }

    public Component getNext() {
        return next;
    }

    public void setNext(Component next) {
        this.next = next;
    }

    public ArrayList<Passenger> getPassengers() {
        return passengers;
    }

    public void setPassengers(ArrayList<Passenger> passengers) {
        this.passengers = passengers;
    }

    public void addPassengers(Passenger passenger){
        passengers.add(passenger);
    }

    public int getMaxCount() {
        return maxCount;
    }

    public ArrayList<Component> getStations() {
        return stations;
    }

    public void setStations(ArrayList<Component> stations) {
        this.stations = stations;
    }

    public JLabel getStationLbl() {
        return stationLbl;
    }

    public void setStationLbl(JLabel stationLbl) {
        this.stationLbl = stationLbl;
    }
}
