import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Hand{
    private final int MAX_HAND_SIZE = 13;
    private SortedTileList hand;
    private Tile toDiscard;
    private WallStack wall;


    public Hand(WallStack wall){
        this.wall = wall;
        hand = new SortedTileList();
        for(int i = 0; i < MAX_HAND_SIZE; i++){
            hand.add(wall.removeFromWall());
        }

        toDiscard = wall.removeFromWall();
    }

    public Tile discard(){
        Tile temp = toDiscard;
        toDiscard = null;
        return temp;
    }

    public void draw(){
        toDiscard = wall.removeFromWall();
    }

    public void draw(Tile t) {toDiscard = t; }

    public void setToDiscard(int index){
        Tile temp = hand.get(index);
        hand.set(toDiscard, index);
        toDiscard = temp;
    }

    public List<TileList> makeIncompleteGroups(){
        List<TileList> sets = new ArrayList<>();
        for(int i = 0; i < hand.size() - 1; i++) {
            Tile curr = hand.get(i);
            Tile next = hand.get(i + 1);
            if (curr.getSuit().equals(next.getSuit())) {
                if (curr instanceof GenericTile) {
                    GenericTile g = (GenericTile) curr;
                    GenericTile n = (GenericTile) next;
                    int origNum = g.getNumValue();
                    int nextNum = n.getNumValue();
                    int diff = nextNum - origNum;
                    if (diff <= 2) {
                        TileList temp = new TileList();
                        temp.add(curr);
                        temp.add(next);
                        sets.add(temp);
                    }
                }
                if(curr instanceof HonorTile){
                    HonorTile h = (HonorTile) curr;
                    HonorTile n = (HonorTile) next;
                    if(h.name().equals(n.name())){
                        TileList temp = new TileList();
                        temp.add(h);
                        temp.add(n);
                        sets.add(temp);
                    }
                }
            }
        }
        return sets;
    }

    public List<TileList> makeCompleteSets(){
        List<TileList> sets = new ArrayList<>();
        if(hand.size() >= 3){
            Tile a;
            Tile b = hand.get(0);
            Tile c = hand.get(1);

            int index = 2;
            while(index < hand.size()){
                boolean add = false;
                a = b;
                b = c;
                c = hand.get(index);

                if(a.getSuit().equals(c.getSuit())){
                    if(a instanceof GenericTile){
                        GenericTile ga = (GenericTile) a;
                        GenericTile gb = (GenericTile) b;
                        GenericTile gc = (GenericTile) c;

                        if(ga.compareTo(gc) == 0 || (ga.adjacent(gb) && gb.adjacent(gc)) ){
                            add = true;
                        }
                    }else{
                        HonorTile ha = (HonorTile) a;
                        HonorTile hc = (HonorTile) c;
                        if(ha.compareTo(hc) == 0){
                            add = true;
                        }
                    }
                }

                if(add){
                    TileList temp = new TileList();
                    temp.add(a);
                    temp.add(b);
                    temp.add(c);
                    sets.add(temp);
                }
                index++;
            }
        }
        return sets;
    }

    public String toString(){
        if(toDiscard == null) return hand.toString();
        else return hand.toString() + "\nCurrent Discard: " + toDiscard;
    }
}
