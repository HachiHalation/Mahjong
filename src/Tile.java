public abstract class Tile implements Comparable{
    private String suit;

    public Tile(String s) {
        suit = s;
    }

    @Override
    public int compareTo(Object o) {
        if(!(o instanceof Tile)) return -1;
        else {
            Tile other = (Tile) o;
            return this.suit.compareTo(other.suit);
        }
    }

    public boolean equals(Object o){
        return compareTo(o) == 0;
    }

    public String toString() {
        return suit;
    }

    public String getSuit() {
        return suit;
    }
}
