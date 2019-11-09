import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class DeckTest {

    Deck deck;
    Player player1;
    Dealer dealer;

    @Before
    public void before(){
        deck = new Deck();
        player1 = new Player("Player 1");
        dealer = new Dealer();
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
    public void canDealCardToPlayer() {
        deck.populateDeck();
        deck.dealCardToPlayer(player1);
        assertEquals(1, player1.getHandLength());
    }

    @Test
    public void canDealCardToDealer() {
        deck.populateDeck();
        deck.dealCardToDealer(dealer);
        assertEquals(1, dealer.getHandSize());
    }
}
