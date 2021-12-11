
import edu.princeton.cs.algs4.StdDraw;

import java.util.Comparator;

public class Point implements Comparable<Point> {
    private final int x;
    private final int y;

    /**
     * constructor.
     *
     * @param x
     * @param y
     */
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * main.
     *
     * @param args
     */
    public static void main(String[] args) {
    }

    /**
     * draw.
     */
    public void draw() {
        StdDraw.point(x, y);
    }

    /**
     * drawto.
     */
    public void drawTo(Point that) {
        StdDraw.line(this.x, this.y, that.x, that.y);
    }

    /**
     * toString.
     *
     * @return
     */
    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }

    /**
     * compare.
     */
    public int compareTo(Point that) {
        if (this.x == that.x && this.y == that.y) {
            return 0;
        }
        if ((this.x < that.x && this.y == that.y) || this.y < that.y) {
            return -1;
        }
        return 1;
    }

    /**
     * slope.
     */
    public double slopeTo(Point that) {
        if (that.x - this.x == 0 && that.y - this.y == 0) {
            return Double.NEGATIVE_INFINITY;
        } else if (that.x - this.x == 0) {
            return Double.POSITIVE_INFINITY;
        } else if (that.y - this.y == 0) {
            return +0.0;
        }
        return (double) (that.y - this.y) / (that.x - this.x);
    }

    public Comparator<Point> slopeOrder() {
        return new SlopeOrder();
    }

    /**
     * slopeorder.
     */
    private class SlopeOrder implements Comparator<Point> {
        Point pnt = Point.this;

        @Override
        public int compare(Point o1, Point o2) {
            if (pnt.slopeTo(o1) < pnt.slopeTo(o2)) {
                return -1;
            } else if (pnt.slopeTo(o1) > pnt.slopeTo(o2)) {
                return 1;
            }
            return 0;
        }
    }
}
