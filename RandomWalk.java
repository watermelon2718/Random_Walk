import java.util.ArrayList;
import java.util.Random;

import edu.cwi.randomwalk.RandomWalkInterface;

import java.awt.Point;

public class RandomWalk implements RandomWalkInterface{ 
    private int size; 
    private boolean done;
    private ArrayList <Point> path;
    private Point start, end, current;
    private Random generator;

    public RandomWalk(int gridSize) {
        size = gridSize;
        done = false;
        this.start = new Point(0, size - 1);
        this.end = new Point(size - 1, 0);
        current = start;

        path = new ArrayList<Point>();
        path.add(current);
        generator = new Random();
    }

    public RandomWalk(int gridSize, long seed) {
        size = gridSize;
        done = false;
        this.start = new Point(0, size - 1);
        this.end = new Point(size - 1, 0); 
        current = start;

        path = new ArrayList<Point>();
        path.add(current);
        generator = new Random(seed);
    }

    @Override

    public void step() {
        // prevent from running if done
        // guard
        if (done) { return; }
        Point point;
        if (current.x == (size-1)) {
            point = new Point(current.x, current.y - 1);                
        } else if (current.y == 0) {
            point = new Point(current.x + 1, current.y);
        } else if (generator.nextBoolean()) {
            point = new Point(current.x, current.y - 1);
        } else {
            point = new Point(current.x + 1, current.y);
        }
        path.add(point);
        current = point;
        if ((current.x == (size - 1)) && (current.y == (0))) {
            done = true;
        }

    }
    

    @Override
    public void createWalk() {
        do {
            step();
        } while (!done);
    }

    @Override
    public boolean isDone() {
        return done;
    }
    
    @Override
    public int getGridSize() { 
        return size;
    }

    @Override
    public Point getStartPoint() {
       return start;
    }
    @Override
    public Point getEndPoint() {
        return end;
    }
    
    @Override
    public Point getCurrentPoint() {
        return current;
    }

    @Override
    public ArrayList<Point> getPath() {
        ArrayList<Point> copy = new ArrayList<Point>(path);
        return copy;
    }

    public String toString() {
        String result = "\t";
        for (Point point : path) {
            result += "[" + point.x + "," + point.y + "]\t";
        }
        return result;
    }

}
