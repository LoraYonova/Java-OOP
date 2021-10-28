package WorkingWithAbstraction.StudentSystem;

import java.util.*;


public class StudentSystem {
    private Map<String, Student> studentsInfo;

    public StudentSystem() {
        this.studentsInfo = new HashMap<>();
    }

    public void createStudent(String[] input) {
        String name = input[1];
        int age = Integer.parseInt(input[2]);
        double grade = Double.parseDouble(input[3]);
        Student student = new Student(name, age, grade);

        studentsInfo.putIfAbsent(name, student);


    }

    public void showStudent(String name) {

        if (studentsInfo.containsKey(name)) {

            StringBuilder out = new StringBuilder(String.format("%s is %s years old. ", studentsInfo.get(name).getName(), studentsInfo.get(name).getAge()));

            if (studentsInfo.get(name).getGrade() >= 5.00) {
                out.append("Excellent student.");
            } else if (studentsInfo.get(name).getGrade() >= 3.50) {
                out.append("Average student.");
            } else {
                out.append("Very nice person.");
            }

            System.out.println(out);
        }


    }
}
