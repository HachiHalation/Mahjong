import java.util.ArrayList;
import java.util.TreeMap;

public class DiscardList implements TileCollection {
    @Override
    public Tile drawTile() {
        return null;
    }

    @Override
    public void clearTiles() {

    }

    @Override
    public void dropTile(Tile tile) {

    }

    @Override
    public ArrayList<Tile> getSortedList() {
        return null;
    }

    @Override
    public void shuffleTiles() {

    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public TreeMap<String, TileCollection> splitSetBySuit() {
        return null;
    }

    @Override
    public int getNumTile(Tile tile) {
        return 0;
    }
}
