package View;

import javax.swing.*;
import java.awt.*;

public class CalTrain {
    private JFrame frame;
    private Station station;

    public CalTrain(){
        frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(300, 300));
        frame.setLayout(null);
        station = new Station();
        frame.add(station);
        station.setBounds(0,0, 36, 36);
        frame.setVisible(true);
        frame.pack();
    }

}
