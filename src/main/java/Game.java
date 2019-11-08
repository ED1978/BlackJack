public class Game {

    public Player player1;
    public Player player2;
    private Deck deck;
//    private Card card;

    public Game(){
        this.player1 = new Player("Player 1");
        this.player2 = new Player("Player 2");
        this.deck = new Deck();
    }

    public String getPlayer1Name(){
        return this.player1.name;
    }

    public String getPlayer2Name(){
        return this.player2.name;
    }

    public void dealCards(Deck deck){
        deck.populateDeck();
        this.player1.takeCardFromDeck(deck);
        this.player2.takeCardFromDeck(deck);
    }

}
