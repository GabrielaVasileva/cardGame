package gabriela.vasileva;

public class Game {
    private StartDeck startDeck;
    private GameDeck gameDeck;
    private Hero hero;
    private Robot robot;

    public Game() {
        this.startDeck = new StartDeck();
        this.gameDeck = new GameDeck(startDeck, 4);

        this.hero = new Hero(0, "Pesho", 4, this.startDeck);
        this.robot = new Robot(0, 4, this.startDeck);
        this.hero.setEnemy(this.robot);
        this.robot.setEnemy(this.hero);
        startPlaying();
    }

    public void startPlaying() {
        System.out.println("STAR");

        while (true) {
            if (this.startDeck.cards.isEmpty()
                    && !hero.checkForMatches(gameDeck)
                    && !robot.checkForMatches(gameDeck)) {
                break;
            }

            if (this.gameDeck.cards.isEmpty()) {
                if (!this.startDeck.cards.isEmpty()) {
                    int n = 4;
                    while (!this.startDeck.cards.isEmpty() || n-- > 0) {
                        this.gameDeck.cards.add(this.startDeck.drawsCard());
                    }
                } else {
                    System.out.println("GAME END");
                    break;
                }
            }

            if (this.hero.isItMyTurn) {
                boolean play = this.hero.Play(gameDeck);
                System.out.println(hero);
            } else if (this.robot.isItMyTurn) {
                boolean play = this.robot.Play(this.gameDeck);
                System.out.println(robot);
            }

            System.out.println(gameDeck);
        }
        System.out.println("GAME END");
    }
}
