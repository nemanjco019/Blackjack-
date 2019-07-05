package blackjack;
public class Blackjack {
    public static void main(String[] args) {
        
        System.out.println("Welcome to Blackjack!");
        
        //Create playing deck
        Deck playingDeck = new Deck();
        playingDeck.createFullDeck();
        playingDeck.shuffle();
        
        //Create a deck for the player
        Deck playerDeck = new Deck();
        
        //Create a deck for second player
        Deck playerDeck2 = new Deck();
        
        //Create a deck for the dealer 
        Deck dealerDeck = new Deck();
        
        System.out.println(playingDeck);
    }
    
}
