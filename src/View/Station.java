package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Station extends Component {


    public Station(int x, int y) {
        super(x, y);
        thread = new Station_Thread(this);
        thread.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.setBounds(x, y, 36, 36);
        g.drawImage(image, x, y, null);
    }


}
