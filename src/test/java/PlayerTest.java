import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class PlayerTest {

    private Player player;
    private Card card1;
    private Card card2;
    private ArrayList<Card> hand;
    private Deck deck;

    @Before
    public void before(){
        player = new Player("Eric");
        card1 = new Card(SuitType.DIAMONDS, RankType.QUEEN);
        card2 = new Card(SuitType.HEARTS, RankType.ACE);
        hand = new ArrayList<Card>();
        deck = new Deck();
    }

    @Test
    public void canTakeCardFromDeck() {
        deck.populateDeck();
        player.takeCardFromDeck(deck);
        assertEquals(1, player.getHandLength());
    }

    @Test
    public void canAddUpHand() {
        deck.populateDeck();
        player.takeCardFromDeck(deck);
        player.takeCardFromDeck(deck);
        assertNotEquals(null, player.addUpHand());
    }

    @Test
    public void hasBlackJackTrue() {
        deck.populateDeck();
        deck.shuffleDeck();
        player.takeCardFromDeck(deck);
        player.takeCardFromDeck(deck);
        assertEquals(true, player.hasBlackJack());
    }

    @Test
    public void hasBlackJackFalse() {
        deck.populateDeck();
        deck.shuffleDeck();
        player.takeCardFromDeck(deck);
        player.takeCardFromDeck(deck);
        assertEquals(false, player.hasBlackJack());
    }

    @Test
    public void testHandValueUnder16True() {
        deck.populateDeck();
        deck.shuffleDeck();
        player.takeCardFromDeck(deck);
        player.takeCardFromDeck(deck);
        assertEquals(true, player.handValueUnder16());
    }

    @Test
    public void testHandValueUnder16False() {
        deck.populateDeck();
        deck.shuffleDeck();
        player.takeCardFromDeck(deck);
        player.takeCardFromDeck(deck);
        assertEquals(false, player.handValueUnder16());
    }

    @Test
    public void canTakeTurn() {
        deck.populateDeck();
        deck.shuffleDeck();
        player.takeCardFromDeck(deck);
        player.takeTurn(deck);
        assertEquals(3, player.getHandLength());
    }
}
