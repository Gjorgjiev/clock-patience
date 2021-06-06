package main;

import Entity.Card;
import Entity.Deck;
import Entity.Symbol;

import java.util.*;

public class MainClass {

    static Deck mainDeck = setMainDeck();
    static Deck one = new Deck(new ArrayList<>(), new ArrayList<>(), new Card(1, Symbol.C));
    static Deck two = new Deck(new ArrayList<>(), new ArrayList<>(), new Card(2, Symbol.C));
    static Deck three = new Deck(new ArrayList<>(), new ArrayList<>(), new Card(3, Symbol.C));
    static Deck four = new Deck(new ArrayList<>(), new ArrayList<>(), new Card(4, Symbol.C));
    static Deck five = new Deck(new ArrayList<>(), new ArrayList<>(), new Card(5, Symbol.C));
    static Deck six = new Deck(new ArrayList<>(), new ArrayList<>(), new Card(6, Symbol.C));
    static Deck seven = new Deck(new ArrayList<>(), new ArrayList<>(), new Card(7, Symbol.C));
    static Deck eight = new Deck(new ArrayList<>(), new ArrayList<>(), new Card(8, Symbol.C));
    static Deck nine = new Deck(new ArrayList<>(), new ArrayList<>(), new Card(9, Symbol.C));
    static Deck ten = new Deck(new ArrayList<>(), new ArrayList<>(), new Card(10, Symbol.C));
    static Deck jack = new Deck(new ArrayList<>(), new ArrayList<>(), new Card(11, Symbol.C));
    static Deck queen = new Deck(new ArrayList<>(), new ArrayList<>(), new Card(12, Symbol.C));
    static Deck king = new Deck(new ArrayList<>(), new ArrayList<>(), new Card(13, Symbol.C));
    static List<Deck> decks = Arrays.asList(one, two, three, four, five, six, seven, eight, nine, ten, jack, queen, king);

    static Deck nextDeck;
    static Card nextCard;

    public static void main(String[] args) {

        nextDeck = one;
        nextCard = null;

        setUp();

        while(true){
            if(giveCard(nextDeck, nextCard)){
                List<Deck> exposedCards = new ArrayList<>();
                System.out.println(   "," + nextCard.getNumber() + nextCard.getSymbol());
                break;
            }
        }

    }

    private static void setUp(){
        for(int i = 0; i<4; i++){
            for (Deck deck: decks) {
                addCard(deck, mainDeck);
            }
        }
        for (Deck deck: decks) {
            selectMainCards(deck);
        }
    }

    private static boolean giveCard(Deck deck, Card card){
        System.out.println("\nDeck: " + deck.getMainCard().getNumber());
        if(card != null) {
            deck.addCardToMainCards(card);
        }
            if (checkWinner(deck)) {
                System.out.println("Winner cards:\n");
                deck.getCardsFromMainCards().stream().forEach(card1 -> {
                    System.out.println(card1);
                });
                return true;
            }
            Card sendCard = deck.getCardFromCards(0);
            deck.removeCardFromCards(sendCard);
            System.out.println("Card to give: " + sendCard);
            for (Deck deck1 : decks) {
                if (deck1.getMainCard().getNumber() == sendCard.getNumber()) {
                    nextDeck = deck1;
                    nextCard = sendCard;
                }
            }

        System.out.println("Main cards:\n");
        deck.getCardsFromMainCards().stream().forEach(card1 -> {
            System.out.println(card1);
        });
        return false;
    }

    private static boolean checkWinner(Deck deck) {
        if(deck.getCardsFromMainCards().size() == 4){
            return true;
        }else{
            return false;
        }
    }

    private static void addCard(Deck n1, Deck n2){
        Random random = new Random();
        int num = random.nextInt(n2.getCardsFromCards().size());
        n1.addCardToCards(n2.getCardFromCards(num));
        n2.removeCardFromCards(num);
    }

    private static void selectMainCards(Deck n1){
        List<Card> list = n1.getCardsFromCards();
        for(int i = 0; i<list.size(); i++){
            if(list.get(i).getNumber() == n1.getMainCard().getNumber()) {
                n1.addCardToMainCards(list.get(i));
                n1.removeCardFromCards(list.get(i));
            }
        }
    }

    private static Deck setMainDeck(){
        List<Symbol> symbols = Arrays.asList(Symbol.C, Symbol.S,Symbol.H,Symbol.D);
        List<Card> cards = new ArrayList<>();
        for (Symbol symbol:symbols) {
            for(int i = 1; i<14; i++){
                cards.add(new Card(i, symbol));
            }
        }
        Deck deck = new Deck(cards);
        return deck;
    }

}
