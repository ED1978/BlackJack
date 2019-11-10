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
    private Deck deck;

    @Before
    public void before(){
        dealer = new Dealer();
        card1 = new Card(SuitType.DIAMONDS, RankType.QUEEN);
        card2 = new Card(SuitType.DIAMONDS,RankType.TWO);
        card3 = new Card(SuitType.DIAMONDS,RankType.ACE);
        hand = new ArrayList<Card>();
        deck = new Deck();
    }

    @Test
    public void hasName() {
        assertEquals("Dealer", dealer.getName());
    }

    @Test
    public void canTakeCardFromDeck() {
        deck.populateDeck();
        deck.shuffleDeck();
        dealer.takeCardFromDeck(deck);
        assertEquals(1, dealer.getHandSize());
    }

    @Test
    public void canAddUpHand() {
        deck.populateDeck();
        deck.shuffleDeck();
        dealer.takeCardFromDeck(deck);
        dealer.takeCardFromDeck(deck);
        assertEquals(12, dealer.addUpHand());
    }

    @Test
    public void CheckIsBustTrue() {
        deck.populateDeck();
        deck.shuffleDeck();
        dealer.takeCardFromDeck(deck);
        dealer.takeCardFromDeck(deck);
        dealer.takeCardFromDeck(deck);
        assertEquals(true, dealer.isBust());
    }

    @Test
    public void checkIsBustFalse() {
        deck.populateDeck();
        deck.shuffleDeck();
        dealer.takeCardFromDeck(deck);
        dealer.takeCardFromDeck(deck);
        assertEquals(false, dealer.isBust());
    }

    @Test
    public void checkIsBust21() {
        deck.populateDeck();
        deck.shuffleDeck();
        dealer.takeCardFromDeck(deck);
        dealer.takeCardFromDeck(deck);
        dealer.takeCardFromDeck(deck);
        assertEquals(false, dealer.isBust());
    }

    @Test
    public void hasBlackJackTrue() {
        deck.populateDeck();
        deck.shuffleDeck();
        dealer.takeCardFromDeck(deck);
        dealer.takeCardFromDeck(deck);
        assertEquals(true, dealer.hasBlackJack());
    }

    @Test
    public void hasBlackJackFalse() {
        deck.populateDeck();
        deck.shuffleDeck();
        dealer.takeCardFromDeck(deck);
        dealer.takeCardFromDeck(deck);
        assertEquals(false, dealer.hasBlackJack());
    }

    @Test
    public void canShowFirstCardValue() {
        deck.populateDeck();
        deck.shuffleDeck();
        dealer.takeCardFromDeck(deck);
        dealer.takeCardFromDeck(deck);
        assertEquals(2, dealer.showFirstCardValue());

    }

    @Test
    public void canTakeTurn() {
        deck.populateDeck();
        deck.shuffleDeck();
        dealer.takeCardFromDeck(deck);
        dealer.takeTurn(deck);
        assertEquals(3, dealer.getHandSize());
    }

    @Test
    public void canGetCardSuit() {
        assertEquals(SuitType.DIAMONDS, dealer.getCardSuit(card1));
    }

    @Test
    public void canGetCardRank() {
        assertEquals(RankType.QUEEN, dealer.getCardRank(card1));
    }

    @Test
    public void canBuildCardString() {
        deck.populateDeck();
        dealer.takeCardFromDeck(deck);
        dealer.takeCardFromDeck(deck);
        dealer.takeCardFromDeck(deck);
        assertEquals("Dealer's hand: [ACE of HEARTS]. [TWO of HEARTS]. [THREE of HEARTS].", dealer.buildCardString());
    }

    @Test
    public void canSysOutCardString() {
        deck.populateDeck();
        dealer.takeCardFromDeck(deck);
        dealer.takeCardFromDeck(deck);
        dealer.takeCardFromDeck(deck);
        dealer.sysOutCardString();
    }

    @Test
    public void canBuildFirstHandString() {
        deck.populateDeck();
        dealer.takeCardFromDeck(deck);
        dealer.takeCardFromDeck(deck);
        assertEquals("Dealer's hand: [ACE of HEARTS]. [ ? of ? ].", dealer.buildFirstHandString());
    }

    @Test
    public void canSysOutFirstHandString() {
        deck.populateDeck();
        dealer.takeCardFromDeck(deck);
        dealer.takeCardFromDeck(deck);
        dealer.takeCardFromDeck(deck);
        dealer.sysOutFirstHandString();
    }
}
