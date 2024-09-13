import Entities.Grass;
import Entities.Predator;

public class Main {
    public static void main(String[] args) {
        Predator p = new Predator("t" , 2, 3, 4 );
        p.makeMove();
    }
}