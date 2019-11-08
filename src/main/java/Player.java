public class Player {

    public String name;
    private Card card;

    public Player(String name){
        this.name = name;
        this.card = card;
    }

    public Card getCard(){
        return this.card;
    }

    public void takeCardFromDeck(Deck deck){
        Card card = deck.removeCard();
        this.card = card;
    }



}
