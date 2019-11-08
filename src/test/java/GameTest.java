import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class GameTest {

    private Game game;
    private Player player1;
    private Player player2;
    private Deck deck;
    private Card card1;
    private Card card2;
    private Card card3;

    @Before
    public void before(){
        game = new Game();
        player1 = new Player("Player 1");
        player2 = new Player("Player 2");
        card1 = new Card(SuitType.DIAMONDS, RankType.ACE);
        card2 = new Card(SuitType.DIAMONDS, RankType.TWO);
        card3 = new Card(SuitType.HEARTS, RankType.ACE);
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

    @Test
    public void canPlayGame() {
        assertEquals("Draw", game.playGame(deck));
    }
}
