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
            total += card.getValue();
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
        if(addUpHand() == 11 && getHandSize() == 2 && handHasCardValue10()){
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
                updateAceValues();
                sysOutCardString();
                System.out.println("");
            }
        }
    }

    public SuitType getCardSuit(Card card){
        return card.getSuit();
    }

    public RankType getCardRank(Card card){
        return card.getRank();
    }

    public void sysOutCardString(){
        String cardStringToPrint = buildCardString();
        System.out.println(cardStringToPrint);
    }

    public String buildCardString(){
        String cardString = "Dealer's hand:";
        for (Card card : hand){
            cardString += " [" + card.getRank();
            cardString += " of ";
            cardString += card.getSuit() + "].";
        }
        return cardString;
    }

    public Card getFirstCardInHand(){
        Card card = this.hand.get(0);
        return card;
    }

    public String buildFirstHandString(){
        Card card = getFirstCardInHand();
        String firstHandString = "Dealer's hand:";
        firstHandString += " [" + card.getRank();
        firstHandString += " of ";
        firstHandString += card.getSuit() + "].";
        firstHandString +=  " [ ? of ? ].";
        return firstHandString;
    }

    public void sysOutFirstHandString(){
        String firstHandToPrint = buildFirstHandString();
        System.out.println(firstHandToPrint);
    }

    public Boolean handHasCardValue10(){
        Boolean value10 = false;
        for(Card card : hand){
            if(card.getValueFromEnum() == 10){
                value10 = true;
            }
        }
        return value10;
    }

    public int getDealerTotal(){
        int dealerTotal = 0;
        if(hasBlackJack()){
            dealerTotal = 21;
        } else {
            dealerTotal = addUpHand();
        }
        return dealerTotal;
    }

    public void updateAceValues(){
        for (Card card : hand){
            if (card.getRank() == RankType.ACE && addUpHand() < 12){
                card.updateValue(11);
            } else if (card.getRank() == RankType.ACE  && addUpHand() > 11){
                card.updateValue(1);
            }
        }
    }

}
