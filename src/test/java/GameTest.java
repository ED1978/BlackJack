import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
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

//    @Test
//    public void getResultPlayerWins() {
//        deck.populateDeck();
//        deck.shuffleDeck();
//        game.player1.takeCardFromDeck(deck);
//        game.player1.takeCardFromDeck(deck);
//        game.dealer.takeCardFromDeck(card2);
//        game.dealer.takeCardFromDeck(card2);
//        assertEquals("Player wins", game.getResult());
//    }
//
//    @Test
//    public void getResultDealerWins() {
//        deck.populateDeck();
//        deck.shuffleDeck();
//        game.player1.takeCardFromDeck(deck);
//        game.player1.takeCardFromDeck(deck);
//        game.dealer.takeCardFromDeck(card1);
//        game.dealer.takeCardFromDeck(card1);
//        assertEquals("Dealer wins", game.getResult());
//    }

//    @Test
//    public void gameBustPlayer() {
//        deck.populateDeck();
//        deck.shuffleDeck();
//        game.player1.takeCardFromDeck(deck);
//        game.player1.takeCardFromDeck(deck);
//        game.player1.takeCardFromDeck(deck);
//        assertEquals("Player Bust, Dealer Wins!", game.isBust());
//    }

//    @Test
//    public void gameBustBoth() {
//        deck.populateDeck();
//        deck.shuffleDeck();
//        game.player1.takeCardFromDeck(deck);
//        game.player1.takeCardFromDeck(deck);
//        game.player1.takeCardFromDeck(deck);
//        game.dealer.takeCardFromDeck(card1);
//        game.dealer.takeCardFromDeck(card1);
//        game.dealer.takeCardFromDeck(card1);
//        assertEquals("Both Bust, Dealer Wins!", game.isBust());
//    }

//    @Test
//    public void gameBustNone() {
//        deck.populateDeck();
//        deck.shuffleDeck();
//        game.player1.takeCardFromDeck(deck);
//        game.player1.takeCardFromDeck(deck);
//        game.dealer.takeCardFromDeck(card1);
//        game.dealer.takeCardFromDeck(card1);
//        assertEquals(null, game.isBust());
//    }
//
//    @Test
//    public void testBlackJackDealer() {
//        deck.populateDeck();
//        deck.shuffleDeck();
//        game.player1.takeCardFromDeck(deck);
//        game.player1.takeCardFromDeck(deck);
//        game.dealer.takeCardFromDeck(card1);
//        game.dealer.takeCardFromDeck(card2);
//        assertEquals("BLACKJACK!! Dealer wins.", game.blackJack());
//    }

//    @Test
//    public void testBlackJackPlayer() {
//        deck.populateDeck();
//        deck.shuffleDeck();
//        game.player1.takeCardFromDeck(deck);
//        game.player1.takeCardFromDeck(deck);
//        game.dealer.takeCardFromDeck(card1);
//        game.dealer.takeCardFromDeck(card1);
//        assertEquals("BLACKJACK!! Player wins.", game.blackJack());
//    }
//
//    @Test
//    public void testBlackJackBoth() {
//        deck.populateDeck();
//        deck.shuffleDeck();
//        game.player1.takeCardFromDeck(deck);
//        game.player1.takeCardFromDeck(deck);
//        game.dealer.takeCardFromDeck(card1);
//        game.dealer.takeCardFromDeck(card2);
//        assertEquals("BLACKJACK!! Dealer wins.", game.blackJack());
//    }

//    @Test
//    public void testBlackJackNone() {
//        deck.populateDeck();
//        deck.shuffleDeck();
//        game.player1.takeCardFromDeck(deck);
//        game.player1.takeCardFromDeck(deck);
//        game.dealer.takeCardFromDeck(card1);
//        game.dealer.takeCardFromDeck(card1);
//        assertEquals(null, game.blackJack());
//    }


    @Test
    public void canPlayGame() throws IOException {
        assertEquals("Dealer wins", game.playGame(deck));
    }

//    @Test
//    public void canGetUserInput() {
//        assertEquals("t", game.getUserInput());
//    }
}
