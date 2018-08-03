package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class CalTrain {
    private JFrame frame;
    private JLabel addPassenger, addTrain, stationLbl, startLbl, endLbl;
    private JPanel main, add, input;
    private JOptionPane option;
	private ArrayList<Station> stations;
	private ArrayList<Passenger> passengers;
	private ArryaList<Train> trains;

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

        //init components
        init();
        initStations();

        frame.pack();
        /*station = new Station();
        frame.add(station);
        station.setBounds(0,0, 100, 36);*/
    }
    private void init(){
        //init panels
        main = new JPanel();
        main.setBounds(125, 0, 800, 600);
        main.setBackground(Color.white);
        main.setLayout(null);
        main.setVisible(true);
        frame.add(main);

        input = new JPanel();
        input.setBounds(0, 0, 100, 600);
        input.setBackground(Color.white);
        input.setLayout(null);
        input.setVisible(true);
        frame.add(input);

        add = new JPanel();
        add.setBounds(0, 0, 800, 600);
        add.setBackground(Color.white);
        add.setLayout(null);
        add.setVisible(false);
        frame.add(add);

        //for adding passengers
        option = new JOptionPane();
        startLbl = new JLabel("Start");
        endLbl = new JLabel("End");

        option.setLayout(null);
        option.setPreferredSize(new Dimension(300, 200));

        /* Adding lables */
        addPassenger = new JLabel("Add Passenger");
        addTrain = new JLabel("Add Train");
        addPassenger.setBackground(Color.LIGHT_GRAY);

        addPassenger.setBounds(0, 0, 100, 25);
        main.add(addPassenger);

        addTrain.setBounds(0, 125, 100, 25);
        main.add(addTrain);

        addPassenger.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
				option = new J
				
            }
        });

        addTrain.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
            }
        });


    }
    
    private void initStations(){
      stations = new ArrayList<Station>();
      //add stations, substations, and terminals to the arraylist
      
    }

    public void addPassengers(Passenger passenger){
        passengers.add(passenger);   
    }

        
    public void addTrains(Train train){
		trains.add(train);
    }

	public void addStations(Station station){
	  stations.add(station);
	}

}
