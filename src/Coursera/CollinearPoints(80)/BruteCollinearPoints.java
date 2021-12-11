

import edu.princeton.cs.algs4.StdDraw;

import java.util.ArrayList;
import java.util.Arrays;

public class BruteCollinearPoints {
    private final Point[] points;
    private java.util.ArrayList<LineSegment> linesegments = new ArrayList<LineSegment>();
    private LineSegment[] segments;
    private int count;

    public BruteCollinearPoints(Point[] points) {
        check(points);
        this.points = points.clone();
        Arrays.sort(this.points);
        for (int i = 0; i < this.points.length - 3; i++) {
            for (int j = i + 1; j < this.points.length - 2; j++) {
                for (int k = j + 1; k < this.points.length - 1; k++) {
                    for (int l = k + 1; l < this.points.length; l++) {
                        if (this.points[i].slopeTo(this.points[j]) == this.points[j].slopeTo(this.points[k]) &&
                                this.points[j].slopeTo(this.points[k]) == this.points[k].slopeTo(this.points[l])) {
                            LineSegment ls = new LineSegment(this.points[i], this.points[l]);
                            if (!linesegments.contains(ls)) {
                                linesegments.add(ls);
                            }
                            this.points[i].drawTo(this.points[l]);
                            StdDraw.show();
                        }
                    }
                }
            }
        }
        segments = linesegments.toArray(new LineSegment[linesegments.size()]);

    }

    public int numberOfSegments() {
        return segments.length;
    }

    public LineSegment[] segments() {
        return segments;
    }

    private void check(Point[] points) {
        if (points == null) {
            throw new IllegalArgumentException();
        }
        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < points.length; j++) {
                if (points[i] == null || points[j] == null) {
                    throw new IllegalArgumentException();
                }
                if (i != j && points[i].compareTo(points[j]) == 0) {
                    throw new IllegalArgumentException();
                }
            }
        }
    }

    private void checkdup(Point[] points) {
        for (int i = 0; i < points.length - 1; i++) {
            if (points[i].compareTo(points[i + 1]) == 0) {
                throw new IllegalArgumentException("duplicated");
            }
        }
    }

    private void checknull(Point[] points) {
        for (int i = 0; i < points.length - 1; i++) {
            if (points[i] == null) {
                throw new NullPointerException("null");
            }
        }
    }
}
