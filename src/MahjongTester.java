import java.util.ArrayList;
import java.util.TreeMap;

public class MahjongTester {

    public static void main(String[] args){
        Tile t1 = new GenericTile(3, "Man");
        System.out.println(t1);
        Tile t2 = new HonorTile("Red", "Dragon");
        System.out.println(t2);
        Tile t3 = new GenericTile(2, "Man");
        System.out.println(t1.equals(t3));
        TileStack set1 = new TileStack();
        set1.add(t1);
        set1.add(t2);
        set1.add(t3);
        System.out.println(set1);
        WallStack test = new WallStack();
        System.out.println(test.peekNextDraws(14));
        Hand h1 = new Hand(test);
        System.out.println(h1);
        System.out.println(test.peekNextDraws(5));
    }

    public static void showTest(Object expected, Object actual, int testNum, String testingWhat){
        if(expected.equals(actual)) System.out.println("Test " + testNum + " passed. Testing " + testingWhat);
        else System.out.println("Test " + testNum + " failed. Testing " + testingWhat);
        System.out.println("\nExpected: " + expected.toString()
        + "\nActual: " + actual.toString());

    }
}
