import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class PlayerTest {

    private Player player;
    private Card card;
    private ArrayList<Card> hand;

    @Before
    public void before(){
        player = new Player("Eric");
        card = new Card(SuitType.DIAMONDS, RankType.QUEEN);
        hand = new ArrayList<Card>();
    }

    @Test
    public void canTakeCardFromDeck() {
        player.takeCardFromDeck(card);
        assertEquals(null, player.getHandLength());
    }

}
