public class HonorTile extends Tile implements Comparable {
    private String name;

    public HonorTile(String name, String suit) {
        super(suit);
        this.name = name;
    }

    @Override
    public String toString() {
        return name + " " + getSuit();
    }

    @Override
    public int compareTo(Object o) {
        int compared = super.compareTo(o);
        if(compared == 0){
            HonorTile other = (HonorTile) o;
            return this.name.compareTo(other.name);
        }
        else if(o instanceof GenericTile) return 1;
        else return compared;
    }

}
