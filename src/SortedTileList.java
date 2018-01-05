import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by phant on 1/4/2018.
 */
public class SortedTileList extends TileList implements Iterable<Tile>{
    private List<Tile> con;

    public SortedTileList(){
        con = new ArrayList<>();
    }

    @Override
    public void add(Tile t){
        boolean added = false;
        for(int i = 0; i < con.size() && !added; i++){
            added = t.compareTo(con.get(i)) <= 0;
            if(added) con.add(i, t);
        }

        if(!added) con.add(t);
    }

    @Override
    public Tile get(int index) {
        return con.get(index);
    }

    @Override
    public int size() {
        return con.size();
    }

    @Override
    public String toString() {
        return con.toString();
    }

    public Tile remove(int index){
        return con.remove(index);
    }

    @Override
    public Iterator iterator() {
        return new Titerator();
    }

    private class Titerator implements Iterator<Tile>{
        int index;


        @Override
        public boolean hasNext() {
            return index < con.size();
        }

        @Override
        public Tile next() {
            Tile t = con.get(index);
            index++;
            return t;
        }
    }
}
