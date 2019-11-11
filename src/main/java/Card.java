public class Card {

    public SuitType suit;
    private RankType rank;
    private int value;

    public Card(SuitType suit, RankType rank){
        this.suit = suit;
        this.rank = rank;
        this.value = getValueFromEnum();
    }

    public SuitType getSuit(){
        return this.suit;
    }

    public RankType getRank(){
        return this.rank;
    }

    public int getValueFromEnum(){
        return this.rank.getValue();
    }

    public int getValue(){
        return this.value;
    }

    public void updateValue(int value){
        this.value = value;
    }

}
