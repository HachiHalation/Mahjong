public class Hand{
    private final int MAX_HAND_SIZE = 13;
    private TileList hand;
    private Tile toDiscard;
    private WallStack wall;


    public Hand(WallStack wall){
        this.wall = wall;
        hand = new TileList();
        for(int i = 0; i < MAX_HAND_SIZE; i++){
            hand.add(wall.removeFromWall());
        }

        toDiscard = wall.removeFromWall();
    }

    public Tile discard(){
        Tile temp = toDiscard;
        toDiscard = null;
        return temp;
    }

    public void draw(){
        toDiscard = wall.removeFromWall();
    }

    public void draw(Tile t) {toDiscard = t; }

    public void setToDiscard(int index){
        Tile temp = hand.get(index);
        hand.set(toDiscard, index);
        toDiscard = temp;
    }

    public String toString(){
        if(toDiscard == null) return hand.toString();
        else return hand.toString() + "\nCurrent Discard: " + toDiscard;
    }
}
