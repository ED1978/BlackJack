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
        System.out.println(result);
        return result;
    }

    public String blackJack(){
        String blackJack = null;
        if(dealer.hasBlackJack() == false && player1.hasBlackJack() == true){
            blackJack = "Player wins.";
        } else if(dealer.hasBlackJack() == true){
            blackJack = "Dealer wins.";
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
            result =  "Dealer Wins!";
        } else if (player1.isBust() == true && dealer.isBust() == false){
            result =  "Dealer Wins!";
        } else if (player1.isBust() == false && dealer.isBust() ==true){
            result =  "Player Wins!";
        }
        return result;
    }

    public void playGame(Deck deck) throws IOException {
        dealCards(deck);

        outputFirstDeal();

        Boolean gameOver = playerTurn(deck);

        dealerTurn(deck, gameOver);


        outputFinalTotals();

        getResult();

    }

    public Boolean playerTurn(Deck deck){
        Boolean gameOver = false;
        System.out.println("PLAYER'S TURN:");
        System.out.println("");
        if (player1.hasBlackJack() == false){
            player1.takeTurn(deck);
            if(player1.isBust() == false) {
                System.out.println("Player Sticks");
            } else {
                System.out.println("Player Bust");
                System.out.println("");
                dealer.sysOutCardString();
                gameOver = true;
            }
        } else {
            gameOver = true;
            System.out.println("BLACKJACK!!!");
        }
        return gameOver;
    }

    public void dealerTurn(Deck deck, Boolean gameOver){
        if(gameOver == false){
            System.out.println("");
            System.out.println("DEALER'S TURN");
            System.out.println("");
            dealer.sysOutCardString();
            System.out.println("");
            if(dealer.hasBlackJack() == false){
                dealer.takeTurn(deck);
                if(dealer.isBust() == false){
                    System.out.println("Dealer Sticks");
                } else {
                    System.out.println("Dealer Bust");
                }
            } else {
                System.out.println("BLACKJACK!!!");
            }
        }

    }

    public void outputFirstDeal(){
        System.out.println("Dealing cards...");
        System.out.println("");
        player1.sysOutCardString();
        dealer.sysOutFirstHandString();
        System.out.println("");
    }

    public void outputFinalTotals(){
        System.out.println("");
        int finalPlayerTotal = player1.getPlayerTotal();
        System.out.println("Player's hand total = " + finalPlayerTotal);
        int finalDealerTotal = dealer.getDealerTotal();
        System.out.println("Dealer's hand total = " + finalDealerTotal);
        System.out.println("");
    }




//    public String getUserInput(){
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Player: press T to TWIST or S to STICK");
//        String twistOrStick = scanner.nextLine();
//        return twistOrStick;
//    }







}
