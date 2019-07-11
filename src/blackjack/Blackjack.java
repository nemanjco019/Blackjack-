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
            
            boolean endRound = false;
            
            //Start dealing cards 
            playerDeck.draw(playingDeck);
            playerDeck.draw(playingDeck);
            
            dealerDeck.draw(playingDeck);
            dealerDeck.draw(playingDeck);
            
            while(true){
                
                //Player's hand
                System.out.print("Your hand: ");
                System.out.println(playerDeck.toString());
                System.out.println("Your deck has a value of: " + playerDeck.cardsValue());
                
                //Dealer's hand
                System.out.print("Dealer hand: ");
                System.out.println(dealerDeck.getCard(0).toString() + " and [Hidden]");               
                
                System.out.println("Would you like to Hit(1) or Stand(2)");
                int response = userInput.nextInt();
                
                if(response == 1){
                    playerDeck.draw(playingDeck);
                    System.out.println("You draw a: " + playerDeck.getCard(playerDeck.deckSize()-1).toString());
                        if(playerDeck.cardsValue() > 21){
                            System.out.println("Busted ! Your hand is valued at: " + playerDeck.cardsValue());
                            playerMoney -= playerBet;
                            endRound = true;
                            break;
                        }
                    
                }
                
                if(response == 2){
                    break;
                }             
            }
            
            //Revealing Dealer's cards
            System.out.println("Dealer cards; " + dealerDeck.toString());
            //Determine if dealer has more points than player
            if(dealerDeck.cardsValue() > playerDeck.cardsValue() && endRound == false){
                    System.out.println("Dealer beats you !");
                    playerMoney -= playerBet;
                    endRound = true;
            }
            
             //Dealer draws at 16 and stand at 17
            while((dealerDeck.cardsValue() < 17) && endRound == false){
                dealerDeck.draw(playingDeck);
                System.out.println("Dealers draws: " + dealerDeck.getCard(dealerDeck.deckSize()-1).toString());
            }
            
            //Display total value of dealers hand
            System.out.println("Dealer's hand has a value of: " + dealerDeck.cardsValue());
            //Determine if dealer is busted
            if((dealerDeck.cardsValue() > 21) && endRound == false){
                System.out.println("Dealer busted ! You win !");
                playerMoney += playerBet;
                endRound = true;
            }
            
            //Determine if it's a push
            if((playerDeck.cardsValue() == dealerDeck.cardsValue()) && endRound == false){
                System.out.println("Push!");
                endRound = true;
            }
            
            if((playerDeck.cardsValue() > dealerDeck.cardsValue()) && endRound == false){
                System.out.println("You won this hand !");
                playerMoney += playerBet;
                endRound = true;
            }
            else if(endRound == false){
                System.out.println("You lost this hand.");
                playerMoney -= playerBet;
                endRound = true;
            }
            
            //Putting cards back into the deck
            playerDeck.moveAllToDeck(playingDeck);
            dealerDeck.moveAllToDeck(playingDeck);
            System.out.println("End of hand.");
        }
       //Game over
        System.out.println("Game is over, you lost all money.");
    }
    
}
