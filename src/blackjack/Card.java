package blackjack;
public class Card {
    private Suit suit;
    private Values value;
    
    public Card(Suit suit, Values value){
        this.value = value;
        this.suit = suit;       
    }
    
    public String toString(){
        return this.suit.toString() + "-" + this.value.toString();
    }
    
    public Values getValue(){
        return this.value;
    }
}
