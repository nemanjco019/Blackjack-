package blackjack;

import java.util.ArrayList;
import java.util.Random;

public class Deck {
    private ArrayList<Card> cards;
    
    public Deck(){
        this.cards = new ArrayList<Card>();
    }
    //Create deck
    public void createFullDeck(){
        for(Suit cardSuit : Suit.values()){
                for(Values cardValue : Values.values()){
                    this.cards.add(new Card(cardSuit, cardValue));
                }
        }
    }
    // Shuffle the deck
    public void shuffle(){
        ArrayList<Card> tmpDeck = new ArrayList<Card>();
        Random random = new Random();
        int randomCardIndex = 0;
        int originalSize = this.cards.size();
        for(int i = 0; i < originalSize; i++){
            randomCardIndex = random.nextInt((this.cards.size()-1)+1);
            tmpDeck.add(this.cards.get(randomCardIndex));
            this.cards.remove(randomCardIndex);
        }
        this.cards = tmpDeck;
    }
    
    //Draw from the deck
    public void draw(Deck comingFrom){
        this.cards.add(comingFrom.getCard(0));
        comingFrom.removeCard(0);
    }
    
    public void removeCard(int i){
        this.cards.remove(i);
    }
    
    public Card getCard(int i){
        return this.cards.get(i);
    }
    
    public void addCard (Card addCard){
        this.cards.add(addCard);
    }
    
    public String toString(){
        String cardListOutput = "";     
        for (Card aCard : this.cards){
            cardListOutput += "\n " + aCard.toString();           
        }
        return cardListOutput;
    }
}
