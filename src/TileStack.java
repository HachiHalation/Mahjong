import java.util.*;

public class TileStack  {
    private Deque<Tile> con;

    public TileStack(){
        con = new ArrayDeque<>();
    }

    public TileStack(List<Tile> list){
        List<Tile> temp = new ArrayList<>(list);
        Collections.shuffle(temp);

        con = new ArrayDeque<>();
        while(!temp.isEmpty()){
            con.add(temp.remove(temp.size() - 1));
        }
    }

    public void add(Tile t){
        con.add(t);
    }

    public Tile remove(){
        return con.remove();
    }

    public boolean isEmpty(){
        return con.isEmpty();
    }

    public Iterator<Tile> iterator(){
        return con.iterator();
    }

    public String toString(){
        return con.toString();
    }


}
