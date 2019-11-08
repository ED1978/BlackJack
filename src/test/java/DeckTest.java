import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class DeckTest {

    Deck deck;
    Player player1;

    @Before
    public void before(){
        deck = new Deck();
        player1 = new Player("Player 1");
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
        deck.dealCard(player1);
        assertEquals(51, deck.getCardsLength());
    }

}
