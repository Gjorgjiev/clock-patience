package Entity;

import java.util.List;

public class Deck {

    private List<Card> cards;
    private List<Card> mainCards;
    private Card mainCard;

    public Deck(List<Card> cards){
        this.cards = cards;
    }

    public Deck(List<Card> cards, List<Card> mainCards, Card mainCard){
        this.cards = cards;
        this.mainCards = mainCards;
        this.mainCard = mainCard;
    }

    public Deck(){}

    public void addCardToCards(Card card){
        this.cards.add(card);
    }

    public List<Card> getCardsFromCards(){
        return this.cards;
    }

    public void removeCardFromCards(int pos){
        this.cards.remove(pos);
    }

    public void removeCardFromCards(Card pos){
        for (int i = 0; i<cards.size(); i++) {
            if(pos.getNumber() == cards.get(i).getNumber() && pos.getSymbol().equals(cards.get(i).getSymbol())){
                this.cards.remove(i);
            }
        }
    }

    public void exposedCards(Card card){

    }

    public Card getCardFromCards(int pos){
        return this.cards.get(pos);
    }

    public Card getMainCard(){
        return this.mainCard;
    }

    public void addCardToMainCards(Card card){
        this.mainCards.add(card);
    }

    public List<Card> getCardsFromMainCards(){
        return this.mainCards;
    }
}
