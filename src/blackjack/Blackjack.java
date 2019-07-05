package blackjack;

import java.util.Scanner;

public class Blackjack {
    public static void main(String[] args) {
        
        System.out.println("Welcome to Blackjack!");
        
        //Create playing deck
        Deck playingDeck = new Deck();
        playingDeck.createFullDeck();
        playingDeck.shuffle();
        
        //Create a deck for the player
        Deck playerDeck = new Deck();
        
        //Create a deck for the dealer 
        Deck dealerDeck = new Deck();
        
        double playerMoney = 100.00;
        
        Scanner userInput = new Scanner(System.in);
        
        //Gaming logic
        while(playerMoney > 0){
            //Game in progress
            System.out.println("You have " + playerMoney + ", how much would you like to bet?");
            double playerBet = userInput.nextDouble();
            if(playerBet > playerMoney){
                System.out.println("You can't bet that amount");
                break;
            }
            
            //Start dealing cards 
            playerDeck.draw(playingDeck);
            playerDeck.draw(playingDeck);
            
            dealerDeck.draw(playingDeck);
            dealerDeck.draw(playingDeck);
            
            while(true){
                
                //Player's hand
                System.out.println("Your hand: ");
                System.out.println(playerDeck.toString());
                System.out.println("Your deck has a value of: " + playerDeck.cardsValue());
                
                //Dealer's hand
                System.out.println("Dealer hand: " + dealerDeck.getCard(0).toString() + " and [Hidden]");
                
                System.out.println("Would you like to Hit(1) or Stand(2)");
                int response = userInput.nextInt();
                
                if(response == 1){
                    playerDeck.draw(playingDeck);
                    System.out.println("You draw a: " + playerDeck.getCard(playerDeck.deckSize()-1).toString());
                        if(playerDeck.cardsValue() > 21){
                            System.out.println("Busted ! Your hand is valued at: " + playerDeck.cardsValue());
                            playerMoney -= playerBet;
                            
                        }
                    
                }
            }
        }
       //Game over
        System.out.println("Game is over, you lost all money.");
    }
    
}
