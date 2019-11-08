import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class GameTest {

    private Game game;
    private Deck deck;

    @Before
    public void before(){
        game = new Game();
        deck = new Deck();
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

    @Test
    public void canPlayGame() {
        assertEquals("Draw", game.playGame(deck));
    }
}
