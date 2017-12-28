public class Board {
    private Player p1;
    private Player p2;
    private Player p3;
    private Player p4;
    private WallStack wall;

    public Board(){
        wall = new WallStack();
        p1 = new Player(wall);
        p2 = new Player(wall);
        p3 = new Player(wall);
        p4 = new Player(wall);

    }

    public void startGame(){

    }
}
