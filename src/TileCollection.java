import java.util.ArrayList;
import java.util.TreeMap;

public interface TileCollection {
    //draw tile from top
    Tile drawTile();

    //clear collection
    void clearTiles();

    //add tile to top
    void dropTile(Tile tile);

    //get number of this tile left in set
    int getNumTile(Tile tile);

    //return sorted list of tiles
    ArrayList<Tile> getSortedList();

    //randomize tiles
    void shuffleTiles();

    //return size
    int size();

    //split by suit
    TreeMap<String, TileCollection> splitSetBySuit();

}
