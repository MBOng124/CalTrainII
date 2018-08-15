package View;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Passenger extends JPanel {
    private JPanel mainPanel;
    private ImageIcon img;
    private ArrayList<Image> image;
    private Passenger_Thread_Monitor thread;
    private int x, y, movX, movY;
    private Train train;// not sure if this is needed
    private int start, end;
    private Component current;
    private static int passId = 0;
    private int id;

    public Passenger(int x, int y, int start, int end, Component initial){
        thread = new Passenger_Thread_Monitor(this);
        thread.start();
        mainPanel = new JPanel();
        mainPanel.setPreferredSize(new Dimension(36, 36));
        image = new ArrayList<>();
        img = new ImageIcon(this.getClass().getResource("/images/ronaldo.png"));
        image.add(img.getImage());
        img = new ImageIcon(this.getClass().getResource("/images/dk2.png"));
        image.add(img.getImage());
        img = new ImageIcon(this.getClass().getResource("/images/dk3.png"));
        image.add(img.getImage());
        movX = 1;
        movY = 1;
        this.x = x;
        this.y = y;
        this.start = start;
        this.end = end;
        this.current = initial;
        id = passId;
        passId++;
        mainPanel.setOpaque(false);
        this.setOpaque(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image.get(id%3), x, y, null);
        //this.setBounds(x, y, 36, 36);

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

    public Train getTrain() {
        return train;
    }

    public void setTrain(Train train) {
        this.train = train;
    }

    public Passenger_Thread_Monitor getThread() {
        return thread;
    }

    public int getStart()
    {
        return start;
    }

    public int getEnd() {
        return end;
    }

    public Component getCurrent() {
        return current;
    }

    public void setCurrent(Component current) {
        this.current = current;
    }
}
