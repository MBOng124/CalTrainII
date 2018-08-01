package View;

import javax.swing.*;
import java.awt.*;

public class Train extends JPanel {
    private JPanel mainPanel;
    private ImageIcon img;
    private Image image;
    private int x, y, movX, movY;
    private Train_Thread thread;

    public Train(int x, int y){
        thread = new Train_Thread(this);
        thread.start();
        mainPanel = new JPanel();
        mainPanel.setPreferredSize(new Dimension(36, 36));
        /*img = new ImageIcon(this.getClass().getResource(" "));
        image = img.getImage();*/
        this.x = x;
        this.y = y;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        //g.drawImage(image, x, y, null);
        g.drawRect(x, y, 36, 36);

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
}
