package gabriela.vasileva;

import java.util.ArrayList;
import java.util.List;

public class GameDeck extends Deck{
    GameDeck(StartDeck startDeck,int cardsNum){
        if (cardsNum >= startDeck.getCards().size()){
            cardsNum = startDeck.getCards().size()-1;
        }
        List<Card> listOfCards = new ArrayList<>();
        for (int i = 0; i < cardsNum; i++) {
            listOfCards.add(startDeck.drawsCard());
        }

        super.cards = listOfCards;
    }

}
