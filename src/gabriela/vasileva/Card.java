package gabriela.vasileva;

public class Card {
    private String name;
    private String num;
    private String suit;
    private int power;
    private int id;

    public Card(){
    }
    public Card(String name, String num, String suit, int power, int id) {
        this.name = name;
        this.num = num;
        this.suit = suit;
        this.power = power;
        this.id = id;
    }

    public String getNum() {
        return num;
    }


    @Override
    public String toString() {
        return String.format("%s %s %s %d %d",name,num,suit,power,id);
    }
}