import java.util.ArrayList;

public class Player {

    public String name;
    public ArrayList<Card> hand;

    public Player(String name){
        this.name = name;
        this.hand = new ArrayList<Card>();
    }

    public int getHandLength(){
        return this.hand.size();
    }

    public void takeCardFromDeck(Card card){
        this.hand.add(card);
    }



}
