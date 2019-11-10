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

    public Card dealCardToPlayer(){
        return this.deck.remove(0);
    }

    public void dealCardToDealer(Dealer dealer){
        Card card = this.deck.remove(0);
        dealer.takeCardFromDeck(card);
    }

    public void shuffleDeck(){
        Collections.shuffle(deck);
    }

//    public void twistPlayer(Player player){
//        dealCardToPlayer(player);
//    }

    public void twistDealer(Dealer dealer){
        dealCardToDealer(dealer);
    }

}
