import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

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
        player1.takeCardFromDeck(deck);
        dealer.takeCardFromDeck(deck);
        player1.takeCardFromDeck(deck);
        dealer.takeCardFromDeck(deck);
    }


    public String getResult(){
        String result = isBust();

        if (result == null){
            result = blackJack();
        }

        if(result == null){
            result = declareWinner();
        }

        return result;
    }

    public String blackJack(){
        String blackJack = null;
        if(dealer.hasBlackJack() == false && player1.hasBlackJack() == true){
            blackJack = "BLACKJACK!! Player wins.";
        } else if(dealer.hasBlackJack() == true){
            blackJack = "BLACKJACK!! Dealer wins.";
        }
        return blackJack;
    }

    public String declareWinner(){
        String winner = null;
        if (this.player1.addUpHand() > this.dealer.addUpHand()){
           winner = "Player wins";
        } else if (this.player1.addUpHand() < this.dealer.addUpHand()) {
            winner = "Dealer wins";
        } else {
            winner = "Draw!  Dealer wins";
        }
        return winner;
    }

    public String isBust(){
        String result = null;
        if (player1.isBust() == true && dealer.isBust() == true) {
            result =  "Both Bust, Dealer Wins!";
        } else if (player1.isBust() == true && dealer.isBust() == false){
            result =  "Player Bust, Dealer Wins!";
        } else if (player1.isBust() == false && dealer.isBust() ==true){
            result =  "Dealer Bust, Player Wins!";
        }
        return result;
    }

    public String playGame(Deck deck) throws IOException {
        dealCards(deck);
        System.out.println("Player's hand total = " + player1.addUpHand());
        System.out.println("Dealer's hand total = " + dealer.addUpHand());
        playerTurn(deck);
//        System.out.println("Player's hand total = " + player1.addUpHand());
        String result = getResult();
        System.out.println(result);
        return result;
    }

    public void playerTurn(Deck deck){
        player1.takeTurn(deck);
        if(player1.isBust() == true){
            getResult();
        } else {
            System.out.println("Player Sticks");
        }
    }



//    public String getUserInput(){
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Player: press T to TWIST or S to STICK");
//        String twistOrStick = scanner.nextLine();
//        return twistOrStick;
//    }







}
