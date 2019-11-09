import java.util.ArrayList;
import java.util.Collections;

public class Game {

    public Player player1;
    public Dealer dealer;
    private ArrayList<Card> deck;

    public Game(){
        this.player1 = new Player("Player 1");
        this.dealer = new Dealer();
        this.deck = new ArrayList<Card>();
    }

    public void dealCards(Deck deck){
        deck.populateDeck();
        deck.shuffleDeck();
        deck.dealCardToPlayer(player1);
        deck.dealCardToDealer(dealer);
        deck.dealCardToPlayer(player1);
        deck.dealCardToDealer(dealer);
    }

//    public String getResult(){
//        String result = "";
//        if (this.player1.card.getValueFromEnum() == this.player2.card.getValueFromEnum()){
//            result = "Draw";
//        } else if (this.player2.card.getValueFromEnum() < this.player1.card.getValueFromEnum()){
//            result = "Player 1";
//        } else {
//            result = "Player 2";
//        }
//        return result;
//    }

//    public String playGame(Deck deck){
//        dealCards(deck);
//        return getResult();
//    }





}
