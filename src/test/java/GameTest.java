import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class GameTest {

    private Game game;
    private Deck deck;
    private Dealer dealer;
    private Player player;
    private Card card1;
    private Card card2;

    @Before
    public void before(){
        game = new Game();
        deck = new Deck();
        dealer = new Dealer();
        player = new Player("Eric");
        card1 = new Card(SuitType.DIAMONDS, RankType.QUEEN);
        card2 = new Card(SuitType.DIAMONDS, RankType.ACE);
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

    @Test
    public void getResultPlayerWins() {
        game.player1.takeCardFromDeck(card1);
        game.player1.takeCardFromDeck(card1);
        game.dealer.takeCardFromDeck(card2);
        game.dealer.takeCardFromDeck(card2);
        assertEquals("Player 1 wins", game.getResult());
    }

    @Test
    public void getResultDealerWins() {
        game.player1.takeCardFromDeck(card2);
        game.player1.takeCardFromDeck(card2);
        game.dealer.takeCardFromDeck(card1);
        game.dealer.takeCardFromDeck(card1);
        assertEquals("Dealer wins", game.getResult());
    }

    @Test
    public void gameBustPlayer() {
        game.player1.takeCardFromDeck(card1);
        game.player1.takeCardFromDeck(card1);
        game.player1.takeCardFromDeck(card1);
        assertEquals("Player Bust, Dealer Wins!", game.isBust());
    }

    @Test
    public void gameBustBoth() {
        game.player1.takeCardFromDeck(card1);
        game.player1.takeCardFromDeck(card1);
        game.player1.takeCardFromDeck(card1);
        game.dealer.takeCardFromDeck(card1);
        game.dealer.takeCardFromDeck(card1);
        game.dealer.takeCardFromDeck(card1);
        assertEquals("Both Bust, Dealer Wins!", game.isBust());
    }

    @Test
    public void gameBustNone() {
        game.player1.takeCardFromDeck(card1);
        game.player1.takeCardFromDeck(card1);
        game.dealer.takeCardFromDeck(card1);
        game.dealer.takeCardFromDeck(card1);
        assertEquals(null, game.isBust());
    }

    @Test
    public void testBlackJackDealer() {
        game.player1.takeCardFromDeck(card1);
        game.player1.takeCardFromDeck(card1);
        game.dealer.takeCardFromDeck(card1);
        game.dealer.takeCardFromDeck(card2);
        assertEquals("BLACKJACK!! Dealer wins.", game.blackJack());
    }

    @Test
    public void testBlackJackPlayer() {
        game.player1.takeCardFromDeck(card1);
        game.player1.takeCardFromDeck(card2);
        game.dealer.takeCardFromDeck(card1);
        game.dealer.takeCardFromDeck(card1);
        assertEquals("BLACKJACK!! Player wins.", game.blackJack());
    }

    @Test
    public void testBlackJackBoth() {
        game.player1.takeCardFromDeck(card1);
        game.player1.takeCardFromDeck(card2);
        game.dealer.takeCardFromDeck(card1);
        game.dealer.takeCardFromDeck(card2);
        assertEquals("BLACKJACK!! Dealer wins.", game.blackJack());
    }

    @Test
    public void testBlackJackNone() {
        game.player1.takeCardFromDeck(card1);
        game.player1.takeCardFromDeck(card1);
        game.dealer.takeCardFromDeck(card1);
        game.dealer.takeCardFromDeck(card1);
        assertEquals(null, game.blackJack());
    }

//    @Test
//    public void canPlayGame() {
//        assertEquals("Dealer wins", game.playGame(deck));
//    }

}
