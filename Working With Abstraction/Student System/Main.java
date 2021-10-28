package WorkingWithAbstraction.StudentSystem;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StudentSystem studentSystem = new StudentSystem();

        String[] input = scanner.nextLine().split("\\s+");

        while (!input[0].equals("Exit")) {

            if(input[0].equals("Create")) {
                studentSystem.createStudent(input);

            } else if (input[0].equals("Show")) {
                studentSystem.showStudent(input[1]);
            }

            input = scanner.nextLine().split("\\s+");
        }
    }
}
