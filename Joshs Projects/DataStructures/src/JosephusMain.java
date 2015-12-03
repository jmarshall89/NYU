/**
 * Created by jmarshall on 11/28/15.
 */
public class JosephusMain {

    public static void main(String[] args) {
        Josephus josephus = new Josephus(100, 77);
        josephus.execute();
        josephus.printDead();
        josephus.printSurvivor();
    }
}
