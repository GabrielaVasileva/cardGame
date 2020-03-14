package gabriela.vasileva;
import gabriela.vasileva.constants.GlobalConstants;

import javax.swing.*;

public class MainWindow extends JFrame {
    public MainWindow(){
        setTitle("Card game");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(GlobalConstants.WIDTH_SIZE,GlobalConstants.HEIGHT_SIZE);
        setLocation(GlobalConstants.LOCATION_SIZE_X,GlobalConstants.LOCATION_SIZE_Y);
        add(new GameField());
        setVisible(true);
    }

    public static void main(String[] args) {
        MainWindow mw = new MainWindow();
    }

}
