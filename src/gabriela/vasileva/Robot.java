package gabriela.vasileva;

public class Robot extends Player {

     Robot(int score, int cardsNum, StartDeck startDeck) {
        super(score, "Robot", cardsNum, startDeck);
        isItMyTurn = false;
    }


    @Override
    public boolean Play(GameDeck gameDeck){
//        if (!gameDeck.cards.isEmpty()) {
        boolean isMatches = checkForMatches(gameDeck);
        if (isMatches) {
            checkForMatchesAndGetMatchedCards(gameDeck);
            return true;
        }else {
            Card cardForGameDeck = startDeck.drawsCard();
            if (cardForGameDeck != null) {
                gameDeck.cards.add(cardForGameDeck);
            }

            Card cardForPlayerDeck = startDeck.drawsCard();
            if (cardForPlayerDeck != null){
                playerDeck.cards.add(cardForPlayerDeck);
            }
        }
        if (!isEnemyDeckEmpty()) {
            isItMyTurn = false;
            enemy.isItMyTurn = true;
        }

        return false;
    }

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
        return super.toString();
    }
}
