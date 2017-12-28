public class Player {
    private WallStack wall;
    private Hand hand;
    private TileList discards;
    private boolean isTurn;
    

    public Player(WallStack w){
        wall = w;
        hand = new Hand(w);
        discards = new TileList();
    }

    public void startTurn(){
        isTurn = true;
        hand.draw();
    }


    public void endTurn(){
        discards.add(hand.discard());
        isTurn = false;
    }

    public void pon(){

    }

    public void chi(){

    }

    public void ron(){

    }

    public void kan(){

    }

    public void richii(){

    }
}
