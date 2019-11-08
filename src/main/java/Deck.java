import java.util.ArrayList;

public class Deck {

    private ArrayList<Card> cards;
    private Card card;

    public Deck(){
        this.cards = new ArrayList<Card>();
        this.card = card;
    }

    public int getCardsLength(){
        return this.cards.size();
    }

    public void addCard(SuitType suite, RankType rank){
        Card cardToAdd = new Card(suite, rank);
        this.cards.add(cardToAdd);
    }

    public void populateDeck(){
        for(SuitType suit : SuitType.values()){
            for(RankType rank : RankType.values()){
                addCard(suit, rank);
            }
        }
    }

    public Card removeCard(){
        return this.cards.remove(0);
    }

}
