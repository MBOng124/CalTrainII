package View;

import javafx.fxml.Initializable;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class CalTrain {
    private JFrame frame;
    private JLabel addPassenger, addTrain, startLbl, endLbl, qtyLbl, bgLbl, railLbl;
    private ImageIcon bgImg, railImg;
    private JButton addPass, addTrains;
    private JComboBox passStart, passEnd;
    private JTextField trainTxt;
    private JPanel main, add, input, passOpt, trainOpt, realMain, subMain;
    private JOptionPane option, trainOption;
    private Terminal terminal;
    private static ArrayList<Component> stations;
	private ArrayList<Passenger> passengers;
	private ArrayList<Train> trains;
	private Train train1, train2;
	private Passenger pass1, pass2, pass3, pass4;


    public CalTrain(){
        terminal = new Terminal(0, 0);
        /*  Set up frame */
        frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(800, 700));
        frame.setLayout(null);
        frame.setBackground(Color.WHITE);
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
        realMain = new JPanel();
        realMain.setBounds(0, 0, 800, 600);
        realMain.setBackground(Color.white);
        realMain.setLayout(null);
        realMain.setVisible(true);
        realMain.setOpaque(false);
        frame.add(realMain);

        main = new JPanel();
        main.setBounds(0, 0, 800, 600);
        main.setBackground(Color.white);
        main.setLayout(null);
        main.setVisible(true);
        main.setOpaque(false);
        realMain.add(main);

        subMain = new JPanel();
        subMain.setBounds(0, 0, 800, 600);
        subMain.setBackground(Color.white);
        subMain.setLayout(null);
        subMain.setVisible(true);
        subMain.setOpaque(false);
        main.add(subMain);

        input = new JPanel();
        input.setBounds(0, 600, 800, 100);
        input.setBackground(Color.white);
        input.setLayout(null);
        input.setVisible(true);
        frame.add(input);

        /*add = new JPanel();
        add.setBounds(0, 0, 800, 600);
        add.setBackground(Color.white);
        add.setLayout(null);
        add.setVisible(false);
        frame.add(add);*/

        bgLbl = new JLabel();
        bgImg = new ImageIcon(this.getClass().getResource("/images/train rails2.png"));
        bgLbl.setIcon(bgImg);



        realMain.add(bgLbl);
        bgLbl.setBounds(0,0, 800, 600);

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
        passOpt = new JPanel();
        trainOpt = new JPanel();
        passOpt.setLayout(null);
        passOpt.setBounds(0, 0, 300, 200);
        trainOpt.setLayout(null);
        trainOpt.setBounds(0, 0, 300, 200);
        passStart = new JComboBox();
        passEnd = new JComboBox();

        for(int i= 1; i <= 7; i++){
            passStart.addItem(i);
        }

        for(int j = 2; j <= 8; j++){
            passEnd.addItem(j);
        }

        trainOpt.add(qtyLbl);
        trainOpt.add(trainTxt);
        trainOpt.add(addTrains);

        qtyLbl.setBounds(10, 20, 85, 30);
        trainTxt.setBounds(110, 20, 50, 25);
        addTrains.setBounds(60, 105, 75, 25);

        passOpt.add(startLbl);
        passOpt.add(endLbl);
        passOpt.add(addPass);
        passOpt.add(passStart);
        passOpt.add(passEnd);

        startLbl.setBounds(20, 20, 75, 25);
        endLbl.setBounds(20, 60, 75, 25);
        passStart.setBounds(110, 20, 45, 20);
        passEnd.setBounds(110, 60, 45, 20);
        addPass.setBounds(60, 105, 75, 25);


        addPassenger.setBackground(Color.LIGHT_GRAY);

        addPassenger.setBounds(0, 0, 100, 25);
        input.add(addPassenger);

        addTrain.setBounds(110, 0, 100, 25);
        input.add(addTrain);


        //Action Listeners
        addPassenger.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                UIManager.put("OptionPane.minimumSize", new Dimension(300, 200));
                option.showMessageDialog(frame, passOpt);
            }
        });

        addTrain.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                UIManager.put("OptionPane.minimumSize", new Dimension(300, 200));
                option.showMessageDialog(frame, trainOpt);
            }
        });

        addPass.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int start, end;
                start = Integer.parseInt(passStart.getSelectedItem().toString());
                end = Integer.parseInt(passEnd.getSelectedItem().toString());
                if(end > start){
                    if(start <= 4){
                        Passenger passenger = new Passenger(start%5*161, 190, start*2-1, end*2-1, stations.get(start*2-1));
                        main.add(passenger);
                        passenger.setBounds(0, 0, 800, 600);
                    }
                    if(start > 4){
                        Passenger passenger = new Passenger((start%5+1)*161, 490,start*2-1, end*2-1, stations.get(start*2-1));
                        main.add(passenger);
                        passenger.setBounds(0, 0, 800, 600);
                    }
                }else{
                    new JOptionPane().showMessageDialog(option, "Invalid input");
                }


            }
        });

        addTrains.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int capacity;
                capacity = Integer.parseInt(trainTxt.getText().toString());
                Train train = new Train(0, 245, capacity, stations);
                System.out.println("Added");
                terminal.getAllTrains().add(train);
                train.setBounds(0, 0, 800, 600);
                main.add(train);
            }
        });

        /*for(int i = 0; i < 10; i++){
            Train train = new Train(0, 245, 10, stations);
            terminal.getAllTrains().add(train);
            main.add(train);
            train.setBounds(0, 0, 800, 600);
        }*/


        /*pass1 = new Passenger(100, 100, 3, 5, CalTrain.getStations().get(2));
        subMain.add(pass1);
        pass1.setBounds(0, 0, 800, 500);
        pass2 = new Passenger(120, 20, 3, 5, CalTrain.getStations().get(2));
        //stations.get(3).getPassengers().add(pass1);
        pass3 = new Passenger(100, 20, 3, 5, CalTrain.getStations().get(2));
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

    public static ArrayList<Component> getStations() {
        return stations;
    }

    public static void setStations(ArrayList<Component> stations) {
        CalTrain.stations = stations;
    }

}
