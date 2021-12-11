import java.util.ArrayList;
import java.util.Arrays;

public class FastCollinearPoints {
    private LineSegment[] segments;
    private java.util.ArrayList<LineSegment> linesegments = new ArrayList<LineSegment>();

    public FastCollinearPoints(Point[] points) {
        check(points);
        Point[] points1 = Arrays.copyOf(points, points.length);
        Point[] points2 = Arrays.copyOf(points, points.length);
        Arrays.sort(points2);
        check(points2);
        for (int i = 0; i < points2.length; i++) {
            Point min = points2[i];
            Arrays.sort(points1, min.slopeOrder());
            int count = 1;
            Point start = null;
            for (int j = 0; j < points1.length - 1; j++) {
                if (points1[j].slopeTo(min) == points1[j + 1].slopeTo(min)) {
                    count++;
                    if (count == 2) {
                        start = points1[j];
                        count++;
                    }
                } else if (count >= 4) {
                    if (start.compareTo(min) > 0) {
                        linesegments.add(new LineSegment(min, points1[j]));
                    }
                    count = 1;
                } else {
                    count = 1;

                }
            }

        }

        segments = linesegments.toArray(new LineSegment[linesegments.size()]);
    }

    public int numberOfSegments() {
        return segments.length;
    }

    public LineSegment[] segments() {
        return Arrays.copyOf(segments, segments.length);
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
}
