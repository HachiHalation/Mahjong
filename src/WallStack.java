import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.TreeMap;

public class WallStack extends TileStack implements TileCollection {
    private final String[] NORMAL_SUITS = {"MAN","SOU","PIN"};
    private final int[] NORMAL_VALUES = {1, 2, 3, 4, 5, 6, 7, 8, 9};
    private final String[] HONOR_SUITS = {"DRAGON","WIND"};
    private final String[] DRAGON_NAMES = {"Red", "Green", "White"};
    private final String[] WIND_NAMES = {"North", "South", "East", "West"};
    private TreeMap<String, String[]> HONOR_TILES = new TreeMap<>();

    public WallStack() {
        super();
        HONOR_TILES.put(HONOR_SUITS[0], DRAGON_NAMES);
        HONOR_TILES.put(HONOR_SUITS[1], WIND_NAMES);
        fillWall();
    }

    private void fillWall() {
        for(String s: NORMAL_SUITS){
            for(int i: NORMAL_VALUES){
                for(int c = 0; c < 4; c++){
                    dropTile(new GenericTile(i, s));
                }
            }
        }
        for(String s: HONOR_TILES.keySet()){
            for(String n: HONOR_TILES.get(s)){
                for(int c = 0; c < 4; c++){
                    dropTile(new HonorTile(n, s));
                }
            }
        }
        shuffleTiles();

    }

    public String peekNextDraws(int numPeeks){
        Deque<Tile> temp = new ArrayDeque<>();
        StringBuilder s =  new StringBuilder();
        boolean onlyOnce = false;
        for(int i = 0; i < numPeeks; i++){
            Tile currTile = drawTile();
            if(!onlyOnce){
                onlyOnce = true;
            } else s.append(" -> ");
            s.append(currTile);
            temp.push(currTile);
        }
        while(!temp.isEmpty()) dropTile(temp.pop());
        return s.toString();
    }
}
