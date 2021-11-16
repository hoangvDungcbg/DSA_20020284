
public class LineSegment {
    public final Point p;
    public final Point q;

    /**
     * cons.
     *
     * @param p
     * @param q
     */
    public LineSegment(Point p, Point q) {
        if (p != null && q != null) {
            this.p = p;
            this.q = q;
        } else {
            throw new NullPointerException();
        }
    }

    /**
     * draw.
     */
    public void draw() {
        p.drawTo(q);
    }

    /**
     * tostring.
     *
     * @return
     */
    @Override
    public String toString() {
        return p + "->" + q;
    }


}
