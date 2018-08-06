package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class CalTrain {
    private JFrame frame;
    private JLabel addPassenger, addTrain, startLbl, endLbl, qtyLbl;
    private JButton addPass, addTrains;
    private JComboBox passStart, passEnd;
    private JTextField trainTxt;
    private JPanel main, add, input;
    private JOptionPane option, trainOption;

    public static ArrayList<Component> getStations() {
        return stations;
    }

    public static void setStations(ArrayList<Component> stations) {
        CalTrain.stations = stations;
    }

    private static ArrayList<Component> stations;
	private ArrayList<Passenger> passengers;
	private ArrayList<Train> trains;
	private Train train1, train2;
	private Passenger pass1, pass2, pass3, pass4;


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
        initStations();
        init();


        frame.pack();
        /*station = new Station();
        frame.add(station);
        station.setBounds(0,0, 100, 36);*/
    }
    private void init(){
        //init panels
        main = new JPanel();
        main.setBounds(100, 0, 800, 600);
        main.setBackground(Color.white);
        main.setLayout(null);
        main.setVisible(true);
        main.setOpaque(false);
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
        //option = new JOptionPane();
        //startLbl = new JLabel("Start");
        //endLbl = new JLabel("End");
        option = new JOptionPane();
        option.setLayout(null);
        option.setPreferredSize(new Dimension(300, 200));

        trainOption = new JOptionPane();
        trainOption.setLayout(null);
        trainOption.setPreferredSize(new Dimension(300, 200));

        /* Adding lables */
        addPassenger = new JLabel("Add Passenger");
        addTrain = new JLabel("Add Train");
        startLbl = new JLabel("Origin");
        qtyLbl = new JLabel("Max Capacity");
        endLbl = new JLabel("Destination");
        trainTxt = new JTextField();
        addPass = new JButton("Add");
        addTrains = new JButton("Add");
        passStart = new JComboBox();
        passEnd = new JComboBox();

        for(int i= 1; i <= 7; i++){
            passStart.addItem(i);
        }

        for(int j = 2; j <= 8; j++){
            passEnd.addItem(j);
        }

        trainOption.add(qtyLbl);
        trainOption.add(trainTxt);
        trainOption.add(addTrains);

        qtyLbl.setBounds(20, 20, 75, 30);
        trainTxt.setBounds(110, 20, 50, 25);
        addTrains.setBounds(125, 155, 50, 25);

        option.add(startLbl);
        option.add(endLbl);
        option.add(addPass);
        option.add(passStart);
        option.add(passEnd);

        startLbl.setBounds(20, 20, 75, 25);
        endLbl.setBounds(20, 60, 50, 25);
        passStart.setBounds(110, 20, 45, 20);
        passEnd.setBounds(110, 60, 45, 20);
        addPass.setBounds(125, 155, 50, 25);


        addPassenger.setBackground(Color.LIGHT_GRAY);

        addPassenger.setBounds(0, 0, 100, 25);
        input.add(addPassenger);

        addTrain.setBounds(0, 125, 100, 25);
        input.add(addTrain);

        addPassenger.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                option.setVisible(true);
            }
        });

        addTrain.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                trainOption.setVisible(true);
            }
        });

        train1 = new Train(10, 20, 10, stations);
        main.add(train1);
        train1.setBounds(0, 0, 300, 500);
        train2 = new Train(50, 20, 10, stations);
        main.add(train2);
        train2.setBounds(0, 0, 300, 500);
        pass1 = new Passenger(100, 20, 3, 5, CalTrain.getStations().get(2));
        pass2 = new Passenger(100, 20, 3, 5, CalTrain.getStations().get(2));
        /*pass3 = new Passenger(100, 20, 3, 5, CalTrain.getStations().get(2));
        pass4 = new Passenger(100, 20, 3, 5, CalTrain.getStations().get(2));*/

    }
    
    private void initStations(){
      stations = new ArrayList<Component>();
      //add stations, substations, and terminals to the arraylist
        for(int i = 0; i < 8; i++){
            SubStation subStation = new SubStation(0+i, 0+1);
            Station station = new Station(1+i, 1+i);
            stations.add(subStation);
            stations.add(station);
        }
      
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
