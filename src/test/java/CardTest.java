import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CardTest {

    Card card;
    Card card1;

    @Before
    public void before(){
        card = new Card(SuitType.HEARTS, RankType.ACE);
        card1 = new Card(SuitType.DIAMONDS, RankType.FIVE);
    }

    @Test
    public void canGetSuit() {
        assertEquals(SuitType.HEARTS, card.getSuit());
    }

    @Test
    public void canGetRank() {
        assertEquals(RankType.ACE, card.getRank());
    }

    @Test
    public void aceHasValue1() {
        assertEquals(1, card.getValueFromEnum());
    }

    @Test
    public void cardHasValue() {
        assertEquals(5, card1.getValue());
    }

    @Test
    public void canUpdateValue() {
        card1.updateValue(2);
        assertEquals(2, card1.getValue());
    }
}
