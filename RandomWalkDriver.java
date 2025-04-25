import java.util.Random;
import java.util.Scanner;

public class RandomWalkDriver {
    public static void main(String[] args) {
    Scanner keyboard = new Scanner(System.in);
    int gridsize;
    long seed;
    RandomWalk walk;

    do {
        System.out.println("Enter grid size: ");
        gridsize = keyboard.nextInt();
    } while (gridsize <= 0);

    do {
        System.out.println("Enter your random seed: (0 for no seed)");
        seed = keyboard.nextLong();
    } while (seed < 0); 

    if (seed == 0) {
        walk = new RandomWalk(gridsize);
    } else {
        walk = new RandomWalk(gridsize, seed);
    }

    walk.createWalk();
    System.out.println(walk.toString());
        
    }
}
