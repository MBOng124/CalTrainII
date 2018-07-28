package View;

import javax.swing.*;
import java.awt.*;

public class Station extends JPanel {
    private JPanel mainPanel;
    private ImageIcon img;
    private JLabel lbl;


    public Station(){
        mainPanel = new JPanel();
        mainPanel.setPreferredSize(new Dimension(36, 36));
        img = new ImageIcon(this.getClass().getResource("/images/world.png"));
        lbl = new JLabel(img);
        mainPanel.add(lbl);
        lbl.setVisible(true);
        mainPanel.setVisible(true);
        this.setVisible(true);
        add(mainPanel);
    }

}
