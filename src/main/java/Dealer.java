import java.util.ArrayList;

public class Dealer {

    private String name;
    public ArrayList<Card> hand;

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
        if(addUpHand() == 11 && getHandSize() == 2){
            result = true;
        }
        return result;
    }

    public int showFirstCardValue(){
        Card card = hand.get(0);
        return card.getValueFromEnum();
    }

    public Boolean handValueUnder16(){
        if (addUpHand() < 16){
            return true;
        } else {
            return false;
        }
    }

    public void takeTurn(Deck deck){
        if (handValueUnder16()){
            while (addUpHand() < 16){
                System.out.println("Dealer Twists");
                takeCardFromDeck(deck);
                System.out.println("Dealer's hand total = " + addUpHand());
            }
        }
    }

}
