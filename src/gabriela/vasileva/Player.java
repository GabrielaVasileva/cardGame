package gabriela.vasileva;

import java.util.ArrayList;
import java.util.List;

public abstract class Player {
    protected Deck playerDeck = new Deck();
    protected StartDeck startDeck = new StartDeck();
    protected Deck cardsWon = new Deck();
    protected String name;
    protected int score;
    protected boolean isItMyTurn;
    protected boolean hasWon;
    protected Player enemy;

    Player(int score,String name,int cardsNum, StartDeck startDeck){
        this.startDeck = startDeck;

        setPlayerDeck(cardsNum, startDeck);

        this.name = name;
        setScore(score);
    }

    private void setPlayerDeck(int cardsNum, StartDeck startDeck) {
        if (cardsNum >= startDeck.getCards().size()){
            cardsNum = startDeck.getCards().size()-1;
        }

        List<Card> listOfCards = new ArrayList<>();
        for (int i = 0; i < cardsNum; i++) {
            Card card = startDeck.drawsCard();
            if (card != null) {
                listOfCards.add(card);
            }
        }
        this.playerDeck.setCards(listOfCards);
    }

    public boolean isEnemyDeckEmpty(){
        return enemy.playerDeck.cards.isEmpty();
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setEnemy(Player listOfEnemies) {
        this.enemy = listOfEnemies;
    }

//    public abstract void Play(GameDeck gameDeck);


    public abstract boolean Play(GameDeck gameDeck);

    public boolean checkForMatches(GameDeck gameDeck){
        boolean isMatches = false;
        for (int i = 0; i < gameDeck.cards.size(); i++) {
            Card gameDeckCard = gameDeck.cards.get(i);
            for (int j = 0; j < playerDeck.getCards().size(); j++) {
                Card pleyersDeckCard = playerDeck.getCards().get(j);
                String numDC = gameDeckCard.getNum();
                String numP = pleyersDeckCard.getNum();
                if (numDC.equals(numP)){
                    isMatches = true;
                    return isMatches;
                }
            }
        }
        return isMatches;
    }

    public boolean checkForMatchesAndGetMatchedCards(GameDeck gameDeck){
        boolean isMatches = false;
        for (int i = 0; i < gameDeck.cards.size(); i++) {
            Card gameDeckCard = gameDeck.cards.get(i);
            for (int j = 0; j < playerDeck.getCards().size(); j++) {
                Card pleyersDeckCard = playerDeck.getCards().get(j);
                String numDC = gameDeckCard.getNum();
                String numP = pleyersDeckCard.getNum();
                if (numDC.equals(numP)){
                    isMatches = true;
                    cardsWon.cards.add(gameDeckCard);
                    cardsWon.cards.add(pleyersDeckCard);
                    gameDeck.cards.remove(gameDeckCard);
                    playerDeck.cards.remove(pleyersDeckCard);
                    return isMatches;
                }
            }
        }
        return isMatches;
    }

    @Override
    public String toString() {
        return String.format("Name:%s%n%s" +
                "score:%d%n" +
                "cards won :%n%s",
                name, playerDeck,score,cardsWon);
    }
}
