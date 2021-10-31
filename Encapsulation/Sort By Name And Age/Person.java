package encapsulaton.sortByNameAndAge;

public class Person {
    private String firstName;
    private String lastName;
    private int age;

    public Person(String name, String lastName, int age) {
        this.firstName = name;
        this.lastName = lastName;
        this.age = age;
    }

    @Override
    public String toString() {
        return String.format("%s %s is %d years old.", this.firstName, this.lastName, this.age);
    }

    public String getFirstName() {
        return firstName;
    }

    public int getAge() {
        return age;
    }
}