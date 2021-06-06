package Entity;

public enum Symbol {

    C("Clubs"), D("Diamonds"), H("Hearts"), S("Spades");

    private String name;

    private Symbol(String name){
        this.name = name;
    }

}
