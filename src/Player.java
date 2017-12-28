import java.util.ArrayList;

public class Player {
    private WallStack wall;
    private Hand hand;
    private TileList discards;
    private ArrayList<TileList> lockedSets;
    private boolean isTurn;
    private boolean richii;
    private int points;

    public Player(WallStack w){
        wall = w;
        hand = new Hand(w);
        discards = new TileList();
        lockedSets = new ArrayList<>();
    }

    public void startTurn(){
        isTurn = true;
        hand.draw();

        if(richii) endTurn();
    }


    public void endTurn(){
        discards.add(hand.discard());
        isTurn = false;
    }

    public void steal(Tile add, int t1, int t2){
        TileList set = new TileList();
        hand.setToDiscard(t1);
        set.add(hand.discard());
        hand.setToDiscard(t2);
        set.add(hand.discard());

        set.add(add);
        lockedSets.add(set);

        isTurn = true;
        hand.setToDiscard(0);
    }

    public void pon(Tile add, int t1, int t2){
        steal(add, t1, t2);
    }

    public void chi(Tile add, int t1, int t2){
        steal(add, t1, t2);
    }

    public void ron(){

    }

    public void kan(){

    }

    public void richii(){
        points -= 5000;
        richii = true;


    }
}
