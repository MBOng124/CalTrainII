package View;

import java.awt.*;

public class Station extends Component {


    public Station(int x, int y) {
        super(x, y);
        thread = new Station_Thread_Monitor(this);
        thread.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.setBounds(x, y, 36, 36);
        g.drawImage(image, x, y, null);
    }


}
