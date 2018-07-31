package View;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class CalTrain {
    private JFrame frame;
    private Station station;
    private JButton addPassenger, addTrain;
    private ArrayList<Train> trains;
    private ArrayList<Passenger> passengers;

    public CalTrain(){
        /*  Set up frame */
        frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(800, 600));
        frame.setLayout(null);
        frame.setBackground(Color.WHITE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);

        /* Adding lables */
        addPassenger = new JButton("Add Passenger");
        addTrain = new JButton("Add Train");
        addPassenger.setBorderPainted(false);
        addTrain.setBorderPainted(false);

        addPassenger.setBounds(0, 0, 100, 25);
        frame.add(addPassenger);


        frame.pack();
        /*station = new Station();
        frame.add(station);
        station.setBounds(0,0, 100, 36);*/
    }



    protected void addPassengers(Passenger passenger){
        this.passengers.add(passenger);
    }

    protected void addTrains(Train train){
        this.trains.add(train);
    }



}
