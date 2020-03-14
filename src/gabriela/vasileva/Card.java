package gabriela.vasileva;
import javafx.scene.image.Image;

import java.awt.*;

public class Card {
    private String name;
    private String num;
    private String suit;
    private int power;
    private int id;
    private Image image;

    public Card(){
    }
    public Card(String name, String num, String suit, int power, int id,String imagePath) {
        this.name = name;
        this.num = num;
        this.suit = suit;
        this.power = power;
        this.id = id;
//        this.image = new Image(imagePath);;
    }

    public String getNum() {
        return num;
    }


    @Override
    public String toString() {
        return String.format("%s %s %s %d %d",name,num,suit,power,id);
    }

    public Image getImage() {
        return image;
    }
}