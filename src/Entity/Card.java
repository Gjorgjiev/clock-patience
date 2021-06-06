package Entity;

public class Card {

    private int number;
    private Symbol symbol;

    public Card(int number, Symbol symbol){
        this.number = number;
        this.symbol = symbol;
    }

    public Card(){}

    public int getNumber(){
        return this.number;
    }

    public Symbol getSymbol(){
        return this.symbol;
    }

    @Override
    public String toString(){
        return number + symbol.name();
    }

}
