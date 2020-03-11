package tests;


import gabriela.vasileva.Card;

import java.util.ArrayList;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        ArrayList<Card> cards = new ArrayList<>();


        cards = new ArrayList<>();

        int id = 0;

        cards.add(new Card(
                "Ace of Spades",
                "A",
                "Spades",
                11,
                0));
        id++;
        cards.add(new Card(
                "Ace of Hearts",
                "A",
                "Hearts",
                11,
                id));
        id++;
        cards.add(new Card(
                "Ace of Diamonds",
                "A",
                "Diamonds",
                11,
                id));

        Card card = drawsCard(cards);
        System.out.println(card);
    }

    public static Card drawsCard(ArrayList<Card> cards) {
        if (cards.size() > 0) {
            Random random = new Random();
            int index = random.nextInt(cards.size());
            return cards.remove(index);
        } else {
            return null;
        }
    }
}