package WorkingWithAbstraction.PointInRectangle;

public class Rectangle {
    private Point pointA;
    private Point pointC;

    public Rectangle(Point pointA, Point pointC) {
        this.pointA = pointA;
        this.pointC = pointC;
    }

    public boolean isInside(Point p) {
        return p.isGreaterThenOrEqual(pointA) && p.isLessThenOrEqual(pointC);
    }
}
