import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class DealerTest {

    private Dealer dealer;
    private Card card1;
    private Card card2;
    private ArrayList<Card> hand;

    @Before
    public void before(){
        dealer = new Dealer();
        card1 = new Card(SuitType.DIAMONDS, RankType.QUEEN);
        card2 = new Card(SuitType.DIAMONDS,RankType.TWO);
        hand = new ArrayList<Card>();
    }

    @Test
    public void hasName() {
        assertEquals("Dealer", dealer.getName());
    }

    @Test
    public void canTakeCardFromDeck() {
        dealer.takeCardFromDeck(card1);
        assertEquals(1, dealer.getHandSize());
    }

    @Test
    public void canAddUpHand() {
        dealer.takeCardFromDeck(card1);
        dealer.takeCardFromDeck(card2);
        assertEquals(12, dealer.addUpHand());
    }
}
