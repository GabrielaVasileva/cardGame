package gabriela.vasileva;


import javax.swing.*;
import java.awt.*;
import java.util.Set;

import gabriela.vasileva.constants.GlobalConstants;

public class GameField extends JPanel {
    private Image card;
    private Set<Image> cards;

    public GameField() {
        StartDeck startDeck = new StartDeck();
        setBackground(new Color(0, 51, 0));

        loadImage();
        initPanel();
    }


    private void loadImage() {
        ImageIcon iia = new ImageIcon();
        card = iia.getImage();
    }

    private void initPanel() {
        setPreferredSize(new Dimension(50, 50));
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.drawImage(card, 50, 50, this);


    }

}
