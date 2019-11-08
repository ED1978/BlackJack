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
        card1 = new Card(SuitType.DIAMONDS, RankType.FIVE);
        card2 = new Card(SuitType.HEARTS, RankType.KING);
        cards = new ArrayList<Card>();
        cards.add(card1);
        deck = new Deck(cards);
    }

    @Test
    public void canAddCard() {
        deck.addCard(SuitType.DIAMONDS, RankType.ACE);
        assertEquals(2, deck.getCards());
    }

    @Test
    public void canPopulateDeck() {
        deck.populateDeck();
        assertEquals(53, deck.getCards());
    }
}
