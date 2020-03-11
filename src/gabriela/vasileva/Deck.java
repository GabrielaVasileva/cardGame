package gabriela.vasileva;

import java.util.*;

public class Deck {
    protected List<Card> cards = new ArrayList<>();

    public Deck() {
    }

    public Card getCard(int index) throws IndexOutOfBoundsException {
        Card card = new Card();
        try {
            card = this.cards.get(index);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("      IndexOutOfBoundsException      ");
        }
        return card;
    }

    private Card removeCard(int index) throws IndexOutOfBoundsException {
        Card card = new Card();
        try {
            card = this.cards.remove(index);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("-----IndexOutOfBoundsException-----");
        }
        return card;
    }

    public Card drawsCard(){
        if (this.cards.size() > 0 ) {
            Random random = new Random();
            int index = random.nextInt(this.cards.size());
            return removeCard(index);
        }else {
            return null;
        }
    }

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        if (cards.size() > 0) {
            cards.forEach(e -> {
                if (e != null){
                    stringBuilder.append(e.toString());
                    stringBuilder.append(String.format("%n"));
                }
            });
            return stringBuilder.toString();
        }
        return String.format("No cards!%n");
    }
}