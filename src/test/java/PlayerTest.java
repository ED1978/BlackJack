import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class PlayerTest {

    private Player player;
    private Deck deck;
    private Card card;

    @Before
    public void before(){
        player = new Player("Eric");
        deck = new Deck();
    }

    @Test
    public void canGetCard() {
        assertEquals(null, player.getCard());
    }

//    @Test
//    public void canTakeCardFromDeck() {
//        deck.populateDeck();
//        player.takeCardFromDeck(deck);
//        assertEquals(null, player.getCard());
//    }
}
