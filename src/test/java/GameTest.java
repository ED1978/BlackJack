import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GameTest {

    private Game game;
    private Deck deck;
//    private Player player;
//    private Player player2;

    @Before
    public void before(){
        game = new Game();
        deck = new Deck();
//        player = new Player ("Player 1");
    }

    @Test
    public void canGetPlayer1Name() {
        assertEquals("Player 1", game.getPlayer1Name());
    }

    @Test
    public void canGetPlayer2Name() {
        assertEquals("Player 2", game.getPlayer2Name());
    }

    @Test
    public void canDealCardsPopulatesDeck() {
        game.dealCards(deck);
        assertEquals(50, deck.getCardsLength());
    }

    @Test
    public void canDealCardToPlayer1() {
        game.dealCards(deck);
        assertEquals(50, deck.getCardsLength());
    }

    @Test
    public void canDealACardToBothPlayers() {
        game.dealCards(deck);
        assertEquals(50, deck.getCardsLength());
    }

//    @Test
////    public void checkPlayer2Card() {
////        game.dealCards(deck);
////        assertEquals(null, game.player2.getCard());
////    }

    @Test
    public void name() {
    }
}
