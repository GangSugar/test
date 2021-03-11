class Card{
    int rank;
    String suit;
    public Card(int rank, String suit) {
        this.rank = rank;
        this.suit = suit;
    }
}

public class TestDemo1 {

    public static void main(String[] args) {
        Card c1 = new Card(1,"♠");
        Card c2 = new Card(2,"♠");
    }
}
