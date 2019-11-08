import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class DeckTest {

    Deck deck;
    Card card1;
    Card card2;
    Card card3;
    Card card4;
    Card card5;
    ArrayList<Card> cards;

    @Before
    public void before(){
        card1 = new Card(SuitType.DIAMONDS, RankType.ACE);
        card2 = new Card(SuitType.DIAMONDS, RankType.ACE);
        card3 = new Card(SuitType.CLUBS, RankType.FIVE);
        card4 = new Card(SuitType.SPADES, RankType.TEN);
        card5 = new Card(SuitType.HEARTS, RankType.QUEEN);
        cards = new ArrayList<Card>();
        cards.add(card1);
        cards.add(card2);
        cards.add(card3);
        cards.add(card4);
        cards.add(card5);
        deck = new Deck();
    }

    @Test
    public void canAddCard() {
        deck.addCard(SuitType.DIAMONDS, RankType.ACE);
        assertEquals(1, deck.getCardsLength());
    }

    @Test
    public void canPopulateDeck() {
        deck.populateDeck();
        assertEquals(52, deck.getCardsLength());
    }

    @Test
    public void canRemoveCard() {
        deck.populateDeck();
        deck.removeCard();
        assertEquals(51, deck.getCardsLength());
    }

    @Test
    public void canShuffle() {
        deck.populateDeck();
        deck.shuffleDeck();
    }
}
