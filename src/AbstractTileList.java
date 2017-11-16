import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.TreeMap;

public class AbstractTileList implements TileCollection {
    ArrayList<Tile> tiles;
    public AbstractTileList(){
        tiles = new ArrayList<>();
    }

    @Override
    public void addTile(Tile tile) {
        tiles.add(tile);
    }

    @Override
    public Tile removeTile() {
        return tiles.remove(tiles.size() - 1);
    }

    public Tile removeTile(int index){
        return tiles.remove(index);
    }


    @Override
    public void clearTiles() {
        tiles.clear();
    }

    @Override
    public ArrayList<Tile> getSortedList() {
        ArrayList<Tile> temp = new ArrayList<>(tiles);
        Collections.sort(temp);
        return temp;
    }

    @Override
    public void shuffleTiles() {
        Collections.shuffle(tiles);
    }

    @Override
    public int size() {
        return tiles.size();
    }

    @Override
    public TreeMap<String, TileCollection> splitSetBySuit() {
        Iterator<Tile> iter = tiles.iterator();
        TreeMap<String, TileCollection> result = new TreeMap<>();
        while(iter.hasNext()){
            Tile curr = iter.next();
            TileCollection temp;
            if(result.containsKey(curr.getSuit())){
                temp = result.get(curr.getSuit());
                temp.addTile(curr);
            } else {
                temp = new TileList();
                temp.addTile(curr);
            }
            result.put(curr.getSuit(), temp);
        }

        return result;
    }
}
