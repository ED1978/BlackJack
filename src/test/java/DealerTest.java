import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class DealerTest {

    private Dealer dealer;
    private Card card;
    private ArrayList<Card> hand;

    @Before
    public void before(){
        dealer = new Dealer();
        card = new Card(SuitType.DIAMONDS, RankType.QUEEN);
        hand = new ArrayList<Card>();
    }

    @Test
    public void hasName() {
        assertEquals("Dealer", dealer.getName());
    }

    @Test
    public void canTakeCardFromDeck() {
        dealer.takeCardFromDeck(card);
        assertEquals(1, dealer.getHandSize());
    }
}
