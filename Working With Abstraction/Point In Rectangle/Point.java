package WorkingWithAbstraction.PointInRectangle;

public class Point {
    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public boolean isGreaterThenOrEqual(Point p) {
        return x >= p.x && y >= p.y;
    }

    public boolean isLessThenOrEqual(Point p) {
        return x <= p.x && y <= p.y;
    }


}
