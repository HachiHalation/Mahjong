public class GenericTile extends Tile implements  Comparable{
    private int numValue;

    public GenericTile(int value, String suit){
        super(suit);
        this.numValue = value;

    }

    public int getNumValue(){
        return numValue;
    }

    public String toString(){
        return getSuit() + " " + numValue;
    }

    @Override
    public int compareTo(Object o) {
            int compared = super.compareTo(o);
            if(compared == 0){
                GenericTile other = (GenericTile) o;
                return numValue - other.numValue;
            }
            else if(o instanceof HonorTile) return -1;
            else return compared;
    }

    public boolean adjacent(GenericTile t){
        return Math.abs(t.numValue - this.numValue) == 1;
    }
}
