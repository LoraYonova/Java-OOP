package WorkingWithAbstraction.RhombusOfStars;

import java.util.Scanner;

public class RhombusOfStars {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int size = Integer.parseInt(scan.nextLine());

        String rhombusOfStart = buildRhombusOfStart(size);
        printOutput(rhombusOfStart);

    }

    private static String buildRhombusOfStart(int size) {
        StringBuilder out = new StringBuilder();
        for (int i = 1; i <= size; i++) {
            out.append(printLine(size - i, i))
                    .append(System.lineSeparator());
        }
        for (int i = size - 1; i >= 1; i--) {
            out.append(printLine(size - i, i))
                    .append(System.lineSeparator());
        }

        return out.toString();
    }

    private static String printLine(int spaces, int stars) {
        StringBuilder out = new StringBuilder();
        for (int i = 0; i < spaces; i++) {
            out.append(" ");
        }

        for (int i = 0; i < stars; i++) {
            out.append("* ");
        }



        return out.toString();
    }
    private static void printOutput(String rhombusOfStarts) {
        System.out.println(rhombusOfStarts);
    }

}
