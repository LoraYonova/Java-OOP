package WorkingWithAbstraction.PointInRectangle;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[] coordinates = readArray(scan);

        Point pointA = new Point(coordinates[0], coordinates[1]);
        Point pointC = new Point(coordinates[2], coordinates[3]);

        Rectangle rectangle = new Rectangle(pointA, pointC);

        int n = Integer.parseInt(scan.nextLine());

        while (n-- > 0) {
            int [] coordinatesOfPoint = readArray(scan);

            Point p = new Point(coordinatesOfPoint[0], coordinatesOfPoint[1]);

            boolean isInside = rectangle.isInside(p);

            System.out.println(isInside);
        }

    }

    public static int[] readArray(Scanner scan) {
        return Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
