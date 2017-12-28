import java.util.*;

public class WallStack{
    private final String[] NORMAL_SUITS = {"MAN","SOU","PIN"};
    private final int[] NORMAL_VALUES = {1, 2, 3, 4, 5, 6, 7, 8, 9};
    private final String[] HONOR_SUITS = {"DRAGON","WIND"};
    private final String[] DRAGON_NAMES = {"Red", "Green", "White"};
    private final String[] WIND_NAMES = {"North", "South", "East", "West"};
    private TreeMap<String, String[]> HONOR_TILES = new TreeMap<>();
    private TileStack wall;


    public WallStack() {
        HONOR_TILES.put(HONOR_SUITS[0], DRAGON_NAMES);
        HONOR_TILES.put(HONOR_SUITS[1], WIND_NAMES);
        List<Tile> temp = generateWall();
        wall = new TileStack(temp);
    }

    private List<Tile> generateWall() {
        List<Tile> temp = new ArrayList<>();
        for(String s: NORMAL_SUITS){
            for(int i: NORMAL_VALUES){
                for(int c = 0; c < 4; c++){
                    temp.add(new GenericTile(i, s));
                }
            }
        }
        for(String s: HONOR_TILES.keySet()){
            for(String n: HONOR_TILES.get(s)){
                for(int c = 0; c < 4; c++){
                    temp.add(new HonorTile(n, s));
                }
            }
        }
        return temp;
    }

    public Tile removeFromWall(){
        return wall.remove();
    }

    public String peekNextDraws(int numPeeks){
        Iterator<Tile> iter = wall.iterator();
        StringBuilder s =  new StringBuilder();
        boolean onlyOnce = false;
        for(int i = 0; i < numPeeks; i++){
            Tile currTile = iter.next();
            if(!onlyOnce){
                onlyOnce = true;
            } else s.append(" -> ");
            s.append(currTile);
        }
        return s.toString();
    }
}
