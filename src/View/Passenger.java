package View;

import javax.swing.*;
import java.awt.*;

public class Passenger extends JPanel {
    private JPanel mainPanel;
    private ImageIcon img;
    private JLabel lbl;

    public Passenger(){
        mainPanel = new JPanel();
        mainPanel.setPreferredSize(new Dimension(36, 36));
        img = new ImageIcon(this.getClass().getResource(" "));
        lbl = new JLabel(img);
        mainPanel.add(lbl);
    }
}
