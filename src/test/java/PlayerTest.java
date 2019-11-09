import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class PlayerTest {

    private Player player;
    private Card card1;
    private Card card2;
    private ArrayList<Card> hand;

    @Before
    public void before(){
        player = new Player("Eric");
        card1 = new Card(SuitType.DIAMONDS, RankType.QUEEN);
        card2 = new Card(SuitType.HEARTS, RankType.TWO);
        hand = new ArrayList<Card>();
    }

    @Test
    public void canTakeCardFromDeck() {
        player.takeCardFromDeck(card1);
        assertEquals(1, player.getHandLength());
    }

    @Test
    public void canAddUpHand() {
        player.takeCardFromDeck(card1);
        player.takeCardFromDeck(card2);
        assertEquals(12, player.addUpHand());
    }
}
