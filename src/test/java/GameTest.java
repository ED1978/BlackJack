import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class GameTest {

    private Game game;
    private Deck deck;
    private Dealer dealer;

    @Before
    public void before(){
        game = new Game();
        deck = new Deck();
        dealer = new Dealer();
    }

    @Test
    public void canDealCardsPopulatesDeck() {
        game.dealCards(deck);
        assertEquals(48, deck.getCardsLength());
    }

    @Test
    public void canDealCardToPlayer1() {
        game.dealCards(deck);
        assertEquals(48, deck.getCardsLength());
    }

    @Test
    public void canDeal2CardsToBothPlayersPlayer() {
        game.dealCards(deck);
        int result = game.player1.getHandLength();
        assertEquals(2, result );
    }

    @Test
    public void canDeal2CardsToBothPlayerDealer() {
        game.dealCards(deck);
        assertEquals(2, game.dealer.getHandSize());
    }

    //    @Test
//    public void canPlayGame() {
//        assertEquals("Draw", game.playGame(deck));
//    }
}
