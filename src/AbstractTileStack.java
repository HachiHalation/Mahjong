import java.util.*;

public abstract class AbstractTileStack implements TileCollection {
    private Deque<Tile> tiles;

    public AbstractTileStack(){
        tiles = new ArrayDeque<>();
    }

    @Override
    public Tile drawTile() {
        return tiles.pop();
    }

    @Override
    public void dropTile(Tile tile) {
        tiles.push(tile);
    }

    @Override
    public int getNumTile(Tile tile) {
        int result = 0;
        for(Tile t: tiles){
            if(t.equals(tile)) result++;
        }
        return result;
    }

    @Override
    public ArrayList<Tile> getSortedList() {
        ArrayList<Tile> sorted = new ArrayList<>(tiles);
        Collections.sort(sorted);
        return sorted;
    }

    @Override
    public void shuffleTiles() {
        ArrayList<Tile> temp = new ArrayList<>(tiles);
        clearTiles();
        Collections.shuffle(temp);
       for(Tile t: temp){
           tiles.push(t);
       }

    }

    @Override
    public void clearTiles() {
        tiles.clear();
    }

    @Override
    public int size() {
        return tiles.size();
    }

    @Override
    public TreeMap<String, TileCollection> splitSetBySuit() {
       TreeMap<String, TileCollection> result = new TreeMap<>();
       Deque<Tile> temp = new ArrayDeque<>();
        while(!tiles.isEmpty()){
            temp.push(tiles.pop());
        }
        while(!temp.isEmpty()){
           Tile curr = temp.pop();
           TileCollection currSet;
           if(result.containsKey(curr.getSuit())){
               currSet = result.get(curr.getSuit());
               currSet.dropTile(curr);
           } else {
               currSet = new TileStack();
               currSet.dropTile(curr);
           }
           result.put(curr.getSuit(), currSet);
       }
       return result;
    }

    @Override
    public String toString() {
        return tiles.toString();
    }
}
