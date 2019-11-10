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

    public void takeCardFromDeck(Deck deck){
        Card card = deck.dealCard();
        this.hand.add(card);
    }

    public int addUpHand(){
        int total = 0;
        for (Card card : hand){
            total += card.getValueFromEnum();
        }
        return total;
    }

    public Boolean isBust(){
        if (addUpHand() <= 21){
            return false;
        } else {
            return true;
        }
    }

    public Boolean hasBlackJack(){
        Boolean result = false;
        if (getHandLength() == 2 && addUpHand() == 11){
            result = true;
        }
        return result;
    }

    public Boolean handValueUnder16(){
        if (addUpHand() < 16){
            return true;
        } else {
            return false;
        }
    }

    public void takeTurn(Deck deck){
            if(handValueUnder16()){
                while (addUpHand() < 16){
                    System.out.println("Player Twists");
                    takeCardFromDeck(deck);
                    System.out.println("Player's hand total = " + addUpHand());
                }
            }
    }
}
