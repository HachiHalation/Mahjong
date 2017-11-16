import java.util.ArrayList;
import java.util.TreeMap;

public interface TileCollection {
    //add tile
    void addTile(Tile tile);

    Tile removeTile();

    //clear collection
    void clearTiles();

    //return sorted list of tiles
    ArrayList<Tile> getSortedList();

    //randomize tiles
    void shuffleTiles();

    //return size
    int size();

    //split by suit
    TreeMap<String, TileCollection> splitSetBySuit();

}
