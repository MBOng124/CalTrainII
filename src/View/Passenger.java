package View;

import javax.swing.*;
import java.awt.*;

public class Passenger extends JPanel {
    private JPanel mainPanel;
    private ImageIcon img;
    private Image image;
    private Passenger_Thread thread;
    private int x, y, movX, movY;
    private Train train;
    private Station start, end;

    public Passenger(int x, int y, Station start, Station end){
        thread = new Passenger_Thread(this);
        thread.start();
        mainPanel = new JPanel();
        mainPanel.setPreferredSize(new Dimension(36, 36));
       /* img = new ImageIcon(this.getClass().getResource(" "));
        image = img.getImage();*/
        movX = 1;
        movY = 1;
        this.x = x;
        this.y = y;
        this.start = start;
        this.end = end;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        //g.drawImage(image, x, y, null);
        this.setBounds(x, y, 36, 36);

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

    public Passenger_Thread getThread() {
        return thread;
    }

    public Station getStart()
    {
        return start;
    }

    public Station getEnd() {
        return end;
    }
}
