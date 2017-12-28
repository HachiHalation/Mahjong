import java.util.ArrayList;
import java.util.List;

public class TileList{
    private List<Tile> con;

    public TileList(){
        con = new ArrayList<>();
    }

    public void add(Tile t){
        con.add(t);
    }

    public void set(Tile t, int index){
        con.set(index, t);
    }

    public Tile get(int index){
        return con.get(index);
    }

    public Tile remove(int index){
        return con.remove(index);
    }

    public String toString(){
        return con.toString();
    }


}
