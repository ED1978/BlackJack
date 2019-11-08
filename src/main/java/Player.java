public class Player {

    public String name;
    public Card card;

    public Player(String name){
        this.name = name;
        this.card = card;
    }

    public Card getCard(){
        return this.card;
    }

    public void takeCardFromDeck(Card card){
        this.card = card;
    }



}
