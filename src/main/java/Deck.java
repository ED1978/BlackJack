import java.util.ArrayList;
import java.util.Collections;

public class Deck {

    private ArrayList<Card> deck;

    public Deck(){
        this.deck = new ArrayList<Card>();
    }

    public int getCardsLength(){
        return this.deck.size();
    }

    public void addCard(SuitType suite, RankType rank){
        Card cardToAdd = new Card(suite, rank);
        this.deck.add(cardToAdd);
    }

    public void populateDeck(){
        for(SuitType suit : SuitType.values()){
            for(RankType rank : RankType.values()){
                addCard(suit, rank);
            }
        }
    }

    public void dealCardToPlayer(Player player){
        Card card =  this.deck.remove(0);
        player.takeCardFromDeck(card);
    }

    public void dealCardToDealer(Dealer dealer){
        Card card = this.deck.remove(0);
        dealer.takeCardFromDeck(card);
    }

    public void shuffleDeck(){
        Collections.shuffle(deck);
    }

}
