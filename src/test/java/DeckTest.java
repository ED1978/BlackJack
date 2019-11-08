import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class DeckTest {

    Deck deck;
    Card card1;
    Card card2;
    ArrayList<Card> cards;

    @Before
    public void before(){
        deck = new Deck();
    }

    @Test
    public void canAddCard() {
        deck.addCard(SuitType.DIAMONDS, RankType.ACE);
        assertEquals(1, deck.getCards());
    }

    @Test
    public void canPopulateDeck() {
        deck.populateDeck();
        assertEquals(52, deck.getCards());
    }
}
