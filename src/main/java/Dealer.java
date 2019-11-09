import java.util.ArrayList;

public class Dealer {

    private String name;
    private ArrayList<Card> hand;

    public Dealer(){
        this.name = "Dealer";
        this.hand = new ArrayList<Card>();
    }

    public String getName(){
        return this.name;
    }

    public int getHandSize(){
        return this.hand.size();
    }

    public void takeCardFromDeck(Card card){
        this.hand.add(card);
    }

}
