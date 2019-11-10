import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class DealerTest {

    private Dealer dealer;
    private Card card1;
    private Card card2;
    private Card card3;
    private ArrayList<Card> hand;

    @Before
    public void before(){
        dealer = new Dealer();
        card1 = new Card(SuitType.DIAMONDS, RankType.QUEEN);
        card2 = new Card(SuitType.DIAMONDS,RankType.TWO);
        card3 = new Card(SuitType.DIAMONDS,RankType.ACE);
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

    @Test
    public void CheckIsBustTrue() {
        dealer.takeCardFromDeck(card1);
        dealer.takeCardFromDeck(card1);
        dealer.takeCardFromDeck(card2);
        assertEquals(true, dealer.isBust());
    }

    @Test
    public void checkIsBustFalse() {
        dealer.takeCardFromDeck(card1);
        dealer.takeCardFromDeck(card2);
        assertEquals(false, dealer.isBust());
    }

    @Test
    public void checkIsBust21() {
        dealer.takeCardFromDeck(card1);
        dealer.takeCardFromDeck(card1);
        dealer.takeCardFromDeck(card3);
        assertEquals(false, dealer.isBust());
    }

    @Test
    public void hasBlackJackTrue() {
        dealer.takeCardFromDeck(card1);
        dealer.takeCardFromDeck(card3);
        assertEquals(true, dealer.hasBlackJack());
    }

    @Test
    public void hasBlackJackFalse() {
        dealer.takeCardFromDeck(card1);
        dealer.takeCardFromDeck(card1);
        assertEquals(false, dealer.hasBlackJack());
    }

    @Test
    public void canShowFirstCardValue() {
        dealer.takeCardFromDeck(card2);
        dealer.takeCardFromDeck(card3);
        assertEquals(2, dealer.showFirstCardValue());

    }
}
